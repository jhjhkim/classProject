
-- 2021.10.28.

-- 로그인한 사용자가 보유하고 있는 테이블 정보를 가지고 있는 메타데이터 테이블
select * from tab;

-- 테이블의 구조 확인
desc dept;  -- 널? -> not null : null값을 허용하지 않는다.

select * from emp;
select * from dept;
select loc, deptno, dname from dept;
select * from book;
select * from customer;
select * from orders;
select orderid, custid, saleprice from orders;

-- Select 구문에서 컬럼의 산술연산이 가능
select sal, sal + 100, sal - 100
from emp;

select * from emp;

-- 우리 회사의 사원들의 이름과 월 급여, 연봉을 리스트로 출력
select ename, sal, sal * 12
from emp;

-- 연봉에 +comm , 주의! comm 의 값 중에는 null 이 존재
-- null : 정해지지 않은 값 - 있는 것도 아니고 없는 것도 아니다! 연산의 결과 -> null
select ename, sal, sal * 12, sal * 12 + comm
from emp;

-- null 값을 치환해주는 nvl 함수
-- nvl (컬럼명, 치환할 데이터) -> 컬럼의 값 중 null값은 치환 값으로 변경
select comm, nvl(comm, 0)
from emp;

-- nvl 함수를 이용해서 결과값 도출
select ename, sal, sal * 12, sal * 12 + comm,
       comm, nvl(comm, 0), sal * 12 + nvl(comm, 0)
from emp;

-- 별칭을 이용해서 컬럼이름 사용
select ename as "사원이름", sal as "월급여", sal * 12 + nvl(comm, 0) as "연봉"
from emp;

-- 문자열을 연결해주는 || 연결자
select ename || ' is a ' || job msg
from emp;

-- 사원들이 소속된 부서 번호 출력
select deptno
from emp;

-- 우리 서점에 입점한 출판사 리스트
select distinct publisher
from book;

select deptno, job
from emp;

------------------------------------------

select *    -- 출력하고자 하는 컬럼
from emp    -- 대상 테이블
where sal >= 3000   -- (행을 찾는) 조건 : 비교연산 또는 논리연산
;

-- 10번 부서에 소속된 -> 행을 검색할 조건
-- 사원의 리스트 출력
select *
from emp
where deptno = 10
;

-- 이름이 FORD인 사원의 : 행
-- 사원번호(EMPNO)와 사원이름(ENAME)과 급여(SAL)를 출력 : 컬럼
select empno, ename, sal
from emp
where ename = 'FORD'
;   -- 비교하는 문자열 데이터는 대소문자 구별!!!

-- 날짜 비교 : 82년 이후 입사자
select *
from emp
where hiredate >= '82/01/01'
;

-- 10번 부서 소속인 사원들 중에서 -> and
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno = 10 and job = 'MANAGER'
;

-- 10번 부서에 소속된 사원이거나 -> or
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where deptno = 10 or job = 'MANAGER'
;

-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급을 출력
select ename, deptno, job
from emp
where not deptno = 10
-- where deptno <> 10
-- where deptno != 10
;

-- 2000 에서 3000 사이의 급여를 받는 사원 : 조건
select *
from emp
--where sal >= 2000 and sal <= 3000
where sal between 2000 and 3000
;

-- 1987년에 입사한 사원을 출력해봅시다.
select *
from emp
where hiredate between '87/01/01' and '87/12/31'
;

-- 커미션이 300 이거나 500 이거나 1400 인 사원을
-- 검색하기 위해서 IN 연산자를 사용해봅시다.
select *
from emp
--where comm = 300 or comm = 500 or comm = 1400
where comm in(300, 500, 1400)
;

-- like 패턴 검색
-- F로 시작하는 이름을 가진 사원을 검색
select *
from emp
where ename like 'F%'
;

-- 이름 중 A를 포함하는 사원을 검색
select *
from emp
where ename like '%A%'
;

-- N으로 끝나는 이름을 가진 사원을 검색
select *
from emp
where ename like '%N'
;

-- 이름의 두 번째 글자가 A인 사원을 검색
select *
from emp
where ename like '_A%'
;

-- 이름에 A를 포함하지 않는 사원을 검색
select *
from emp
where ename not like '%A%'
;

-- 커미션을 받지 않는 사원을 검색
select *
from emp
where comm is null
;

-- 정렬을 위한 order by 절
-- order by 컬럼명 {[asc] } desc} , asc(오름차순) desc(내림차순)

-- 급여 컬럼을 기준으로 오름차순으로 정렬
select *
from emp
--order by sal asc
--order by sal
order by sal desc
;

-- 사원 이름순으로 정렬
select *
from emp
order by ename
;

-- 입사일순으로 정렬
select *
from emp
order by hiredate, sal asc
;