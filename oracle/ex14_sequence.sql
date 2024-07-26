/*

    시퀀스, Sequence
    - 데이터베이스 객체(물리적으로 구분되어서 관리되는 요소) 중 하나(테이블, 제약사항, 시퀀스) 
    - 오라클 전용 객체(다른 DBMS 제품에는 없음)
    - 일련 번호를 생성하는 객체(********)
    - 주로 식별자를 만드는데 사용한다. > 주로 PK 값으로 사용한다. > 이외에 다양한 용도로 활용한다.
    
    시퀀스 객체 생성하기
    - create sequence 시퀀스명;
    
    시퀀스 객체 삭제하기
    - drop sequence 시퀀스명;
    
    시퀀스 객체 사용하기
    - 시퀀스명.nextVal
    - 시퀀스명.currVal
    
*/

-- DB Object 명명법
-- : 헝가리언 표기법
-- ex) tblMemo
-- ex) seqMemo

drop sequence seqNum;
create sequence seqNum;

select seqNum.nextVal from dual;    -- 10 > 11 > 12

select seqNum.currVal from dual;    -- 11 > 11 > 11

insert into tblMemo values(seqNum.nextVal, '시퀀스', '일련번호입니다.', sysdate);

select * from tblMemo;

-- 쇼핑몰 > 상품번호 > ABC001 > ABC002 > ABC003
select 'ABC' || seqNum.nextVal from dual;   -- ABC21 > ABC021
select 'ABC' || lpad(seqNum.nextVal, 3, '0') from dual;   -- ABC21 > ABC021


/*

    시퀀스 객체 생성하기
    - create sequence 시퀀스명;
    
    시퀀스 객체 생성하기
    - create sequence 시퀀스명 
        increment by n  -- 증감치
        start with n    -- 시작값
        maxvalue n      -- 최댓값
        minvalue n      -- 최솟값
        cycle           -- 순환유무
        cache n;        -- 임시 저장

*/

drop sequence seqTest;

create sequence seqTest
--    increment by 3;
--    increment by -3;  // 음수값을 줬을 때 -1부터 시작
--    start with 10;
--    maxvalue 10;

--    increment by -1
--    start with 10
--    maxvalue 10
--    minvalue 1;

--    maxvalue 10
--    cycle
--    cache 5;

    cache 20;   -- 기본값 20
    
select seqTest.nextVal from dual;   -- 5 > 6 > 10 > 11(X) > 26
/*
    seq를 저장할 때마다 주기억장치(메모리)에서 보조기억장치로 데이터를 교환하는데
    1씩 증가할 때마다 왔다갔다하면 부담스럽기 때문에 한번에 왔다갔다하기 위한 장치
*/
