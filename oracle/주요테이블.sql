CREATE TABLE tblHousekeeping
(
	seq number primary key,
	item varchar2(50) not null,
	price number not null,
	qty number not null,
	buydate date not null,
	memo varchar2(1000) null
);

INSERT INTO tblHousekeeping VALUES (1, '양말', 2000, 5, '2024-02-05', null);
INSERT INTO tblHousekeeping VALUES (2, '티셔츠', 5000, 1, '2024-02-06', null);
INSERT INTO tblHousekeeping VALUES (3, '수저세트', 10000, 4, '2024-02-07', null);
INSERT INTO tblHousekeeping VALUES (4, '컵', 3000, 2, '2024-02-08', null);
INSERT INTO tblHousekeeping VALUES (5, '행주', 1000, 10, '2024-02-09', null);
INSERT INTO tblHousekeeping VALUES (6, '도마', 5000, 1, '2024-02-09', null);
INSERT INTO tblHousekeeping VALUES (7, '식칼', 15000, 1, '2024-02-10', null);
INSERT INTO tblHousekeeping VALUES (8, '위생봉투', 1000, 5, '2024-02-10', null);
INSERT INTO tblHousekeeping VALUES (9, '종이컵', 100, 100, '2024-02-10', null);
INSERT INTO tblHousekeeping VALUES (10, '물티슈', 1000, 50, '2024-02-13', null);
INSERT INTO tblHousekeeping VALUES (11, '건전지', 1000, 20, '2024-02-15', null);
INSERT INTO tblHousekeeping VALUES (12, '노트', 1400, 5, '2024-02-18', null);
INSERT INTO tblHousekeeping VALUES (13, '이쑤시개', 10, 3000, '2024-02-18', null);
INSERT INTO tblHousekeeping VALUES (14, '손톱깎이', 3000, 1, '2024-02-19', null);
INSERT INTO tblHousekeeping VALUES (15, '세제', 9000, 2, '2024-02-19', null);
INSERT INTO tblHousekeeping VALUES (16, '냄비받침대', 3000, 2, '2024-02-20', null);
INSERT INTO tblHousekeeping VALUES (17, '슬리퍼', 8000, 3, '2024-02-20', null);
INSERT INTO tblHousekeeping VALUES (18, '치약', 4000, 4, '2024-02-21', null);
INSERT INTO tblHousekeeping VALUES (19, '칫솔', 1700, 9, '2024-02-21', null);
INSERT INTO tblHousekeeping VALUES (20, '비누', 2500, 6, '2024-02-21', null);



--------------


