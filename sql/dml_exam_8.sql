
-- 1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneInfo_basic;

-- insert
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber)
                     values (1, '김철수', '000-000-0000');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber) 
                     values (2, '최영희', '000-000-1111');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber, fr_email, fr_address, fr_regdate) 
                     values (3, '박영수', '000-000-1234', 'email@mail.com', '서울', '21/11/01');
insert into phoneInfo_basic 
                     values (4, '이지영', '000-000-9999', 'email2@mail.com', '부산', '21/11/02');

-- select
select * from phoneInfo_basic;

-- update
update phoneInfo_basic
set fr_address = '인천'
where idx = 1;

update phoneInfo_basic
set (fr_email, fr_address) = (select fr_email, fr_address from phoneInfo_basic where idx = 3)
where idx = 2;

-- delete
delete from phoneInfo_basic
where idx = 4;

-- 2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneInfo_univ;

insert into phoneInfo_univ (idx, fr_u_major, fr_ref)
                    values (1, '경영', 1);
insert into phoneInfo_univ values (2, '경제', 3, 2);

select * from phoneInfo_univ;

update phoneInfo_univ
set fr_u_year = 4
where idx = 1;

delete from phoneInfo_univ
where idx = 2;

-- 3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneInfo_com;

insert into phoneInfo_com (idx, fr_ref) values (1, 3);
insert into phoneInfo_com values (2, 'LG', 4);

select * from phoneInfo_com;

update phoneInfo_com
set fr_c_company = 'SAMSUNG'
where idx = 2;

delete from phoneInfo_com
where idx = 1;


select *
from phoneInfo_basic b join phoneInfo_univ u
on b.idx = u.fr_ref
;

select *
from phoneInfo_basic b, phoneInfo_com c
where b.idx = c.fr_ref
;