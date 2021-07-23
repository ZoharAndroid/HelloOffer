
# SQL基本语法

## 连接Postgres数据库

```sql
C:\Programs\PostgreSQL\13\bin\psql.exe -U postgres
```

## 创建数据库

```sql
create database <数据库名称>;
e.g. create database shop;
```

## 删除数据库

```sql
drop database <数据库名>;

e.g. 
drop database shop;
```

## 连接数据库

```sql
C:\Programs\PostgreSQL\13\bin\psql.exe -U postgres -d <数据库名>;
e.g. psql.exe -u postgres -d shop;
```

## 创建表

```sql
create table <表名> (
 <列名1> <数据类型> <该列的约束条件>,
 <列名2> <数据类型> <该列的约束条件>,
 <列名3> <数据类型> <该列的约束条件>,
 .
 .
 .
 <该表的约束1>，<该表的约束2>,……
);

e.g. 
create table product(
product_id char(4) not null,
product_name varchar(100) not null,
product_type varchar(32) not null,
sale_price integer,
purchase_price integer,
reigst_date date,
primary key(product_id)
);
```

## 删除表

```sql
drop table <表名>;
e.g. drop table product;
```

## 表中增加列

```sql
alter table <表名> add <列名1> <数据类型> <约束条件>, add  <列名2> <数据类型> <约束条件>;
e.g. 
-- 添加一列
alter table product add product_name char(100) not null;
-- 添加多列

alter table product add product_pinyin varchar(100) not null,add supply_name varchar(100) not null;
```

## 表中删除列

```sql
alter table <表名> drop <列名1>, drop <列名2>;

-- 删除单列
e.g.

alter table product drop product_pinyin;
-- 删除多列
e.g.
alter table product drop product_pinyin,drop supply_name;
```

## 修改表名

```sql
alter table <表名> rename to <新表名>;

e.g.
alter table product rename to product_1;
```

## 查询

### 查询表的全部数据

```sql
select * from <表名>;

e.g.
select * from product;
```

### 查询表部分数据

```sql
select <列名1>,<列名2>,... from <表名>;

e.g.
 select product_id,product_name,sale_price from product;
```

### 为列设置别名

```sql
select <列名1> as <别名1>,<列名2> as <别名2>,... from <表名>;

e.g.
-- 英文
select product_id as id,product_name as name,sale_price as price from product;

-- 中文
select product_id as "商品编号",product_name as "商品名称",sale_price as "商品价格" from product;
```

### 查询结果剔除重复数据

```sql
e.g.
select distinct product_type from product;
```

> 如果数据包含null，那么合并呈一条。

### 查询结果剔除多列重复数据

```sql
e.g.
 select distinct reigst_date,product_type from product;
```

> 只有多列的数据同时与另外行的数据相同才会剔除。
> distinct关键字只能用于第一个列名之后。

### where筛选

```sql
select <列名1>,<列名2> from <表名> where <条件>;
e.g.
select product_name, product_type from product where product_type='衣服';
```

### 算术运算符

算术运算符包括“ + - * /”。

```sql
e.g.
select product_name,sale_price,sale_price * 2 as "sale_price *2" from product;
```

> 注意：
> Null，包含null计算的结果，结果都是null。包括 null/0=null。

### 比较运算符

#### 等于 =

```sql
e.g.
select product_name,product_type from product where sale_price=500;
```

#### 不等于 <>/!=

```sql
select product_name,product_type from product where sale_price <> 500;
select product_name,product_type from product where sale_price != 500;
```

#### 大于等于>=

```sql
select product_name,product_type,sale_price from product where sale_price >=1000;
```

#### 小于

```sql
select product_name,product_type,sale_price from product where reigst_date < '2009-09-27';
```

#### is null和is not null

```sql
select product_name,purchase_price from product where purchase_price is null;
select product_name,purchase_price from product where purchase_price is not null;
```

### 比较和算术结合

```sql
select product_name,sale_price,purchase_price from product where sale_price - purchase_price >=500;
```

### 逻辑运算符

#### not

```sql
select product_name, product_type, sale_price from product where not sale_price >=1000;
```

#### and/or

```sql
select product_name, purchase_price from product where product_type='厨房用品' and sale_price >= 300;
select product_name, purchase_price from product where product_type='厨房用品' or sale_price >= 300;
select * from product where product_type = '办公用品' and (reigst_date = '2009-09-11' or reigst_date = '2009-09-20');
```
