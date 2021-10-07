insert into city (name, state, country) values ('San Francisco', 'CA', 'US');
insert into hotel(city, name, address, zip) values (1, 'Conrad Treasury Place', 'William & George Streets', '4001');
insert into ticket(id,amount,creation_date ) values (1,12,CURRENT_DATE());
insert into ticket_detail(id,ticket_id,description,amount ) values (1,1,'San Francisco cccc',13);