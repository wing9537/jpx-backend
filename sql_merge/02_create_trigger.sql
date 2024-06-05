-- pandora.tbl_manga triggers
DELIMITER $$
CREATE OR REPLACE TRIGGER tbl_manga_tr_delete AFTER UPDATE ON tbl_manga FOR EACH ROW
BEGIN
  IF (OLD.deleted = 'N' AND NEW.deleted = 'Y') THEN
    UPDATE tbl_chapter SET deleted = 'Y' where mangaId = NEW.id;
    UPDATE tbl_image SET deleted = 'Y' where id = NEW.coverPage;
  END IF;
  IF (OLD.coverPage <> NEW.coverPage) THEN
    UPDATE tbl_image SET deleted = 'Y' where id = OLD.coverPage;
  END IF;
END; $$
DELIMITER ;

-- pandora.tbl_chapter triggers
DELIMITER $$
CREATE OR REPLACE TRIGGER tbl_chapter_tr_delete AFTER UPDATE ON tbl_chapter FOR EACH ROW
BEGIN
  IF (OLD.deleted = 'N' AND NEW.deleted = 'Y') THEN
    UPDATE tbl_chapterImage SET deleted = 'Y' where chapterId = NEW.id;
  END IF;
END; $$
DELIMITER ;

-- pandora.tbl_chapterImage triggers
DELIMITER $$
CREATE OR REPLACE TRIGGER tbl_chapterImage_tr_delete AFTER UPDATE ON tbl_chapterImage FOR EACH ROW
BEGIN
  IF (OLD.deleted = 'N' AND NEW.deleted = 'Y') THEN
    UPDATE tbl_image SET deleted = 'Y' where id = NEW.imageId;
  END IF;
END; $$
DELIMITER ;