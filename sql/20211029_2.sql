----------------------------------------------------------
-- 집합 함수(그룹 함수)
-- 하나의 행의 컬럼이 대상이 아니고, 행 그룹의 컬럼들(집합)이 대상
----------------------------------------------------------
select
    to_char(sum(sal)*1200, 'L999,999,999') as "월 급여 총액",
    to_char(round(avg(sal)*1200), 'L999,999,999') as "월 급여 평균",
    count(*) as "총 사원의 수",
    count(comm) as "커미션 등록 수",   -- null 값이 있는 행은 제외한다.
    sum(comm) as "커미션 합",
    avg(comm) as "커미션 평균",
    max(sal) as "가장 높은 급여",
    min(sal) as "가장 낮은 급여"
from emp
;

-- 사원들의 업무의 개수
select job from emp;
select count(distinct job) from emp;

select sum(sal)
from emp
where deptno = 10
;

select sum(sal)
from emp
where deptno = 20
;

select sum(sal)
from emp
where deptno = 30
;

select * from emp order by deptno;

-- group by : 특정 컬럼으로 그룹핑 -> 그룹 내의 평균이나 합과 같은 집합 함수를 사용할 수 있다.

-- 부서 번호를 기준으로 그룹핑
--  -> 급여의 총합, 평균, 최대, 최소, 사원의 수, 
--     커미션 받는 사람 수, 커미션 평균, 커미션 총합
select deptno, 
       count(*) as "사원 수",
       sum(sal) as "급여 총합",
       floor(avg(sal)) as "급여 평균",
       max(sal) as "최대 급여", 
       min(sal) as "최소 급여",
       count(comm) as "커미션 대상자 수",  
       nvl(sum(comm), 0) as "커미션 총합",
       nvl(floor(avg(comm)), 0) as "커미션 평균"
from emp
--where deptno != 20
group by deptno
--having avg(sal) >= 2000 -- group by 후에 결과값에 제한을 두려면 having
having max(sal) > 2900
order by deptno
;

