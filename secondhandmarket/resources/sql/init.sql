DROP DATABASE IF EXISTS DB_SECOND_HAND_MARKET;
CREATE DATABASE DB_SECOND_HAND_MARKET;
USE DB_SECOND_HAND_MARKET;

#用户表
DROP TABLE IF EXISTS T_USER;
CREATE TABLE T_USER(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL DEFAULT '' UNIQUE,
    password VARCHAR(20) NOT NULL DEFAULT '',
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP COMMENT '数据更新时间'
)ENGINE=InnoDB CHARSET=utf8;

#商品表
DROP TABLE IF EXISTS T_PRODUCT;
CREATE TABLE T_PRODUCT(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_number VARCHAR(50) NOT NULL DEFAULT '' UNIQUE, #系统生成的商品编号
    name VARCHAR(50) NOT NULL DEFAULT '',
    description TEXT,
    image VARCHAR(100) DEFAULT '',
    depreciation_rate FLOAT NOT NULL DEFAULT '', #折旧率
    quantity INT NOT NULL DEFAULT 1,
    price FLOAT NOT NULL DEFAULT 0,
    is_sold TINYINT NOT NULL DEFAULT 0,
    type_code CHAR(4) NOT NULL DEFAULT '',
    sale_way_code CHAR(4) NOT NULL DEFAULT '',
    time_limit int COMMENT '竞价时间期限',   #竞价时间期限
    add_price_limit int DEFAULT NULL COMMENT '加价幅度',
    user_id INT NOT NULL DEFAULT 0,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP COMMENT '数据更新时间'
)ENGINE=InnoDB CHARSET=utf8;

#商品类别表
DROP TABLE IF EXISTS T_PRODUCT_TYPE;
CREATE TABLE T_PRODUCT_TYPE(
    prod_type_id INT PRIMARY KEY AUTO_INCREMENT,
    code CHAR(4) NOT NULL DEFAULT '' UNIQUE,   #商品类别编码
    name VARCHAR(20) NOT NULL DEFAULT '',
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

#出售形式表
DROP TABLE IF EXISTS T_SALE_WAY;
CREATE TABLE T_SALE_WAY(
    sale_way_id INT PRIMARY KEY AUTO_INCREMENT,
    code CHAR(4) NOT NULL DEFAULT '' UNIQUE,
    name VARCHAR(20) NOT NULL DEFAULT '',
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

#竞价记录表
DROP TABLE IF EXISTS T_BIDDING_RECORD;
CREATE TABLE T_BIDDING_RECORD(
    bidding_record_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL DEFAULT 0,
    bidding_price FLOAT NOT NULL DEFAULT 0,
    description VARCHAR(100),
    user_id INT NOT NULL DEFAULT 0,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

#议价记录表
DROP TABLE IF EXISTS T_BARGAINING_RECORD;
CREATE TABLE T_BARGAINING_RECORD(
    bargaining_record_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL DEFAULT 0,
    bargaining_price FLOAT NOT NULL DEFAULT 0,
    description VARCHAR(100),
    user_id INT NOT NULL DEFAULT 0,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)ENGINE=InnoDB CHARSET=utf8;

#订单表
DROP TABLE IF EXISTS T_ORDER;
CREATE TABLE T_ORDER(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    order_number VARCHAR(50) NOT NULL DEFAULT '' UNIQUE,
    deal_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    product_id INT NOT NULL DEFAULT 0,
    buy_user_id INT NOT NULL DEFAULT 0,   
    sale_user_id INT NOT NULL DEFAULT 0,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP COMMENT '数据更新时间'
)ENGINE=InnoDB CHARSET=utf8;

#求购信息表
DROP TABLE IF EXISTS T_DEMAND_INFO;
CREATE TABLE T_DEMAND_INFO(
    demand_info_id INT PRIMARY KEY AUTO_INCREMENT,
    demand_info_number varchar(50) NOT NULL DEFAULT '',
    name VARCHAR(50) NOT NULL DEFAULT '',
    type_code CHAR(4) NOT NULL DEFAULT 0,
    depreciation_rate DOUBLE,
    quantity INT,
    price FLOAT,
    other VARCHAR(50),
    user_id INT NOT NULL DEFAULT 0,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP COMMENT '数据更新时间'
)ENGINE=InnoDB CHARSET=utf8;


INSERT INTO T_SALE_WAY(code, name, create_date) VALUES('BIDD', '竞价', CURRENT_TIMESTAMP);
INSERT INTO T_SALE_WAY(code, name, create_date) VALUES('BARG', '议价', CURRENT_TIMESTAMP);
INSERT INTO T_SALE_WAY(code, name, create_date) VALUES('BOUT', '一口价', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('FURN', '家具', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('ELAP', '电器', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('DGTL', '数码', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('TSPT', '交通工具', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('HDWR', '五金器具', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('DCRT', '装饰摆件', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('CLTB', '服饰包具', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('TCKT', '点券', CURRENT_TIMESTAMP);
INSERT INTO T_PRODUCT_TYPE(code, name, create_date) VALUES('DGTP', '数字商品', CURRENT_TIMESTAMP);

