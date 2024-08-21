-- aws educenter 계정 생성 및 권한 부여
create user educenter identified by java1234;

grant connect, resource, dba to educenter;

commit;

select * from all_users where username = upper('educenter');