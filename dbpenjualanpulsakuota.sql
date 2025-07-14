-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Jul 2025 pada 10.34
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
  `nomorHpCustomer` char(12) NOT NULL,
  `passwordCustomer` varchar(255) NOT NULL,
  `emailCustomer` varchar(255) DEFAULT NULL,
  `statusAktif` enum('1','0') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tblcustomer`
--
DELIMITER $$
CREATE TRIGGER `insertPulsaKuotaCustomer` AFTER INSERT ON `tblcustomer` FOR EACH ROW BEGIN
    
    INSERT INTO tblpulsakuotacustomer VALUES ( NULL, NEW.idCustomer, 0, 0 );

    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblmitra`
--

CREATE TABLE `tblmitra` (
  `idMitra` int(11) NOT NULL,
  `namaMitra` varchar(255) NOT NULL,
  `emailMitra` varchar(255) NOT NULL,
  `passwordMitra` varchar(255) NOT NULL,
  `statusVerifikasi` enum('0','1') NOT NULL,
  `statusAktif` enum('1','0') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tblmitra`
--
DELIMITER $$
CREATE TRIGGER `insertSaldoMitra` AFTER INSERT ON `tblmitra` FOR EACH ROW BEGIN
    
    INSERT INTO tblsaldomitra VALUES ( NULL, NEW.idMitra, 0 );

    END
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
  `statusAktif` enum('1','0') NOT NULL
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
  `statusAktif` enum('1','0') NOT NULL
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
  `statusAktif` enum('1','0') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tbltransaksipulsa`
--
DELIMITER $$
CREATE TRIGGER `updatePulsaCustomer` AFTER UPDATE ON `tbltransaksipulsa` FOR EACH ROW BEGIN
    
    UPDATE tblpulsakuotacustomer SET pulsaCustomer = pulsaCustomer + OLD.jumlahPulsa WHERE idCustomer = OLD.idCustomer;
    UPDATE tblsaldomitra SET saldoMitra = saldoMitra - OLD.jumlahPulsa WHERE idMitra = NEW.idMitra;

    END
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
  `statusAktif` enum('1','0') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Trigger `tbltransaksisaldo`
--
DELIMITER $$
CREATE TRIGGER `updateSaldoMitra` AFTER UPDATE ON `tbltransaksisaldo` FOR EACH ROW BEGIN
    
    UPDATE tblsaldomitra SET saldoMitra = saldoMitra + OLD.jumlahSaldo WHERE idMitra = OLD.idMitra;

    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwallmitra`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwallmitra` (
`idMitra` int(11)
,`namaMitra` varchar(255)
,`emailMitra` varchar(255)
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
,`statusAktif` enum('1','0')
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
,`nomorHpCustomer` char(12)
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
,`nomorHpCustomer` char(12)
,`jumlahPulsa` int(11)
,`idMitra` int(11)
,`namaMitra` varchar(255)
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
,`namaMitra` varchar(255)
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
,`nomorHpCustomer` char(12)
,`passwordCustomer` varchar(255)
,`emailCustomer` varchar(255)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vwdonetransaksipaket`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vwdonetransaksipaket` (
`idTransaksiPaket` int(11)
,`idCustomer` int(11)
,`namaCustomer` varchar(255)
,`nomorHpCustomer` char(12)
,`idPaket` int(11)
,`namaPaket` varchar(255)
,`kuota` int(11)
,`hargaPaket` int(11)
,`waktuTransaksi` timestamp
,`statusTransaksi` enum('diproses','selesai')
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
,`nomorHpCustomer` char(12)
,`jumlahPulsa` int(11)
,`idMitra` int(11)
,`namaMitra` varchar(255)
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
,`namaMitra` varchar(255)
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
,`namaMitra` varchar(255)
,`emailMitra` varchar(255)
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
,`namaMitra` varchar(255)
,`emailMitra` varchar(255)
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
,`statusAktif` enum('1','0')
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
,`statusAktif` enum('1','0')
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
,`nomorHpCustomer` char(12)
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
,`nomorHpCustomer` char(12)
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
,`namaMitra` varchar(255)
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
,`nomorHpCustomer` char(12)
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
,`namaMitra` varchar(255)
,`emailMitra` varchar(255)
,`saldoMitra` int(11)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vwallmitra`
--
DROP TABLE IF EXISTS `vwallmitra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallmitra`  AS   (select `dbpenjualanpulsa2`.`tblmitra`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tblmitra`.`emailMitra` AS `emailMitra`,`dbpenjualanpulsa2`.`tblmitra`.`passwordMitra` AS `passwordMitra`,`dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` AS `statusVerifikasi` from `dbpenjualanpulsa2`.`tblmitra` where `dbpenjualanpulsa2`.`tblmitra`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwallpaket`
--
DROP TABLE IF EXISTS `vwallpaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwallpaket`  AS   (select `dbpenjualanpulsa2`.`tblpaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`deskripsiPaket` AS `deskripsiPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`statusAktif` AS `statusAktif` from `dbpenjualanpulsa2`.`tblpaket`)  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksipaket`
--
DROP TABLE IF EXISTS `vwalltransaksipaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksipaket`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipaket`.`idTransaksiPaket` AS `idTransaksiPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`statusTransaksi` AS `statusTransaksi` from ((`dbpenjualanpulsa2`.`tbltransaksipaket` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) join `dbpenjualanpulsa2`.`tblpaket` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` = `dbpenjualanpulsa2`.`tblpaket`.`idPaket`)) where `dbpenjualanpulsa2`.`tbltransaksipaket`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksipulsa`
--
DROP TABLE IF EXISTS `vwalltransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksipulsa`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` from ((`dbpenjualanpulsa2`.`tbltransaksipulsa` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwalltransaksisaldo`
--
DROP TABLE IF EXISTS `vwalltransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwalltransaksisaldo`  AS   (select `dbpenjualanpulsa2`.`tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` from (`dbpenjualanpulsa2`.`tbltransaksisaldo` join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwcustomer`
--
DROP TABLE IF EXISTS `vwcustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwcustomer`  AS   (select `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`passwordCustomer` AS `passwordCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`emailCustomer` AS `emailCustomer` from `dbpenjualanpulsa2`.`tblcustomer` where `dbpenjualanpulsa2`.`tblcustomer`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwdonetransaksipaket`
--
DROP TABLE IF EXISTS `vwdonetransaksipaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwdonetransaksipaket`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipaket`.`idTransaksiPaket` AS `idTransaksiPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`statusTransaksi` AS `statusTransaksi` from ((`dbpenjualanpulsa2`.`tbltransaksipaket` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) join `dbpenjualanpulsa2`.`tblpaket` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` = `dbpenjualanpulsa2`.`tblpaket`.`idPaket`)) where `dbpenjualanpulsa2`.`tbltransaksipaket`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksipaket`.`statusTransaksi` = 'selesai')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwdonetransaksipulsa`
--
DROP TABLE IF EXISTS `vwdonetransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwdonetransaksipulsa`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` from ((`dbpenjualanpulsa2`.`tbltransaksipulsa` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusTransaksi` = 'selesai')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwdonetransaksisaldo`
--
DROP TABLE IF EXISTS `vwdonetransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwdonetransaksisaldo`  AS   (select `dbpenjualanpulsa2`.`tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` from (`dbpenjualanpulsa2`.`tbltransaksisaldo` join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusTransaksi` = 'selesai')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwmitranonverifikasi`
--
DROP TABLE IF EXISTS `vwmitranonverifikasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitranonverifikasi`  AS   (select `dbpenjualanpulsa2`.`tblmitra`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tblmitra`.`emailMitra` AS `emailMitra`,`dbpenjualanpulsa2`.`tblmitra`.`passwordMitra` AS `passwordMitra`,`dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` AS `statusVerifikasi` from `dbpenjualanpulsa2`.`tblmitra` where `dbpenjualanpulsa2`.`tblmitra`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` = '0')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwmitraterverifikasi`
--
DROP TABLE IF EXISTS `vwmitraterverifikasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwmitraterverifikasi`  AS   (select `dbpenjualanpulsa2`.`tblmitra`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tblmitra`.`emailMitra` AS `emailMitra`,`dbpenjualanpulsa2`.`tblmitra`.`passwordMitra` AS `passwordMitra`,`dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` AS `statusVerifikasi` from `dbpenjualanpulsa2`.`tblmitra` where `dbpenjualanpulsa2`.`tblmitra`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpaketaktif`
--
DROP TABLE IF EXISTS `vwpaketaktif`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpaketaktif`  AS   (select `dbpenjualanpulsa2`.`tblpaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`deskripsiPaket` AS `deskripsiPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`statusAktif` AS `statusAktif` from `dbpenjualanpulsa2`.`tblpaket` where `dbpenjualanpulsa2`.`tblpaket`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpaketnonaktif`
--
DROP TABLE IF EXISTS `vwpaketnonaktif`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpaketnonaktif`  AS   (select `dbpenjualanpulsa2`.`tblpaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`deskripsiPaket` AS `deskripsiPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`statusAktif` AS `statusAktif` from `dbpenjualanpulsa2`.`tblpaket` where `dbpenjualanpulsa2`.`tblpaket`.`statusAktif` = '0')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksipaket`
--
DROP TABLE IF EXISTS `vwpendingtransaksipaket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksipaket`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipaket`.`idTransaksiPaket` AS `idTransaksiPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` AS `idPaket`,`dbpenjualanpulsa2`.`tblpaket`.`namaPaket` AS `namaPaket`,`dbpenjualanpulsa2`.`tblpaket`.`kuota` AS `kuota`,`dbpenjualanpulsa2`.`tblpaket`.`hargaPaket` AS `hargaPaket`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipaket`.`statusTransaksi` AS `statusTransaksi` from ((`dbpenjualanpulsa2`.`tbltransaksipaket` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) join `dbpenjualanpulsa2`.`tblpaket` on(`dbpenjualanpulsa2`.`tbltransaksipaket`.`idPaket` = `dbpenjualanpulsa2`.`tblpaket`.`idPaket`)) where `dbpenjualanpulsa2`.`tbltransaksipaket`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksipaket`.`statusTransaksi` = 'diproses' and `dbpenjualanpulsa2`.`tblcustomer`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksipulsa`
--
DROP TABLE IF EXISTS `vwpendingtransaksipulsa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksipulsa`  AS   (select `dbpenjualanpulsa2`.`tbltransaksipulsa`.`idTransaksiPulsa` AS `idTransaksiPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`jumlahPulsa` AS `jumlahPulsa`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusTransaksi` AS `statusTransaksi` from (`dbpenjualanpulsa2`.`tbltransaksipulsa` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tbltransaksipulsa`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) where `dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksipulsa`.`statusTransaksi` = 'diproses' and `dbpenjualanpulsa2`.`tblcustomer`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpendingtransaksisaldo`
--
DROP TABLE IF EXISTS `vwpendingtransaksisaldo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpendingtransaksisaldo`  AS   (select `dbpenjualanpulsa2`.`tbltransaksisaldo`.`idTransaksiSaldo` AS `idTransaksiSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`jumlahSaldo` AS `jumlahSaldo`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`waktuTransaksi` AS `waktuTransaksi`,`dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusTransaksi` AS `statusTransaksi` from (`dbpenjualanpulsa2`.`tbltransaksisaldo` join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tbltransaksisaldo`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tbltransaksisaldo`.`statusTransaksi` = 'diproses' and `dbpenjualanpulsa2`.`tblmitra`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwpulsakuotacustomer`
--
DROP TABLE IF EXISTS `vwpulsakuotacustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwpulsakuotacustomer`  AS   (select `dbpenjualanpulsa2`.`tblpulsakuotacustomer`.`idPulsaKuotaCustomer` AS `idPulsaKuotaCustomer`,`dbpenjualanpulsa2`.`tblpulsakuotacustomer`.`idCustomer` AS `idCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`namaCustomer` AS `namaCustomer`,`dbpenjualanpulsa2`.`tblcustomer`.`nomorHpCustomer` AS `nomorHpCustomer`,`dbpenjualanpulsa2`.`tblpulsakuotacustomer`.`pulsaCustomer` AS `pulsaCustomer`,`dbpenjualanpulsa2`.`tblpulsakuotacustomer`.`kuotaCustomer` AS `kuotaCustomer` from (`dbpenjualanpulsa2`.`tblpulsakuotacustomer` join `dbpenjualanpulsa2`.`tblcustomer` on(`dbpenjualanpulsa2`.`tblpulsakuotacustomer`.`idCustomer` = `dbpenjualanpulsa2`.`tblcustomer`.`idCustomer`)) where `dbpenjualanpulsa2`.`tblcustomer`.`statusAktif` = '1')  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vwsaldomitra`
--
DROP TABLE IF EXISTS `vwsaldomitra`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwsaldomitra`  AS   (select `dbpenjualanpulsa2`.`tblsaldomitra`.`idSaldoMitra` AS `idSaldoMitra`,`dbpenjualanpulsa2`.`tblsaldomitra`.`idMitra` AS `idMitra`,`dbpenjualanpulsa2`.`tblmitra`.`namaMitra` AS `namaMitra`,`dbpenjualanpulsa2`.`tblmitra`.`emailMitra` AS `emailMitra`,`dbpenjualanpulsa2`.`tblsaldomitra`.`saldoMitra` AS `saldoMitra` from (`dbpenjualanpulsa2`.`tblsaldomitra` join `dbpenjualanpulsa2`.`tblmitra` on(`dbpenjualanpulsa2`.`tblsaldomitra`.`idMitra` = `dbpenjualanpulsa2`.`tblmitra`.`idMitra`)) where `dbpenjualanpulsa2`.`tblmitra`.`statusAktif` = '1' and `dbpenjualanpulsa2`.`tblmitra`.`statusVerifikasi` = '1')  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tblcustomer`
--
ALTER TABLE `tblcustomer`
  ADD PRIMARY KEY (`idCustomer`);

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
  ADD KEY `idCustomerPulsaKuota` (`idCustomer`);

--
-- Indeks untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  ADD PRIMARY KEY (`idSaldoMitra`),
  ADD KEY `idMitraSaldoMitra` (`idMitra`);

--
-- Indeks untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  ADD PRIMARY KEY (`idTransaksiPaket`),
  ADD KEY `idCustomerTransaksiPaket` (`idCustomer`),
  ADD KEY `idPaketTransaksiPaket` (`idPaket`);

--
-- Indeks untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  ADD PRIMARY KEY (`idTransaksiPulsa`),
  ADD KEY `idCustomerTransaksiPulsa` (`idCustomer`),
  ADD KEY `idMitraTransaksiPulsa` (`idMitra`);

--
-- Indeks untuk tabel `tbltransaksisaldo`
--
ALTER TABLE `tbltransaksisaldo`
  ADD PRIMARY KEY (`idTransaksiSaldo`),
  ADD KEY `idMitraTransaksiSaldo` (`idMitra`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tblcustomer`
--
ALTER TABLE `tblcustomer`
  MODIFY `idCustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tblmitra`
--
ALTER TABLE `tblmitra`
  MODIFY `idMitra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tblpaket`
--
ALTER TABLE `tblpaket`
  MODIFY `idPaket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `tblpulsakuotacustomer`
--
ALTER TABLE `tblpulsakuotacustomer`
  MODIFY `idPulsaKuotaCustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  MODIFY `idSaldoMitra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  MODIFY `idTransaksiPaket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  MODIFY `idTransaksiPulsa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  ADD CONSTRAINT `idCustomerPulsaKuota` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tblsaldomitra`
--
ALTER TABLE `tblsaldomitra`
  ADD CONSTRAINT `idMitraSaldoMitra` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksipaket`
--
ALTER TABLE `tbltransaksipaket`
  ADD CONSTRAINT `idCustomerTransaksiPaket` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idPaketTransaksiPaket` FOREIGN KEY (`idPaket`) REFERENCES `tblpaket` (`idPaket`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksipulsa`
--
ALTER TABLE `tbltransaksipulsa`
  ADD CONSTRAINT `idCustomerTransaksiPulsa` FOREIGN KEY (`idCustomer`) REFERENCES `tblcustomer` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idMitraTransaksiPulsa` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbltransaksisaldo`
--
ALTER TABLE `tbltransaksisaldo`
  ADD CONSTRAINT `idMitraTransaksiSaldo` FOREIGN KEY (`idMitra`) REFERENCES `tblmitra` (`idMitra`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
