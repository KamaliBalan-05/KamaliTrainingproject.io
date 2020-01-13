/*Movies table detail*/
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', 'Yes', '2019-04-23', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', 'Yes', '2019-12-23', 'Superhero', 'No');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', 'Yes', '2020-01-10', 'Romance', 'No');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', 'No', '2021-02-04', 'Science Fiction', 'Yes');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2750760348', 'Yes', '2022-02-17', 'Superhero', 'Yes');

/*User table detail*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Kamali');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Annie');

/*View Movies List Admin */
SELECT * FROM moviecruiser.movies;

/*View Movies List Customer */
select * from moviecruiser.movies where mo_active='Yes' and mo_date_of_launch > (select curdate());

/*Edit Movies Item */
select * from moviecruiser.movies where mo_id='1';

Update moviecruiser.movies
set
mo_title='Charlie',
mo_box_office='2787965087',
mo_active='Yes',
mo_date_of_launch='2019-04-23',
mo_genre='Science Fiction',
mo_has_teaser='Yes'
where
mo_id='1';

SELECT * FROM moviecruiser.movies;
/*Add favorites detail*/
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('1', '1', '1');
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('2', '1', '3');
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('3', '1', '5');
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('4', '2', '2');
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('5', '2', '4');

/*View Favorites*/
select mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from
moviecruiser.movies
inner join
moviecruiser.favorites on fs_mo_id = mo_id
where fs_us_id=1;

/*No of favorites */  
SELECT count(mo_id) as no_of_favorites FROM moviecruiser.movies 
inner join moviecruiser.favorites
on fs_mo_id=mo_id where fs_us_id=1; 
 
/*Remove movies from favorites */
delete from moviecruiser.favorites where fs_us_id=1 and fs_mo_id=1 limit=1;
select mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from
moviecruiser.movies
inner join
moviecruiser.favorites on fs_mo_id = mo_id
where fs_us_id=1;
