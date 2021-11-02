
-- 2021.11.02.
-- 중첩 질의

-- 평균급여보다 더 많은 급여를 받는 사원을 검색하는 문장
select avg(sal) from emp;

select ename, sal
from emp
where sal > (select avg(sal) from emp)
;

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
-- 평균 주문금액
select avg(saleprice) from orders;
-- 주문금액 이하의 주문에 대해서 주문번호와 금액
select orderid, saleprice
from orders
where saleprice <= (select avg(Saleprice) from orders)
;

--각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.
--각 고객의 평균 주문금액
select avg(saleprice) from orders where custid = 1;

select custid, orderid, saleprice
from orders O
where saleprice > (
    select avg(saleprice) from orders OA where OA.custid = O.custid
    )
;


-- 다중행 서브 쿼리
-- IN, SOME, ANY, ALL, EXISTS

--급여를 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 동일한 부서에서 근무하는 사원
-- 급여를 3000 이상 받는 사원이 소속된 부서
select distinct deptno from emp where sal >= 3000;

select *
from emp
where deptno IN (
    select distinct deptno from emp where sal >= 3000
    )
;

--대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
-- 대한민국에 거주하는 고객
select custid from customer where address like '%대한민국%';
select sum(saleprice)
from orders
where custid in (select custid from customer where address like '%대한민국%')
;

--3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.
-- 3번 고객의 주문도서의 금액들
select saleprice from orders where custid = 3;
-- 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
select saleprice
from orders
;

--부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 많은 급여를 받는 사원의 이름, 급여를 출력
select ename, sal
from emp
where sal > any (select sal from emp where deptno = 30)
;

-- 30번 부서의 최고 급여보다 큰 급여를 받는 사원
select ename, sal
from emp
--where sal > all (select sal from emp where deptno = 30)
where sal > (select max(sal) from emp where deptno = 30)
;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오
-- EXISTS 연산자로 대한민국에 거주하는 고객
select * from customer where address like '%대한민국%' and custid = 2;

select sum(saleprice)
from orders o
where EXISTS (
    select * 
    from customer c 
    where address like '%대한민국%' and c.custid = o.custid
    )
;