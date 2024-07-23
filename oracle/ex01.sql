-- 한줄 주석

/*
    여러줄 주석
    ex01.sql
    
    설치 프로그램
    1. Oracle Database 11g Express Edition
        - 데이터베이스(DB)
        - 오라클(회사) > 오라클(제품)
        - 11g > 버전
        - Express Edition > 종류 > 무료 버전(기능 제한x, 성능 제한o)
        - 실행 화면이 없는 프로그램 > 눈에 안보이는 프로그램(백그라운드 프로그램) ? 
            - 서비스(Windows), linux/mac(데몬) > 조작가능한 UI가 없다.
        
    2. SQL Developer
        - 데이터베이스 클라이언트 도구(DB Client Tools) > GUI
        - 데이터베이스를 조작하는 프로그램
        
    3. SQL*Plus
        - 데이터베이스 클라이언트 도구 > CLI(Command Line Interface)
        - 간단한 작업용
        
    Oracle Database 11g Express Edition
    - 오라클 서비스
    - Win + R > services.msc > OracleServiceXE/OracleXETNSListener가 실행중
    
    1. OracleServiceXE
        - 오라클 데이터베이스
        - 메인 서비스
        - 서비스 제어
            - net start 서비스명
            - net stop 서비스명
    
    2. OracleXETNSListener
        - 클라이언트 접속 관리
        
    오라클 설치 중..
    - 암호 입력(java1234)
    - SYS, SYSTEM 계정의 암호가 될 예정이다 > 기본 계정 > 관리자 계정
        - SYS(회장님, 최고 관리자), SYSTEM(사장님, 최고 관리자 기능 중 하나가 빠짐)
    
    SQL Developer 접속
    - 오라클 데이터베이스에 접속
    1. 사용자 이름: system
    2. 비밀번호: java1234
    3. 호스트 이름: localhost > 오라클이 설치된 컴퓨터 IP or 도메인 > 원격 접속
        > localhost(127.0.0.1, 절대값) 예약어, 192.168.10.34(상대값)
    4. 포트: 1521(Listener Port Number) 외부로부터 접속을 받기 위한 번호
    5. SID: xe > 하나의 컴퓨터에 여러 오라클 설치 > 구분 식별자
        ex. orcl1, orcl2
        but. orcl은 무료버전이기 때문에 오라클을 여러개 깔지 못한다 > 이름 고정
    6. Name: system@localhost > 접속 이력명 > 접속 이력을 남기기 위한 이름
        ex. localhost.system
    
    
    DB 계정
    1. SYSTEM
        - 로컬 접속 가능
        - 원격 접속 가능
        
    2. SYS
        - 로컬 접속 가능
        - 원격 접속 불가(보안 때문)
    
    3. 일반 계정
        - 생성 후 사용
        3.1 hr, scott
            - 학습용 계정
            - 소량의 데이터 제공 > 학습
        3.2 직접 생성
            - 수업 중
            - 프로젝트 
            
    hr 계정 사용하기
    1. 잠긴 계정 풀기
        - alter user 유저명 account unlock;
    2. 암호 바꾸기
        - alter user 유저명 identified by 암호명;
    3. 
*/


-- ctrl + Enter
ALTER USER hr ACCOUNT UNLOCK;

ALTER USER hr IDENTIFIED BY java1234;

/*
    Database 
    - 데이터베이스
    - 데이터의 집합
    
    Database Management System
    - 데이터베이스 관리 시스템
    - 데이터 집합 + 조작/관리
    - 오라클 > DBMS
    
    Relational Database Management System
    - 관계형 데이터베이스 관리 시스템
    - RDB, RDBMS
    - 테이블로 데이터를 저장하는 DB
    
    RDBMS
    - Oracle > 기업용 > 자바
    - MSSQL > MS > 기업용
    - DB2 > IBM > 기업용
    - MySQL > Oracle > 무료 > 개인/중소기업용 > 대기업 > 유/무료로 바뀜
    - MariaDB > MySQL 유사 > 무료
    - PostreSQL > MySQL, MariaDB와 유사
    - SQLite > 모바일
    - H2 > 스프링 > 초경량 DB, SQLite와 유사
    - MS Access > MS 오피스 > 개인용 DB
    
    Oracle Database Version
    - 1.0 
    - 11g
    - 23ai
    
    오라클(데이터베이스, DB 서버) <-> SQL Developer(클라이언트 툴) <-> 개발자(클라이언트) 
    
    SQL, Structured Query Language
    - 오라클 사용하는 언어 > 모든 관계형 데이터베이스 관리 시스템이 사용하는 언어
    - RDBMS(R*DB)와 대화하는 언어
    - 구조화된 질의 언어
    - Query(질의) > 오라클에게 질문
    - SQL == Query
    
    DB 분야 직군
    - 오라클 시스템 + SQL 언어
    
    1. 데이터베이스 관리자, DBA, Database Administrator
        - 모든 것 취급
    
    2. 데이터베이스 개발자
        - 거의 모든 것
    
    3. 응용 프로그램 개발자(=자바 개발자)
        - 일부 작업 > SQL 언어
    
    SQL
    1. 데이터베이스 제작사와 독립적이다.
        - 모든 데이터베이스에서 공통으로 사용한다.
        - 표준 SQL > 제작사들이 자신의 제품에 적용한다.
    
    2. 표준 SQL, ANSI-SQL
        - 모든 DB에서 사용 가능한 SQL
        
    3. 방언
        - 제작사 별로 자기 제품에서만 동작하는 SQL
        - Oracle > PL/SQL
        - MS-SQL > T-SQL
        
    오라클 수업 = 표준 SQL(60%) + DB 설계(10%) + PL/SQL(30%)
        - 2주 정도
        
    표준 SQL 
    
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
        
    2. DML
        - Data Manipulation Language
        - 데이터 조작어
        - 데이터를 추가/수정/삭제/조회하는 명령어
        - 사용 빈도가 가장 높음
        - CRUD
            a. select: 조회(읽기)   > [R]ead
            b. insert: 추가(생성)   > [C]reate
            c. update: 수정         > [U]pdate
            d. delete: 삭제         > [D]elete
        - 직업군
            - 데이터베이스 관리자
            - 데이터베이스 개발자
            - 프로그래머(*********)
            
    3. DCL
        - Data Control Language
        - 데이터 제어어
        - 계정 관리, 보안 관리, 트랜잭션 처리 등..
            a. commit
            b. rollback
            c. grant
            d. revoke
        - 직업군
            - 데이터베이스 관리자
            - 데이터베이스 개발자
            - 프로그래머(일부)
    
    4. DQL
        - Data Query Language
        - DML 중에서 select문을 따로 부르는 표현
        
    5. TCL
        - Transaction Control Language
        - DCL 중에서 commit, rollback문을 따로 부르는 표현
    
    오라클 인코딩
    - 1.0 ~ 8: EUC-KR
    - 9i ~ 현재: UTF-8
    
    Java > 대소문자를 구분한다.(Strong 타입 Language)
    SQL > 대소문자를 구분하지 않는다.(Weak 타입 Language)
    - 파란색 > 키워드 > 대문자
    - 검은색 > 식별자 > 소문자
    
*/

-- alt + '
select * from tabs;

SELECT * FROM tabs;

