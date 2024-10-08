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