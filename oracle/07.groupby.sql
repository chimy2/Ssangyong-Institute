-- tblHousekeeping 테이블 문제

-- 1. 각 날짜별로 구매한 물품의 총 개수와 총 금액을 구하시오.
select to_char(buydate, 'yyyy-mm-dd'), sum(qty) 개수, sum(price) 금액 
    from tblHousekeeping group by to_char(buydate, 'yyyy-mm-dd');

-- 2. 가격대별로 구매한 물품의 수를 구하시오. (가격대는 1000원 단위로 나누어 주세요)
select floor(price / 1000) || '000원 이상', count(*) price 
    from tblHousekeeping group by floor(price / 1000);

-- 3. 각 물품별로 총 구매 금액을 구하고, 구매 금액이 높은 순으로 정렬하시오.
select item, sum(price) "총 구매 금액" 
    from tblHousekeeping group by item order by "총 구매 금액" desc;

-- 4. 각 주차별로 구매한 물품의 총 개수와 총 금액을 구하시오. (주는 일요일부터 시작합니다)
select to_char(buydate, 'w') 주, sum(qty), sum(price) 
    from tblHousekeeping group by to_char(buydate, 'w') order by 주;

-- 5. 구매 수량이 10개 이상인 물품들의 평균 가격을 구하시오.
select avg(price) from tblHousekeeping where qty >= 10; 

-- 6. 각 물품별로 구매 횟수를 구하고, 구매 횟수가 1회 초과인 물품만 출력하시오.
select item from tblHousekeeping group by item having count(*) > 1;

-- 7. 구매 날짜별로 가장 비싼 물품의 가격을 구하시오.
select to_char(buydate, 'yyyy-mm-dd') 구매날짜, max(price) 
    from tblHousekeeping group by to_char(buydate, 'yyyy-mm-dd');

-- 8. 각 물품 종류별로 총 구매 금액을 구하고, 10만원 이상 구매한 물품 종류만 출력하시오.
select item, sum(price) from tblHousekeeping group by item having sum(price) > 100000;

-- 9. 요일별로 평균 구매 금액을 구하고, 평균 금액이 높은 순으로 정렬하시오.
select to_char(buydate, 'd'), avg(price) from tblHousekeeping group by to_char(buydate, 'd') order by avg(price) desc;

-- 10. 월별로 구매한 물품의 총 개수와 총 금액을 구하시오.
select to_char(buydate, 'mm') || '월', count(*), sum(price) from tblHousekeeping group by to_char(buydate, 'mm');


-- tblInsa 테이블 문제

-- 1. 각 부서별로 직원 수와 평균 급여(기본급+수당)를 구하시오.
select buseo, count(*), avg(basicpay + sudang) from tblInsa group by buseo;

-- 2. 직위별로 직원 수와 최고 급여, 최저 급여를 구하시오.
select jikwi, count(*), max(basicpay), min(basicpay) from tblInsa group by jikwi;

-- 3. 입사년도별로 직원 수를 구하고, 가장 많은 직원이 입사한 연도 3개를 구하시오.
select * from (select to_char(ibsadate, 'yyyy'), count(*) from tblInsa group by to_char(ibsadate, 'yyyy') order by count(*) desc) where rownum <= 3;

-- 4. 각 도시별로 직원 수와 평균 급여를 구하고, 직원 수가 5명 이상인 도시만 출력하시오.
select city, count(*), avg(basicpay) from tblInsa group by city having count(*) >= 5; 

-- 5. 부서별, 직위별로 평균 급여를 구하고, 부서와 직위 순으로 정렬하시오.
select buseo, jikwi, avg(basicpay) from tblInsa group by buseo, jikwi order by buseo, jikwi;

-- 6. 나이대별(20대, 30대, 40대 등)로 직원 수와 평균 급여를 구하시오.
--select floor((124 - substr(ssn, 1, 2) - 1) / 10) from tblInsa group by floor((124 - substr(ssn, 1, 2) - 1) / 10);
select floor((124 - substr(ssn, 1, 2) - 1) / 10) || '0대' 나이대, count(*) 직원수, avg(basicpay) 평균급여 
    from tblInsa group by floor((124 - substr(ssn, 1, 2) - 1) / 10);

-- 7. 입사월별로 직원 수와 평균 급여를 구하고, 평균 급여가 높은 순으로 정렬하시오.
select to_char(ibsadate, 'mm') || '월', count(*) 직원수, avg(basicpay) 평균급여 
    from tblInsa group by to_char(ibsadate, 'mm') order by 평균급여;

-- 8. 부서별로 가장 높은 급여를 구하시오.
select buseo, max(basicpay) from tblInsa group by buseo;

-- 9. 직위별로 총 급여 합계를 구하고, 총 급여가 5000만원 이상인 직위만 출력하시오.
select jikwi, sum(basicpay) from tblInsa group by jikwi having sum(basicpay) >= 50000000;

-- 10. 입사년도별, 부서별로 직원 수를 구하고, 직원 수가 5명 이상인 그룹만 출력하시오.
select to_char(ibsadate, 'yyyy'), buseo, count(*) from tblInsa group by to_char(ibsadate, 'yyyy'), buseo having count(*) >= 5;


-- tblMen, tblWomen 테이블 문제

-- 1. 남녀별로 평균 나이와 평균 키를 구하시오.
select avg(age), avg(height) from tblMen;
select avg(age), avg(height) from tblWomen;

-- 2. 커플 상태(연인 있음, 없음)별로 남녀 수를 구하시오.
select 
    case
        when couple is null then '없음'
        when couple is not null then '연인 있음'
    end,
    count(*)
from tblMen 
group by case
        when couple is null then '없음'
        when couple is not null then '연인 있음'
    end;