CREATE TABLE tblInsa(
        num NUMBER(5) NOT NULL CONSTRAINT tblInsa_pk PRIMARY KEY
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '871212-1022432', '2008-10-11', '서울', '011-2356-4528', '기획부',
   '부장', 2610000, 200000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '901007-1544236', '2010-11-29', '경기', '010-4758-6532', '총무부',
   '사원', 1320000, 200000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '870922-2312547', '2009-02-25', '인천', '010-4231-1236', '개발부',
   '부장', 2550000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '890304-1788896', '2010-10-01', '전북', '019-5236-4221', '영업부',
   '대리', 1954200, 170000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '911112-1566789', '2014-08-13', '서울', '018-5211-3542', '총무부',
   '사원', 1420000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '880505-2978541', '2012-02-11', '인천', '010-3214-5357', '개발부',
   '과장', 2265000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '880506-1625148', '2008-03-16', '제주', '011-2345-2525', '개발부',
   '대리', 1250000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '921011-2362514', '2012-04-30', '서울', '016-2222-4444', '홍보부',
'사원', 950000 , 145000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '910810-1552147', '2013-10-10', '경기', '019-1111-2222', '인사부',
   '사원', 840000 , 220400);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '851010-1122233', '2007-08-08', '부산', '011-3214-5555', '영업부',
   '부장', 2540000, 130000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '901010-2987897', '2010-07-07', '서울', '010-8888-4422', '영업부',
   '사원', 1020000, 140000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '860909-1333333', '2009-10-16', '강원', '018-2222-4242', '홍보부',
   '사원', 880000 , 114000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '890102-2777777', '2008-06-07', '경기', '019-6666-4444', '홍보부',
   '대리', 1601000, 103000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '910707-2574812', '2012-02-15', '인천', '010-3214-5467', '개발부',
   '사원', 1100000, 130000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '900606-2954687', '2009-07-26', '경기', '016-2548-3365', '총무부',
   '사원', 1050000, 104000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '881010-1666678', '2011-11-29', '경기', '010-4526-1234', '개발부',
   '과장', 2350000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '920507-1452365', '2010-08-28', '인천', '010-3254-2542', '개발부',
   '사원', 950000 , 210000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '901028-1849534', '2014-08-08', '전북', '018-1333-3333', '개발부',
   '사원', 880000 , 123000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '880710-1985632', '2009-12-10', '서울', '017-4747-4848', '인사부',
   '과장', 2300000, 165000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '900304-2741258', '2013-10-10', '전남', '011-9595-8585', '자재부',
   '사원', 880000 , 140000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '901010-1111111', '2011-09-07', '경기', '011-9999-7575', '개발부',
   '사원', 875000 , 120000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '900501-2312456', '2013-02-25', '전남', '017-5214-5282', '기획부',
   '대리', 1960000, 180000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '831211-1214576', '2005-02-23', '서울', NULL           , '영업부',
   '부장', 2500000, 170000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '930225-2633334', '2009-08-28', '서울', '011-5248-7789', '기획부',
   '대리', 1900000, 170000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '901103-1654442', '2010-10-01', '서울', '010-4563-2587', '영업부',
   '사원', 1100000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '910907-2015457', '2012-08-28', '경기', '010-2112-5225', '영업부',
   '사원', 1050000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '901216-1898752', '2010-10-18', '서울', '019-8523-1478', '총무부',
   '과장', 2340000, 170000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '910101-1010101', '2011-09-07', '제주', '016-1818-4848', '인사부',
   '사원', 892000 , 110000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '900301-2020202', '2010-09-08', '서울', '016-3535-3636', '총무부',
   '사원', 920000 , 124000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '890210-2101010', '2009-10-17', '부산', '019-6564-6752', '총무부',
   '과장', 2304000, 124000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '871115-1687988', '2011-01-21', '서울', '019-5552-7511', '기획부',
   '부장', 2450000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '910206-2222222', '2010-05-05', '전북', '016-8888-7474', '자재부',
   '사원', 880000 , 108000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '880505-2999999', '2008-06-07', '서울', '011-2444-4444', '영업부',
   '사원', 1020000, 104000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '920505-1325468', '2015-09-26', '경기', '011-3697-7412', '기획부',
   '사원', 1100000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '931010-2153252', '2012-05-16', '인천', NULL           , '개발부',
   '사원', 1050000, 140000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '801126-2852147', '2013-08-10', '서울', '011-9999-9999', '자재부',
   '사원', 960400 , 190000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '870129-1456987', '2008-10-15', '인천', '011-7777-7777', '홍보부',
   '과장', 2350000, 187000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '891009-2321456', '2009-11-15', '부산', '010-6542-7412', '영업부',
   '대리', 2000000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '900504-2000032', '2013-12-28', '경기', '010-2587-7895', '영업부',
   '대리', 2010000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '890509-1635214', '2010-09-10', '경북', '016-4444-7777', '인사부',
   '대리', 2100000, 130000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '821217-1951357', '2011-12-10', '충남', '016-4444-5555', '자재부',
   '과장', 2300000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '910709-2000054', '2013-10-17', '경기', '011-5125-5511', '개발부',
   '사원', 1020000, 200000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '930504-2471523', '2013-09-24', '서울', '016-8548-6547', '영업부',
   '사원', 1100000, 210000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '920305-1475286', '2014-01-21', '서울', '011-5555-7548', '영업부',
   '사원', 1060000, 220000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2013-03-16', '전북', '011-7777-7777', '영업부',
   '사원', 960000 , 152000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '860105-1458752', '2009-05-04', '경남', '017-3333-3333', '총무부',
   '부장', 2650000, 150000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '880505-1234567', '2011-07-15', '서울', '018-0505-0505', '영업부',
   '대리', 2100000, 112000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '890604-1415141', '2011-06-07', '전남', NULL           , '개발부',
   '대리', 2050000, 106000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '930908-2456548', '2010-04-07', '인천', '010-6654-8854', '개발부',
   '사원', 1300000, 130000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '910403-2828287', '2013-06-07', '경기', '011-8585-5252', '홍보부',
   '대리', 1950000, 103000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '890303-2155554', '2010-06-04', '서울', '011-5555-7548', '영업부',
   '과장', 2260000, 104000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '920406-2000456', '2010-10-10', '경기', '010-3644-5577', '기획부',
   '사원', 1020000, 105000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '900715-1313131', '2009-12-12', '전북', '011-7585-7474', '자재부',
   '사원', 960000 , 108000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '910705-1212141', '2009-10-16', '강원', '016-1919-4242', '홍보부',
   '사원', 980000 , 114000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '920506-2425153', '2014-06-07', '서울', '016-2424-4242', '영업부',
   '사원', 1000000, 104000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '900605-1456987', '2014-08-13', '인천', '010-7549-8654', '영업부',
   '대리', 1950000, 200000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '880406-2003214', '2008-02-11', '경기', '016-6542-7546', '자재부',
   '부장', 2520000, 160000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '900709-1321456', '2013-08-08', '인천', '010-2415-5444', '기획부',
   '대리', 1950000, 180000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '910809-2121244', '2011-10-10', '서울', '011-4151-4154', '개발부',
   '사원', 890000 , 102000);
