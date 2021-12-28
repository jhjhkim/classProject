-- select
SELECT * FROM project.guestbook;

SELECT * FROM guestbook LIMIT 0, 5;

SELECT COUNT(*) FROM guestbook;

SELECT * FROM guestbook WHERE idx=?;

-- select : join
SELECT
g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, g.updatedate as updatedate, m.idx as memberidx
FROM guestbook g join member m
ON g.memberidx = m.idx
ORDER BY regdate DESC
;

SELECT
g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, g.updatedate as updatedate, m.idx as memberidx
FROM guestbook g join member m
ON g.memberidx = m.idx
WHERE g.idx=?
;

-- insert
INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?);

-- update
UPDATE guestbook SET subject=?, content=?, updatedate=CURRENT_TIMESTAMP WHERE idx=?;

-- delete
DELETE FROM guestbook WHERE idx=?;


-- reply insert
INSERT INTO reply (content, memberidx, guestbookidx) VALUES (?,?,?);

-- reply select : join
SELECT
r.idx as idx, r.content as content, r.regdate as regdate, r.guestbookidx as guestbookidx, m.idx as memberidx, m.username as username, m.photo as photo
FROM reply r JOIN member m
ON r.memberidx = m.idx
WHERE guestbookidx = ?
;