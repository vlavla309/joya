drop table wishlist;
drop table visitlog;
drop table orderitems;
drop table orders;
drop table articles;
drop table boards;
drop table images;
drop table products;
drop table categories;
drop table users;


drop sequence articles_seq;
drop sequence boards_seq;
drop sequence products_seq;
drop sequence orders_seq;

--users 테이블
create table users(
email varchar2(50) not null,
phone varchar2(20) not null,
name varchar2(30) not null,
passwd varchar2(20) not null,
address varchar2(200) not null,
point number default 0,
birthdate date,
type number default 0,
regdate date default SYSDATE
);



alter table users
add constraint email_id_pk primary key (email);


--categories 테이블
create table categories(
category_name varchar2(30) not null,
parent varchar2(30)
);

--제약사항
ALTER TABLE categories
ADD (
CONSTRAINT category_name_pk PRIMARY KEY (category_name)
);


--products 테이블
create table products(
product_id number(8) not null,
category_name varchar2(30),
product_name varchar2(100) not null,
maker varchar2(100) not null,
product_desc varchar2(1000) not null,
regdate date default SYSDATE,
price number not null,
amount number,
hitcount number default 0
);
 

alter table products
add(
constraint product_id_pk primary key(product_id),
constraint category_name_fk foreign key (category_name) references categories(category_name)
);

create sequence products_seq;




  
--boards 테이블
create table boards(
board_id number(8) not null,
board_name varchar2(30) not null,
board_desc varchar2(500)
);

alter table boards
add ( constraint board_id_pk primary key(board_id));

create sequence boards_seq;




--articles 테이블
create table articles(
article_id number(8) not null,
email varchar2(50) not null,
board_id number(8) not null,
title varchar2(80) not null,
contents varchar2(1000) not null,
writer varchar2(30) not  null,
regdate date default SYSDATE,
passwd varchar2(20) not null,
group_no number not null,
type number not null, 
hitcount number default 0, 
file_path varchar2(250),
product_id number,
rating number
);

ALTER TABLE articles
  ADD(CONSTRAINT articles_article_id_pk    PRIMARY KEY(article_id),
      CONSTRAINT articles_email_fk FOREIGN KEY(email) REFERENCES users(email),
      CONSTRAINT articles_board_id_fk FOREIGN KEY(board_id) REFERENCES boards(board_id),
      CONSTRAINT articles_payment_type_ck   CHECK (type in(0,1))
      );
      
create sequence articles_seq;


--images 테이블
create table images(
image_name varchar2(250) not null,
product_id number(8) not null,
path varchar2(300) not null,
order_no number default 0 
);
    
alter table images
add constraint image_name_pk primary key (image_name);

--orders 테이블
create table orders(
order_id number(8) not null,
email varchar2(50) not null,
price number not null,
orderer varchar2(30) not null,
receiver varchar2(30) not null,
address varchar2(200) not null,
phone varchar2(20) not null,
status varchar2(30) not null,
payment_type varchar2(30) not null,
payment number,
payment_date date,
usedpoint number default 0,
card_no number,
approval_no number,
order_date date default SYSDATE,
message VARCHAR2(200),
gst_email varchar2(50)
);

alter table orders
add (constraint orders_order_id_pk primary key (order_id),
CONSTRAINT orders_email_fk FOREIGN KEY(email) REFERENCES users(email),
CONSTRAINT orders_payment_type_ck   CHECK (payment_type in('신용카드', '무통장입금', '카카오페이', '휴대폰결제')),
CONSTRAINT orders_status_ck   CHECK (status in('주문접수', '결제완료', '주문취소', '배송중', '배송완료'))
);


create sequence orders_seq;

--orderitems 테이블
create table orderitems(
product_id number(8) not null,
order_id number(8) not null,
amount number not null
);

alter table orderitems
add(
constraint orderitems_product_id_fk foreign key(product_id) references products(product_id),
constraint orderitems_order_id_fk foreign key(order_id) references orders(order_id),
constraint orderitems_orderitems_pk primary key (product_id, order_id)
);

--visitlog 테이블
create table visitlog(
ip varchar2(20) not null, 
visitdate date not null
);

alter table visitlog
add constraint visitlog_pk primary key ( ip, visitdate); 

--wishlist 테이블
create table wishlist(
product_id number(8) not null,
email varchar2(50) not null,
regdate date default SYSDATE
);

alter table wishlist
add constraint wishlist_pk primary key (product_id, email);

