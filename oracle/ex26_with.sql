/*

    *** 각각의 절은 역할과 실행 순서가 있다.
    [WITH <Sub Query>]
    SELECT column_list
    FROM table_name
    [WHERE search_condition]
    [GROUP BY group_by_expression]
    [HAVING search_condition]
    [ORDER BY order_expression [ASC/DESC]];
    
    
    역할
    WITH 서브쿼리      -- 임시뷰를 만든다.
    SELECT 컬럼리스트  -- 원하는 컬럼을 지정 > 지정된 컬럼만 가져와라.
    FROM 테이블        -- 데이터 소스. 어떤 테이블로부터 데이터를 가져와라.
    WHERE 검색조건     -- 조건 지정. 원하는 레코드만 걸러낸다.
    GROUP BY 그룹기준  -- 특정 컬럼값을 기준으로 여러 그룹을 나눈다.
    HAVING 검색조건    -- 조건 지정. 원하는 그룹만 걸러낸다.
    ORDER BY 정렬기준; -- 결과셋의 레코드 순서를 정한다.
    
    순서
    1. WITH
    6. SELECT
    2. FROM
    3. WHERE
    4. GROUP BY
    5. HAVING
    7. ORDER BY

    with 절
    - 인라인뷰에 이름을 붙이는 기술
    
    with 테이블명 as 서브쿼리
    select문;
    
*/
select * from (select name, buseo, jikwi from tblInsa where city = '서울');

-- 가독성 때문에 사용
with seoul as (select name, buseo, jikwi from tblInsa where city = '서울')
select * from seoul;

select * from (select name, age, couple from tblMen where weight < 90) a
    inner join (select name, age, couple from tblWomen where weight > 60) b
        on a.couple = b.name;
        
with men as (select name, age, couple from tblMen where weight < 90),
    women as (select name, age, couple from tblWomen where weight > 60)
select * from men
    inner join women
        on men.couple = women.name;

with aaa as (select 
    name, buseo, basicpay,
    rank() over(partition by buseo order by basicpay desc) as rnum
from tblInsa)
select * from aaa where rnum = 1;


/*

    null 함수
    - null을 치환하는 함수
    
    nvl > null value > 엔브이엘, 널벨류
    1. nvl(컬럼, 값)
    2. nvl2(컬럼, 값, 값)

*/
        
select
    name,
    case
        when population is not null then population
        when population is null then 0
    end
from tblCountry;
        
select
    name,
    nvl(population, 0)
from tblCountry;

-- ORA-01722: invalid number
select
    name,
    nvl(population, '조사안됨')
from tblCountry;
        
select
    name,
    nvl2(population, 1, 2)
from tblCountry;

drop table tblItem;

create table tblItem (
    seq number primary key,
    name varchar2(30) not null,
    color varchar2(30) not null
);

insert into tblItem (seq, name, color) values (1, '마우스', 'white');
-- ORA-01400: cannot insert NULL into ("HR"."TBLITEM"."SEQ")
-- 모든 null 연산의 결과는 null이다
-- ex. 1 + null = null, null - 1 = null
insert into tblItem (seq, name, color) values ((select max(seq) + 1 from tblItem), '마우스', 'white');
insert into tblItem (seq, name, color) values ((select max(seq) + 1 from tblItem), '키보드', 'white');

insert into tblItem (seq, name, color) values ((select nvl(max(seq), 0) + 1 from tblItem), '마우스', 'white');
insert into tblItem (seq, name, color) values ((select nvl(max(seq), 0) + 1 from tblItem), '키보드', 'white');
insert into tblItem (seq, name, color) values ((select nvl(max(seq), 0) + 1 from tblItem), '모니터', 'white');

select * from tblItem;



