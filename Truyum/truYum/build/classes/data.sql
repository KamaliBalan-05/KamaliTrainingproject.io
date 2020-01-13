/*menu_item table details*/
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', 'Yes', '2019-04-23', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', 'Yes', '2019-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', 'Yes', '2020-01-10', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', 'No', '2021-02-04', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', 'Yes', '2022-02-17', 'Dessert', 'Yes');

/*user table details*/
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Akila');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'Kamali');

/*View Menu Item List Admin (TYUC001)*/
SELECT * FROM truyum.menu_item;

/*View Menu Item List Customer (TYUC002)*/
select * from truyum.menu_item where me_active='Yes' and me_date_of_launch > (select curdate());

/*Edit Menu Item (TYUC003)*/
select * from truyum.menu_item where me_id='1';

Update truyum.menu_item
set
me_name='Biriyani',
me_price='99.00',
me_active='Yes',
me_date_of_launch='2019-04-23',
me_category='Main Course',
me_free_delivery='Yes'
where
me_id='1';

/*cart table details (TYUC004)*/
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('1', '1', '1');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('2', '1', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('3', '1', '5');

/*View Cart (TYUC005)*/
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from
truyum.menu_item
inner join
truyum.cart on ct_me_id = me_id
where ct_us_id=1;

/*total price of all menu items*/
select sum(me_price) as total from truyum.menu_item
inner join truyum.cart on ct_me_id = me_id;

/*Remove Item from Cart (TYUC006)*/
delete from truyum.cart where ct_us_id=1 and ct_me_id=1 limit=1;
select * from truyum.cart; 
