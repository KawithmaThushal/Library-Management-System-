-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.38 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table sample.books: ~11 rows (approximately)
REPLACE INTO `books` (`ID`, `Author`, `Categories`, `Title`, `PublishDate`, `BookAddDate`, `QTY`) VALUES
	('B001', 'Kaithma', 'History', 'super', '2002-01-22', '2024-01-01', 5),
	('B002', 'Author Two', 'Science', 'Science Book', '2015-06-20', '2005-03-14', 1),
	('B003', 'Author Three', 'Literature', 'Literature Book', '2020-09-15', '2010-09-23', 7),
	('B005', 'Author Five', 'Technology', 'Tech Book', '1999-05-30', '2010-12-10', 20),
	('B006', 'Kaithma', 'History', 'Super', '2002-01-26', '2013-01-15', 5),
	('B007', 'kasuri', 'Hisory', 'kana', '2024-05-06', '2002-06-08', 3),
	('B010', 'sumudu', 'History', 'Chamidu', '2021-10-05', '2024-05-10', 5),
	('B011', 'prabudi', 'Science', 'Novel', '2025-04-25', '2025-04-21', 2),
	('B012', 'ks', 's', 'd', '2023-05-06', '2024-12-05', 3),
	('B013', 'ks', 'sp', 'd', '2024-12-05', '2023-05-06', 3),
	('B015', 'Author Five', 'Technology', 'Tech Book', '2010-12-10', '1999-05-30', 20);

-- Dumping data for table sample.borrowbook: ~14 rows (approximately)
REPLACE INTO `borrowbook` (`M_ID`, `book_ID`, `Release_Date`, `Expire_Date`, `days_difference`) VALUES
	('M002', 'B001', '2024-07-29', '2024-08-30', NULL),
	('M002', 'B002', '2024-07-29', 'MONDAY', NULL),
	('M002', 'B003', '2024-07-29', '2024-08-12', NULL),
	('M002', 'B005', '2024-07-29', '2024-08-12', NULL),
	('M003', 'B005', '2024-07-29', '2024-07-30\r\n', NULL),
	('M004', 'B001', '2024-07-29', '2024-08-12', NULL),
	('M004', 'B005', '2024-07-29', '2024-08-12', NULL),
	('M004', 'B012', '2024-07-29', '2024-08-12', NULL),
	('M005', 'B002', '2024-07-29', '2024-08-12', NULL),
	('M005', 'B005', '2024-07-29', '2024-08-31', NULL),
	('M006', 'B010', '2024-07-29', '2024-08-12', NULL),
	('M006', 'B011', '2024-07-29', '2024-08-12', NULL),
	('M006', 'B012', '2024-07-29', '2024-08-31', NULL),
	('M006', 'B013', '2024-07-29', '2024-08-12', NULL);

-- Dumping data for table sample.member: ~5 rows (approximately)
REPLACE INTO `member` (`M_ID`, `NAME`, `Adress`, `NIC`, `DOB`, `CONTAC_NUM`, `EMAIL`, `MembershipDate`) VALUES
	('M002', 'kawithma', 'Mathras', '200202600942', '2024-01-26', 718679496, 'kawithma@gmail.com', '28/07/2024'),
	('M003', 'kawithma', 'Mathr', '200202600942', '2024-01-26', 718679496, 'kawithma@gmail.com', '29/07/2024'),
	('M004', 'kawithma', 'Mathras', '200202600942', '2024-01-26', 718679496, 'kawithma@gmail.com', '29/07/2024'),
	('M005', 'kawithma', 'Mathras', '200202600942', '2024-01-26', 718679496, 'kawithma@gmail.com', '28/07/2024'),
	('M006', 'kawithma', 'Mathras', '200202600942', '2024-01-26', 718679496, 'kawithma@gmail.com', '29/07/2024');

-- Dumping data for table sample.users: ~2 rows (approximately)
REPLACE INTO `users` (`id`, `username`, `password`) VALUES
	(2, 'Kawithma@gmail.com', '200202600942'),
	(3, '123', '2002');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
