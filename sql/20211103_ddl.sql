
-- 2021.11.03

-- DDL : 데이터 정의어, 객체 생성, 수정, 삭제 명령어

-- 테이블 생성 : create table
-- 테이블 수정 : alter table
-- 테이블 삭제 : drop table

-- create table 테이블명 (
--      컬럼이름 데이터_타입(size) 제약조건정의(컬럼 레벨 정의) ,
--      ...,
--      제약조건정의(테이블 레벨 정의)
--  );

-- 부서 테이블과 유사한 테이블을 정의
create table dept_test (
    deptno number(2),
    dname varchar2(20),
    loc varchar2(20)
);

-- 테이블 삭제
drop table dept_test;


-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성해봅시다.
desc emp;

--EMPNO    NOT NULL NUMBER(4)    
--ENAME             VARCHAR2(10) 
--SAL               NUMBER(7,2)

create table emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);


-- 서브쿼리를 이용해서 기존 테이블의 구조를 복사하고, 투플을 복사할 수 있다
-- 컬럼의 정의만 복사되고, 제약조건은 복사되지 않는다!!!
create table emp02
as
select * from emp;

desc emp02;
select * from emp02;


-- 원하는 컬럼만 복사
create table emp03
as
select empno, ename from emp;

desc emp03;
select * from emp03;

-- 원하는 데이터만 복사
create table emp04
as
select * from emp where deptno = 10;

desc emp04;
select * from emp04;

-- 구조만 복사 : 항상 거짓이 되는 조건으로
select * from emp where 1=0;
create table emp05
as
select * from emp where 1=0;

desc emp05;
select * from emp05;


-- 테이블 구조의 변경 : alter table
-- 컬럼 추가 : alter table {테이블 이름} add (컬럼정의);

alter table emp01
add(job varchar2(9))
;

alter table emp01
add(
    hiredate date,
    deptno number(2)
);

-- 컬럼의 변경 : alter table {테이블이름} modify (컬럼정의)
-- 직급(job) 컬럼을 최대 30글자까지 저장할 수 있도록 변경
alter table emp01
modify(job varchar(30));

-- 컬럼의 삭제 : alter table {테이블이름} drop column 컬럼이름;
alter table emp01
drop column job;
desc emp01;


-- 테이블의 모든 튜플을 삭제 : truncate
-- 삭제와 동시에 commit : 바로 물리적인 반역(저장)

-- emp02 테이블의 모든 데이터를 삭제
select * from emp02;
truncate table emp02;


-- 테이블 이름 변경 : rename {old_name} to {new_name}
-- emp02 테이블의 이름을 test로 변경
desc emp02;
rename emp02 to test;
desc test;


----------------------------------------------------
-- 제약조건 확인
desc dept;
insert into dept (deptno, dname, loc) 
       values (10, 'test', 'SEOUL');
       

-- 컬럼 레벨 정의 : column_name data_type constraint_type
-- not null 제약조건을 설정하여 테이블 설정
create table emp02(
    empno number(4) NOT NULL,
    ename varchar2(10) NOT NULL,
    job varchar2(9),
    deptno number(2)
);
desc emp02;
insert into emp02 values (10, 'test', null, null);

-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된
-- EMP03 테이블을 생성하되
-- 사원번호를 유일키로 지정합시다.
drop table emp03;
create table emp03 (
    empno number(4) constraint uk_emp03_empno UNIQUE,
    ename varchar2(10) NOT NULL,
    job varchar2(9),
    deptno number(2)
);
insert into emp03 values (1000, 'test', 'MANAGER', 40);
insert into emp03 values (1000, 'test2', 'MANAGER2', 30);

-- 제약조건명 지정 : column_name data_type CONSTRAINT constraint_name constraint_type
-- 제약조건명 명명규칙 : [테이블명]_[컬럼명]_[제약조건유형]


--------------------------------------------------------------
-- 기본키 제약조건
drop table emp04;
create table emp04 (
    empno number(4) constraint emp04_empno_pk primary key,
    ename varchar2(20) not null,
    job varchar2(9),
    deptno number(2)
);
desc emp04;
select * from emp04;
insert into emp04 values (2000, 'test', 'MANAGER', 40);
insert into emp04 values (1000, 'test2', 'MANAGER2', 30);


--------------------------------------------------------------------
-- 외래키 제약
drop table emp05;
create table emp05 (
    empno number(4) constraint emp05_empno_pk primary key,
    ename varchar2(20) not null,
    job varchar2(9),
    deptno number(2) constraint emp05_deptno_fk references dept (deptno)
);
desc emp05;
desc dept;
select * from emp05;
insert into emp05 values (1000, 'test2', 'MANAGER2', 30);
insert into emp05 values (2000, 'test2', 'MANAGER2', 60);


------------------------------------------------------------
-- CHECK 제약조건
drop table emp06;
create table emp06 (
    empno number(4) constraint emp06_empno_pk primary key,
    ename varchar2(20) not null,
    job varchar2(9),
    sal number(7,2) constraint emp06_sal_ck check(sal between 500 and 5000),
    gender char(1) constraint emp06_gender_ck check(gender in('M', 'F')),
    deptno number(2) constraint emp06_deptno_fk references dept (deptno)
);
desc emp06;
select * from emp06;
insert into emp06 values (1000, 'test', 'MANAGER', 3000, 'M', 30);
insert into emp06 values (2000, 'test', 'MANAGER', 3000, 'F', 30);


-----------------------------------------------------
-- default
drop table dept01;
create table dept01 (
    deptno number(2),
    dname varchar2(20),
    loc varchar2(20) default 'SEOUL',
    regDate date default sysdate
);

select * from dept01;
insert into dept01 (deptno, dname) values (10, 'test');


--------------------------------------------
-- 테이블 레벨에서 제약조건 정의
-- 컬럼 정의 후 제약조건 정의
-- 컬럼 레벨에서 해야 하는 것 -> not null, default

drop table emp07;
create table emp07 (
    empno number(4), -- primary key
    ename varchar2(20) not null,
    sal number(7,2) constraint emp07_sal_ck check (sal between 500 and 5000),
    deptno number(2),
    -------------------------------
    -- 제약조건 정의
    constraint emp07_empno_pk primary key (empno),
    constraint emp07_deptno_fk foreign key (deptno) references dept
);