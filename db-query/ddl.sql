create table m_product
(
id serial primary key not null,
name_product varchar(100) not null
);

create table m_product_price
(
id serial primary key not null,
product_id int not null,
price int not null,
constraint fk_product_price
foreign key (product_id)
references m_product(id)
ON DELETE CASCADE
);
select * from m_product_price as pc
join m_product as p
on p.id = pc.product_id;

create table t_sell
(
id serial primary key not null,
trans_date date not null,
customer_name varchar(100)
);

create table t_sell_detail
(
id serial primary key not null,
sell_id int not null,
product_price_id int not null,
qty int not null,
constraint fk_sell_detail
foreign key (sell_id)
references t_sell(id)
ON DELETE CASCADE,
constraint fk_productprice_detail
foreign key (product_price_id)
references m_product_price(id)
);

select * from t_sell_detail


drop table t_sell_detail;
drop table t_sell;
drop table m_product_price;
drop table m_product;
