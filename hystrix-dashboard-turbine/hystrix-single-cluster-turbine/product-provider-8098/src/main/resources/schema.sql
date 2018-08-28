drop table product if exists;

create table product(
  product_id varchar(32) comment '商品编号',
  product_name varchar(200) comment '商品名称',
  product_price decimal(10.2) comment '商品价格',
  status int(1) comment '商品价格',
  primary key (product_id)
);