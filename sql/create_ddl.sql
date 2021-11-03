-- phoneInfo_basic 테이블 생성
create table phoneInfo_basic (
    idx number(6) constraint infoBasic_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
);

desc phoneInfo_basic;
drop table phoneInfo_basic;


-- phoneInfo_univ 테이블 생성
create table phoneInfo_univ (
    idx number(6),
    fr_u_major varchar2(20) default 'N' not null,
    fr_u_year number(1) default 1 not null,
    fr_ref number(6) not null,
    constraint infoUniv_idx_pk primary key (idx),
    constraint infoUniv_year_ck check (fr_u_year between 1 and 4),
    constraint infoUniv_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx)
);

desc phoneInfo_univ;
drop table phoneInfo_univ;


-- phoneInfo_com 테이블 생성
create table phoneInfo_com (
    idx number(6),
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null,
    constraint infoCom_idx_pk primary key (idx),
    constraint infoCom_ref_fk foreign key (fr_ref) references phoneInfo_basic (idx)
);

desc phoneInfo_com;
drop table phoneInfo_com;



--------------------------------------
-- 데이터 넣어보기
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber) values (1, '김철수', '000-000-0000');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber) values (2, '최영희', '000-000-1111');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber) values (3, '박영수', '000-000-1234');
insert into phoneInfo_basic (idx, fr_name, fr_phonenumber) values (4, '이지영', '000-000-9999');
select * from phoneInfo_basic;


insert into phoneInfo_univ (idx, fr_u_major, fr_ref) values (1, '경영', 1);
insert into phoneInfo_univ values (2, '경제', 3, 2);
select * from phoneInfo_univ;


insert into phoneInfo_com (idx, fr_ref) values (1, 3);
insert into phoneInfo_com values (2, 'LG', 4);
select * from phoneInfo_com;

select *
from phoneInfo_basic b join phoneInfo_univ u
on b.idx = u.fr_ref
;

select *
from phoneInfo_basic b join phoneInfo_com c
on b.idx = c.fr_ref
;