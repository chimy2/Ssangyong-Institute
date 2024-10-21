-- Code/script.sql

-- 코드 테이블
drop table tblCode;

create table tblCode (
    seq number primary key,                 -- 글번호
    subject varchar2(300) not null,         -- 제목
    code varchar2(2000) not null,           -- 코드
    regdate date default sysdate not null,  -- 생성날짜
    language varchar2(30) not null          -- 언어
);

create sequence seqCode;

insert into tblCode values(seqCode.nextVal, '제목', '코드', default, 'java');

commit;