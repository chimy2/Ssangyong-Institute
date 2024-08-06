/*

    근태 관리(출석)

*/
-- 근태 관리(출석)
create table tblDate(
    seq number primary key,         -- PK
    state varchar2(30) not null,    -- 정상, 지각, 조퇴
    regdate date not null           -- 날짜
);

-- 2024년 8월
select * from tblDate;

-- 공휴일 
drop table tblHoliday;

create table tblHoliday (
    seq number primary key,     -- PK
    regdate date not null,      -- 날짜
    name varchar2(30) not null  -- 공휴일명
);

insert into tblHoliday (seq, regdate, name)
    values (1, '2024-08-15', '광복절');

-- 요구사항] 근태 조회 > 8월 전체의 근태 상황 열람
-- ***** 날짜 별로 조회 > 결석한 날짜도 포함 + 휴일 포함
-- ***** 2024-08-01 ~ 2024-08-31 > 모든 날짜 열람
-- 빠진 날짜 메꾸기~***

-- 1. 표준 SQL > *****
-- 2. PL/SQL
-- 3. Java 연동

set serverout on;

select to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') from tblDate;

-- 2. PL/SQL
declare
    vdate date;
    vstate tblDate.state%type;
    vcnt number;
begin
    -- seed(2024-08-01)
    vdate := to_date('2024-08-01', 'yyyy-mm-dd');   -- 00:00:00
    for i in 1..31 loop
        dbms_output.put_line(vdate);
        select count(*) into vcnt from tblDate
            where to_char(regdate, 'yyyy-mm-dd') = to_char(vdate, 'yyyy-mm-dd');
        
        -- 해당 날짜의 근태 기록? > tblDate
        if vcnt > 0 then
            select state into vstate from tblDate where to_char(regDate, 'yyyy-mm-dd') = to_char(vdate, 'yyyy-mm-dd');
            dbms_output.put_line(vstate);        
        else
            if to_char(vdate, 'dy') in ('토', '일') then
                dbms_output.put_line('주말');        
            else
                select count(*) into vcnt from tblHoliday where to_char(vdate, 'yyyy-mm-dd') = to_char(regdate, 'yyyy-mm-dd');
                if vcnt > 0 then
                    dbms_output.put_line('공휴일');
                else
                    dbms_output.put_line('결석');
                end if;
            end if;
        end if;
--        ORA-01403: no data found > select 시 데이터가 없을 때 나는 에러
--        select state into vstate from tblDate where to_char(regDate, 'yyyy-mm-dd') = to_char(vdate, 'yyyy-mm-dd');
        vdate := vdate + 1; -- 하루씩 증가
    end loop;
end;
/

-- 1. 표준 SQL > *****
-- 계층형 쿼리 > 루프 역할
select 
    level,
    sysdate + level - 1
from dual
    connect by level <= 10;

-- 원하는 날짜 생성 > 기억!!!
create or replace view vwDate
as
select
    to_date('2024-08-01', 'yyyy-mm-dd') + level - 1 as regdate
from dual
    connect by level 
        <= (to_date('2024-08-31', 'yyyy-mm-dd') - to_date('2024-08-01', 'yyyy-mm-dd') + 1);

select * from vwDate;   -- 8월 한달 날짜
select * from tblDate;  -- 8월 근태 기록

select
    *
from vwDate v
    left outer join tblDate t
        on to_char(v.regdate, 'yyyy-mm-dd') = to_char(t.regdate, 'yyyy-mm-dd')
            order by v.regdate;
            
select
    v.regdate,
    case
        when to_char(v.regdate, 'd') = '1' then '일요일'
        when to_char(v.regdate, 'd') = '7' then '토요일'
        else t.state
    end state
from vwDate v
    left outer join tblDate t
        on to_char(v.regdate, 'yyyy-mm-dd') = to_char(t.regdate, 'yyyy-mm-dd')
            order by v.regdate;
            
            
select
    v.regdate,
    case
        when to_char(v.regdate, 'd') = '1' then '일요일'
        when to_char(v.regdate, 'd') = '7' then '토요일'
        when h.seq is not null then h.name
        when h.seq is null and t.seq is null then '결석'
        else t.state
    end state
from vwDate v
    left outer join tblDate t
        on to_char(v.regdate, 'yyyy-mm-dd') = to_char(t.regdate, 'yyyy-mm-dd')
            left outer join tblHoliday h
                on to_char(v.regdate, 'yyyy-mm-dd') = to_char(h.regdate, 'yyyy-mm-dd') 
            order by v.regdate;




