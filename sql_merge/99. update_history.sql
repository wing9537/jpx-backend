-- 20230125
ALTER TABLE tbl_user RENAME COLUMN `name` TO firstname varchar(100) NOT NULL;
ALTER TABLE tbl_user ADD lastname varchar(100) NOT NULL AFTER firstname;

-- 20230212
ALTER TABLE tbl_chapter MODIFY COLUMN `desc` varchar(500) NULL;
ALTER TABLE tbl_chapterImage ADD source text NOT NULL AFTER seq;

-- 20230227
ALTER TABLE tbl_chapter MODIFY COLUMN episode int(11) NOT NULL;
ALTER TABLE tbl_manga MODIFY COLUMN latestChapter int(11) DEFAULT 0 NOT NULL;
ALTER TABLE tbl_chapterImage MODIFY COLUMN `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE tbl_image MODIFY COLUMN `content` mediumblob NOT NULL;

