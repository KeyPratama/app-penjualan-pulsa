-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Jun 2025 pada 04.25
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpenjualanpulsakuota`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblcustomer`
--

CREATE TABLE `tblcustomer` (
  `idCustomer` int(11) NOT NULL,
  `namaCustomer` varchar(255) NOT NULL,
  `noHpCustomer` char(12) NOT NULL,
  `passwordCustomer` varchar(255) NOT NULL,
  `emailCustomer` varchar(255) NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tblcustomer`
--
DELIMITER $$
CREATE TRIGGER `insertPulsaKuotaCustomer` AFTER INSERT ON `tblcustomer` FOR EACH ROW INSERT INTO tblpulsakuotacustomer VALUES(NULL,NEW.idCustomer,0,0)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblmitra`
--

CREATE TABLE `tblmitra` (
  `idMitra` int(11) NOT NULL,
  `namaMitra` int(255) NOT NULL,
  `emailMitra` int(255) NOT NULL,
  `passwordMitra` varchar(255) NOT NULL,
  `statusVerifikasi` enum('0','1') NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tblmitra`
--
DELIMITER $$
CREATE TRIGGER `insertSaldoMitra` AFTER INSERT ON `tblmitra` FOR EACH ROW INSERT INTO tblsaldomitra VALUES(NULL,NEW.idMitra,0)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblpaket`
--

CREATE TABLE `tblpaket` (
  `idPaket` int(11) NOT NULL,
  `namaPaket` varchar(255) NOT NULL,
  `deskripsiPaket` text NOT NULL,
  `kuota` int(11) NOT NULL,
  `hargaPaket` int(11) NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblpulsakuotacustomer`
--

CREATE TABLE `tblpulsakuotacustomer` (
  `idPulsaKuotaCustomer` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `pulsaCustomer` int(11) NOT NULL,
  `kuotaCustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblsaldomitra`
--

CREATE TABLE `tblsaldomitra` (
  `idSaldoMitra` int(11) NOT NULL,
  `idMitra` int(11) NOT NULL,
  `saldoMitra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltransaksipaket`
--

CREATE TABLE `tbltransaksipaket` (
  `idTransaksiPaket` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `idPaket` int(11) NOT NULL,
  `waktuTransaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `statusTransaksi` enum('diproses','selesai') NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltransaksipulsa`
--

CREATE TABLE `tbltransaksipulsa` (
  `idTransaksiPulsa` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `jumlahPulsa` int(11) NOT NULL,
  `idMitra` int(11) NOT NULL,
  `waktuTransaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `statusTransaksi` enum('diproses','selesai') NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tbltransaksipulsa`
--
DELIMITER $$
CREATE TRIGGER `updatePulsaCustomer` AFTER UPDATE ON `tbltransaksipulsa` FOR EACH ROW UPDATE tblpulsakuotacustomer SET tblpulsakuotacustomer.pulsaCustomer = tblpulsakuotacustomer.pulsaCustomer + OLD.tbltransaksipulsa.jumlahPulsa WHERE tbltransaksipulsa.idCustomer = OLD.tbltransaksipulsa.idCustomer
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltransaksisaldo`
--

CREATE TABLE `tbltransaksisaldo` (
  `idTransaksiSaldo` int(11) NOT NULL,
  `idMitra` int(11) NOT NULL,
  `jumlahSaldo` int(11) NOT NULL,
  `waktuTransaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `statusTransaksi` enum('diproses','selesai') NOT NULL,
  `statusAktif` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tbltransaksisaldo`
--
DELIMITER $$
CREATE TRIGGER `updateSaldoMitra` AFTER UPDATE ON `tbltransaksisaldo` FOR EACH ROW UPDATE tblsaldomitra SET tblsaldomitra.saldoMitra = tblsaldomitra.saldoMitra + OLD.tbltransaksisaldo.jumlahSaldo WHERE tbltransaksisaldo.idMitra = OLD.tbltransaksisaldo.idMitra
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwallmitra`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwallmitra` (
`idMitra` int(11)
,`namaMitra` int(255)
,`emailMitra` int(255)
,`passwordMitra` varchar(255)
,`statusVerifikasi` enum('0','1')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwallpaket`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwallpaket` (
`idPaket` int(11)
,`namaPaket` varchar(255)
,`deskripsiPaket` text
,`kuota` int(11)
,`hargaPaket` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwalltransaksipaket`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwalltransaksipaket` (
`idTransaksiPaket` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`idPaket` int(11)
,`namaPaket` varchar(255)
,`kuota` int(11)
,`hargaPaket` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwalltransaksipulsa`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwalltransaksipulsa` (
`idTransaksiPulsa` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`jumlahPulsa` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwalltransaksisaldo`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwalltransaksisaldo` (
`idTransaksiSaldo` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`jumlahSaldo` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwcustomer`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwcustomer` (
`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`passwordCustomer` varchar(255)
,`emailCustomer` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwdonetransaksipulsa`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwdonetransaksipulsa` (
`idTransaksiPulsa` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`jumlahPulsa` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwdonetransaksisaldo`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwdonetransaksisaldo` (
`idTransaksiSaldo` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`jumlahSaldo` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwmitranonverifikasi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwmitranonverifikasi` (
`idMitra` int(11)
,`namaMitra` int(255)
,`emailMitra` int(255)
,`passwordMitra` varchar(255)
,`statusVerifikasi` enum('0','1')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwmitraterverifikasi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwmitraterverifikasi` (
`idMitra` int(11)
,`namaMitra` int(255)
,`emailMitra` int(255)
,`passwordMitra` varchar(255)
,`statusVerifikasi` enum('0','1')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpaketaktif`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpaketaktif` (
`idPaket` int(11)
,`namaPaket` varchar(255)
,`deskripsiPaket` text
,`kuota` int(11)
,`hargaPaket` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpaketnonaktif`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpaketnonaktif` (
`idPaket` int(11)
,`namaPaket` varchar(255)
,`deskripsiPaket` text
,`kuota` int(11)
,`hargaPaket` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpendingtransaksipaket`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpendingtransaksipaket` (
`idTransaksiPaket` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`idPaket` int(11)
,`namaPaket` varchar(255)
,`kuota` int(11)
,`hargaPaket` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpendingtransaksipulsa`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpendingtransaksipulsa` (
`idTransaksiPulsa` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`jumlahPulsa` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpendingtransaksisaldo`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpendingtransaksisaldo` (
`idTransaksiSaldo` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`jumlahSaldo` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwpulsakuotacustomer`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwpulsakuotacustomer` (
`idPulsaKuotaCustomer` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`noHpCustomer` char(12)
,`pulsaCustomer` int(11)
,`kuotaCustomer` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwsaldomitra`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwsaldomitra` (
`idSaldoMitra` int(11)
,`idMitra` int(11)
,`namaMitra` int(255)
,`saldoMitra` int(11)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vwallmitra`
--
DROP TABLE IF EXISTS `vwallmitra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmitra`  AS SELECT `tblmitra`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tblmitra`.`emailMitra` AS `emailMitra`, `tblmitra`.`passwordMitra` AS `passwordMitra`, `tblmitra`.`statusVerifikasi` AS `statusVerifikasi` FROM `tblmitra` WHERE `tblmitra`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwallpaket`
--
DROP TABLE IF EXISTS `vwallpaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallpaket`  AS SELECT `tblpaket`.`idPaket` AS `idPaket`, `tblpaket`.`namaPaket` AS `namaPaket`, `tblpaket`.`deskripsiPaket` AS `deskripsiPaket`, `tblpaket`.`kuota` AS `kuota`, `tblpaket`.`hargaPaket` AS `hargaPaket` FROM `tblpaket` ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksipaket`
--
DROP TABLE IF EXISTS `vwalltransaksipaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksipaket`  AS SELECT `tbltransaksipaket`.`idTransaksiPaket` AS `idTransaksiPaket`, `tbltransaksipaket`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tbltransaksipaket`.`idPaket` AS `idPaket`, `tblpaket`.`namaPaket` AS `namaPaket`, `tblpaket`.`kuota` AS `kuota`, `tblpaket`.`hargaPaket` AS `hargaPaket`, `tbltransaksipaket`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksipaket`.`statusTransaksi` AS `statusTransaksi` FROM ((`tbltransaksipaket` join `tblcustomer` on(`tbltransaksipaket`.`idCustomer` = `tblcustomer`.`idCustomer`)) join `tblpaket` on(`tbltransaksipaket`.`idPaket` = `tblpaket`.`idPaket`)) WHERE `tbltransaksipaket`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksipulsa`
--
DROP TABLE IF EXISTS `vwalltransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksipulsa`  AS SELECT `tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`, `tbltransaksipulsa`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`, `tbltransaksipulsa`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` FROM ((`tbltransaksipulsa` join `tblmitra` on(`tbltransaksipulsa`.`idMitra` = `tblmitra`.`idMitra`)) join `tblcustomer` on(`tbltransaksipulsa`.`idCustomer` = `tblcustomer`.`idCustomer`)) WHERE `tbltransaksipulsa`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksisaldo`
--
DROP TABLE IF EXISTS `vwalltransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksisaldo`  AS SELECT `tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`, `tbltransaksisaldo`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`, `tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` FROM (`tbltransaksisaldo` join `tblmitra` on(`tbltransaksisaldo`.`idMitra` = `tblmitra`.`idMitra`)) WHERE `tbltransaksisaldo`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwcustomer`
--
DROP TABLE IF EXISTS `vwcustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwcustomer`  AS SELECT `tblcustomer`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`passwordCustomer` AS `passwordCustomer`, `tblcustomer`.`emailCustomer` AS `emailCustomer` FROM `tblcustomer` WHERE `tblcustomer`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwdonetransaksipulsa`
--
DROP TABLE IF EXISTS `vwdonetransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwdonetransaksipulsa`  AS SELECT `tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`, `tbltransaksipulsa`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`, `tbltransaksipulsa`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` FROM ((`tbltransaksipulsa` join `tblmitra` on(`tbltransaksipulsa`.`idMitra` = `tblmitra`.`idMitra`)) join `tblcustomer` on(`tbltransaksipulsa`.`idCustomer` = `tblcustomer`.`idCustomer`)) WHERE `tbltransaksipulsa`.`statusAktif` = 1 AND `tbltransaksipulsa`.`statusTransaksi` = 'selesai' ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwdonetransaksisaldo`
--
DROP TABLE IF EXISTS `vwdonetransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwdonetransaksisaldo`  AS SELECT `tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`, `tbltransaksisaldo`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`, `tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` FROM (`tbltransaksisaldo` join `tblmitra` on(`tbltransaksisaldo`.`idMitra` = `tblmitra`.`idMitra`)) WHERE `tbltransaksisaldo`.`statusAktif` = 1 AND `tbltransaksisaldo`.`statusTransaksi` = 'selesai' ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwmitranonverifikasi`
--
DROP TABLE IF EXISTS `vwmitranonverifikasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitranonverifikasi`  AS SELECT `tblmitra`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tblmitra`.`emailMitra` AS `emailMitra`, `tblmitra`.`passwordMitra` AS `passwordMitra`, `tblmitra`.`statusVerifikasi` AS `statusVerifikasi` FROM `tblmitra` WHERE `tblmitra`.`statusAktif` = 1 AND `tblmitra`.`statusVerifikasi` = 0 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwmitraterverifikasi`
--
DROP TABLE IF EXISTS `vwmitraterverifikasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitraterverifikasi`  AS SELECT `tblmitra`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tblmitra`.`emailMitra` AS `emailMitra`, `tblmitra`.`passwordMitra` AS `passwordMitra`, `tblmitra`.`statusVerifikasi` AS `statusVerifikasi` FROM `tblmitra` WHERE `tblmitra`.`statusAktif` = 1 AND `tblmitra`.`statusVerifikasi` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpaketaktif`
--
DROP TABLE IF EXISTS `vwpaketaktif`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpaketaktif`  AS SELECT `tblpaket`.`idPaket` AS `idPaket`, `tblpaket`.`namaPaket` AS `namaPaket`, `tblpaket`.`deskripsiPaket` AS `deskripsiPaket`, `tblpaket`.`kuota` AS `kuota`, `tblpaket`.`hargaPaket` AS `hargaPaket` FROM `tblpaket` WHERE `tblpaket`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpaketnonaktif`
--
DROP TABLE IF EXISTS `vwpaketnonaktif`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpaketnonaktif`  AS SELECT `tblpaket`.`idPaket` AS `idPaket`, `tblpaket`.`namaPaket` AS `namaPaket`, `tblpaket`.`deskripsiPaket` AS `deskripsiPaket`, `tblpaket`.`kuota` AS `kuota`, `tblpaket`.`hargaPaket` AS `hargaPaket` FROM `tblpaket` WHERE `tblpaket`.`statusAktif` = 0 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksipaket`
--
DROP TABLE IF EXISTS `vwpendingtransaksipaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksipaket`  AS SELECT `tbltransaksipaket`.`idTransaksiPaket` AS `idTransaksiPaket`, `tbltransaksipaket`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tbltransaksipaket`.`idPaket` AS `idPaket`, `tblpaket`.`namaPaket` AS `namaPaket`, `tblpaket`.`kuota` AS `kuota`, `tblpaket`.`hargaPaket` AS `hargaPaket`, `tbltransaksipaket`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksipaket`.`statusTransaksi` AS `statusTransaksi` FROM ((`tbltransaksipaket` join `tblcustomer` on(`tbltransaksipaket`.`idCustomer` = `tblcustomer`.`idCustomer`)) join `tblpaket` on(`tbltransaksipaket`.`idPaket` = `tblpaket`.`idPaket`)) WHERE `tbltransaksipaket`.`statusAktif` = 1 AND `tbltransaksipaket`.`statusTransaksi` = 'diproses' AND `tblcustomer`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksipulsa`
--
DROP TABLE IF EXISTS `vwpendingtransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksipulsa`  AS SELECT `tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`, `tbltransaksipulsa`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`, `tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` FROM (`tbltransaksipulsa` join `tblcustomer` on(`tbltransaksipulsa`.`idCustomer` = `tblcustomer`.`idCustomer`)) WHERE `tbltransaksipulsa`.`statusAktif` = 1 AND `tbltransaksipulsa`.`statusTransaksi` = 'diproses' AND `tblcustomer`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksisaldo`
--
DROP TABLE IF EXISTS `vwpendingtransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksisaldo`  AS SELECT `tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`, `tbltransaksisaldo`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`, `tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`, `tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` FROM (`tbltransaksisaldo` join `tblmitra` on(`tbltransaksisaldo`.`idMitra` = `tblmitra`.`idMitra`)) WHERE `tbltransaksisaldo`.`statusAktif` = 1 AND `tbltransaksisaldo`.`statusTransaksi` = 'diproses' AND `tblmitra`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpulsakuotacustomer`
--
DROP TABLE IF EXISTS `vwpulsakuotacustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpulsakuotacustomer`  AS SELECT `tblpulsakuotacustomer`.`idPulsaKuotaCustomer` AS `idPulsaKuotaCustomer`, `tblpulsakuotacustomer`.`idCustomer` AS `idCustomer`, `tblcustomer`.`namaCustomer` AS `namaCustomer`, `tblcustomer`.`noHpCustomer` AS `noHpCustomer`, `tblpulsakuotacustomer`.`pulsaCustomer` AS `pulsaCustomer`, `tblpulsakuotacustomer`.`kuotaCustomer` AS `kuotaCustomer` FROM (`tblpulsakuotacustomer` join `tblcustomer` on(`tblpulsakuotacustomer`.`idCustomer` = `tblcustomer`.`idCustomer`)) WHERE `tblcustomer`.`statusAktif` = 1 ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwsaldomitra`
--
DROP TABLE IF EXISTS `vwsaldomitra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwsaldomitra`  AS SELECT `tblsaldomitra`.`idSaldoMitra` AS `idSaldoMitra`, `tblsaldomitra`.`idMitra` AS `idMitra`, `tblmitra`.`namaMitra` AS `namaMitra`, `tblsaldomitra`.`saldoMitra` AS `saldoMitra` FROM (`tblsaldomitra` join `tblmitra` on(`tblsaldomitra`.`idMitra` = `tblmitra`.`idMitra`)) WHERE `tblmitra`.`statusAktif` = 1 AND `tblmitra`.`statusVerifikasi` = 1 ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD PRIMARY KEY (`idCustomer`),
  ADD UNIQUE KEY `noHpCustomer` (`noHpCustomer`),
  ADD UNIQUE KEY `emailCustomer` (`emailCustomer`);

--
-- Indeks untuk tabel `tblmitra`
--
ALTER TABLE `tblmitra`
  ADD PRIMARY KEY (`idMitra`);

--
-- Indeks untuk tabel `tblpaket`
--
ALTER TABLE `tblpaket`
  ADD PRIMARY KEY (`idPaket`);

--
-- Indeks untuk tabel `tblpulsakuotacustomer`
--
ALTER TABLE `tblpulsakuotacustomer`
  ADD PRIMARY KEY (`idPulsaKuotaCustomer`),
  ADD KEY `idCustomer` (`idCustomer`);

--
-- Indeks untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  ADD PRIMARY KEY (`idSaldoMitra`),
  ADD KEY `idMitra` (`idMitra`);

--
-- Indeks untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  ADD PRIMARY KEY (`idTransaksiPaket`),
  ADD KEY `idCustomer` (`idCustomer`),
  ADD KEY `idPaket` (`idPaket`);

--
-- Indeks untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  ADD PRIMARY KEY (`idTransaksiPulsa`),
  ADD KEY `idCustomer` (`idCustomer`),
  ADD KEY `idMitra` (`idMitra`);

--
-- Indeks untuk tabel `tbltransaksisaldo`
--
ALTER TABLE `tbltransaksisaldo`
  ADD PRIMARY KEY (`idTransaksiSaldo`),
  ADD KEY `idMitra` (`idMitra`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tblcustomer`
--
ALTER TABLE `tblcustomer`
  MODIFY `idCustomer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tblmitra`
--
ALTER TABLE `tblmitra`
  MODIFY `idMitra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tblpaket`
--
ALTER TABLE `tblpaket`
  MODIFY `idPaket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tblpulsakuotacustomer`
--
ALTER TABLE `tblpulsakuotacustomer`
  MODIFY `idPulsaKuotaCustomer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  MODIFY `idSaldoMitra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  MODIFY `idTransaksiPaket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  MODIFY `idTransaksiPulsa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbltransaksisaldo`
--
ALTER TABLE `tbltransaksisaldo`
  MODIFY `idTransaksiSaldo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tblpulsakuotacustomer`
--
ALTER TABLE `tblpulsakuotacustomer`
  ADD CONSTRAINT `tblpulsakuotacustomer_ibfk_1` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  ADD CONSTRAINT `tblsaldomitra_ibfk_1` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  ADD CONSTRAINT `tbltransaksipaket_ibfk_1` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbltransaksipaket_ibfk_2` FOREIGN KEY (`idPaket`) REFERENCES `tblpaket` (`idPaket`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  ADD CONSTRAINT `tbltransaksipulsa_ibfk_1` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbltransaksipulsa_ibfk_2` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksisaldo`
--
ALTER TABLE `tbltransaksisaldo`
  ADD CONSTRAINT `tbltransaksisaldo_ibfk_1` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
