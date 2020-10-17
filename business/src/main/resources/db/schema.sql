create table if not exists CATEGORY(
ID int primary key auto_increment,
CATEGORY_NAME VARCHAR(100));

create table if not exists PRODUCT(
ID int primary key auto_increment,
PRODUCT_NAME VARCHAR(100),
CATEGORY_ID int,
FOREIGN KEY(CATEGORY_ID) REFERENCES CATEGORY(ID)
);

create table if not exists PURCHASED(
ID int primary key auto_increment,
purchased_quantity int,
purchased_price float,
purchased_date date,
product_id int,
FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID)
);

create table if not exists sold(
ID int primary key auto_increment,
sold_quantity int,
sold_price float,
sold_date date,
product_id int,
FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID)
);

commit;

