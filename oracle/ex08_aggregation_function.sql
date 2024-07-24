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
    
    2. sum()
    
    3. avg()
    
    4. max()
    
    5. min()
    
    
    
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