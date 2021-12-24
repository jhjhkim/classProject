-- select
SELECT * FROM project.guestbook;

SELECT * FROM guestbook LIMIT 0, 5;

SELECT COUNT(*) FROM guestbook;

SELECT
g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, m.idx as memberidx
FROM guestbook g join member m
ON g.memberidx = m.idx
ORDER BY regdate DESC
;

SELECT
g.idx as idx, g.subject as subject, g.content as content, m.photo as photo, m.username as username, g.regdate as regdate, m.idx as memberidx
FROM guestbook g join member m
ON g.memberidx = m.idx
WHERE g.idx=?
;

-- insert
INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?);
