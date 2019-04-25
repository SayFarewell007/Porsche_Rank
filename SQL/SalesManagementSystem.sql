/*���ݿ��ʼ��*/
create database If Not Exists salesmanagementsystem;

use salesmanagementsystem;
/*�û��������������Ա*/
create table If Not Exists users
(
	name varchar(10) primary key not null,
	password varchar(50) not null,
	isadmin boolean not null,/*�Ƿ������۾�������Ա��*/
	projectsnum int/*��ɵĶ�����*/
);
insert into users values("leon",MD5(111111),false,1);
insert into users values("admin",MD5("admin"),true,0);

/*�ͻ�*/
create table If Not Exists clients
(
	name varchar(10) primary key not null,
	phonenumber varchar(12),
	/*projectsnum int/*��ɵĶ�����*/*/
);
insert into clients values("tom","13811110000");
insert into clients values("jerry","13900001111");

/*��Ʒ*/
create table If Not Exists goods
(
	name varchar(10) primary key not null,
	number int not null,
	unitprice float not null
);
insert into goods values("Ǧ��",10000,2.5);
insert into goods values("�ʼǱ�����",2000,20000);

/*��Ŀ*/
create table If Not Exists projects
(
	id int(10) primary key NOT NULL AUTO_INCREMENT,
	name varchar(10) not null,
	staffname varchar(10) NOT NULL,
	clientname varchar(10) not null,
	goodsname varchar(10) not null,
	goodsnumber int not null,
	state varchar(10) not null,
	startdate date not null,
	enddate date,
	plan varchar(10000),
	
	FOREIGN KEY(staffname) REFERENCES users(name),
	FOREIGN KEY(clientname) REFERENCES clients(name),
	FOREIGN KEY(goodsname) REFERENCES goods(name)
);
insert into projects values(null,"���ڴ���","leon","tom","Ǧ��",2,"���µ�","2018-01-02",default,"��һ���ƻ��ǣ�������Ǯ��");

/*ָ�����*/
create table If Not Exists instructions
(
	id int(10) primary key NOT NULL AUTO_INCREMENT,
	staffname varchar(10) NOT NULL,
	managername varchar(10) NOT NULL,
	content varchar(1000) NOT NULL,
	
	FOREIGN KEY(staffname) REFERENCES users(name),
	FOREIGN KEY(managername) REFERENCES users(name)
);
insert into instructions values(null,"admin","leon","�úøɻ�");

/*ÿ�����۸�������*/
create table If Not Exists actionforday
(
	saledate date primary key NOT NULL,
	number int
);
insert into actionforday values("2018-01-02",2);