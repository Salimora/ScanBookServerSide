# ScanBookServerSide
Scan book server side. 
Using Spring + Jersey.  

BookResource.java is working that add, update, search and delete book.
UserReadingListResource.java is working that current user to add, update, search and delete book info.

Establish DataBase

1. Table "Books"
CREATE TABLE `Books` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `barCode` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `numOfPage` int(11) DEFAULT NULL,
  `readOrNot` int(11) NOT NULL,
  PRIMARY KEY (`bookId`),
  UNIQUE KEY `barCode_UNIQUE` (`barCode`)
)

2. Table "User"
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
)

3. Table "UserReadingList"
CREATE TABLE `UserReadingList` (
  `readingId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `reading` int(11) NOT NULL,
  PRIMARY KEY (`readingId`),
  KEY `bookId_idx` (`bookId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `bookId` FOREIGN KEY (`bookId`) REFERENCES `Books` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)
