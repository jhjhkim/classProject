
-- 부서의 전체 리스트를 출력하는 SQL
select * from project.dept;

SELECT `dept`.`deptno`,
    `dept`.`dname`,
    `dept`.`loc`
FROM `project`.`dept`;

-- 부서 데이터 입력 SQL
INSERT INTO dept (deptno, dname, loc) VALUES (?,?,?);

SELECT * FROM project.dept WHERE deptno=?;

-- 수정
UPDATE dept SET dname=?, loc=? WHERE deptno=?;

-- 삭제
DELETE FROM dept WHERE deptno=?;
