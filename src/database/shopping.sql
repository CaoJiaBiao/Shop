# ����shopping���ݿ�Ϊ��ǰ���ݿ�
use shopping;
# ɾ��shopping���ݿ��е���ر��
drop table orders;
drop table cart;
drop table user;
drop table productInfo;
drop table productSort;

# ����productSort��
create table if not exists productSort
(id int primary key auto_increment,
sortName varchar(50) not null
);
# ����productInfo��
create table if not exists productInfo
(id int primary key auto_increment,
sortId int not null,
productName varchar(50) not null,
price float not null,
discount float not null,
inventory int not null,
discription varchar(500),
picture varchar(30) not null
);
# ����user��
create table if not exists user				# �����user�������򴴽�
(userID int primary key auto_increment,		# ����int�������������Զ�����
userName varchar(30) not null,				# �����ɱ䳤���ַ����͵��У���󳤶�Ϊ30������Ϊ��
passWord varchar(30) not null,				# �����ɱ䳤���ַ����͵��У���󳤶�Ϊ30������Ϊ��
sex varchar(4) not null default '��',		# Ĭ��ֵΪ'��'
age int,
telNum varchar(15),
e_Mail varchar(50) not null
);
# ����cart��
create table if not exists cart
(id int primary key auto_increment,
userId int not null,
productId int not null,
count int not null
);
# ����orders��
create table if not exists orders
(id int primary key auto_increment,
userId int not null,
productId int not null,
address varchar(50) not null,
telNum varchar(15),
e_Mail varchar(50) not null
);

# �������
alter table productInfo add constraint FK_productInfo_productSort foreign key(sortId) references productSort(id) on delete restrict on update restrict;
alter table cart add constraint FK_cart_user foreign key(userId) references user(userID) on delete restrict on update restrict;
alter table cart add constraint FK_cart_productInfo foreign key(productId) references productInfo(id) on delete restrict on update restrict;
alter table orders add constraint FK_order_productInfo foreign key(productId) references productInfo(id) on delete restrict on update restrict;
alter table orders add constraint FK_order_user foreign key(userId) references user(userID) on delete restrict on update restrict;

# ��productSort������¼
insert into productSort (sortName) values("��Ʒͼ��");
insert into productSort (sortName) values("�����Ʒ");
insert into productSort (sortName) values("�ճ���Ʒ");
insert into productSort (sortName) values("ʳƷ�ӻ�");
select * from productSort;

# ��productInfo��¼����
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(1, "JavaEE��ܼ�������ʽ�̳�", 39, 8.0, 40, "һ���ǳ�����Ľ̲�","commodity1.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "Nokia5310", 890, 9.0, 50, "�۸������������","commodity2.jpg");
# ��productInfo��¼����
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(1, "SQL Server", 29.5, 8.0, 30, "����","commodity3.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "����ϴ�·�", 19.5, 9.0, 300, "���˶�˵��", "commodity4.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(4, "�óԵ����", 2.5, 9.0, 200, "�ó���Ͷ�Ե�", "commodity5.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "����ϴ�ྫ", 3.5, 8.0, 150, "�����ֵ�����","commodity6.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "����A40�������", 559, 9.0, 10, "����ʵ��","commodity7.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "����ʼǱ�", 5999, 9.0, 10, "����׿Խ","commodity8.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(4, "���ܱ���", 3.5, 8.5, 660, "����һ�������","commodity9.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "��ܼ���ĭ����", 16.5, 8.0, 180, "�����������ܼҿ�ʼ","commodity10.jpg");

select * from productInfo;

# �Ա�productInfo�Լ�productSort�Ĳ���
delete from productInfo;
delete from productSort;
# ���ű����Ӳ�ѯ
select productName, sortName, price, discount, inventory, discription from productInfo,productSort where productInfo.sortId=productSort.id;

# ��user��¼������
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("������","123456","��",33,"13895251191","wxm@163.com");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("����","123","��",21,"13772507789","liyong@hotmail.com");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("�Ż�","zhanghui","��",25,"15052169987","zhanghui@sina.com.cn");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("����","wangpeng","��",37,"13598799619","wangpeng@yahoo.com.cn");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("�","lijing","Ů",27,"15152094389","lijing@163.com");
select * from user;

# ��cart��¼������
insert into cart(userId,productId,count)
values(1,2,2);
insert into cart(userId,productId,count)
values(2,4,1);
insert into cart(userId,productId,count)
values(2,6,3);
insert into cart(userId,productId,count)
values(3,9,2);
insert into cart(userId,productId,count)
values(4,5,1);
insert into cart(userId,productId,count)
values(3,4,2);
select * from cart;

delete from cart where userId=3 and productId=4;   

# ��ѯ���ﳵ����Ʒ����ϸ��Ϣ
select userName, productName, sortName, price, discount, discription
from user,productInfo,productSort,cart
where user.userID=cart.userId and productInfo.sortId=productSort.id and productInfo.id=cart.productId;
select * from user where userName='�Ż�';
select * from user where userID=1;

