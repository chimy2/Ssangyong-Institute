-- AjaxTest > script.sql

-- 설문 조사
create table tblSurvey (
    seq number primary key,                 -- 번호(PK)
    question varchar2(300) not null,        -- 질문
    item1 varchar2(300) not null,           -- 항목1
    item2 varchar2(300) not null,           -- 항목2
    item3 varchar2(300) not null,           -- 항목3
    item4 varchar2(300) not null,           -- 항목4
    cnt1 number default 0 not null,         -- 선택1
    cnt2 number default 0 not null,         -- 선택2
    cnt3 number default 0 not null,         -- 선택3
    cnt4 number default 0 not null          -- 선택4
);

insert into tblSurvey values (1, '가장 자신있는 프로그래밍 언어는?',
    'JAVA', 'C#', 'Python', 'C++', default, default, default, default);
    
select * from tblSurvey;

update tblSurvey set
    cnt1 = 10,
    cnt2 = 12,
    cnt3 = 4,
    cnt4 = 5
        where seq = 1;
        
commit;

select * from tblUser;


-- 고양이 테이블
create table tblCat (
    catid varchar2(50) primary key, -- <img id="cat1">
    left number not null,
    top number not null
);

insert into tblCat values ('cat1', 0, 0);

select * from tblCat;

delete from tblCat;

select max(to_number(substr(catid, 4))) from tblCat;

commit;

select * from tblAddress;

commit;

-- 테이블의 데이터 삭제하기
-- 1. delete 
-- 2. truncate = delete + commit

-- 3. drop

delete from tblAddress;

rollback;

-- Table TBLADDRESS이(가) 잘렸습니다.
truncate table tblAddress;
