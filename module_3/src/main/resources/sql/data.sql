use bank_application;
insert into users values (default, 'Christian Bauer');
insert into users values (default, 'Gavin King');
insert into users values (default, 'Gary Gregory');
insert into users values (default, 'Bruce Eckel');
insert into users values (default, 'Brian Goetz');
insert into users values (default, 'Tim Peierls');
insert into users values (default, 'Joshua Bloch');
insert into users values (default, 'Joseph Bowbeer');
insert into users values (default, 'David Holmes');
insert into users values (default, 'Doug Lea');

insert into accounts values (default, 100075, 'Alfa1', 1);
insert into accounts values (default, 105083, 'Mono1', 1);
insert into accounts values (default, 500005, 'Mono2', 2);
insert into accounts values (default, 300098, 'Privat2', 2);
insert into accounts values (default, 237805, 'Idea2', 2);
insert into accounts values (default, 300053, 'Mono3', 3);
insert into accounts values (default, 105085, 'Idea4', 4);
insert into accounts values (default, 300067, 'Privat4', 4);
insert into accounts values (default, 57908, 'Alfa4', 4);
insert into accounts values (default, 300098, 'Alfa5', 5);
insert into accounts values (default, 400021, 'Mono6', 6);
insert into accounts values (default, 800045, 'Alfa6', 6);
insert into accounts values (default, 100053, 'Alfa7', 7);
insert into accounts values (default, 600078, 'Privat7', 7);
insert into accounts values (default, 230078, 'Raiffeisen8', 8);
insert into accounts values (default, 567378, 'Credit8', 8);
insert into accounts values (default, 230054, 'ProCredit8', 8);
insert into accounts values (default, 310022, 'Privat9', 9);
insert into accounts values (default, 435434, 'Credit10', 10);
insert into accounts values (default, 534543, 'ProCredit10', 10);


insert into transactions values (default, 55045, CURRENT_TIMESTAMP(), 2, 4);
insert into transactions values (default, 15502, CURRENT_TIMESTAMP(), 3, 5);
insert into transactions values (default, 37006, CURRENT_TIMESTAMP(), 1, 5);
insert into transactions values (default, 23007, CURRENT_TIMESTAMP(), 5, 7);
insert into transactions values (default, 54000, CURRENT_TIMESTAMP(), 5, 4);
insert into transactions values (default, 12800, CURRENT_TIMESTAMP(), 6, 1);
insert into transactions values (default, 32428, CURRENT_TIMESTAMP(), 7, 2);
insert into transactions values (default, 56767, CURRENT_TIMESTAMP(), 9, 5);

