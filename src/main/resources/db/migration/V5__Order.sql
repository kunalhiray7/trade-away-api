CREATE TABLE item_order (
order_id VARCHAR(255) PRIMARY KEY ,
seller_id  VARCHAR(255),
buyer_id VARCHAR(255),
quantity int not null,
item_name varchar(255) NOT NULL,
delivery_address VARCHAR(255) not NULL,
order_time TIMESTAMP,
CONSTRAINT fk_order_seller FOREIGN KEY (seller_id) REFERENCES user (user_name),
CONSTRAINT fk_order_buyer FOREIGN KEY (buyer_id) REFERENCES user (user_name),
CONSTRAINT fk_order_item FOREIGN KEY (item_name) REFERENCES items (item_name)
);