select 
    case
        when couple is null then '없음'
        when couple is not null then '연인 있음'
    end,
    count(*)
from tblWomen 
group by case
        when couple is null then '없음'
        when couple is not null then '연인 있음'
    end;

-- 3. 남녀별로 키 구간(160cm 미만, 160-170cm, 170-180cm, 180cm 이상)에 속하는 사람 수를 구하시오.
select
    case 
        when height >= 180 then '180cm 이상'
        when height >= 170 then '170-180cm'
        when height >= 160 then '160-170cm'
        else '160cm 미만'
    end, count(*)
from tblMen
    group by case 
        when height >= 180 then '180cm 이상'
        when height >= 170 then '170-180cm'
        when height >= 160 then '160-170cm'
        else '160cm 미만'
    end;
    
select
    case 
        when height >= 180 then '180cm 이상'
        when height >= 170 then '170-180cm'
        when height >= 160 then '160-170cm'
        else '160cm 미만'
    end, count(*)
from tblWomen
    group by case 
        when height >= 180 then '180cm 이상'
        when height >= 170 then '170-180cm'
        when height >= 160 then '160-170cm'
        else '160cm 미만'
    end;

-- 5. 남녀별로 가장 높은 체중을 구하시오.
select max(weight) from tblMen;
select max(weight) from tblWomen;

-- 6. 키 구간별(10cm 단위)로 남녀 수를 구하고, 남녀 수가 많은 순으로 정렬하시오.
select floor(height / 10), count(*) 
    from tblMen where height is not null 
    group by floor(height / 10) order by count(*) desc;
select floor(height / 10), count(*) 
    from tblWomen where height is not null 
    group by floor(height / 10) order by count(*) desc;

-- 7. 남녀별로 나이대(20대, 30대 등)에 따른 평균 키를 구하시오.
select floor(age / 10) || '0대', avg(height) from tblMen group by floor(age / 10);
select floor(age / 10) || '0대', avg(height) from tblWomen group by floor(age / 10);

-- 9. 남녀별로 체중이 가장 적게 나가는 사람과 가장 많이 나가는 사람의 몸무게 차이를 구하시오.
select max(weight) - min(weight) from tblMen;
select max(weight) - min(weight) from tblWomen;

-- 10. 남녀 모두에서 가장 긴 이름의 글자 수를 구하시오.
select max(length(name)) from tblMen;
select max(length(name)) from tblWomen;


-- tblTodo 테이블 문제

-- 1. 각 날짜별로 등록된 할 일의 수와 완료된 할 일의 수를 구하시오.
select to_char(adddate, 'yyyy-mm-dd'), count(*), count(completedate) from tblTodo group by to_char(adddate, 'yyyy-mm-dd');

-- 2. 요일별로 할 일 등록 수를 구하고, 가장 많이 등록된 요일부터 정렬하시오.
select to_char(adddate, 'd'), count(*) from tblTodo group by to_char(adddate, 'd') order by count(*) desc; 

-- 3. 각 주차별로 완료된 할 일의 수와 완료되지 않은 할 일의 수를 구하시오.
select to_char(completedate, 'w'), count(*) from tblTodo group by to_char(completedate, 'w');

-- 4. 완료 여부에 따라 평균 소요 시간(완료시간 - 등록시간)을 구하시오.
select
    case
        when completedate is not null then '완료'
        when completedate is not null then '미완료'
    end,
    round(avg((completedate - adddate) / 24))
    from tblTodo group by 
    case 
        when completedate is not null then '완료'
        when completedate is not null then '미완료'
    end;

-- 5. 각 달별로 등록된 할 일의 수와 완료율(완료된 할 일 / 전체 할 일)을 구하시오.
select to_char(adddate, 'mm'), count(*), count(completedate) / count(*) from tblTodo group by to_char(adddate, 'mm');

-- 6. 등록 시간대별(0-6시, 6-12시, 12-18시, 18-24시)로 할 일의 수를 구하시오.
select floor(to_char(adddate, 'hh24') / 6), count(*) from tblTodo group by floor(to_char(adddate, 'hh24') / 6);

-- 7. 완료된 일 중에서, 소요 시간이 가장 긴 일의 소요 시간을 구하시오.
select floor(maxDiff * 24) || '시간' from 
    (select floor(completedate - adddate) floorDiff, max(completedate - adddate) maxDiff
        from tblTodo where completedate is not null 
        group by floor(completedate - adddate)
        order by floor(completedate - adddate) desc
        )
    where rownum <= 1;

-- 8. 등록 후 완료까지 걸린 기간별(당일, 1일, 2일 이상)로 할 일의 수를 구하시오.
select 
    case 
        when floor(completedate - adddate) >= 2 then '2일 이상'
        when floor(completedate - adddate) >= 1 then '1일'
        else '당일'
    end,
    count(*)
from tblTodo
    where completedate is not null
    group by  
    case 
        when floor(completedate - adddate) >= 2 then '2일 이상'
        when floor(completedate - adddate) >= 1 then '1일'
        else '당일'
    end;

-- 9. 각 날짜별로 가장 늦게 완료된 시간을 구하시오.
select 
    to_char(completedate, 'yyyy-mm-dd'), max(to_char(completedate, 'hh24'))
    from tblTodo
    where completedate is not null
    group by to_char(completedate, 'yyyy-mm-dd');

-- 10. 완료 여부에 따라 제목의 평균 글자 수를 구하시오.
select 
    case
        when completedate is not null then '미완료'
        when completedate is null then '완료'
    end,
    avg(length(title))
    from tblTodo
    group by
    case
        when completedate is not null then '미완료'
        when completedate is null then '완료'
    end; 
