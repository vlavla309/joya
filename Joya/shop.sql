create user a IDENTIFIED BY a;
grant connect, resource, plustrace, alter session to a;


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

--users ���̺�
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


--categories ���̺�
create table categories(
category_name varchar2(30) not null,
parent varchar2(30)
);

--�������
ALTER TABLE categories
ADD (
CONSTRAINT category_name_pk PRIMARY KEY (category_name)
);


--products ���̺�
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




  
--boards ���̺�
create table boards(
board_id number(8) not null,
board_name varchar2(30) not null,
board_desc varchar2(500)
);

alter table boards
add ( constraint board_id_pk primary key(board_id));

create sequence boards_seq;




--articles ���̺�
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


--images ���̺�
create table images(
image_name varchar2(250) not null,
product_id number(8) not null,
path varchar2(300) not null,
order_no number default 0 
);

alter table images
add constraint image_name_pk primary key (image_name);

--orders ���̺�
create table orders(
order_id number(8) not null,
email varchar2(50) not null,
price number not null,
receiver varchar2(30) not null,
address varchar2(200) not null,
phone varchar2(20) not null,
status varchar2(30) not null,
payment_type varchar2(3) not null,
payment number,
payment_date date,
usedpoint number default 0,
card_no number,
approval_no number,
order_date date default SYSDATE
);

alter table orders
add (constraint orders_order_id_pk primary key (order_id),
CONSTRAINT orders_email_fk FOREIGN KEY(email) REFERENCES users(email),
CONSTRAINT orders_payment_type_ck   CHECK (payment_type in('�ſ�ī��', '�������Ա�', 'īī������', '�޴�������'))
);


create sequence orders_seq;

--orderitems ���̺�
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

--visitlog ���̺�
create table visitlog(
ip varchar2(20) not null, 
visitdate date not null
);

alter table visitlog
add constraint visitlog_pk primary key ( ip, visitdate); 

--wishlist ���̺�
create table wishlist(
product_id number(8) not null,
email varchar2(50) not null,
regdate date default SYSDATE
);

alter table wishlist
add constraint wishlist_pk primary key (product_id, email);







--����
--user
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, type, birthdate) values ('admin@joa', '010-010-010', '������', 'admin', '�̳��÷���1��',1, SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa1', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa2', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa3', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa4', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa5', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa6', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa7', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa8', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa9', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa10', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa11', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa12', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa13', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa14', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa15', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa16', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa17', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa18', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa19', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa20', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa21', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa22', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa23', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa24', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa25', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa26', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa27', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa28', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa29', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa30', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa31', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa32', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa33', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa34', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa35', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa36', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa37', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa38', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa39', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa40', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa41', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa42', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa43', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa44', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa45', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa46', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa47', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa48', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa49', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa50', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa51', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa52', '010-010-010', '������', 'joa', '�̳��÷���1��', SYSDATE);


commit;
--ī�װ�
insert into categories (category_name, parent) values ('����', null);
insert into categories (category_name, parent) values ('������', '����');
insert into categories (category_name, parent) values ('��������', '����');
insert into categories (category_name, parent) values ('�����', null);




--��ǰ
insert into products values(1,'������', '����A', '�̴ϰ��', '��� �ſ� ���', SYSDATE, 500, 100, 0);
insert into products values(2,'������', '����B', '�̴ϰ��', '�� �ſ� ��', SYSDATE, 1500, 1100, 100);
insert into products values(3,'��������', '����C', '�̴ϰ��', '�̻� �ſ� �̻�', SYSDATE, 11500, 100, 20);
insert into products values(4,'�����', '�����A', '�̴ϰ��', '�̻� �ſ� �̻�', SYSDATE, 110500, 100, 20);
insert into products values(5,'�����', '�����B', '��������', '��� �ſ� ���', SYSDATE, 5010500, 100, 20);
insert into products values(6,'�����', '�����C', '�̴ϰ��', '�� �ſ� ��', SYSDATE, 1500, 100, 20);

--���ӱ�� visitlog
insert into visitlog values('210.231.231.50', SYSDATE);
commit

-- �̹������
--IMAGE TABLE DUMMY DATA INSERT
INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('esmall.jpg', 1, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('4_large.png', 1, '/shopimg/', 3);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('3_large.png', 1, '/shopimg/', 2);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('1qqw.jp', 1, '/shopimg/', 1);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('ring.jpg', 2, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('Sgrande.jpg', 3, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('hihi.jpg', 4, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('zzzz.jpg', 5, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('grande.jpg', 6, '/shopimg/', 0);
commit;
