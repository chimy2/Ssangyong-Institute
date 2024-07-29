/*

    관계형 데이터베이스 시스템이 지양하는 것들
    
    1. 테이블에 기본키가 없는 상태 > 데이터 조작 불가능(레코드 식별 불가능)
    2. NULL이 많은 상태의 테이블 > 공간 낭비 + SQL 작업 불편
    3. 데이터가 중복되는 상태 > 공간 낭비 + 데이터 조작 문제 발생(일관성 저하)
    4. 하나의 속성값이 원자값이 아닌 상태 > 더 이상 쪼개지지 않는 값을 넣는다.
    
*/

-- 직원 정보
-- 직원(번호(PK), 직원명, 급여, 거주지, 담당프로젝트)
create table tblStaff (
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null, -- 거주지
    project varchar2(300)           -- 담당프로젝트
);

insert into tblStaff (seq, name, salary, address, project)
    values (1, '홍길동', 300, '서울시', '홍콩 수출');
insert into tblStaff (seq, name, salary, address, project)
    values (2, '아무개', 250, '인천시', 'TV 광고');
insert into tblStaff (seq, name, salary, address, project)
    values (3, '하하하', 350, '의정부시', '매출 분석');
    
-- '홍길동'에게 담당 프로젝트가 1건 추가 > '고객 관리'
-- '홍콩 수출' + '고객 관리'

update tblStaff set project = project || ', 고객 관리' where seq = 1;
update tblStaff set project = '홍콩 수출' where seq = 1;

insert into tblStaff (seq, name, salary, address, project)
    values (4, '홍길동', 300, '서울시', '고객 관리');

select * from tblStaff;


-- 원인: 테이블 스키마(구조)가 잘못된 상태
-- 해결: 테이블 재구성

drop table tblStaff;

-- 부모 테이블
create table tblStaff(
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null  -- 거주지
--    project varchar2(300)           -- 담당프로젝트
);

-- 자식 테이블
-- 프로젝트 정보
-- 프로젝트(담당프로젝트)
create table tblProject (
    seq number primary key,         -- 프로젝트번호
    project varchar2(300),          -- 담당프로젝트
    staff_seq number not null       -- 담당직원번호
);

insert into tblStaff (seq, name, salary, address)
    values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address)
    values (2, '아무개', 250, '인천시');
insert into tblStaff (seq, name, salary, address)
    values (3, '하하하', 350, '의정부시');
 
insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);

select * from tblStaff;
select * from tblProject;

-- A. 신입 사원 입사 > 신규 프로젝트 배정
-- A.1 신입 사원 추가
insert into tblStaff (seq, name, salary, address)
    values (4, '호호호', 250, '성남시');
    
-- A.2 신규 프로젝트 발주 + 담당자 배정
insert into tblProject (seq, project, staff_seq) values (6, '자재 매입', 4);

-- A.3 신규 프로젝트 발주 + 담당자 배정
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5);


-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제
delete from tblStaff where seq = 1;

-- B.2 '홍길동' 삭제 > 업무 인수 인계(위임)
update tblProject set staff_seq = 2 where staff_seq = 1;

-- B.3 '홍길동' 삭제
delete from tblStaff where seq = 1;

select * from tblStaff;
select * from tblProject;

delete from tblProject;
delete from tblStaff;

drop table tblStaff;
drop table tblProject;

-- 부모 테이블
create table tblStaff(
    seq number primary key,         -- 직원번호(PK)
    name varchar2(30) not null,     -- 직원명
    salary number not null,         -- 급여
    address varchar2(300) not null  -- 거주지
--    project varchar2(300)           -- 담당프로젝트
);

-- 자식 테이블
-- 프로젝트 정보
-- 프로젝트(담당프로젝트)
create table tblProject (
    seq number primary key,                             -- 프로젝트번호
    project varchar2(300),                              -- 담당프로젝트
    staff_seq number references tblStaff(seq) not null  -- 담당직원번호(FK)
);

insert into tblStaff (seq, name, salary, address)
    values (1, '홍길동', 300, '서울시');
insert into tblStaff (seq, name, salary, address)
    values (2, '아무개', 250, '인천시');
insert into tblStaff (seq, name, salary, address)
    values (3, '하하하', 350, '의정부시');
 
