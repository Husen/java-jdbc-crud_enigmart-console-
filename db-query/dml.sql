insert into m_product
(name_product) values
('sampo zinc'),
('sampo Liveboy'),
('sampo Clear'),
('Sabun give'),
('Sabun dove'),
('Sabun rinso'),
('Sabun daia'),
('Kopi ABC'),
('Kopi Mocacino'),
('Kopi Kapal Api'),
('Rokok Surya'),
('Rokok MILD'),
('Rokok DAIA');

insert into m_product_price
(product_id, price) values
(1, 7000),
(2, 9000),
(3, 9000),
(4, 4000),
(5, 5000),
(6, 2000),
(7, 2000),
(8, 12000),
(9, 12500),
(10, 13500),
(11, 22000),
(12, 25000),
(13, 50000);


insert into t_sell
(trans_date, customer_name) values
('2022-10-01', 'indra'),
('2022-10-01', 'husen'),
('2022-10-01', 'yuda'),
('2022-10-01', 'irfan'),
('2022-10-02', 'husen'),
('2022-11-02', 'bimo'),
('2022-11-03', 'irfan'),
('2022-11-04', 'rafif'),
('2022-12-04', 'selvi'),
('2022-12-04', 'yuda'),
('2023-01-01', 'nazir'),
('2023-01-01', 'surya'),
('2023-01-02', 'galuh'),
('2023-01-02', 'husen'),
('2023-01-01', 'indra'),
('2023-02-01', 'bimo'),
('2023-02-02', 'inal'),
('2023-02-02', 'adam');

insert into t_sell
(trans_date, customer_name) values
('2023-02-03', 'a');
select id from t_sell order by id desc limit 1;
insert into t_sell_detail
(sell_id, product_price_id, qty) values
(17, 1, 2),
(17, 2, 2),
(17, 3, 3);


insert into t_sell_detail
(sell_id, product_price_id, qty) values
(1,2,4),
(1,1,1),
(1,11,2),
(2,11,1),
(3,10,2),
(3,1,4),
(3,2,4),
(3,5,2),
(3,3,6),
(4,13,1),
(4,11,2),
(4,4,2),
(5,6,3),
(5,9,1),
(6,13,1),
(7,1,2),
(7,2,3),
(7,3,2),
(7,10,1),
(8,1,2),
(9,13,1),
(10,8,2),
(10,6,4),
(11,7,1),
(11,9,2),
(12,12,3),
(12,1,3),
(12,3,2),
(13,1,2),
(13,10,2),
(14,1,1),
(15,13,2),
(15,1,2),
(15,3,2),
(16,5,1),
(16,3,4),
(17,1,2),
(17,8,2),
(18,2,5);


-- insert t_sell dan t_sell_detail ?



insert into m_product (name_product) values ('sambal abc');
select id from m_product order by id desc limit 1;
insert into m_product_price (product_id, price) values (15, 8000);

select * from m_product_price as pc
join m_product as p
on p.id = pc.product_id;


select * from m_product;
select * from m_product_price;
select * from t_sell;
select * from t_sell_detail;

SELECT * from m_product_price


select p.name_product, pc.price from m_product_price as pc join m_product as p on p.id=pc.product_id order by pc.id asc

select trans_date, customer_name, name_product, price, qty from t_sell_detail as sd
join t_sell as s
on s.id=sd.sell_id
join m_product_price as pc
on pc.id=sd.product_price_id
join m_product as p
on p.id=pc.product_id
order by sd.id asc


delete from m_product_price where id=21 ;
delete from m_product where id=17
delete from m_product where id=18;
DELETE FROM m_product where id=14

delete from t_sell where id=17
truncate m_product_price restart identity cascade


select id from m_product order by id desc limit 1;



