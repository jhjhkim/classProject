--1. 마당서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(5) 박지성이 구매한 도서의 출판사 수
select count(distinct publisher)
from book natural join orders natural join customer
where name = '박지성'
;

select count(distinct publisher)
from book join orders
using (bookid)
where custid = (select custid from customer where name = '박지성')
;
--(6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select bookname, price, saleprice, price-saleprice as pricegap
from book natural join orders natural join customer
where name = '박지성'
;

select bookname, price, saleprice, price-saleprice as pricegap
from book join orders
using (bookid)
where custid = (select custid from customer where name = '박지성')
;

--(7) 박지성이 구매하지 않은 도서의 이름
-- 박지성이 구매한 도서의 bookid
select bookid from orders natural join customer where name = '박지성';

select bookname
from book
where bookid not in (
    select bookid from orders natural join customer where name = '박지성'
    )
order by bookid
;

select bookname
from book 
where bookid not in (
    select bookid from orders 
    where custid = (select custid from customer where name = '박지성'))
order by bookid
;


--2. 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--(8) 주문하지 않은 고객의 이름 (부속질의사용)
select name
from customer 
where custid not in (select custid from orders)
;

--(9) 주문금액의 총액과 주문의 평균 금액
select sum(saleprice) as total,
       avg(saleprice) as avgsaleprice
from orders
;

--(10) 고객의 이름과 고객별 구매액
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

--(11) 고객의 이름과 고객이 구매한 도서 목록
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
group by c.name, b.bookname
order by c.name
;

--(12) 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문
select *
from orders natural join book
where price-saleprice = (select max(price-saleprice) from orders natural join book)
;

--(13) 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름
select name
from customer
where custid in (
    select custid from orders
    group by custid
    having avg(saleprice) > (select avg(saleprice) from orders)
    );

select name
from customer natural join orders
group by name
having avg(saleprice) > (select avg(Saleprice) from orders)
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
-- 박지성이 구매한 도서의 출판사
select distinct publisher
from book natural join orders
where custid = (
    select custid from customer where name = '박지성'
    )
;

-- 박지성이 구매한 도서의 출판사에서 나온 책
select bookid
from book
where publisher in (
    select distinct publisher
    from book natural join orders
    where custid = (
        select custid from customer where name = '박지성'
        )
    )
;

-- 박지성이 구매한 도서의 출판사에서 나온 책을 구매한 고객
select distinct name
from customer natural join orders
where bookid in (
    select bookid from book
    where publisher in (
        select distinct publisher
        from book natural join orders
        where custid = (
            select custid from customer where name = '박지성'
            )
        )
    )
    and name <> '박지성'
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name
from customer natural join orders natural join book
group by name
having count(distinct publisher) >= 2
;