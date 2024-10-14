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

create or replace view vwBoard
as
select
    tblBoard.*, fnRegdate(regdate) as regtime,
    (select name from tblUser where id = tblBoard.id) as name,
    (sysdate - regdate) as isnew
from tblBoard
    order by seq desc;

select * from (select a.*, rownum as rnum from vwBoard a)
    where rnum between 1 and 10;
    
select * from (select a.*, rownum as rnum from vwBoard a)
    where rnum between 11 and 20;
    
-- 댓글
create table tblComment(
    seq number primary key,                         -- 번호(PK)
    content varchar2(2000) not null,                -- 댓글
    regdate date default sysdate not null,          -- 날짜
    id varchar2(50) references tblUser(id) not null,-- 유저(FK)
    bseq number references tblBoard(seq) not null   -- 부모글(FK)
);

create sequence seqComment;

select * from tblComment;

select * from tblBoard order by seq desc;

update tblBoard set subject = '<h1 style=''color:gold;''> 다시 테스트입니다.</h1>' where seq = 285;

commit;

create or replace view vwBoard
as
select
    tblBoard.*, fnRegdate(regdate) as regtime,
    (select name from tblUser where id = tblBoard.id) as name,
    (sysdate - regdate) as isnew,
    (select count(*) from tblComment where bseq = tblBoard.seq) as commentCount 
from tblBoard
    order by seq desc;

    
drop table tblComment;
drop table tblBoard;

-- 게시판 테이블(+답변 > 계층형)
create table tblBoard (
    seq number primary key,                             -- 글번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    regdate date default sysdate not null,              -- 날짜
    readcount number default 0 not null,                -- 조회수
    id varchar2(50) references tblUser(id) not null,    -- 아이디(FK)
    thread number not null,                             -- 답변형(그룹+정렬)
    depth number not null                               -- 답변형(들여쓰기)
);

-- 댓글
create table tblComment (
    seq number primary key,                         -- 번호(PK)
    content varchar2(2000) not null,                -- 댓글
    regdate date default sysdate not null,          -- 날짜
    id varchar2(50) references tblUser(id) not null,-- 유저(FK)
    bseq number references tblBoard(seq) not null   -- 부모글(FK)
);

select max(thread) from tblBoard;

select nvl(max(thread), 0) from tblBoard;

select * from tblBoard;

create or replace view vwBoard
as
select
    tblBoard.*, fnRegdate(regdate) as regtime,
    (select name from tblUser where id = tblBoard.id) as name,
    (sysdate - regdate) as isnew,
    (select count(*) from tblComment where bseq = tblBoard.seq) as commentCount 
from tblBoard
    order by thread desc;
    
select * from vwBoard;


drop table tblComment;
drop table tblBoard;

-- 답변글 O > 수정하도록 컬럼 추가
create table tblBoard (
    seq number primary key,                             -- 글번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    regdate date default sysdate not null,              -- 날짜
    readcount number default 0 not null,                -- 조회수
    id varchar2(50) references tblUser(id) not null,    -- 아이디(FK)
    thread number not null,                             -- 답변형(그룹+정렬)
    depth number not null,                              -- 답변형(들여쓰기)
    ing number(1) default 1 not null                    -- 삭제 유무
);

-- 댓글
create table tblComment (
    seq number primary key,                         -- 번호(PK)
    content varchar2(2000) not null,                -- 댓글
    regdate date default sysdate not null,          -- 날짜
    id varchar2(50) references tblUser(id) not null,-- 유저(FK)
    bseq number references tblBoard(seq) not null   -- 부모글(FK)
);

select count(*) from tblBoard where thread < 1997
    and thread > (select nvl(max(thread), 이전새글의thread) from tblBoard
        where thread < 현재글thread and depth = 현재글depth);
        
select * from vwBoard;
-- 테이블을 수정하거나 삭제하면 view에 반영이 안되기 때문에 view를 재정의 해줘야 한다.


drop table tblComment;
drop table tblBoard;

-- 첨부파일 추가
create table tblBoard (
    seq number primary key,                             -- 글번호(PK)
    subject varchar2(300) not null,                     -- 제목
    content varchar2(4000) not null,                    -- 내용
    regdate date default sysdate not null,              -- 날짜
    readcount number default 0 not null,                -- 조회수
    id varchar2(50) references tblUser(id) not null,    -- 아이디(FK)
    thread number not null,                             -- 답변형(그룹+정렬)
    depth number not null,                              -- 답변형(들여쓰기)
    ing number(1) default 1 not null,                   -- 삭제 유무
    attach varchar2(300) null                           -- 첨부파일
);

-- 댓글
create table tblComment (
    seq number primary key,                         -- 번호(PK)
    content varchar2(2000) not null,                -- 댓글
    regdate date default sysdate not null,          -- 날짜
    id varchar2(50) references tblUser(id) not null,-- 유저(FK)
    bseq number references tblBoard(seq) not null   -- 부모글(FK)
);

select * from tblBoard;

-- 좋아요/싫어요 테이블
create table tblGoodBad (
    seq number primary key,                             -- PK
    id varchar2(50) references tblUser(id) not null,    -- 아이디(FK)
    bseq number references tblBoard(seq) not null,      -- 게시물(FK)
    state number(1) not null                            -- 1(좋아요), 0(싫어요)
);

create sequence seqGoodBad;

select * from tblGoodBad;