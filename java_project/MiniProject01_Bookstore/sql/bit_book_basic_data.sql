/*

    book 데이터 추가 SQL
    카테고리 데이터 추가
    
*/
desc bit_book;
select * from bit_book;
select * from category;
select * from bit_users;

---------------- 관리자 정보 추가 ------------------------
insert into bit_users (userid, username, password, name) values (1, 'admin', 'admin11', '관리자');


---------------- 카테고리 5종류 추가 ---------------------
insert into category values(1,'유아');
insert into category values(2,'IT');
insert into category values(3,'역사');
insert into category values(4,'소설');
insert into category values(5,'만화');

----- 데이터 20종류
insert into bit_book values(1,'구름빵',19000,'백희나','한솔수복',1,9);
insert into bit_book values(2,'거꾸로 읽는 세계사',17500,'유시민', '문학사상사',3,9);
insert into bit_book values(3,'총,균,쇠',28000,'재레드 다이아몬드','돌베개',3,9);
insert into bit_book values(4,'역사의 쓸모',15000,'최태성','다산초당',1,9);
insert into bit_book values(5,'메트로폴리스',27000,'벤 윌슨','매일경제신문사',1,9);
insert into bit_book values(6,'세계사를 바꾼 10가지 감염병',17500,'조지무쇼','사람과나무사이',1,9);
insert into bit_book values(7,'미드나잇 라이브러리',15800,'매트 헤이그','인플루엔셜',4,9);
insert into bit_book values(8,'듄1',25000,'프랭크 허버트','한겨례출판사',4,9);
insert into bit_book values(9,'달러구트 꿈 백화점1',13800,'이미예','팩토리나인',4,9);
insert into bit_book values(10,'달러구트 꿈 백화점2',13800,'이미예','팩토리나인',4,9);
insert into bit_book values(11,'해리포터와 비밀의 방',33000,'J.K롤링','문학수첩',4,9);
insert into bit_book values(12,'알사탕',12000,'백희나','책읽는곰',1,9);
insert into bit_book values(13,'건전지 아빠',13000,'전승배','창비',1,9);
insert into bit_book values(14,'슈퍼 거북',11000,'유설화','책읽는곰',1,9);
insert into bit_book values(15,'나는 개다',13000,'백희나','한솔수북',1,9);
insert into bit_book values(16,'SQL 자격검정 실전문제',18000,'한국데이터베이스진흥원','한국데이터진흥원',2,9);
insert into bit_book values(17,'혼자공부하는 파이썬',18000,'윤인성','한빛미디어',2,9);
insert into bit_book values(18,'Do it! 점프 투 파이썬',18000,'박응용','이지스퍼블리싱',2,9);
insert into bit_book values(19,'Clean Code',33000,'로버트 C.마틴','인사이트',2,9);
insert into bit_book values(20,'2021 빅데이터분석기사 실기',38000,'김원표','와이즈인컴퍼니',2,9);

commit;