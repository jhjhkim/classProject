
-- 2021-11-01

-- JOIN
-- 스키마의 결합, 행은 집합의 합 연산
-- 컬럼의 개수가 늘어난다! 행은 행 * 행 의 결과로 생성

-- Cross Join : 단순히 테이블 붙이는 조인
-- 컬럼을 붙이고, 행(데이터)은 집합의 합연산(카티즌 곱)
--      -> 전체 행 ==> R1의 행의 개수 * R2의 행의 개수
-- emp 테이블과 dept 테이블의 join -> 14 * 4 = 56

-- Cross Join 문
-- select * from 테이블명, 테이블명, ...
select *
from emp, dept
order by dept.deptno
;


-- Equi JOIN
-- 특정 컬럼의 값들을 비교해서 같은 결과의 행만 추출
select *
from emp, dept
where emp.deptno = dept.deptno
;

-- Scott 사원의 부서이름을 출력
select ename, emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno
      and ename = 'SCOTT'
;

-- 테이블 별칭 이용
select *
from emp e, dept d
where e.deptno = d.deptno
;

-- Non-Equi JOIN
select *
from salgrade
;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where e.sal between s.losal and s.hisal
order by e.empno
;


-- Self JOIN
-- 나 자신을 참조해서 붙이는 조인
select e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno
order by e.mgr
;
-- 결과의 행의 개수가 13 이다!!! -> mgr 이 null 이면 무조건 false 가 나오기 때문

-- 조인 조건에 만족하지 못했더라도 해당 행을 나타내고 싶을 때 -> Outer JOIN
select e.ename as ename, nvl(m.ename, '관리자 없음') as manager
from emp e, emp m
where e.mgr = m.empno(+)
order by e.mgr
;


-- Ansi JOIN

-- Cross JOIN

select *
from emp cross join dept
;

-- Inner Join => equi Join, 컬럼 균등 비교
-- select *
-- from t1 inner join t2
-- on 컬럼의 비교 조건(Join의 비교)

-- SCOTT 사원의 사원정보와 부서정보를 inner join을 이용해서 출력
select *
from emp inner join dept
on emp.deptno = dept.deptno
where ename = 'SCOTT'
;

-- using (공통컬럼)
select *
from emp e join dept d
--on e.deptno = d.deptno
using (deptno)
;

-- Natural Join : 조인을 정의한 컬럼의 이름이 동일할 경우
select *
from emp NATURAL join dept;


-- ANSI outer Join
-- from R1 [LEFT | RIGHT | FULL] outer join R2 : 1번 테이블이 왼쪽/오른쪽 어디에 존재하느냐
-- 사원 이름과 상관의 이름을 출력
select e.ename, m.ename
--from emp e LEFT OUTER JOIN emp m
from emp m right outer join emp e
on e.mgr = m.empno
;

-- 테이블 세개 조인 : 주문 내역 (고객 정보, 책의 정보, 구매 정보)
-- 주문 고객의 이름과 책의 이름, 구매날짜와 구매금액 출력
select c.name, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where c.custid = o.custid
      and b.bookid = o.bookid
;