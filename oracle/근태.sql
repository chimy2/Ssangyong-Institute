insert into tblDate (seq, state, regdate) values ( 1, '정상', '2024-08-01');
insert into tblDate (seq, state, regdate) values ( 2, '정상', '2024-08-02');
-- 08-03: 토요일
-- 08-04: 일요일

insert into tblDate (seq, state, regdate) values ( 3, '지각', '2024-08-05');
insert into tblDate (seq, state, regdate) values ( 4, '정상', '2024-08-06');
insert into tblDate (seq, state, regdate) values ( 5, '정상', '2024-08-07');
insert into tblDate (seq, state, regdate) values ( 6, '조퇴', '2024-08-08');
insert into tblDate (seq, state, regdate) values ( 7, '정상', '2024-08-09');
-- 08-10: 토요일
-- 08-11: 일요일


insert into tblDate (seq, state, regdate) values ( 8, '조퇴', '2024-08-12');
insert into tblDate (seq, state, regdate) values ( 9, '정상', '2024-08-13');
insert into tblDate (seq, state, regdate) values (10, '정상', '2024-08-14');
insert into tblDate (seq, state, regdate) values (11, '정상', '2024-08-16');
-- 08-15: 광복절
-- 08-17: 토
-- 08-18: 일

insert into tblDate (seq, state, regdate) values (12, '정상', '2024-08-19');
insert into tblDate (seq, state, regdate) values (13, '정상', '2024-08-20');
insert into tblDate (seq, state, regdate) values (14, '지각', '2024-08-21');
-- 08-22: 결석
insert into tblDate (seq, state, regdate) values (15, '정상', '2024-08-23');
-- 08-24: 토
-- 08-25: 일

insert into tblDate (seq, state, regdate) values (16, '정상', '2024-08-26');
insert into tblDate (seq, state, regdate) values (17, '지각', '2024-08-27');
insert into tblDate (seq, state, regdate) values (18, '정상', '2024-08-28');
insert into tblDate (seq, state, regdate) values (19, '정상', '2024-08-29');
insert into tblDate (seq, state, regdate) values (20, '정상', '2024-08-30');
-- 08-31: 토

commit;

select * from tblDate;