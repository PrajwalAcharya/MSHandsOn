CREATE TABLE 'order' (
  'id' int(11) NOT NULL,
  'Name' varchar(45) DEFAULT NULL,
  'Price' decimal(10,0) DEFAULT NULL,
  'AccessToken' varchar(5000) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB

INSERT INTO 'order' VALUES(401,'Shampoo',75.2,'asasaa')