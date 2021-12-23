-- 방명록
ALTER TABLE `project`.`GuestBook`
	DROP FOREIGN KEY `FK_Member_TO_GuestBook`; -- 회원 -> 방명록

-- 방명록
ALTER TABLE `project`.`GuestBook`
	DROP PRIMARY KEY; -- 방명록 기본키

-- 방명록
DROP TABLE IF EXISTS `project`.`GuestBook` RESTRICT;

-- 방명록
CREATE TABLE `project`.`GuestBook` (
	`idx`       INT         NOT NULL, -- 게시물고유번호
	`subject`   VARCHAR(50) NOT NULL, -- 제목
	`content`   TEXT        NOT NULL, -- 내용
	`regdate`   TIMESTAMP   NULL,     -- 작성일시
	`memberidx` INT         NOT NULL  -- 회원고유번호
);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `PK_GuestBook` -- 방명록 기본키
		PRIMARY KEY (
			`idx` -- 게시물고유번호
		);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `FK_Member_TO_GuestBook` -- 회원 -> 방명록
		FOREIGN KEY (
			`memberidx` -- 회원고유번호
		)
		REFERENCES `project`.`Member` ( -- 회원
			`idx` -- 회원고유번호
		);
        
        
-------------------------------------------------------------------------

-- 댓글
ALTER TABLE `project`.`Reply`
	DROP FOREIGN KEY `FK_Member_TO_Reply`; -- 회원 -> 댓글

-- 댓글
ALTER TABLE `project`.`Reply`
	DROP FOREIGN KEY `FK_GuestBook_TO_Reply`; -- 방명록 -> 댓글

-- 댓글
ALTER TABLE `project`.`Reply`
	DROP PRIMARY KEY; -- 댓글 기본키

-- 댓글
DROP TABLE IF EXISTS `project`.`Reply` RESTRICT;

-- 댓글
CREATE TABLE `project`.`Reply` (
	`idx`          INT       NOT NULL, -- 댓글고유번호
	`content`      TEXT      NOT NULL, -- 내용
	`regdate`      TIMESTAMP NULL,     -- 작성일시
	`memberidx`    INT       NOT NULL, -- 회원고유번호
	`guestbookidx` INT       NOT NULL  -- 게시물고유번호
);

-- 댓글
ALTER TABLE `project`.`Reply`
	ADD CONSTRAINT `PK_Reply` -- 댓글 기본키
		PRIMARY KEY (
			`idx` -- 댓글고유번호
		);

ALTER TABLE `project`.`Reply`
	MODIFY COLUMN `idx` INT NOT NULL AUTO_INCREMENT;

-- 댓글
ALTER TABLE `project`.`Reply`
	ADD CONSTRAINT `FK_Member_TO_Reply` -- 회원 -> 댓글
		FOREIGN KEY (
			`memberidx` -- 회원고유번호
		)
		REFERENCES `project`.`Member` ( -- 회원
			`idx` -- 회원고유번호
		);

-- 댓글
ALTER TABLE `project`.`Reply`
	ADD CONSTRAINT `FK_GuestBook_TO_Reply` -- 방명록 -> 댓글
		FOREIGN KEY (
			`guestbookidx` -- 게시물고유번호
		)
		REFERENCES `project`.`GuestBook` ( -- 방명록
			`idx` -- 게시물고유번호
		);guestbook