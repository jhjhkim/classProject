/*
    1. 유저가 책을 구매 했을시, 자동으로 재고에서 빠지게 해주는 트리거
    2.  주문시 자동으로 저장오더테이블의 정보를 저장하는 트리거 
    
*/

--  1. 주문이 되었을 때 실행되는 트리거, 책 재고를 하나빼

drop trigger AfterBookStock;

create or replace trigger AfterBookStock

    after insert    --  insert가 실행되면 
    on bit_orders   --  bit_orders 테이블에
    for each row    --  이 옵션이 있으면 행트리거가 된다.
                    --  행트리거란? 컬럼의 각각의 행의 데이터 행 변화가 생길때마다 실행되며,
                    --  그 데이터 행의 실제값을 제어할 수 있다.
                    
declare             --  필요 변수는 없다.
    
begin                                           
    update  bit_book                --  변경한다. bit_book 테이블의
    set     stock = stock - 1       --  스톡을 하나줄인다.( 책 갯수 -1 ) 
    where   bookid = :new.bookid;   --  책ID와 주문된 책ID가 같을 때
end;


-----------------------------------------
--  2. 주문시 자동으로 주문정보 저장
drop trigger AfterBookOrderLog;

create or replace trigger AfterBookOrderLog
    after insert
    on bit_orders
    for each row
declare

begin
    insert into bit_orders_log
    values( bit_orders_log_orderId_seq.nextVal, :new.orderId  );
end;
