create table if not exists product_buy(
    id serial primary key,
	title VARCHAR (255) NOT NULL,
	price INT NOT NULL
)

create table if not exists client(
    id serial primary key,
	name VARCHAR (255) NOT NULL,
	product_id INTEGER,
	FOREIGN KEY (product_id) REFERENCES product_buy(id)
)

insert into public.product_buy (title, price) values ('apple', 20), ('orange', 50), ('milk', 35);

insert into public.client (name, product_id) values ('Pavel', 1), ('Nikolay', 2), ('Alexandr', 3);

select * from public.client c
left join public.product_buy p ON c.product_id = p.id;

alter table product_buy add column client_id integer;
alter table product_buy add foreign key(client_id) references client(id);

select * from public.client c
left join public.product_buy p ON c.id = p.client_id;
