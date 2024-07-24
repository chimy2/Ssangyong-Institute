/*
    
    *** 각각의 절은 역할과 실행 순서가 있다.
    [WITH <Sub Query>]
    SELECT column_list
    FROM table_name
    [WHERE search_condition]
    [GROUP BY group_by_expression]
    [HAVING search_condition]
    [ORDER BY order_expression [ASC/DESC]];
    
    ORDER BY절
    - 정렬
    - ORDER BY 컬럼명      -- ascending
    - ORDER BY 컬럼명 ASC  -- ascending, 오름차순
    - ORDER BY 컬럼명 DESC -- descending, 내림차순
    
    역할
    SELECT 컬럼리스트  -- 원하는 컬럼을 지정 > 지정된 컬럼만 가져와라.
    FROM 테이블        -- 데이터 소스. 어떤 테이블로부터 데이터를 가져와라.
    WHERE 검색조건     -- 조건 지정. 원하는 레코드만 걸러낸다.
    ORDER BY 정렬기준; -- 결과셋의 레코드 순서를 정한다.
    
    순서
    3. SELECT
    1. FROM
    2. WHERE
    4. ORDER BY
    

*/

select * from tblInsa;

select * from tblInsa order by basicpay;
select * from tblInsa order by sudang desc;

-- 자료형 확인
select * from tblInsa order by basicpay;   -- 숫자형
select * from tblInsa order by name;       -- 문자형
select * from tblInsa order by ibsadate;   -- 날짜시간형


-- 다중 정렬
select * from tblInsa order by buseo asc;                           -- 1차 정렬
select * from tblInsa order by buseo asc, jikwi asc;                -- 2차 정렬
select * from tblInsa order by buseo asc, jikwi asc, basicpay desc; -- 3차 정렬

select 
    num, name, buseo, jikwi
from tblInsa 
order by buseo;


-- Java > 첨자가 0부터 시작한다.(컴파일 언어)
-- SQL > 첨자가 1부터 시작한다.(스크립트 언어)
select 
    num, name, buseo, jikwi -- 2.
from tblInsa                -- 1.
order by buseo;             -- 3. 컬럼의 순서 > 정렬 기준


select 
    num, name, buseo, jikwi -- 2.
from tblInsa                -- 1.
order by 3;             -- 3. 컬럼의 순서 > 정렬 기준 > 비권장

-- 가공된 값을 정렬 기준으로 사용
select * from tblInsa order by basicpay desc;
select * from tblInsa order by basicpay + sudang desc;

-- 남자 > 여자 순으로 정렬
select name, ssn,
    case
        when ssn like '%-1%' then '남자'
        when ssn like '%-2%' then '여자'
    end gender                              -- 2.
from tblInsa                                -- 1.
    order by gender;                        -- 3.
    
-- 직위 순으로 정렬: 부장(1) > 과장(2) > 대리(3) > 사원(4)
select name, jikwi,
    case 
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end
from tblInsa order by 3 asc;

select name, jikwi
from tblInsa order by 
    case 
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end asc;