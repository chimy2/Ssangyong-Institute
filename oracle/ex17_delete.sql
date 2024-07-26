/*

    delete 문
    - DML
    - 원하는 행을 삭제하는 명령어

    delete [from] 테이블명 [where 절];
    
*/

commit;
rollback;

select * from tblInsa;

delete from tblInsa where name = '홍길동'; 
delete from tblInsa where PK; 
delete from tblInsa where num = 1001; 
delete from tblInsa; 

select count(*) from tblInsa;
