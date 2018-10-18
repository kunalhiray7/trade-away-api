CREATE TABLE items (
  item_name varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  image_url varchar(255) DEFAULT NULL,
  price double DEFAULT NULL,
  category_category_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (item_name),
  KEY FK6tvhgkcbau4i08xx5uu9vaoxu (category_category_name),
  CONSTRAINT FK6tvhgkcbau4i08xx5uu9vaoxu FOREIGN KEY (category_category_name) REFERENCES category (category_name)
);

CREATE TABLE items_sellers (
  items_item_name varchar(255) NOT NULL,
  sellers_user_name varchar(255) NOT NULL,
  PRIMARY KEY (items_item_name,sellers_user_name),
  KEY FK1j410nu658p9a1t3cfa7foxwx (sellers_user_name),
  CONSTRAINT FK1j410nu658p9a1t3cfa7foxwx FOREIGN KEY (sellers_user_name) REFERENCES user (user_name),
  CONSTRAINT FKbnctx20wovuq913uhw17xahya FOREIGN KEY (items_item_name) REFERENCES items (item_name)
);


INSERT INTO items (item_name, description, image_url, price, category_category_name)
VALUES ('Iphone 8', 'Sell your kidney', 'https://www.digifloor.com/wp-content/uploads/2017/08/iphone8.jpg', 100000.99, 'Mobile Devices');

INSERT INTO items (item_name, description, image_url, price, category_category_name)
VALUES ('Pixel XL', 'Sell your half kidney', 'http://cdn2.gsmarena.com/vv/bigpic/google-pixel-xl.jpg', 50000.99, 'Mobile Devices');

INSERT INTO user
(user_name, address, dob, exp_months, exp_years, gender, mobile, name, pan, password, role)
VALUES
('seller', 'seller adress', NULL, '12', '10', NULL, '8888888888888', 'seller', 'SellerPAN', '1234567', 'SELLER');

INSERT INTO user
(user_name, address, dob, exp_months, exp_years, gender, mobile, name, pan, password, role)
VALUES
('seller1', 'seller1 adress', NULL, '12', '10', NULL, '999999999999', 'seller1', 'SellerPAN1', '1234567', 'SELLER');

INSERT INTO items_sellers(items_item_name, sellers_user_name)
VALUES ('Iphone 8', 'seller');

INSERT INTO items_sellers(items_item_name, sellers_user_name)
VALUES ('Iphone 8', 'seller1');

INSERT INTO items_sellers(items_item_name, sellers_user_name)
VALUES ('Pixel XL', 'seller1');