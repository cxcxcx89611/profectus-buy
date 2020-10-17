insert into category values (1, 'Dairy');
insert into category values (2, 'Fruit');

insert into product values (1, 'Milk', 1);
insert into product values (2, 'Cream', 1);
insert into product values (3, 'Cheese', 1);

insert into product values (4, 'Bananas', 2);
insert into product values (5, 'Apples', 2);
insert into product values (6, 'Oranges', 2);


insert into Purchased values (1, 200, 500, PARSEDATETIME('2020-06-09', 'yyyy-MM-dd'),1);
insert into Purchased values (2, 100, 300, PARSEDATETIME('2020-06-12', 'yyyy-MM-dd'),2);
insert into Purchased values (3, 150, 900, PARSEDATETIME('2020-07-03', 'yyyy-MM-dd'),3);

insert into Purchased values (4, 400, 200, PARSEDATETIME('2020-07-18', 'yyyy-MM-dd'),4);
insert into Purchased values (5, 300, 350, PARSEDATETIME('2020-05-04', 'yyyy-MM-dd'),5);
insert into Purchased values (6, 320, 320, PARSEDATETIME('2020-06-07', 'yyyy-MM-dd'),6);

insert into Sold values (1, 180, 540, PARSEDATETIME('2020-06-14', 'yyyy-MM-dd'),1);
insert into Sold values (2, 75, 300, PARSEDATETIME('2020-06-22', 'yyyy-MM-dd'),2);
insert into Sold values (3, 100, 800, PARSEDATETIME('2020-08-03', 'yyyy-MM-dd'),3);

insert into Sold values (4, 350, 250, PARSEDATETIME('2020-07-23', 'yyyy-MM-dd'),4);
insert into Sold values (5, 200, 300, PARSEDATETIME('2020-07-14', 'yyyy-MM-dd'),5);
insert into Sold values (6, 280, 420, PARSEDATETIME('2020-08-07', 'yyyy-MM-dd'),6);