insert into tblProject (seq, project, staff_seq) values (1, '홍콩 수출', 1);
insert into tblProject (seq, project, staff_seq) values (2, 'TV 광고', 2);
insert into tblProject (seq, project, staff_seq) values (3, '매출 분석', 3);
insert into tblProject (seq, project, staff_seq) values (4, '노조 협상', 1);
insert into tblProject (seq, project, staff_seq) values (5, '대리점 분양', 2);

-- A. 신입 사원 입사 > 신규 프로젝트 배정
-- A.1 신입 사원 추가
insert into tblStaff (seq, name, salary, address)
    values (4, '호호호', 250, '성남시');
    
-- A.2 신규 프로젝트 발주 + 담당자 배정
insert into tblProject (seq, project, staff_seq) values (6, '자재 매입', 4);

-- A.3 신규 프로젝트 발주 + 담당자 배정
-- ORA-02291: integrity constraint (HR.SYS_C007140) violated - parent key not found
insert into tblProject (seq, project, staff_seq) values (7, '고객 유치', 5);


-- B. '홍길동' 퇴사
-- B.1 '홍길동' 삭제
-- ORA-02292: integrity constraint (HR.SYS_C007140) violated - child record found
delete from tblStaff where seq = 1;

-- B.2 '홍길동' 삭제 > 업무 인수 인계(위임)
update tblProject set staff_seq = 2 where staff_seq = 1;

-- B.3 '홍길동' 삭제
delete from tblStaff where seq = 1;

select * from tblStaff;
select * from tblProject;


/*

    조인, Join
    - (서로 관계를 맺고 있는) 2개(1개) 이상의 테이블을 1개의 결과셋으로 만드는 기술
    
    조인의 종류
    1. 단순 조인, Cross Join
    2. 내부 조인, Inner Join
    3. 외부 조인, Outer Join
    4. 셀프 조인, Self Join
    5. 전체 외부 조인, Full Outer Join


    1. 단순 조인, Cross Join, 카티션 곱, 데카르트 곱
    - 모든 조인의 기본 동작
    - A 테이블 X B 테이블
    - 쓸모없다. > 가치있는 행과 가치없는 행이 뒤섞여 있어서..
    - 대량의 더미 생산용(유효성 낮음)
    
*/

select * from tblCustomer;  -- 3명
select * from tblSales;     -- 9건

select * from tblCustomer cross join tblSales;  -- 3 x 9 = 27개, 표준 SQL 권장!! 
select * from tblCustomer, tblSales;            -- 오라클 전용

/*

    2. 내부 조인, Inner Join ***********
    - 단순 조인에서 유효한 레코드만 추출한 조인

    select 컬럼리스트 from 테이블A cross join 테이블B;
    select 컬럼리스트 
        from 테이블A inner join 테이블B   -- 테이블X테이블
        on 테이블A.컬럼 = 테이블B.컬럼;   -- 조인의 where 절
    select 컬럼리스트 
        from 테이블A inner join 테이블B
        on 부모테이블.컬럼(PK) = 자식테이블.컬럼(FK);   -- 조인의 where 절

*/

select * from tblCustomer inner join tblSales on tblcustomer.seq = tblsales.cseq;

select * from tblStaff cross join tblProject;
select * from tblStaff inner join tblProject on tblstaff.seq = tblproject.staff_seq;

-- 고객번호, 고객명(tblCustomer), 상품번호, 상품명(tblSales)
-- ORA-00918: column ambiguously defined
select seq, name, seq, item from tblCustomer inner join tblSales on tblcustomer.seq = tblsales.cseq;
select tblCustomer.seq, name, tblSales.seq, item from tblCustomer inner join tblSales on tblcustomer.seq = tblsales.cseq;
select c.seq cseq, name, s.seq sseq, item from tblCustomer c inner join tblSales s on c.seq = s.cseq;

-- 고객 + 판매
-- 어떤 고객(c.name)이 어떤 물건(s.item)을 몇 개(s.qty) 사갔는지?
select 
    c.name as 고객명,
    s.item as 상품명,
    s.qty as 수량
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;

-- 어떤 고객(c.name)이 어떤 물건(s.item)을 몇 개(s.qty) 사갔는지?
-- 메인SQL > 자식 테이블
-- 서브SQL > 부모 테이블
select 
    item as 상품명,
    qty as 수량,
    (select name from tblCustomer where seq = s.cseq) as 고객명
from tblSales s;


-- 장르 + 비디오
select 
    * 
from tblGenre g 
    inner join tblVideo v
        on g.seq = v.genre;

-- 장르 + 비디오 + 대여
select 
    *
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video;

