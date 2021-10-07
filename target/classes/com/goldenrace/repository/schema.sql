
drop table if exists city;
drop table if exists hotel;
 
create table city (id int primary key auto_increment, name varchar, state varchar, country varchar);
create table hotel (city int, name varchar, address varchar, zip varchar);


create table ticket(id int primary key auto_increment, amount double, creation_date date);
create table ticket_detail(id int primary key auto_increment,ticket_id int, description varchar, amount double);

