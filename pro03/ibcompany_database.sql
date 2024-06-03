create database ib;
use ib;

-- sample 테이블 생성
create table sample (num int, title varchar(50), res datetime default current_timestamp);
select * from sample;

-- sample 테이블 더미데이터
insert into sample values (1, '샘플1', default);
insert into sample values (2, '샘플2', default);
insert into sample values (3, '샘플3', default);
insert into sample values (4, '샘플4', default);


-- member 테이블 생성
create table member(id varchar(20) primary key, pw varchar(300) not null, name varchar(100) not null,
email varchar(200), tel varchar(100), addr1 varchar(200), addr2 varchar(200), 
postcode varchar(20), point int default 1000,
resdate datetime default current_timestamp);
select * from member;
desc member;

-- member 테이블 더미데이터
insert into member values('test1', '1234', '테스트계정', 'test@naver.com','010-0123-1234', '강서구화곡동', '원주민', '12345', default, default);


-- board 테이블 생성
create table board(bno int auto_increment primary key, 
title varchar(200), content varchar(2000), author varchar(20) default 'admin', vcnt int default 0,
resdate datetime default current_timestamp);
select * from board;

-- board 테이블 더미데이터
insert into board(title, content) values ('더미글 제목1', '더미글 내용1 입니다.');
insert into board(title, content) values ('더미글 제목2', '더미글 내용2 입니다.');
insert into board(title, content) values ('더미글 제목3', '더미글 내용3 입니다.');
insert into board(title, content) values ('더미글 제목4', '더미글 내용4 입니다.');


-- free 테이블 생성
create table free(no int auto_increment primary key, title varchar(200),
content varchar(1000), hits int default 0, resdate datetime default current_timestamp,
id varchar(20), name varchar(100));
select * from free;

alter table free add constraint fk_memfree foreign key (id) references member(id);

create view ckboard as(select f.no as no, f.title as title, f.content as content, f.hits as hits, 
f.resdate as resdate, m.id as id, m.name as name from free f,member m where f.id=m.id);
select * from ckboard;


-- qna 테이블 생성
create table qna(no int auto_increment primary key, title varchar(200),
content varchar(1000), lev int, parno int,
hits int default 0, resdate datetime default current_timestamp,
id varchar(20), name varchar(100));
select * from qna;
desc qna;

alter table qna add constraint fk_mem0 foreign key (id) references member(id);

-- fileboard 테이블 생성
create table fileboard(no int auto_increment primary key, title varchar(200),
content varchar(1000), url varchar(300),
hits int default 0, resdate datetime default current_timestamp,
author varchar(20));
select * from fileboard;

-- review 테이블 생성
create table review(rno int auto_increment primary key,
pno int,
id varchar(20),
content varchar(2000),
img varchar(300),
resdate datetime default current_timestamp,
star int,
foreign key(pno) references product(pno),
foreign key(id) references member(id));


-- select pno, ROUND(AVG(star),1) as avgstar from review where pno=#{pno} group by pno;


-- product 테이블 생성
create table product(pno int auto_increment primary key, 
category varchar(20) not null, pname varchar(100) not null,
com varchar(1000), price int default 1000, img varchar(300), img2 varchar(300), star float);
select * from product;

alter table product add img2 varchar(300);

-- product 테이블 더미데이터 생성
insert into product values(default, 'snack', 'THE 빠새 청양마요맛', 'haitai', 1500, 'snack01_list.png', 'snack01.png');
insert into product values(default, 'candy', '연양갱 고구마', 'haitai', 1200, 'candy01_list.png', 'candy01.png');
insert into product values(default, 'choco', '프로틴 너티 클러스터', 'haitai', 1800, 'choco01_list.png', 'choco01.png');
insert into product values(default, 'choco', '프로틴 너티 클러스터 초코', 'haitai', 2000, 'choco02_list.png', 'choco02.png');


-- productvo view 생성
create view productvo as (select p.pno as pno, p.category as category, 
p.pname as pname, p.com as com, p.img as img, p.img2 as img2,
avg(i.inprice) as inprice, max(i.outprice) as outprice,
sum(i.amount) as amount from product p, inventory i 
where p.pno=i.pno
group by p.pno); 
select * from productvo;


-- inventory 테이블 생성
create table inventory(ino int auto_increment primary key,
pno int, inprice int default 1000, outprice int default 1000,
amount int default 1, remark varchar(200), resdate datetime default current_timestamp,
foreign key(pno) references product(pno));
select * from inventory;

-- inventory 테이블 더미데이터
insert into inventory values(default, 10, 1000, 1100, 130, "여긴뭐쓰는겨", default);
insert into inventory values(default, 12, 1300, 1500, 82, "이건머임", default);

-- inventoryvo view 생성
create view inventoryvo as (select i.ino as ino, i.pno as pno, p.pname as pname, 
avg(i.inprice) as inprice, 
max(i.outprice) as outprice, sum(i.amount) as amount, 
i.remark as remark, max(i.resdate) as resdate 
from inventory i, product p where i.pno=p.pno group by i.ino, i.pno, p.pname,i.remark);
select * from inventoryvo where pno=11;


-- sales 테이블 생성
create table sales(sno int auto_increment primary key,
pno int, amount int default 1, tot int, id varchar(20),
paymethod varchar(20), paynum varchar(30),
addr varchar(300), tel varchar(100), 
delcom varchar(50), deltel varchar(50),
delno varchar(50), delstatus varchar(20),
st varchar(20), resdate datetime default current_timestamp);
select * from sales;

alter table sales add constraint fk_mem1 foreign key (id) references member(id);
alter table sales add constraint fk_pro1 foreign key (pno) references member(pno);
alter table sales add resdate datetime default current_timestamp;


-- basket 테이블 생성
create table basket(bno int auto_increment primary key,
id varchar(20), pno int, amount int, remark varchar(100), resdate datetime default current_timestamp);
select * from basket;
desc basket;

alter table basket add constraint fk_mem2 foreign key (id) references member(id);
alter table basket add constraint fk_pro2 foreign key (pno) references product(pno); 
alter table basket add resdate datetime default current_timestamp;






