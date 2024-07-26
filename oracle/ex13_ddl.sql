/*

    1. ex01 ~ ex12 > DML 수업(select)
    2. DDL > 테이블(구조)
    3. DML 수업(insert, update, delete, select)
    4. 데이터베이스 설계
    5. PL/SQL
    -------------------
    6. 프로젝트

    
    1. DDL
        - Data Difintion Language
        - 데이터 정의어
        - 테이블, 뷰, 사용자, 인덱스 등의 데이터베이스 오브젝트를 생성/수정/삭제하는 명령어
        - DB 구조를 생성/수정/삭제하는 명령어
            a. create: 생성
            b. drop: 삭제
            c. alter: 수정
        - 직업군
            - 데이터베이스 관리자
            - 데이터베이스 개발자
            - 프로그래머(일부)
            
    테이블 생성하기 > 스키마 정의하기 > 컬럼 정의하기 > 컬럼의 이름, 자료형, 제약사항 정의
    
    테이블 생성하기
    
    CREATE TABLE 테이블명 {
        컬럼 정의,
        컬럼 정의,
        컬럼명 자료형(길이) NULL 제약사항
    }
    
    제약사항, Constraint
    - 해당 컬럼에 들어가는 데이터(값)에 대한 조건(규칙)
        1. 조건을 만족하면 > 대입
        2. 조건을 불만족하면 > 에러 발생 > 무결성 유지!!
    - 데이터 무결성을 보장하는 도구
    
    1. NOT NULL
        - 해당 컬럼이 반드시 값을 가져야 한다.
        - 해당 컬럼에 값이 없으면 에러 발생!!
        - 필수값
        
    2. PRIMARY KEY, PK
        - 기본키
        - 테이블의 레코드(행)를 구분하기 (대표)식별자 역할
        - *** 모든 테이블은 반드시 1개의 기본키가 존재해야 한다.
        - PRIMARY KEY = UNIQUE + NOT NULL
    
    3. FOREIGN KEY
        - 나중에    
    
    4. UNIQUE
        - 유일하다. > 레코드 간의 중복값을 가질 수 없다. > PK?
        - NULL을 가질 수 있다. > 식별자가 될 수 없다.
        ex) 초등학교 교실
            - 학생(번호(PK), 이름(NN), 직책(UQ))
                1, 홍길동, 반장
                2, 아무개, null
                3, 하하하, 부반장
                4, 호호호, null
    
    5. CHECK
        - 사용자 정의형 제약 사항
        - where절 조건 > 컬럼의 제약사항으로 사용
    
    6. DEFAULT
        - 기본값 설정
        - insert/update 작업 시 > 해당 컬럼에 값을 안넣으면 null 대신 미리 설정한 값을 대입
*/

-- 메모 테이블
create table tblMemo (
    -- 컬럼명 자료형(길이) NULL 제약사항
    seq number(3),      -- 메모번호
    name varchar2(30),  -- 작성자
    memo varchar2(1000),-- 메모내용
    regdate date        -- 작성날짜
);

create table tblMemo (
    -- 컬럼명 자료형(길이) NULL 제약사항
    seq number(3) null,     -- 기본적으로 null이 생략되어 있음 
    name varchar2(30) null,  
    memo varchar2(1000) null,
    regdate date null
);


select * from tblMemo;
select to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') from tblMemo;

insert into tblMemo values(1, '홍길동', '메모입니다.', '2024-07-25');
insert into tblMemo values(2, '아무개', '메모입니다.', to_date('2024-07-25 17:37:30', 'yyyy-mm-dd hh24:mi:ss'));
insert into tblMemo(seq, name, memo, regdate) values(3, '홍길동', '다른 메모입니다.', sysdate);
insert into tblMemo values(4, '홍길동', null, sysdate);
insert into tblMemo values(5, null, null, null);
insert into tblMemo values(null, null, null, null);


-- NOT NULL 제약
drop table tblMemo;

create table tblMemo (
    seq number(3) not null,         -- 메모번호(NN)
    name varchar2(30) null,         -- 작성자
    memo varchar2(1000) not null,   -- 메모내용(NN)
    regdate date null               -- 작성날짜
);

insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);
-- SQL 오류: ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
insert into tblMemo values(2, '홍길동', null, sysdate);
-- SQL 오류: ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."MEMO")
insert into tblMemo values(3, '홍길동', '', sysdate);  -- 빈 문자열('')도 null이다.


-- PK 제약
drop table tblMemo;

create table tblMemo (
    seq number(3) primary key,      -- 메모번호(PK)
    name varchar2(30),              -- 작성자
    memo varchar2(1000) not null,   -- 메모내용(NN)
    regdate date                    -- 작성날짜
);

insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);

-- ORA-00001: unique constraint (HR.SYS_C007076) violated
insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);
insert into tblMemo values(2, '홍길동', '메모입니다.', sysdate);
-- SQL 오류: ORA-01400: cannot insert NULL into ("HR"."TBLMEMO"."SEQ")
insert into tblMemo values(null, '홍길동', '메모입니다.', sysdate);

select * from tblMemo;


-- UNIQUE 제약
drop table tblMemo;

create table tblMemo (
    seq number(3) primary key,      -- 메모번호(PK) 
    name varchar2(30) unique,       -- 작성자(UQ)
    memo varchar2(1000) not null,   -- 메모내용(NN)
    regdate date                    -- 작성날짜
);

insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);
-- ORA-00001: unique constraint (HR.SYS_C007079) violated
insert into tblMemo values(2, '홍길동', '메모입니다.', sysdate);

insert into tblMemo values(2, '아무개', '메모입니다.', sysdate);

insert into tblMemo values(3, null, '메모입니다.', sysdate);


-- CHECK 제약
drop table tblMemo;

create table tblMemo (
    seq number(3) primary key,      -- 메모번호(PK) 
    name varchar2(30),              -- 작성자(UQ)
    memo varchar2(1000),            -- 메모내용(NN)
    regdate date,                   -- 작성날짜
--    중요도(1. 중요, 2. 보통, 3. 안중요)
--    priority number(1) check(조건)              
--    priority number(1) check(priority >= 1 and priority <= 3)              
--    priority number(1) check(priority between 1 and 3)              
    priority number(1) check(priority in (1, 2, 3)),
    
--    카테고리(할일, 공부, 약속, 가족, 개인)
--    category varchar2(10) check (category = '할일' or category = '공부')
    category varchar2(10) check (category in ('할일', '공부', '약속'))
);

insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate, 2, '공부');
-- ORA-02290: check constraint (HR.SYS_C007082) violated
insert into tblMemo values(2, '홍길동', '메모입니다.', sysdate, 5, '공부');
-- ORA-02290: check constraint (HR.SYS_C007083) violated
insert into tblMemo values(2, '홍길동', '메모입니다.', sysdate, 2, '코딩');


-- DEFAULT 제약
drop table tblMemo;

create table tblMemo (
    seq number(3) primary key,          -- 메모번호(PK) 
    name varchar2(30) default '익명',   -- 작성자(UQ)
    memo varchar2(1000),                -- 메모내용(NN)
    regdate date default sysdate        -- 작성날짜
);

insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);

insert into tblMemo values(2, null, '메모입니다.', sysdate); -- default 값이 들어가지 않음

insert into tblMemo values(3, '', '메모입니다.', sysdate);   -- default 값이 들어가지 않음

select * from tblMemo;

-- null을 집어넣는 방법
-- null 상수를 집어 넣기(null 명시)/ 컬럼 생략
insert into tblMemo(seq, memo, regdate) values(4, '메모입니다.', sysdate);

select * from tblMemo;

-- 컬럼을 생략하지 않으면서도 default값을 집어 넣고 싶을 때
insert into tblMemo values(5, default, '메모입니다.', default);


/*

    제약 사항을 만드는 방법
    - 1~3 결과는 동일 > 가독성 or 코드 관리
    
    1. 컬럼 수준에서 만드는 방법
        - 위의 방식
        - 컬럼을 선언할 때 제약 사항도 같이 선언한다.
        - 예제 수준
    
    2. 테이블 수준에서 만드는 방법
        - 컬럼 선언하고 제약 사항 선언을 분리한다.
        - 코드 관리 차원
        - 프로젝트
    
    3. 외부에서 만드는 방법
        - 나중에 수업
        - 코드 관리 차원
        - 프로젝트

*/

--    1. 컬럼 수준에서 만드는 방법
drop table tblMemo;

create table tblMemo (
--    seq number(3) constraint 제약사항명 primary key,
    seq number(3) constraint tblmemo_seq_pk primary key,
    name varchar2(30),
    memo varchar2(1000),
    regdate date
);

-- ORA-00001: unique constraint (HR.SYS_C007086) violated
-- ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);


--    2. 테이블 수준에서 만드는 방법
drop table tblMemo;

create table tblMemo (
    seq number(3),
    name varchar2(30),
    memo varchar2(1000),
    regdate date,
    constraint tblmemo_seq_pk primary key(seq),
    constraint tblmemo_name_uq unique(name),
    constraint tblmemo_memo_ck check(length(memo) >= 10)
);

-- ORA-00001: unique constraint (HR.TBLMEMO_SEQ_PK) violated
insert into tblMemo values(1, '홍길동', '메모입니다.', sysdate);


