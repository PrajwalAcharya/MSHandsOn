CREATE TABLE `itemorder` (
  `id` int(11) NOT NULL,
  `OrderName` varchar(45) DEFAULT NULL,
  `OrderPrice` decimal(10,0) DEFAULT NULL,
  'AccessToken' varchar(6000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB

INSERT INTO 'itemorder' VALUES(401,'Headphones',990.00, 'hshhdk1233')