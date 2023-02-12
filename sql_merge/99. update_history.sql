-- 20230125
ALTER TABLE tbl_user RENAME COLUMN `name` TO firstname varchar(100) NOT NULL;
ALTER TABLE tbl_user ADD lastname varchar(100) NOT NULL AFTER firstname;

-- 20230212
ALTER TABLE tbl_chapter MODIFY COLUMN `desc` varchar(500) NULL;
ALTER TABLE tbl_chapterImage ADD source text NOT NULL AFTER seq;