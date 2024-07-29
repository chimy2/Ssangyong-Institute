/*
    연산자, Operator
    
    1. 산술 연산자
    - +, -, *, /
    - %(없음) > 함수로 제공(mod())
    
    2. 문자열 연산자(concat)
    - +(X) > ||(O)
    
    3. 비교 연산자
    - >, >=, <, <=
    - =(==), <>(!=)
    - 논리값 반환 > boolean 존재X > 명시적 표현 불가능 > select절에서 사용X
    - 조건절에서 사용
    
    4. 비교 연산자
    - and(&&), or(||), not(!)
    - 컬럼 리스트에서 사용 불가
    - 조건절에서 사용
    
    5. 대입 연산자
    - =
    - 컬럼 = 값
    - update문
    - 복합 대입 연산자(+=, -=..) 없음
    
    6. 3항 연산자
    - 없음
    - 제어문 없음
    
    7. 증감 연산자
    - 없음
    
    8. SQL 연산자
    - 자바 > 객체 instanceof 타입
    - 오라클 > in, between, like, is 등..
    
*/

select population, area, 
    population + area,
    population - area,
    population * area,
    population / area
from tblcountry;

-- ORA-01722: invalid number
select name + capital from tblcountry;


select name || capital from tblcountry;


/*

    컬럼의 별칭(Alias)
    - 결과셋(원본X)의 컬럼명을 원하는 컬렴명으로 바꾸는 기술
    - *** 결과셋의 컬럼명이 식별자로 적합하지 않을 때 > 적합한 식별자로 수정
*/
SELECT
    name,
    age - 1,    -- 컬럼명 별칭 
    couple
FROM
    tblmen;
    
SELECT
    name,
    age - 1 as 만나이,    -- 컬럼명 별칭 
    age - 1 as age,    -- 컬럼명 별칭 
    couple
FROM
    tblmen;

select * from tblWomen;

select name, age, height from tblMen;
select hr.tblmen.name, hr.tblmen.age, hr.tblmen.height from hr.tblMen;

select m.name, m.age, m.height from tblMen m; -- 다른 DB들은 테이블의 별칭에도 as를 사용

-- ORA-00904: "TBLMEN"."HEIGHT": invalid identifier
select tblmen.name, tblmen.age, tblmen.height    -- 실행순서2
from tblMen m;                                   -- 실행순서1
-- 별칭을 붙이면 테이블명이 아예 개명이 되기 때문에 원테이블의 이름을 사용하면 오류가 난다

/*
    별칭을 붙이는 이유
    컬럼의 별칭: 식별자로서 적합하지 않아서
    테이블의 별칭: 가독성
*/