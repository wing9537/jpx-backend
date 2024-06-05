-- pandora.tbl_image definition

CREATE TABLE IF NOT EXISTS `tbl_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(100) NOT NULL,
  `fileType` enum('Manga','Cover','Icon','Others') NOT NULL,
  `mimeType` varchar(100) NOT NULL,
  `content` mediumblob NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `createUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifyUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `modifyTime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- pandora.tbl_user definition

CREATE TABLE IF NOT EXISTS `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(120) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `role` enum('Admin','User') NOT NULL,
  `status` enum('Active','Inactive','Freeze','Lock') NOT NULL,
  `loginFailedCount` int(2) NOT NULL DEFAULT 0,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `createUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifyUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `modifyTime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- pandora.tbl_manga definition

CREATE TABLE IF NOT EXISTS `tbl_manga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `link` text DEFAULT NULL,
  `coverPage` int(11) DEFAULT NULL,
  `latestChapter` int(11) NOT NULL DEFAULT 0,
  `lastUpdateTime` timestamp NULL DEFAULT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `createUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifyUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `modifyTime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `coverPage` (`coverPage`),
  CONSTRAINT `tbl_manga_ibfk_1` FOREIGN KEY (`coverPage`) REFERENCES `tbl_image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- pandora.tbl_chapter definition

CREATE TABLE IF NOT EXISTS `tbl_chapter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mangaId` int(11) NOT NULL,
  `episode` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `createUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifyUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `modifyTime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `mangaId` (`mangaId`),
  CONSTRAINT `tbl_chapter_ibfk_1` FOREIGN KEY (`mangaId`) REFERENCES `tbl_manga` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- pandora.tbl_chapterImage definition

CREATE TABLE IF NOT EXISTS `tbl_chapterImage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mangaId` int(11) NOT NULL,
  `chapterId` int(11) NOT NULL,
  `imageId` int(11) NOT NULL,
  `seq` int(11) NOT NULL DEFAULT 0,
  `source` text NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `createUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `createTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifyUser` varchar(20) NOT NULL DEFAULT 'SYSTEM',
  `modifyTime` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `mangaId` (`mangaId`),
  KEY `chapterId` (`chapterId`),
  KEY `imageId` (`imageId`),
  CONSTRAINT `tbl_chapterImage_ibfk_1` FOREIGN KEY (`mangaId`) REFERENCES `tbl_manga` (`id`),
  CONSTRAINT `tbl_chapterImage_ibfk_2` FOREIGN KEY (`chapterId`) REFERENCES `tbl_chapter` (`id`),
  CONSTRAINT `tbl_chapterImage_ibfk_3` FOREIGN KEY (`imageId`) REFERENCES `tbl_image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;