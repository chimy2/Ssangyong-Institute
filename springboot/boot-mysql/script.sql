select now();

-- ����Ŭ ����
select sysdate from dual;

create user 'springboot'@'localhost' identified by 'java1234';

grant all privileges on *.* to 'springboot'@'localhost' with grant option;

flush privileges;

create table member (
    id bigint not null auto_increment,
    name varchar(50),
    age integer,
    primary key(id)
);

insert into member (name, age) values ('ȫ�浿', 20);

select * from member;