INSERT INTO tblInsa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '910809-2111111', '2011-10-10', '서울', '011-4151-4444', '개발부',
   '사원', 900000 , 102000);
   
   
-----------


CREATE TABLE tblMen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);

CREATE TABLE tblWomen
(
	name varchar2(30) primary key,
	age number not null,
	height number null,
	weight number null,
	couple varchar2(30) null
);


INSERT INTO tblMen VALUES ('홍길동', 25, 180, 70, '장도연');
INSERT INTO tblMen VALUES ('아무개', 22, 175, NULL, '이세영');
INSERT INTO tblMen VALUES ('하하하', 27, NULL, 80, NULL);
INSERT INTO tblMen VALUES ('무명씨', 21, 177, 72, NULL);
INSERT INTO tblMen VALUES ('유재석', 29, NULL, NULL, '김숙');
INSERT INTO tblMen VALUES ('박명수', 30, 170, NULL, '김지민');
INSERT INTO tblMen VALUES ('정준하', 31, 183, NULL, '신보라');
INSERT INTO tblMen VALUES ('정형돈', 28, NULL, 92, NULL);
INSERT INTO tblMen VALUES ('양세형', 22, 166, 55, '김민경');
INSERT INTO tblMen VALUES ('조세호', 24, 165, 58, '오나미');

INSERT INTO tblWomen VALUES ('박나래', 23, 150, 55, NULL);
INSERT INTO tblWomen VALUES ('장도연', 28, 177, 65, '홍길동');
INSERT INTO tblWomen VALUES ('김지민', 30, 160, NULL, '박명수');
INSERT INTO tblWomen VALUES ('김숙', 34, 158, NULL, '유재석');
INSERT INTO tblWomen VALUES ('오나미', 27, NULL, NULL, '조세호');
INSERT INTO tblWomen VALUES ('김민경', 22, 169, 88, '양세형');
INSERT INTO tblWomen VALUES ('홍현희', 20, 158, 75, NULL);
INSERT INTO tblWomen VALUES ('신보라', 26, 170, 60, '정준하');
INSERT INTO tblWomen VALUES ('이세영', 28, 163, NULL, '아무개');
INSERT INTO tblWomen VALUES ('신봉선', 27, 162, NULL, NULL);



-------------


CREATE TABLE tblTodo
(
	seq number primary key,
	title varchar2(200) not null,
	adddate date not null,
	completedate date null
);

INSERT INTO tblTodo VALUES (1, '할일 계획 세우기', to_date('2024-02-01 06:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-01 18:30:00', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (2, '마트 장보기', to_date('2024-02-03 13:00:00', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-04 20:28:30', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (3, '자바 콘솔 프로젝트 에러잡기', to_date('2024-02-11 14:22:24', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-11 17:32:54', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (4, '내방 청소하기', to_date('2024-02-08 22:00:00', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (5, '강아지 산책시키기', to_date('2024-02-07 10:11:34', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (6, '다이어트 시작하기', to_date('2024-02-01 12:53:20', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (7, '데이터베이스 책 대여하기', to_date('2024-02-02 11:34:52', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-15 12:10:15', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (8, '노트북 포맷하기', to_date('2024-02-02 19:32:12', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-02 19:50:22', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (9, '치과 예약하기', to_date('2024-02-04 11:22:33', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-08 12:32:02', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (10, '아마존에서 키보드 직구하기', to_date('2024-02-08 09:21:11', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (11, '스타벅스 다이어리 예약하기', to_date('2024-02-02 17:23:43', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-03 15:43:21', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (12, '헌혈하기', to_date('2024-02-09 23:33:23', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-12 15:48:52', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (13, '친구에게 전화하기', to_date('2024-02-09 14:42:21', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-09 15:32:34', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (14, '비행기 티켓 예약하기', to_date('2024-02-06 12:23:53', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-11 09:46:22', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (15, '아르바이트 계약서 작성하기', to_date('2024-02-12 12:30:23', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-12 15:32:45', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (16, '과제 제출하기', to_date('2024-02-10 15:03:21', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (17, 'AS 센터 방문하기', to_date('2024-02-11 22:44:22', 'yyyy-mm-dd hh24:mi:ss'), to_date('2024-02-12 16:30:52', 'yyyy-mm-dd hh24:mi:ss'));
INSERT INTO tblTodo VALUES (18, '스터디 그룹 짜기', to_date('2024-02-03 22:10:20', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (19, '운전 면허 갱신하기', to_date('2024-02-06 21:21:02', 'yyyy-mm-dd hh24:mi:ss'), NULL);
INSERT INTO tblTodo VALUES (20, '헬스 등록하기', to_date('2024-02-05 19:24:42', 'yyyy-mm-dd hh24:mi:ss'), NULL);



---------------



