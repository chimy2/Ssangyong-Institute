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
        
    2. PRIMARY KEY
    
    3. FOREIGN KEY
    
    4. UNIQUE
    
    5. CHECK
    
    6. DEFAULT
    
*/

-- 메모 테이블
create table tblMemo (
    -- 컬럼명 자료형(길이) NULL 제약사항
    seq number(3),      -- 메모번호
    name varchar2(30),  -- 작성자
    memo varchar2(1000),-- 메모내용
    regdate date        -- 작성날짜
);

select * from tblMemo;
select to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') from tblMemo;

insert into tblMemo values(1, '홍길동', '메모입니다.', '2024-07-25');
insert into tblMemo values(2, '아무개', '메모입니다.', to_date('2024-07-25 17:37:30', 'yyyy-mm-dd hh24:mi:ss');