-- 장르 + 비디오 + 대여 + 회원
select 
    m.name 누가,
    v.name 무엇을,
    r.rentdate 언제,
    g.price 얼마에
from tblGenre g
    inner join tblVideo v
        on g.seq = v.genre
            inner join tblRent r
                on v.seq = r.video
                    inner join tblMember m
                        on m.seq = r.member;

-- hr
select
    *
from employees e
    inner join departments d
        on d.department_id = e.department_id
            inner join locations l
                on l.location_id = d.location_id
                    inner join countries c
                        on c.country_id = l.country_id
                            inner join regions r
                                on r.region_id = c.region_id
                                    inner join jobs j
                                        on j.job_id = e.job_id;
        
/*

    3. 외부 조인, Outer Join
    - 내부 조인 반댓말(X)
    - 내부 조인 결과셋 + α(내부 조인에 포함되지 않은 부모 테이블의 나머지 레코드
    
    select 
        컬럼리스트
    from 테이블X
        (left|right) outer join 테이블B
            on 테이블A.PK = 테이블B.FK;

*/

select * from tblCustomer;  -- 3
select * from tblSales;     -- 9

insert into tblCustomer values (4, '호호호', '010-9999-9999', '서울시');
insert into tblCustomer values (5, '후후후', '010-5555-5555', '강릉시');

-- 내부 조인 > 9개
-- > 물건을 한번이라도 구매한 이력이 있는 고객의 정보 + 구매 내역을 가져오시오.
-- > 구매 이력이 없는 4, 5번 회원은 제외
-- > 내부 조인 > 양쪽 테이블 모두에 존재하는 행만 가져오기
select 
    *
from tblCustomer c
    inner join tblSales s
        on c.seq = s.cseq;
        
-- 외부 조인 > 11개
-- inner join 결과셋 + inner join이 안된 행을 가져온다.
-- > 물건을 한번이라도 구매한 이력이 있는 고객의 정보 + 구매 내역을 가져오시오.
-- > 물건을 한번도 구매 안한 고객의 정보까지도 같이 가져오시오.(+α)
select
    *
from tblCustomer c
    left outer join tblSales s
        on c.seq = s.cseq;
        
-- 부모쪽으로 방향을 두지 않으면 inner join이 된다 > 9개
-- 참조키는 보통 not null로 두기 때문에 inner join이 되어 outer join을 하는 이유가 없어진다.
select
    *
from tblCustomer c
    right outer join tblSales s
        on c.seq = s.cseq;
  
-- 내부조인 > 프로젝트를 최소 1건 이상 담당하고 있는 직원 명단 + 담당 프로젝트
select 
    *
from tblStaff s
    inner join tblProject p
        on s.seq = p.staff_seq;
        
-- 외부조인 > 담당 프로젝트의 유무와 상관없이 모든 직원 + 프로젝트 정보
select
    *
from tblStaff s
    left outer join tblProject p
        on s.seq = p.staff_seq;
        
-- 비디오(P) + 대여(C) > 대여가 한번이라도 발생했던 비디오 +  대여기록
select count(*) from tblVideo;  -- 11

select * from tblVideo v
    inner join tblRent r
        on v.seq = r.video;
        
select distinct name from tblVideo v
    inner join tblRent r
        on v.seq = r.video;
    
-- 비디오(P) + 대여(C) > 대여와 상관없이 모든 비디오 + 대여기록
select * from tblVideo v
    left outer join tblRent r
        on v.seq = r.video;
        
-- 회원 + 대여 > 대여를 최소 1회 이상 했던 회원 + 대여 내역
select * from tblMember m
    inner join tblRent r
        on m.seq = r.member;
        
-- 회원 + 대여 > 대여와 상관없이 모든 회원 + 대여 내역
select * from tblMember m
    left outer join tblRent r
        on m.seq = r.member;
        
select * from tblMember m
    left outer join tblRent r
        on m.seq = r.member
            where r.seq is null;
        
-- 대여 기록이 있는 회원의 이름과 연락처 + 대여 횟수
select
    m.name,
--    m.tel,
    count(*),
    (select tel from tblMember where name = m.name)
from tblMember m
    inner join tblRent r
        on m.seq = r.member
             group by m.name
                order by count(*) desc;

select name, tel, count(*) from tblMember m
    inner join tblRent r
        on m.seq = r.member
            group by name, tel
                order by count(*) desc;
/*

    4. 셀프 조인, Self Join
    5. 전체 외부 조인, Full Outer Join

*/