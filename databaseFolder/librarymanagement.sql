-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 May 2018, 15:03:11
-- Sunucu sürümü: 10.1.31-MariaDB
-- PHP Sürümü: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `librarymanagement`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `access_level`
--

CREATE TABLE `access_level` (
  `access_level_id` int(11) NOT NULL,
  `access_level_description` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `access_level`
--

INSERT INTO `access_level` (`access_level_id`, `access_level_description`) VALUES
(1, 'admin'),
(2, 'librarian'),
(3, 'member');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `author_name` varchar(100) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `author`
--

INSERT INTO `author` (`author_id`, `author_name`) VALUES
(1, 'Ahmet Kara'),
(2, 'Hakan Can'),
(3, 'Düdük ali'),
(4, 'Nazım Hikmet '),
(5, 'Süleyman Seba'),
(6, 'Ali Sami Yen'),
(7, 'Şükrü Saracoğlu'),
(8, 'İlhan Cancav'),
(9, 'Alper Başturk'),
(10, 'Mustafa Danacı'),
(11, 'Nusret Toprak'),
(12, 'Beyza Ulusoy'),
(13, 'Mehmet Akif Ersoy');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `authors_of_book`
--

CREATE TABLE `authors_of_book` (
  `authorsOfBook_id` int(11) NOT NULL,
  `authorsOfBook_book_id` int(11) NOT NULL,
  `authorsOfBook_author_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `authors_of_book`
--

INSERT INTO `authors_of_book` (`authorsOfBook_id`, `authorsOfBook_book_id`, `authorsOfBook_author_id`) VALUES
(1, 1, 1),
(2, 3, 2),
(3, 1, 2),
(4, 4, 3),
(5, 2, 3),
(6, 4, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `book_number_of_pages` int(11) NOT NULL,
  `book_category_id` int(11) NOT NULL,
  `book_issue_status_id` int(11) NOT NULL,
  `book_release_date` date NOT NULL,
  `book_publisher` varchar(100) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `book_number_of_pages`, `book_category_id`, `book_issue_status_id`, `book_release_date`, `book_publisher`) VALUES
(1, 'Vadideki vakvaklar', 150, 2, 1, '1998-05-22', ''),
(2, 'uçan kaya', 222, 3, 1, '2000-11-22', ''),
(3, 'Uçurtma Avcısı', 500, 2, 2, '2001-03-04', 'Everest Yayınları'),
(4, 'Kamasutra', 999, 3, 1, '2018-05-08', 'Babagundi yayınlar');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(2, 'Roman'),
(3, 'Masal'),
(4, 'Bilim Kurgu'),
(5, 'Tarih'),
(6, 'Dram'),
(7, 'Aşk'),
(8, 'Sanat'),
(9, 'Felsefe'),
(10, 'Sağlık'),
(11, 'Hukuk'),
(12, 'Sosyoloji'),
(13, 'Piskoloji');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `issue_status`
--

CREATE TABLE `issue_status` (
  `issue_status_id` int(11) NOT NULL,
  `issue_status_description` varchar(25) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `issue_status`
--

INSERT INTO `issue_status` (`issue_status_id`, `issue_status_description`) VALUES
(1, 'not issued'),
(2, 'issued');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `log`
--

CREATE TABLE `log` (
  `log_id` int(11) NOT NULL,
  `log_operation_id` int(11) NOT NULL,
  `log_user_id` int(11) NOT NULL,
  `log_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `operation`
--

CREATE TABLE `operation` (
  `operation_id` int(11) NOT NULL,
  `operation_description` varchar(25) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `operation`
--

INSERT INTO `operation` (`operation_id`, `operation_description`) VALUES
(1, 'login'),
(2, 'logout');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `return_status`
--

CREATE TABLE `return_status` (
  `return_status_id` int(11) NOT NULL,
  `return_status_description` varchar(25) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `return_status`
--

INSERT INTO `return_status` (`return_status_id`, `return_status_description`) VALUES
(1, 'not returned'),
(2, 'returned');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_book_id` int(11) NOT NULL,
  `transaction_member_id` int(11) NOT NULL,
  `transaction_librarian_id` int(11) NOT NULL,
  `transaction_date` date NOT NULL,
  `transaction_return_status_id` int(11) NOT NULL,
  `transaction_return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_book_id`, `transaction_member_id`, `transaction_librarian_id`, `transaction_date`, `transaction_return_status_id`, `transaction_return_date`) VALUES
(1, 2, 4, 2, '2018-07-05', 2, '0000-00-00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_access_level_id` int(11) NOT NULL,
  `user_username` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `user_password` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `user_name` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `user_tc` int(11) NOT NULL,
  `user_email` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `user_phone_number` int(11) DEFAULT NULL,
  `user_address` varchar(250) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`user_id`, `user_access_level_id`, `user_username`, `user_password`, `user_name`, `user_tc`, `user_email`, `user_phone_number`, `user_address`) VALUES
(1, 1, 'karamemet', '123456', 'Mustafa Kadir', 1567894561, NULL, NULL, NULL),
(2, 2, 'niyazi', '123789', 'Niyazi Baba', 1479633215, NULL, NULL, NULL),
(3, 3, 'tarkan', '753159', 'tarkan hilal', 1647651234, NULL, NULL, NULL),
(4, 3, 'plaka', '44444', 'Ayşe fatma', 1231231233, NULL, NULL, NULL),
(5, 3, 'byahmet', '789456', 'Ahmet Bay', 1030215364, 'sdjsdfh@gmail.com', 534366785, 'talas bahçeli evler sigorta sitesi '),
(7, 3, 'samsam', '12345', 'samet samimiyet', 541631565, 'same@gmail.com', 542254, 'talas melihşah mahallesi'),
(8, 3, 'halilovski', 'halil123', 'halil ovix', 6451361, 'halilo@gmail.com', 46745213, 'bimex mahallesi bim sokağı'),
(9, 3, 'yigitosivas', 'sivas', 'yiğit sivaslı', 254651314, 'kimgiyi@gmail.com', 214254, 'anayurt mahallesi direk sokak'),
(10, 3, 'ensevren', 'sivaslı ', 'enes evren', 4257869, 'ens@gmail.com', 24586584, 'tokat en büyük şehir'),
(11, 3, 'yunus', 'ynscn', 'yunus can', 5864565, 'ynscn@gmail.com', 35464458, 'bu adress cok gizlidir.'),
(12, 3, 'marsu', 'marsus', 'marsu işletim', 53465416, 'marsu@gmail.com', 65465456, 'marsu bir su şirketidir'),
(13, 3, 'acer', 'acerhacer', 'hacer acer', 2314685, 'acrhcrqgmqil.com', 6548694, 'acer bilgisayar ltd. sti'),
(14, 3, 'kimsesizler', 'flashKutusu', 'kimsesiz usb', 5416486, 'kimsesiz@gmail.com', 4536546, 'görevli odası erciyes üniveristesi'),
(15, 3, 'caykurHasan', 'hsncykur', 'Çaykur hasan', 54656846, 'hsncykur@gmail.com', 58461, 'caykur güzel bir çay markasıdır'),
(16, 2, 'GamzeliYarim', 'mrvsvgli', 'Gamze Ulu', 456542, 'gamze@gmail.com', 864635133, 'gamze caddesi gamze sokak'),
(18, 2, 'txtelhalil', 'halil akkürşat', 'halil kürşat ersoy', 64146, 'hallkursat@gamil.com', 4554646, 'kimsesizler mahallesi erciyes küme evler'),
(19, 2, 'sumeyra', 'smyrs', 'sumeyra kırmızı', 4564686, 'smyrs@gmail.com', 6, 'tulpar caddesi monster sokak'),
(20, 2, 'abraMonster', 'monsterAbra', ' Monster Abra', 5867354, 'monster@gmail.com', 45668, 'osmanoğlu caddesi istanbul'),
(21, 2, 'KayseriProvience', 'kysriPro', 'Kayseri Belediyesi', 785323, 'kysri@gmail.com', 4469463, 'melihgazi caddesi kayseri'),
(22, 1, 'bahriyeBsturk', 'bstrkBah', 'Bahtiyar Başturk', 13268749, 'basbah@gmail.com', 65464123, 'erciyes üniversitesi sigorta sitesi'),
(23, 1, 'lotto', 'losttototos', 'lotto cüzdan', 2165855, 'lotto@gmail.com', 9634656, 'lotto cüzdan caddesi akçaburgaz mahallesi'),
(24, 1, 'logitecht', 'logimouse', 'log mouse', 1687853, 'logitech@gmail.com', 46135103, 'logitech mahallesi mouse sitesi kayseri'),
(25, 1, 'everest', 'everestCamera', 'Everest Kamera', 31897153, 'everstqgmail.com', 1314684, 'everest mahallesi izlenme sokak istanbul'),
(26, 1, 'karanfil', 'karakaranfil54', 'karanfil kara', 631584, 'karakaranfil@gmail.com', 149136541, 'karanfil sokak sigorta sitesi d blok');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `access_level`
--
ALTER TABLE `access_level`
  ADD PRIMARY KEY (`access_level_id`);

--
-- Tablo için indeksler `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Tablo için indeksler `authors_of_book`
--
ALTER TABLE `authors_of_book`
  ADD PRIMARY KEY (`authorsOfBook_id`);

--
-- Tablo için indeksler `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Tablo için indeksler `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Tablo için indeksler `issue_status`
--
ALTER TABLE `issue_status`
  ADD PRIMARY KEY (`issue_status_id`);

--
-- Tablo için indeksler `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`log_id`);

--
-- Tablo için indeksler `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`operation_id`);

--
-- Tablo için indeksler `return_status`
--
ALTER TABLE `return_status`
  ADD PRIMARY KEY (`return_status_id`);

--
-- Tablo için indeksler `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `access_level`
--
ALTER TABLE `access_level`
  MODIFY `access_level_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `authors_of_book`
--
ALTER TABLE `authors_of_book`
  MODIFY `authorsOfBook_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Tablo için AUTO_INCREMENT değeri `issue_status`
--
ALTER TABLE `issue_status`
  MODIFY `issue_status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `log`
--
ALTER TABLE `log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `operation`
--
ALTER TABLE `operation`
  MODIFY `operation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `return_status`
--
ALTER TABLE `return_status`
  MODIFY `return_status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
