create table customer(
    id serial primary key,
    firstName varchar(255),
    lastName varchar(255),
    balance float default 0.0,
    phone varchar(25)
);

create table items(
    id serial primary key,
    name varchar(46),
    description varchar(356),
    price float default 0.0
);

create table orders(
    id serial primary key,
    customerID int REFERENCES  customer (id),
    itemID int REFERENCES  items (id),
    amount int not null,
    totalPrice float not null
);
/*
insert into customer(firstName, lastName, balance, phone) VALUES ('Dias', 'Orazbaev', 13.2, '+77773736454');
insert into customer(firstName, lastName, balance, phone) VALUES ('Azamat', 'Cplusmaster', 11.23, '+77773736433');

insert into items(name, description, price) values ('PS5', 'This is amazing console for solo', 399.99);
insert into items(name, description, price) values ('DualSense', 'This is amazing controller for amazing console', 39.99);
*/
