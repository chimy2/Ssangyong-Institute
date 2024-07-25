/*

    메서드
    - 함수, 프로시저 등..
    - 클래스 안에서 선언한 함수

    함수, Function
    1. 내장 함수(Built-in Function)
    2. 사용자 정의 함수(User Function) > 표준SQL(X)
    
    집계 함수, Aggregation Function
    - Java Stream> count(), sum(), max(), min(), average()
    - 아주 쉬움 > 나중에 하는 수업과 결합 > 꽤 어려움;;
    
    1. count()
    2. sum()
    3. avg()
    4. max()
    5. min()
    
    1. count()
    - 결과 테이블의 레코드 수를 반환한다.
    - number count(컬럼명)
    - null 값은 제외한다.(*****)
    
*/

select * from tblCountry;
select count(*) from tblCountry;

select name from tblCountry;
select count(name) from tblCountry;

select population from tblCountry;
select count(population) from tblCountry;


-- 연락처가 있는  직원 수?
select count(*) from tblInsa;   -- 60
select count(tel) from tblInsa; -- 57

select count(*) - count(tel) from tblInsa;

select count(*) from tblInsa where tel is not null; -- 57
select count(*) from tblInsa where tel is null;     -- 3

-- tblInsa. 어떤 부서들이 있나? > 부서 총 몇개?
select count(distinct buseo) from tblInsa;

-- tblComedian. 남자수? 여자수? 
select * from tblComedian;

select count(*) from tblComedian where gender = 'm';
select count(*) from tblComedian where gender = 'f';

-- tblComedian. 남자수? 여자수? > 1개의 테이블 > 자주 사용되는 패턴 + case
select 
    count(
        case 
            when gender = 'm' then '남자'
        end
    ) men,
    count(
        case 
            when gender = 'f' then '여자'
        end
    ) women
    from tblComedian;

select 
    count(
        case 
            when gender = 'm' then 1
        end
    ) men,
    count(
        case 
            when gender = 'f' then 1
        end
    ) women
    from tblComedian;


-- tblInsa. 기획부 몇명? 총무부 몇명? 개발부 몇명? > 1개의 테이블

select count(*) from tblInsa where buseo = '기획부';   -- 7명
select count(*) from tblInsa where buseo = '총무부';   -- 7명
select count(*) from tblInsa where buseo = '개발부';   -- 14명

select 
    count(
        case
            when buseo = '기획부' then 1
        end
    ) 기획부, 
    count(
        case
            when buseo = '총무부' then 1
        end
    ) 총무부, 
    count(
        case
            when buseo = '개발부' then 1
        end
    ) 개발부,
    count(
        case 
            when buseo not in ('기획부', '총무부', '개발부') then 1
        end
    ) 나머지,
    count(*) 총직원수
    from tblInsa;
    
select 
    name as 이름,
    buseo as 부서
from tblInsa;

select 
    name as "employee name",
    buseo as "select"
from tblInsa;   //(X) 별칭에 띄어쓰기 넣기, 예약어 넣지 말기


/*
    
    2. sum()
    - 해당 컬럼값의 합을 구한다.
    - number sum(컬럼명)
    
*/

select * from tblCountry;

select count(area) from tblCountry; -- 14   > 레코드 개수
select count(name) from tblCountry; -- 14

select sum(area) from tblCountry;   -- 3459 > 수치의 합
select sum(name) from tblCountry;   -- ORA-01722: invalid number
select sum(ibsadate) from tblInsa;  -- ORA-00932: inconsistent datatypes: expected NUMBER got DATE
-- select sum(*) from tblCountry;

select 
    sum(basicpay) as "지출 급여 합",
    sum(sudang) as " 지출 수당 합",
    sum(basicpay) + sum(sudang) as "총 지출",
    sum(basicpay + sudang) as "총 지출"
from tblInsa;

/*

    3. avg()
    - 해당 컬럼값의 평균값을 구한다.
    - number avg(컬럼명)
    - 숫자형에만 적용 가능
    - null이 제외
    
*/

-- tblInsa.평균 급여
select sum(basicpay)/ 60 from tblInsa;
select sum(basicpay)/ count(basicpay) from tblInsa;
select avg(basicpay) from tblInsa;

-- tblCountry. 14개국의 평균 인구수?
select sum(population) / 14 from tblCountry;
select sum(population) / count(*) from tblCountry;
select sum(population) / count(population) from tblCountry;
select avg(population) from tblCountry;

-- 회사 > 성과급 지급 > 출처 > 1팀 공로
-- 1. 균등 지급 > 총 성과급 / 모든 직원 수 = sum() / count(*)
-- 2. 차등 지급 > 총 성과급 / 1팀 직원 수 = sum() / count(1팀) = avg()


/*

    4. max()
    - 최댓값 반환
    - object max(컬럼명)
    
    5. min()
    - 최솟값 반환
    - object min(컬럼명)

    - 컬럼명 + 반환값 > 숫자형, 문자형, 날짜
    
*/


select max(basicpay), min(basicpay) from tblInsa;   -- 숫자형
select max(name), min(name) from tblInsa;           -- 문자형
select max(ibsadate), min(ibsadate) from tblInsa;   -- 날짜형

select 
    count(*) as 직원수,
    sum(basicpay) as 총급여합,
    avg(basicpay) as 평균급여,
    max(basicpay) as 최고급여,
    min(basicpay) as 최저급여
from tblInsa;


-- 집계 함수 사용 시 주의점!! + 집계 함수의 특성(잘 이해!!!!!!)

-- 요구사항] 직원들 이름과 총 직원수를 가져오시오.
select name, count(name) from tblInsa;  
-- ORA-00937: not a single-group group function
-- 컬럼 리스트(SELECT절)에서는 집계 함수와 일반 컬럼을 동시에 사용할 수 없다.

-- 요구사항] 평균 급여보다 더 많이 받는 직원들?
select avg(basicpay) from tblInsa;  -- 1556526
select * from tblInsa where basicpay >= 1556526;
select * from tblInsa where basicpay >= avg(basicpay);  
-- ORA-00934: group function is not allowed here

-- where절에는 집계함수를 사용할 수 없다.
-- where절 > 개인(레코드)에 대한 조건절 > 집합 값 사용 불가능
-- 서브쿼리로 해결

