/*

    숫자 함수
    - Math.XXX()
    
    round()
    - 반올림 함수
    - number round(컬럼명)
    - number round(컬럼명, 소수이하 자릿수)

*/

select avg(basicpay) from tblInsa;
select round(avg(basicpay)) from tblInsa;
select round(avg(basicpay), 1) from tblInsa;

-- 시스템 테이블
select * from tabs;
select * from dual; --X(dummy) > 1행 1열짜리 테이블

select round(3.14) from dual;

select 
    3.5678,
    round(3.5678),
    round(3.5678, 1),
    round(3.5678, 2),
    round(3.5678, 0)
from dual;

/*

    floor(), trunc()
    - 절삭 함수
    - 무조건 내림 함수
    - number floor(컬럼명)
    - number trunc(컬럼명)
    - number trunc(컬럼명, 소수이하 자릿수)

*/

select 
    3.5678,
    floor(3.5678),
    trunc(3.5678),
    floor(3.9999),
    trunc(3.9999),
    trunc(3.5678, 1),
    trunc(3.5678, 2)
from dual;


/*

    ceil()
    - 무조건 올림 함수
    - 천장
    - number ceil(컬럼명)

*/

select 
    3.14,
    ceil(3.14)
from dual;

select 
    floor(3.9999999999999999999),
    ceil(3.000000000000000000001)
from dual;


/*

    mod()
    - 나머지 함수
    - number mod(피제수, 제수)

*/

select 
    10 / 3,
    floor(10 / 3) as 몫,
    mod(10, 3) as 나머지
from dual;

select 
    abs(10), abs(-10),
    power(2, 2), power(2, 3), power(2, 4),
    sqrt(4), sqrt(9), sqrt(16)
from dual;