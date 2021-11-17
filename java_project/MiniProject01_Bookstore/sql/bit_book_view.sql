
-- 1. 책이름과 주문금액을 포함하는 orders_view 뷰
drop view orders_view;
create or replace view orders_view
as
select o.orderid as orderid, o.userid as userid, o.bookid as bookid, b.bookname as bookname, b.price as price, o.orderdate AS orderdate
from bit_orders o, bit_book b
where o.bookid = b.bookid
order by o.orderid
;