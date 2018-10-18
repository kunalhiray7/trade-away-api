CREATE TABLE user (
 user_name varchar(255) NOT NULL,
 address varchar(255) DEFAULT NULL,
 dob tinyblob,
 exp_months int(11) DEFAULT NULL,
 exp_years int(11) DEFAULT NULL,
 gender varchar(255) DEFAULT NULL,
 mobile bigint(20) DEFAULT NULL,
 name varchar(255) DEFAULT NULL,
 pan varchar(255) DEFAULT NULL,
 password varchar(255) DEFAULT NULL,
 role varchar(255) DEFAULT NULL,
 PRIMARY KEY (user_name)
);