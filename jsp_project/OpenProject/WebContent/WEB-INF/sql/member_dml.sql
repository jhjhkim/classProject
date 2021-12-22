-- select
select * from project.member;
select * from member where userid=? and password=?;

-- limit index, count
select * from project.member limit 0, 2; -- 1page
select * from project.member limit 2, 2; -- 2page

select * from project.member order by regdate desc limit ?,?;

-- index : (page-1)*count

select count(*) from member;

select * from member where idx=?;

-- insert
INSERT INTO member (userid, password, username, photo) VALUES (?,?,?,?);

-- update
UPDATE member SET password=?, username=?, photo=? WHERE idx = ?;
