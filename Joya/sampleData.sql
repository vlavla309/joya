--샘플
-- 게시판 생성
insert into boards(board_id, board_name, board_desc)
VALUES (1, '공지사항', '쇼핑몰과 관련된 공지사항을 올리는 게시판입니다.');

INSERT INTO boards(board_id, board_name, board_desc)
VALUES (2, 'QnA', '쇼핑몰을 이용과 관련된 문의 내용을 올려주세요.');

INSERT INTO boards(board_id, board_name, board_desc)
VALUES (3, '상품평', '주문하신 상품에 대한 의견을 올려주세요.');

INSERT INTO boards(board_id, board_name, board_desc)
VALUES (4, 'A/S', '주문하신 상품의 A/S 신청 게시판입니다.');

--user
insert into users(email, phone, name, passwd, address, birthdate) values ('anonymous@joa.com', '010-1010-1010', 'anonymous', 'anonymous', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate, point) values ('joa@joa.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE, 50000);
insert into users(email, phone, name, passwd, address, type, birthdate) values ('admin@joa.com', '010-1010-1010', '관리자', 'admin', '서울 가산###이노플렉스1차###201',1, SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa1.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa2.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa3.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa4.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa5.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa6.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa7.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa8.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa9.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa10.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa11.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa12.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa13.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa14.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa15.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa16.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa17.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa18.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa19.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa20.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa21.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa22.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa23.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa24.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa25.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa26.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa27.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa28.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);
insert into users(email, phone, name, passwd, address, birthdate) values ('joa@joa29.com', '010-1010-1010', '조아조', 'joajoa', '서울 가산###이노플렉스1차###201', SYSDATE);


commit;
--카테고리
insert into categories (category_name, parent) values ('반지', null);
insert into categories (category_name, parent) values ('웨딩링', '반지');
insert into categories (category_name, parent) values ('남성반지', '반지');
insert into categories (category_name, parent) values ('목걸이', null);
insert into categories (category_name, parent) values ('싱글링', '반지');
insert into categories (category_name, parent) values ('커플링', '반지');
insert into categories (category_name, parent) values ('여성반지', '반지');
insert into categories (category_name, parent) values ('귀걸이', null);
insert into categories (category_name, parent) values ('팔찌', null);




--상품
insert into products values(1,'웨딩링', '반지A', '미니골드', '비쌈 매우 비쌈', SYSDATE, 500, 100, 0);
insert into products values(2,'웨딩링', '반지B', '미니골드', '쌈 매우 쌈', SYSDATE, 1500, 1100, 100);
insert into products values(3,'남성반지', '반지C', '미니골드', '이쁨 매우 이쁨', SYSDATE, 11500, 100, 20);

--접속기록 visitlog
insert into visitlog values('210.231.231.50', SYSDATE);
commit

--wishlist
insert into wishlist(email, product_id) values ('joa@joa.com', 6);


--product

--상품 추가
insert into products values(7,'목걸이', '모던 목걸이', '미니골드', '드럽게 쌈', SYSDATE, 149000, 100, 0);
insert into products values(8,'목걸이', '스윙스톤 목걸이', '미니골드', '비싸요', SYSDATE, 159000, 100, 0);
insert into products values(9,'목걸이', '미니모 목걸이', '미니골드', '비쌈 짱 비쌈', SYSDATE, 139000, 100, 0);
insert into products values(10,'목걸이', '센스라운드 목걸이', '미니골드', '짱 쌈', SYSDATE, 139000, 200, 0);
insert into products values(11,'목걸이', '빅토르 목걸이', '미니골드', '이쁨 매우 쌈', SYSDATE, 139000, 100, 0);
insert into products values(12,'목걸이', '샤이닝 목걸이', '미니골드', '쌈', SYSDATE, 159000, 100, 0);
insert into products values(13,'목걸이', '블루밍루나 목걸이', '미니골드', '쌈', SYSDATE, 149000, 100, 0);
insert into products values(14,'목걸이', '밀키웨이 목걸이', '미니골드', '비쌈', SYSDATE, 169000, 100, 0);
insert into products values(15,'목걸이', '유즐리 목걸이', '미니골드', '이쁘고 쌈', SYSDATE, 129000, 100, 0);
insert into products values(16,'목걸이', '레인드롭 목걸이', '미니골드', '이쁨 매우 비쌈', SYSDATE, 199000, 100, 0);
insert into products values(17,'목걸이', '키스미 목걸이', '미니골드', '비쌈 짱 비쌈', SYSDATE, 219000, 100, 0);
insert into products values(18,'싱글링', '레이닝 미스링', '미니골드', '쌈', SYSDATE, 109000, 100, 40);
insert into products values(19,'싱글링', '레인라인 미스링', '미니골드', '비쌈', SYSDATE, 99800, 100, 0);
insert into products values(20,'싱글링', '메이븐 반지', '미니골드', '비쌈', SYSDATE, 549000, 100, 0);
insert into products values(21,'싱글링', '보르도 반지', '미니골드', '비쌈', SYSDATE, 649000, 100, 10);
insert into products values(22,'싱글링', '보니타 반지', '미니골드', '쌈', SYSDATE, 429000, 100, 70);
insert into products values(23,'싱글링', '라비타 반지', '미니골드', '쌈', SYSDATE, 419000, 100, 10);
insert into products values(24,'싱글링', '레이닝 미스링', '미니골드', '쌈', SYSDATE, 109000, 100, 40);
insert into products values(25,'커플링', '빅네이브 커플링(남)', '미니골드', '쌈', SYSDATE, 499000, 100, 10);
insert into products values(26,'커플링', '빅네이브 커플링(여)', '미니골드', '쌈', SYSDATE, 389000, 100, 20);
insert into products values(27,'커플링', '리버풀 커플링(남)', '미니골드', '쌈', SYSDATE, 219000, 100, 40);
insert into products values(28,'커플링', '리버풀 커플링(여)', '미니골드', '쌈', SYSDATE, 199000, 100, 30);
insert into products values(29,'커플링', '샤이닝러브 커플링(남)', '미니골드', '쌈', SYSDATE, 149000, 100, 70);
insert into products values(30,'커플링', '샤이닝러브 커플링(여)', '미니골드', '쌈', SYSDATE, 129000, 100, 40);
insert into products values(31,'귀걸이', '트롱 귀걸이', '미니골드', '비쌈', SYSDATE, 20800, 100, 60);
insert into products values(32,'귀걸이', '스노우벨로 귀걸이', '미니골드', '비쌈', SYSDATE, 27800, 100, 50);
insert into products values(33,'귀걸이', '큐큐 귀걸이', '미니골드', '비쌈', SYSDATE, 29800, 100, 70);
insert into products values(34,'귀걸이', '쓰리큐 귀걸이', '미니골드', '비쌈', SYSDATE, 29800, 100, 10);
insert into products values(35,'귀걸이', '레이스 귀걸이', '미니골드', '비쌈', SYSDATE, 25800, 100, 60);
insert into products values(36,'귀걸이', '리얼별 귀걸이', '미니골드', '매우쌈', SYSDATE, 15800, 100, 60);
insert into products values(37,'귀걸이', '데일락 귀걸이', '미니골드', '비쌈', SYSDATE, 89800, 100, 6);
insert into products values(38,'귀걸이', '로즈리 귀걸이', '미니골드', '비쌈', SYSDATE, 119000, 100, 10);
insert into products values(39,'팔찌', '쓰리핏 팔찌', '스톤헨지', '매우 쌈', SYSDATE, 55860, 100, 40);
insert into products values(40,'팔찌', '글램할로우 팔찌', '스톤헨지', '비쌈', SYSDATE, 10860, 100, 50);
insert into products values(41,'팔찌', '댄디 팔찌', '로이드', '비쌈', SYSDATE, 73400, 100, 10);

DROP SEQUENCE products_seq;

CREATE  SEQUENCE products_seq
      START WITH 42;



--상품 이미지 추가
INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck1.jpg', 7, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck1_2.jpg', 7, '/shopimg/', 1);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck1_3.jpg', 7, '/shopimg/', 2);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck2.jpg', 8, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck3.jpg', 9, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck4.jpg', 10, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck5.jpg', 11, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck6.jpg', 12, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck7.jpg', 13, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck8.jpg', 14, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck9.jpg', 15, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck10.jpg', 16, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('neck11.jpg', 17, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering1.jpg', 18, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering1_2.JPG', 18, '/shopimg/', 1);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering2.jpg', 19, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering3.jpg', 20, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering4.jpg', 21, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering5.jpg', 22, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering6.jpg', 23, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('singlering7.jpg', 24, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple1m.jpg', 25, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple1w.jpg', 26, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple2m.jpg', 27, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple2w.jpg', 28, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple3m.jpg', 29, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('couple4w.jpg', 30, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringA.jpg', 31, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringB.jpg', 32, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringC.jpg', 33, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringD.jpg', 34, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringE.jpg', 35, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringF.jpg', 36, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringG.jpg', 37, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('earringH.jpg', 38, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('bracelet1.jpg', 39, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('bracelet2.jpg', 40, '/shopimg/', 0);

INSERT INTO images (IMAGE_NAME, PRODUCT_ID, PATH, ORDER_NO)
VALUES ('bracelet3.jpg', 41, '/shopimg/', 0);


insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 10000,'나주문' ,'김진수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 10000, '2016-10-10', 101010102, 2032010, '2016-10-10');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 10000,'나주문' , '김갑수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 10000, '2016-10-10', 201023102, 2033210, '2016-09-10');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 20000,'나주문' , '박진수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 20000, '2016-08-10', 401010102, 3032010, '2016-08-01');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 40000,'나주문' , '김진수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '카카오페이', 40000, '2016-07-12', 091010102, 5032010, '2016-07-11');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 30000,'나주문' , '한상수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 30000, '2016-06-22', 291010102, 2032010, '2016-06-21');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 50000,'나주문' , '김진수', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 50000, '2016-06-22', 301010102, 2032010, '2016-06-21');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 600000,'나주문' , '홍길동', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 600000, '2016-05-15', 991010102, 2032010, '2016-05-15');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 600000,'나주문' , '이수진', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 600000, '2016-04-13', 891010102, 2032010, '2016-04-12');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 80000,'나주문' , '한동근', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 80000, '2016-04-13', 661010102, 6632010, '2016-04-12');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 200000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 200000, '2016-03-10', 761010102, 7632010, '2016-03-10');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 5000000,'나주문' , '나부자', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '신용카드', 5000000, '2016-02-26', 881033102, 8232010, '2016-02-26');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 10000000,'나주문' , '나부자', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 10000000, '2016-01-24', 891010102, 2332010, '2016-01-24');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 10000000,'나주문' , '나부자', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 10000000, '2016-01-14', 871010102, 8832010, '2016-01-14');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 7000000,'나주문' , '나부자', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 7000000, '2016-02-25', 871010102, 8832010, '2016-02-24');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 90000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '무통장입금', 90000, '2016-03-17', 871010102, 8832010, '2016-03-17');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 100000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '무통장입금', 100000, '2016-04-27', 871010102, 8832010, '2016-04-27');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 20000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '무통장입금', 20000, '2016-05-18', 871010102, 8832010, '2016-05-15');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 50000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 50000, '2016-06-11', 871010102, 8832010, '2016-06-11');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 500000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 500000, '2016-07-21', 871010102, 8832010, '2016-07-21');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 3000000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '신용카드', 3000000, '2016-08-22', 871010102, 8832010, '2016-08-22');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 700000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 700000, '2016-09-30', 871010102, 8832010, '2016-09-30');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 900000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '카카오페이', 900000, '2016-10-05', 871010102, 8832010, '2016-10-05');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 6000000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 6000000, '2016-11-11', 871010102, 8832010, '2016-11-11');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 60000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 60000, '2016-12-11', 871010102, 8832010, '2016-12-11');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 20000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 20000, '2016-12-16', 871010102, 8832010, '2016-12-16');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 440000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 440000, '2016-11-18', 871010102, 8832010, '2016-11-18');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 540000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '주문접수', '카카오페이', 540000, '2016-01-18', 871010102, 8832010, '2016-01-18');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 2540000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '카카오페이', 2540000, '2016-02-18', 871010102, 8832010, '2016-02-18');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 140000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 140000, '2016-03-18', 871010102, 8832010, '2016-03-18');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 240000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '휴대폰결제', 240000, '2016-04-13', 871010102, 8832010, '2016-04-13');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 340000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '무통장입금', 340000, '2016-05-13', 871010102, 8832010, '2016-05-13');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 90000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '무통장입금', 90000, '2016-06-13', 871010102, 8832010, '2016-06-13');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 100000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 100000, '2016-07-20', 871010102, 8832010, '2016-07-20');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 300000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 300000, '2016-08-10', 871010102, 8832010, '2016-08-10');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 3000000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 3000000, '2016-09-19', 871010102, 8832010, '2016-09-19');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 90000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 90000, '2016-10-19', 871010102, 8832010, '2016-10-19');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 356000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '신용카드', 356000, '2016-11-19', 871010102, 8832010, '2016-11-19');
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 8000000,'나주문' , '한개만', '05020###서울시 강남구###101', '010-2222-3333', '결제완료', '카카오페이', 8000000, '2016-12-25', 871010102, 8832010, '2016-12-25');

