-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Creato il: Ott 23, 2020 alle 13:10
-- Versione del server: 10.4.10-MariaDB
-- Versione PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farmacia`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
CREATE TABLE IF NOT EXISTS `amministratore` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cognome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`id`, `username`, `password`, `nome`, `cognome`) VALUES
(1, 'admin', 'admin', 'Chiara', 'Francesca');

-- --------------------------------------------------------

--
-- Struttura della tabella `contenuto`
--

DROP TABLE IF EXISTS `contenuto`;
CREATE TABLE IF NOT EXISTS `contenuto` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `prescrizione` int(7) NOT NULL,
  `farmaco` int(7) NOT NULL,
  `quantità` int(7) NOT NULL,
  `dosaggio` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `prescrizione` (`prescrizione`),
  KEY `farmaco` (`farmaco`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `contenuto`
--

INSERT INTO `contenuto` (`id`, `prescrizione`, `farmaco`, `quantità`, `dosaggio`) VALUES
(1, 1, 4, 2, 'uno al giorno'),
(2, 2, 2, 1, 'due al giorno'),
(3, 3, 1, 1, 'uno al giorno'),
(4, 4, 5, 3, 'due al giorno');

-- --------------------------------------------------------

--
-- Struttura della tabella `farmacista`
--

DROP TABLE IF EXISTS `farmacista`;
CREATE TABLE IF NOT EXISTS `farmacista` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `farmacista`
--

INSERT INTO `farmacista` (`id`, `username`, `cognome`, `nome`, `password`) VALUES
(1, 'Farmacista1', 'Rossi', 'Mario', 'farmacista1'),
(2, 'Farmacista2', 'Miche', 'Chiara', 'farmacista2'),
(3, 'Farmacista3', 'Santo', 'Francesca', 'farmacista3'),
(5, 'farmacista', 'Francesca', 'Chiara', 'farmacista');

-- --------------------------------------------------------

--
-- Struttura della tabella `farmaco`
--

DROP TABLE IF EXISTS `farmaco`;
CREATE TABLE IF NOT EXISTS `farmaco` (
  `Id` int(7) NOT NULL AUTO_INCREMENT,
  `disponibilita` int(7) NOT NULL,
  `quantitàMinima` int(7) NOT NULL,
  `casaFarmaceutica` varchar(50) NOT NULL,
  `metodoConservazione` varchar(300) NOT NULL,
  `tipoContenuto` varchar(300) NOT NULL,
  `tipoUso` varchar(300) NOT NULL,
  `effettiIndesiderati` varchar(1000) NOT NULL,
  `nomeFarmaco` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `nomeFarmaco` (`nomeFarmaco`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `farmaco`
--

INSERT INTO `farmaco` (`Id`, `disponibilita`, `quantitàMinima`, `casaFarmaceutica`, `metodoConservazione`, `tipoContenuto`, `tipoUso`, `effettiIndesiderati`, `nomeFarmaco`) VALUES
(1, 9, 5, 'Dompé farmaceutici S.p.A.', 'asciutto', 'bustine', 'orale', 'può causare dolori intestinali, problemi ai reni, reazione allergica, prurito ', 'OKI'),
(2, 10, 7, 'Mylan', 'asciutto', 'bustine', 'orale', 'può causare dolori intestinali, problemi ai reni, reazione allergica, prurito.', 'Brufen'),
(3, 6, 2, 'Angelini', 'fresco', 'pasticche', 'orale', 'può causare dolori intestinali, problemi ai reni, reazione allergica, prurito.', 'Buscopan'),
(4, 5, 5, 'Angelini', 'asciutto', 'bustine', 'orale', 'può causare dolori intestinali, problemi ai reni, reazione allergica, prurito.', 'Moment'),
(5, 10, 5, 'Angelini', 'fresco', 'pasticche', 'orale', 'può causare dolori intestinali, problemi ai reni, reazione allergica, prurito.', 'Tachipirina500');

-- --------------------------------------------------------

--
-- Struttura della tabella `medico`
--

DROP TABLE IF EXISTS `medico`;
CREATE TABLE IF NOT EXISTS `medico` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `medico`
--

INSERT INTO `medico` (`id`, `username`, `nome`, `cognome`, `password`) VALUES
(1, 'Medico1', 'Renato', 'Galzio', 'ciao'),
(2, 'Medico2', 'Mario', 'Piccoli', 'ciao'),
(3, 'Medico3', 'Chiara', 'Panino', 'ciao'),
(5, 'medico', 'Chiara', 'Francesca', 'medico');

-- --------------------------------------------------------

--
-- Struttura della tabella `paziente`
--

DROP TABLE IF EXISTS `paziente`;
CREATE TABLE IF NOT EXISTS `paziente` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `codiceFiscale` varchar(17) NOT NULL,
  `username` varchar(50) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codiceFiscale` (`codiceFiscale`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `paziente`
--

INSERT INTO `paziente` (`id`, `codiceFiscale`, `username`, `cognome`, `nome`, `password`) VALUES
(1, 'SNTFNC97D54C632K', 'Paziente1', 'Santoferrara', 'Francesca', 'ciao'),
(2, 'GGTFNC97D54C632K', 'Paziente2', 'Rossi', 'Mario', 'ciao'),
(3, 'PNNCHR98D54C632K', 'Paziente3', 'Milano', 'Giovanni', 'ciao'),
(4, 'CFSM9897CIAO', 'paziente', 'Francesca', 'Chiara', 'paziente');

-- --------------------------------------------------------

--
-- Struttura della tabella `prescrizione`
--

DROP TABLE IF EXISTS `prescrizione`;
CREATE TABLE IF NOT EXISTS `prescrizione` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `oraCreazione` time NOT NULL,
  `dataCreazione` date NOT NULL,
  `farmacista` int(7) DEFAULT NULL,
  `paziente` int(7) NOT NULL,
  `medico` int(7) NOT NULL,
  `evasa` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Paziente` (`paziente`),
  KEY `Medico` (`medico`),
  KEY `Farmacista` (`farmacista`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16;

--
-- Dump dei dati per la tabella `prescrizione`
--

INSERT INTO `prescrizione` (`id`, `oraCreazione`, `dataCreazione`, `farmacista`, `paziente`, `medico`, `evasa`) VALUES
(1, '15:00:00', '2020-10-23', NULL, 4, 5, NULL),
(2, '14:00:00', '2020-10-09', NULL, 2, 1, NULL),
(3, '08:00:00', '2020-10-18', NULL, 3, 2, NULL),
(4, '10:00:00', '2020-10-15', NULL, 1, 3, NULL);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `contenuto`
--
ALTER TABLE `contenuto`
  ADD CONSTRAINT `contenuto_ibfk_1` FOREIGN KEY (`prescrizione`) REFERENCES `prescrizione` (`id`),
  ADD CONSTRAINT `contenuto_ibfk_2` FOREIGN KEY (`farmaco`) REFERENCES `farmaco` (`Id`);

--
-- Limiti per la tabella `prescrizione`
--
ALTER TABLE `prescrizione`
  ADD CONSTRAINT `prescrizione_ibfk_1` FOREIGN KEY (`paziente`) REFERENCES `paziente` (`id`),
  ADD CONSTRAINT `prescrizione_ibfk_2` FOREIGN KEY (`farmacista`) REFERENCES `farmacista` (`id`),
  ADD CONSTRAINT `prescrizione_ibfk_5` FOREIGN KEY (`medico`) REFERENCES `medico` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
