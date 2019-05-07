
DELETE FROM [nomDB].Panier;
DELETE FROM [nomDB].Produit;
DELETE FROM [nomDB].User;

DROP TABLE [nomDB].Panier;
DROP TABLE [nomDB].Produit;
DROP TABLE [nomDB].User;


CREATE TABLE `Panier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Produit` (
  `nom` varchar(45) NOT NULL,
  `prix` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `User` (
  `pseudo` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `admin` int(11) NOT NULL,
  PRIMARY KEY (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8