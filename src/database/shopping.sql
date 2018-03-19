# 设置shopping数据库为当前数据库
use shopping;
# 删除shopping数据库中的相关表格
drop table orders;
drop table cart;
drop table user;
drop table productInfo;
drop table productSort;

# 构建productSort表
create table if not exists productSort
(id int primary key auto_increment,
sortName varchar(50) not null
);
# 生成productInfo表
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
# 创建user表
create table if not exists user				# 如果表user不存在则创建
(userID int primary key auto_increment,		# 创建int类型主键，且自动增长
userName varchar(30) not null,				# 创建可变长度字符类型的列，最大长度为30，不许为空
passWord varchar(30) not null,				# 创建可变长度字符类型的列，最大长度为30，不许为空
sex varchar(4) not null default '男',		# 默认值为'男'
age int,
telNum varchar(15),
e_Mail varchar(50) not null
);
# 创建cart表
create table if not exists cart
(id int primary key auto_increment,
userId int not null,
productId int not null,
count int not null
);
# 创建orders表
create table if not exists orders
(id int primary key auto_increment,
userId int not null,
productId int not null,
address varchar(50) not null,
telNum varchar(15),
e_Mail varchar(50) not null
);

# 创建外键
alter table productInfo add constraint FK_productInfo_productSort foreign key(sortId) references productSort(id) on delete restrict on update restrict;
alter table cart add constraint FK_cart_user foreign key(userId) references user(userID) on delete restrict on update restrict;
alter table cart add constraint FK_cart_productInfo foreign key(productId) references productInfo(id) on delete restrict on update restrict;
alter table orders add constraint FK_order_productInfo foreign key(productId) references productInfo(id) on delete restrict on update restrict;
alter table orders add constraint FK_order_user foreign key(userId) references user(userID) on delete restrict on update restrict;

# 向productSort表插入记录
insert into productSort (sortName) values("精品图书");
insert into productSort (sortName) values("数码产品");
insert into productSort (sortName) values("日常用品");
insert into productSort (sortName) values("食品杂货");
select * from productSort;

# 向productInfo表补录数据
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(1, "JavaEE框架技术进阶式教程", 39, 8.0, 40, "一本非常优秀的教材","commodity1.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "Nokia5310", 890, 9.0, 50, "价格最优性能最好","commodity2.jpg");
# 向productInfo表补录数据
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(1, "SQL Server", 29.5, 8.0, 30, "好书","commodity3.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "雕牌洗衣粉", 19.5, 9.0, 300, "用了都说好", "commodity4.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(4, "好吃点饼干", 2.5, 9.0, 200, "好吃你就多吃点", "commodity5.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "立白洗洁精", 3.5, 8.0, 150, "不伤手的立白","commodity6.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "三星A40数码相机", 559, 9.0, 10, "便宜实惠","commodity7.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(2, "联想笔记本", 5999, 9.0, 10, "性能卓越","commodity8.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(4, "达能饼干", 3.5, 8.5, 660, "补充一天的能量","commodity9.jpg");
insert into productInfo (sortId, productName, price, discount, inventory, discription, picture) values(3, "妙管家泡沫厨房", 16.5, 8.0, 180, "美好生活从妙管家开始","commodity10.jpg");

select * from productInfo;

# 对表productInfo以及productSort的操作
delete from productInfo;
delete from productSort;
# 两张表连接查询
select productName, sortName, price, discount, inventory, discription from productInfo,productSort where productInfo.sortId=productSort.id;

# 向user表录入数据
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("王新民","123456","男",33,"13895251191","wxm@163.com");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("李勇","123","男",21,"13772507789","liyong@hotmail.com");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("张辉","zhanghui","男",25,"15052169987","zhanghui@sina.com.cn");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("王鹏","wangpeng","男",37,"13598799619","wangpeng@yahoo.com.cn");
insert into user(userName,passWord,sex,age,telNum,e_Mail)
values("李静","lijing","女",27,"15152094389","lijing@163.com");
select * from user;

# 向cart表录入数据
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

# 查询购物车中商品的详细信息
select userName, productName, sortName, price, discount, discription
from user,productInfo,productSort,cart
where user.userID=cart.userId and productInfo.sortId=productSort.id and productInfo.id=cart.productId;
select * from user where userName='张辉';
select * from user where userID=1;

