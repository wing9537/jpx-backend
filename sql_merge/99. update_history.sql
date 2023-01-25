-- 20230125
ALTER TABLE tbl_user RENAME COLUMN name TO firstname varchar(100) NOT NULL;
ALTER TABLE tbl_user ADD lastname varchar(100) NOT NULL AFTER firstname;