--orders jjh
insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 160000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 160000, '2017-01-10', 101010102, 2032010, '2016-01-10');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 70000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 70000, '2017-01-15', 101010102, 2032010, '2016-01-15');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 56800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 56800, '2017-01-24', 101010102, 2032010, '2016-01-24');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 49800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 49800, '2017-01-30', 101010102, 2032010, '2016-01-30');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 40000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 40000, '2017-02-04', 101010102, 2032010, '2016-02-04');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 80000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 80000, '2017-02-27', 101010102, 2032010, '2016-02-27');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 62000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 62000, '2017-02-28', 101010102, 2032010, '2016-02-28');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 34000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 34000, '2017-03-06', 101010102, 2032010, '2016-03-06');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 50000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 50000, '2017-03-10', 101010102, 2032010, '2016-03-10');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 80000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 80000, '2017-03-16', 101010102, 2032010, '2016-03-16');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 16000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 16000, '2017-03-28', 101010102, 2032010, '2016-03-28');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 90000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 90000, '2017-03-31', 101010102, 2032010, '2016-03-31');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 20000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 20000, '2017-04-10', 101010102, 2032010, '2016-04-10');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 34000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 34000, '2017-04-14', 101010102, 2032010, '2016-04-14');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 70000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 70000, '2017-04-23', 101010102, 2032010, '2016-04-23');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 60000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 60000, '2017-04-28', 101010102, 2032010, '2016-04-28');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 60800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 60800, '2017-05-01', 101010102, 2032010, '2016-05-01');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 64800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 64800, '2017-05-08', 101010102, 2032010, '2016-05-08');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 27000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 27000, '2017-05-17', 101010102, 2032010, '2016-05-17');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 240000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 240000, '2017-05-29', 101010102, 2032010, '2016-05-29');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 70000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 70000, '2017-06-03', 101010102, 2032010, '2016-06-03');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 24700, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 24700, '2017-06-16', 101010102, 2032010, '2016-06-16');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 14800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 14800, '2017-06-27', 101010102, 2032010, '2016-06-27');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 41500, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 41500, '2017-07-17', 101010102, 2032010, '2016-07-17');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 89600, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 89600, '2017-07-20', 101010102, 2032010, '2016-07-20');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 17800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 17800, '2017-07-26', 101010102, 2032010, '2016-07-26');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 45600, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 45600, '2017-08-04', 101010102, 2032010, '2016-08-04');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 170000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 170000, '2017-08-27', 101010102, 2032010, '2016-08-27');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 98000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 98000, '2017-09-14', 101010102, 2032010, '2016-09-14');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 146000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 146000, '2017-09-21', 101010102, 2032010, '2016-09-21');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 34000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 34000, '2017-09-30', 101010102, 2032010, '2016-09-30');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 15600, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 15600, '2017-10-09', 101010102, 2032010, '2016-10-09');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 34700, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 34700, '2017-10-28', 101010102, 2032010, '2016-10-28');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 47800, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 47800, '2017-11-03', 101010102, 2032010, '2016-11-03');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 74600, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 74600, '2017-11-19', 101010102, 2032010, '2016-11-19');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 50000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 50000, '2017-11-25', 101010102, 2032010, '2016-11-25');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 73250, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 73250, '2017-12-11', 101010102, 2032010, '2016-12-11');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 13000, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 13000, '2017-12-17', 101010102, 2032010, '2016-12-17');

insert into orders(order_id, email, price, orderer, receiver, address, phone, status, payment_type, payment, payment_date, card_no, approval_no, order_date)
values(orders_seq.nextval, 'joa@joa.com', 48300, '황민현', '김만이', '21313###인천광역시 부평구###401', '010-1111-1111', '결제완료', '신용카드', 48300, '2017-12-26', 101010102, 2032010, '2016-12-26');

commit;