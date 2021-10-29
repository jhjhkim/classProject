desc dual;

-- 함수 : 단일행 함수, 집합 함수
-- 단일행 함수 : 숫자, 문자, 날짜, 변환

-- 숫자 함수
select abs(-15) from dual;
select FLOOR(35.73) "FLOOR" FROM DUAL;  -- 소숫점 아래를 버림
select ROUND(15.193) from dual;     -- 반올림
select ROUND(15.193, 2) from dual;
select ROUND(15.193, -1) from dual;
select TRUNC(15.6789) FROM DUAL;    -- 특정 자릿수에서 버림
select TRUNC(15.6789, 2) FROM DUAL;
select TRUNC(15.6789, -1) FROM DUAL;
select MOD(11,4) from dual;     -- (피제수, 제수) 나눈 나머지


-- 문자 함수
select LOWER('MR. SCOTT MCMILLAN') "Lowercase" from dual;
select ename, lower(ename) from emp;
select CONCAT('저는 ', '손흥민 입니다.') from dual;
select ename || ' is a ' || job from emp;
select concat(concat('나의 이름은 ', ename), ' 입니다.') from emp;
select LPAD('Page 1',15,'*') "LPAD example" FROM DUAL;
select RPAD('Page 1',15,'*') from dual;
select rpad('001111-3', 14, '*') from dual;

select SUBSTR('ABCDEFG',3,4) from dual;
select substr('001212-3001234', 1, 8) from dual;
select substr(hiredate, 1, 2) from emp;

select rpad(substr('001212-3001234', 1, 8), 14, '*') from dual;

select substr(name, 1, 2) from customer;
select rpad(substr(name,1,2),5,'*') from customer;  --rpad에서 한글은 2byte씩 들어간다

select Ltrim('     =from=     ') from dual;
select Rtrim('     =from=     ') from dual;

select trim('+' from '+++++from+++++') as a from dual;   --잘라낼 문자를 지정할 수 있다
select trim(' ' from '     +++++from+++++     ') as b from dual;

select REPLACE('JACK and JUE','J','BL') from dual;
select replace('000-0000-0000', '-', '') from dual;


-- 날짜 함수
select sysdate from dual;
select sysdate-30 from dual;
select add_months(sysdate, -4) from dual;
select last_day(sysdate) from dual;



-- 변환함수
-- 날짜 -> 문자 to_char(원본, 출력패턴)
-- 숫자 -> 문자 to_char(원본, 패턴)
-- 문자 -> 날짜 to_date(원본, 패턴)
-- 문자 -> 숫자 to_number(원본, 패턴)

-- 문자 -> 날짜 to_date(원본, 패턴)
select to_date('2021.10.25.', 'yyyy.mm.dd.') from dual;

-- 2021-01-01 ~ 오늘 며칠이 지났는지.
select trunc(sysdate - to_date('2021-01-01', 'YYYY-MM-DD')) from dual;


-- 날짜 -> 문자 to_char(원본, 출력패턴)
select to_char(sysdate, 'YYYY.MM.DD. HH24:MI:ss') from dual;
select hiredate, to_char(hiredate, 'YYYY.MM.DD.') from emp;

-- 숫자 -> 문자 to_char(원본, 패턴)
select to_char(100000, '0,000,000') from dual;  -- 0으로 채워야 하는 경우
select to_char(100000, '9,999,999') from dual;  -- 자릿수를 채우지 않는 경우
select to_char(100000, 'L9,999,999') from dual;
select to_char(100000.123, '9,999,999.99') from dual;

select sal, to_char(sal*1200, 'L9,999,999') from emp;

-- 문자 -> 숫자 to_number(원본, 패턴)
select to_number('100,000', '9,999,999') + 100000 from dual;


-- switch case 와 유사한 decode 함수
-- emp 테이블에서 사원 이름, 부서 번호, 부서 이름을 출력
select * from dept;

select ename, deptno, 
       decode(deptno, 
            10, 'ACCOUNTING',
            20, 'RESEARCH',
            30, 'SALES',
            40, 'OPERATIONS'
       ) as dname
from emp;

--직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANAlYST'인 사원은 5%,
--       'SALESMAN'인 사원은 10%,
--       'MANAGER'인 사원은 15%,
--       'CLERK'인 사원은 20%인 인상한다.
select ename, job, sal,
        decode(job, 'ANALYST', sal*1.05,
                    'SALESMAN', sal*1.1,
                    'MANAGER', sal*1.15,
                    'CLERK', sal*1.2
        ) as upSal
from emp
;

-- case when then : if else if 와 유사 -> 조건식에서 = 이외의 비교 연산을 할 수 있다.
--부서번호에 해당되는 부서명을 구하는 예제를 이번에는 CASE 함수를 사용하여 작성해 봅시다.
select ename, job, sal,
       case
           when sal >= 3000 then sal*1.1
           when sal < 3000 then sal*1.2
       end as upSal
from emp
;