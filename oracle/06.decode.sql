-- decode


-- 1. tblInsa. 부장 몇명? 과장 몇명? 대리 몇명? 사원 몇명?
select 
    count(decode(jikwi, '부장', 1)) 부장,
    count(decode(jikwi, '과장', 1)) 과장,
    count(decode(jikwi, '대리', 1)) 대리,
    count(decode(jikwi, '사원', 1)) 사원
from tblInsa;

-- 2. tblInsa. 간부(부장, 과장) 몇명? 사원(대리, 사원) 몇명?
select 
    count(decode(jikwi, '부장', 1, '과장', 1)) 간부,
    count(decode(jikwi, '대리', 1, '사원', 1)) 사원
from tblInsa;

-- 3. tblInsa. 기획부, 영업부, 총무부, 개발부의 각각 평균 급여?
select 
    avg(decode(buseo, '기획부', basicpay)) 기획부평균,
    avg(decode(buseo, '영업부', basicpay)) 영업부평균,
    avg(decode(buseo, '총무부', basicpay)) 총무부평균,
    avg(decode(buseo, '개발부', basicpay)) 개발부평균
from tblInsa;

-- 4. tblInsa. 남자 직원 가장 나이가 많은 사람이 몇년도 태생? 여자 직원 가장 나이가 어린 사람이 몇년도 태생?
select 
    min(decode(substr(ssn, 8, 1), 1, substr(ssn, 0, 2))) 가장나이많은남자직원,
    max(decode(substr(ssn, 8, 1), 2, substr(ssn, 0, 2))) 가장나이적은여자직원
from tblInsa;

