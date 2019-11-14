CREATE TABLE payment(
  paymentId UUID NOT NULL PRIMARY KEY ,
  orderId UUID NOT NULL ,
  status INTEGER ,
  username VARCHAR (100) NOT NULL,
  cardInfo INTEGER
);