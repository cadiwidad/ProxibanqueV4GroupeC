-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 23 oct. 2019 à 13:35
-- Version du serveur :  10.3.16-MariaDB
-- Version de PHP :  7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanqueversion4`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `adresse_client` varchar(255) DEFAULT NULL,
  `email_client` varchar(255) DEFAULT NULL,
  `nom_client` varchar(255) DEFAULT NULL,
  `prenom_client` varchar(255) DEFAULT NULL,
  `id_conseiller` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `adresse_client`, `email_client`, `nom_client`, `prenom_client`, `id_conseiller`) VALUES
(59, 'rabat', 'issmail@gmail.com', 'nourri', 'issmail', 27);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `type_compte` varchar(2) NOT NULL,
  `id_compte` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `id_conseiller` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`type_compte`, `id_compte`, `date_creation`, `solde`, `decouvert`, `taux`, `id_client`, `id_conseiller`) VALUES
('CC', 'CC208139284664', '2019-10-21 11:36:02', -323, 3000, NULL, 59, 27);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `id_conseiller` bigint(20) NOT NULL,
  `adresse_conseiller` varchar(255) DEFAULT NULL,
  `email_conseiller` varchar(255) DEFAULT NULL,
  `nom_conseiller` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom_conseiller` varchar(255) DEFAULT NULL,
  `id_gerant` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`id_conseiller`, `adresse_conseiller`, `email_conseiller`, `nom_conseiller`, `password`, `prenom_conseiller`, `id_gerant`) VALUES
(27, 'Casablanaca', 'zineb@gmail.com', 'sidilkhir', 'zinebproxi', 'zineb', 1),
(28, 'rabat', 'mouhamed@gmail.com', 'bourkha', 'bourkhaproxi', 'mouhamed\r\n', 1);

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `id_gerant` bigint(20) NOT NULL,
  `adresse_gerant` varchar(255) DEFAULT NULL,
  `email_gerant` varchar(255) DEFAULT NULL,
  `nom_gerant` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom_gerant` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gerant`
--

INSERT INTO `gerant` (`id_gerant`, `adresse_gerant`, `email_gerant`, `nom_gerant`, `password`, `prenom_gerant`) VALUES
(1, 'casablanca', 'jawad@gmail.com', 'cadi', 'jawad', 'jawad');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `type_operation` varchar(31) NOT NULL,
  `id_operation` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `id_compte` varchar(255) DEFAULT NULL,
  `id_conseiller` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`type_operation`, `id_operation`, `date_operation`, `montant`, `id_compte`, `id_conseiller`) VALUES
('retrait', 110, '2019-10-21 15:23:59', 444, 'CC208139284664', 26),
('versement', 111, '2019-10-21 15:23:59', 444, 'CC1021906172078', 26),
('retrait', 112, '2019-10-21 15:24:40', 444, 'CC1021906172078', 26),
('versement', 113, '2019-10-21 15:24:40', 444, 'CC208139284664', 26),
('retrait', 114, '2019-10-22 19:46:06', 343, 'CC208139284664', 27),
('versement', 115, '2019-10-22 19:46:06', 343, 'CC1021906172078', 27);

-- --------------------------------------------------------

--
-- Structure de la table `parametrage`
--

CREATE TABLE `parametrage` (
  `id_parametrage` bigint(20) NOT NULL,
  `commission` int(11) NOT NULL,
  `decouvert` double NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nbr_clients` int(11) NOT NULL,
  `nbr_conseillers` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `solde` double NOT NULL,
  `style_graphe` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parametrage`
--

INSERT INTO `parametrage` (`id_parametrage`, `commission`, `decouvert`, `login`, `nbr_clients`, `nbr_conseillers`, `password`, `solde`, `style_graphe`) VALUES
(1, 3, 3000, 'parametrage', 3, 11, 'parametrage', 20, 'Camembert');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD KEY `FKcu16e576j6rsiofn47y4wx5yu` (`id_conseiller`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`),
  ADD KEY `FKfn9jafk7kn8gpmsxv9uhqna92` (`id_client`),
  ADD KEY `FKpe05jvqrafuxh35ibccr4fnm6` (`id_conseiller`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id_conseiller`),
  ADD KEY `FKs178dp3cf41x4oyqq8pcvirxn` (`id_gerant`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`id_gerant`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id_operation`),
  ADD KEY `FKp4dijgl2tub2wqsl5gegb0psj` (`id_compte`),
  ADD KEY `FKlyhkfka0xyc81bm6lfcgy07wa` (`id_conseiller`);

--
-- Index pour la table `parametrage`
--
ALTER TABLE `parametrage`
  ADD PRIMARY KEY (`id_parametrage`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `id_conseiller` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `gerant`
--
ALTER TABLE `gerant`
  MODIFY `id_gerant` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `id_operation` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT pour la table `parametrage`
--
ALTER TABLE `parametrage`
  MODIFY `id_parametrage` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
