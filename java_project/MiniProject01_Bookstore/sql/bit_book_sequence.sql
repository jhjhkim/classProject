/*
    sequence.    
    
    1. 회원가입 시퀀스
    2. 아이디 시퀀스     
    3. 책ID 시퀀스
    4. 주문정보 자동 저장 시퀀스 
    5. 오더 테이블 오더 ID 시퀸스
*/

-- 1. 회원가입 시퀀스

drop sequence bit_users_userid_seq;     -- 삭제하려고 하는 테이블이 없으면 오류 발생하지만 신경안쓰셔도됩니다!
create sequence bit_users_userid_seq
    start with 1
    increment by 1;

-- 2. 아이디 시퀀스
drop sequence bit_users_userId_seq;     -- 삭제하려고 하는 테이블이 없으면 오류 발생하지만 신경안쓰셔도됩니다!
create sequence bit_users_userId_seq
    start with 10
    increment by 1;
    
    
--  3. 책Id 시퀀스
drop sequence bit_book_bookId_seq;      -- 삭제하려고 하는 테이블이 없으면 오류 발생하지만 신경안쓰셔도됩니다!
create sequence bit_book_bookId_seq
    start with 21                       --  기존 데이터 20개가 있기 때문에 20으로 시작
    increment by 1;
    

--  4. 주문정보 자동저장 시퀀스
drop sequence bit_orders_log_orderId_seq;
create sequence bit_orders_log_orderId_seq
    start with 1
    increment by 1;

--    5. 오더 테이블 오더 ID 시퀸스
drop sequence bit_orders_orderId_seq;
create sequence bit_orders_orderId_seq
    start with 1
    increment by 1;


