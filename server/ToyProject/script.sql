-- ToyProject > script.sql

-- user system

show user;

create user toy identified by java1234;

grant connect, resource, dba to toy;


-- user toy

-- 유저 테이블
drop table tblUser;

create table tblUser (
    id varchar2(50) primary key,                        -- 아이디
    pw varchar2(50) not null,                           -- 암호
    name varchar2(50) not null,                         -- 이름
    email varchar2(100) not null,                       -- 이메일
    lv number(1) not null,                              -- 등급(1.일반, 2.관리자)
    pic varchar2(100) default 'pic.png' not null,       -- 프로필 사진
    intro varchar2(500) null,                           -- 소개
    regdate date default sysdate not null,              -- 가입날짜
    ing number(1) default 1 not null                    -- 탈퇴(1.활동, 0.탈퇴)
);

-- 회원 데이터
insert into tblUser (id, pw, name, email, lv, pic, intro, regdate, ing)
    values ('hong', '1111', '홍길동', 'hong@gmail.com', 1, default, '안녕하세요.', default, default);
    
insert into tblUser (id, pw, name, email, lv, pic, intro, regdate, ing)
    values ('dog', '1111', '강아지', 'dog@gmail.com', 1, default, '멍멍~', default, default);
    
insert into tblUser (id, pw, name, email, lv, pic, intro, regdate, ing)
    values ('cat1', '1111', '고양이', 'cat@gmail.com', 2, null, '냐옹~ 관리자', default, default);
    
select * from tblUser;

commit;

-- 로그인
select * from tblUser where id = ? and pw = ?;

-- 게시판 테이블
create table tblBoard (
    seq number primary key,                         -- 글번호(PK)
    subject varchar2(300) not null,                 -- 제목
    content varchar2(4000) not null,                -- 내용
    regdate date default sysdate not null,          -- 날짜
    readcount number default 0 not null,            -- 조회수
    id varchar2(50) references tblUser(id) not null -- 아이디(FK)
);

create sequence seqBoard;

select * from tblBoard;

select seq, subject, substr(regdate, 1, 11) as regdate, readcount, id from tblBoard order by seq desc;

-- 함수
-- 작성 날짜 or 작성 시간 함수
-- 1. 조회 시각이 오늘과 같은 날짜면 > 시간 반환
-- 2. 조회 시각이 오늘과 다른 날짜면 > 날짜 반환
create or replace function fnRegdate (
    regdate date
) return varchar2
is

begin
    if to_char(sysdate, 'yyyy-mm-dd') = to_char(regdate, 'yyyy-mm-dd') then
        return to_char(regdate, 'hh24:mi:ss');
    else 
        return to_char(regdate, 'yyyy-mm-dd');
    end if;
end fnRegdate;
/

select * from tblBoard;
select fnRegdate(regdate) from tblBoard;
-- 에러 발생 시 밑의 줄 확인해서 실행

select tablespace_name, file_name, bytes from dba_data_files;
select username, default_tablespace from dba_users;

-- system으로 실행
alter user toy default tablespace users;
-- 여기까지

select * from tblBoard order by seq desc;

update tblBoard set regdate = regdate - 2 where seq <= 5;
update tblBoard set regdate = regdate - 1.5 where seq = 6;
update tblBoard set regdate = regdate - 1 where seq = 7;

select fnRegdate(regdate) from tblBoard order by seq desc;

commit;