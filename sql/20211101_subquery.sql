
-- 2021.11.01.

-- 서브 쿼리 (부속 질의)
-- select 구문 안에 또 다른 select 구문을 이용하는 sql 문

-- SCOTT 사원의 부서 이름을 출력
select dname
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT'
;

select dname, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and dname = 'SCOTT'
;

select deptno from emp where ename = 'SCOTT';
select dname
from dept
where deptno = (select deptno from emp where ename = 'SCOTT');




-- 마당서점의 고객별 판매액을 보이시오 (결과는 고객이름과 고객별 판매액을 출력)
select * from customer;
select * from orders;
select custid,
       (select name from customer c where o.custid = c.custid) as name,
       sum(saleprice)
from orders o
group by custid
order by custid
;

-- JOIN
-- 마당서점의 고객별 판매액을 보이시오 (결과는 고객이름과 고객별 판매액을 출력)
select o.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by o.custid, c.name
;

-- 사원의 이름과 부서 이름을 출력
select ename, 
       (select dname from dept where emp.deptno = dept.deptno)
from emp
;

select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;

-- 고객번호가 2 이하인 고객의 판매액
select custid, name from customer where custid <= 2;
select o.custid, sum(saleprice)
from orders o,
     (select custid, name from customer where custid <= 2) c
where o.custid = c.custid
group by o.custid
;

select custid
from orders
where custid <= 2
group by custid
;


-- 30번 부서의 인라인뷰를 만들어서 사용
select *
from (select * from emp where deptno = 30)
;