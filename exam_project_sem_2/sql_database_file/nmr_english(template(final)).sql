CREATE SCHEMA nordic_motorhome_rental;

CREATE TABLE nordic_motorhome_rental.employee(
employee_id 			INT(10) 		NOT NULL,
employee_dept 			VARCHAR(45) 	NOT NULL,
employee_first_name 	VARCHAR(45) 	NOT NULL,
employee_last_name 		VARCHAR(45) 	NOT NULL,
employee_address 		VARCHAR(100) 	NOT NULL,
employee_cpr 			VARCHAR(11) 	NOT NULL,
employee_password 		VARCHAR(45) 	NOT NULL,
PRIMARY KEY (employee_id)
);

CREATE TABLE nordic_motorhome_rental.customer(
customer_id 				INT(10) 		NOT NULL,
customer_first_name 		VARCHAR(45) 	NOT NULL,
customer_last_name 			VARCHAR(45) 	NOT NULL,
customer_address 			VARCHAR(100) 	NOT NULL,
customer_driver_license_no 	VARCHAR(15) 	NOT NULL,
customer_cpr_no 				VARCHAR(11) 	NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE nordic_motorhome_rental.rental(
rental_id 				INT(10) 		NOT NULL, 
customer_id				INT(10)			NOT NULL,
motorhome_id 			INT(10) 		NOT NULL,
employee_id				INT(10)			NOT NULL,
date_start 				VARCHAR(45) 	NOT NULL,
date_end 				VARCHAR(45) 	NOT NULL,
total 					VARCHAR(45) 	NOT NULL,
valuta 					VARCHAR(45) 	NOT NULL,
paid 					VARCHAR(45) 	NOT NULL,
comments				VARCHAR(45),
PRIMARY KEY (rental_id)
); 

CREATE TABLE nordic_motorhome_rental.motorhome(
motorhome_id 				INT(10) 		NOT NULL,
motorhome_price 			VARCHAR(45) 	NOT NULL,
motorhome_license_plate 	VARCHAR(45) 	NOT NULL,
motorhome_brand 			VARCHAR(45) 	NOT NULL,
motorhome_model 			VARCHAR(45) 	NOT NULL,
motorhome_year 				INT(4) 			NOT NULL,
motorhome_colour 			VARCHAR(10) 	NOT NULL,
motorhome_bedding 			INT(10) 		NOT NULL,
PRIMARY KEY (motorhome_id)
);

INSERT INTO nordic_motorhome_rental.employee(employee_id, employee_dept, employee_first_name, employee_last_name, employee_address, employee_cpr, employee_password)
VALUES 
('12341', 'Admin', 			'Rasmus', 	'Nielsen',		'Frederiksvej 2, 2730 Herlev',	'220798-7351', 'passwordadminet'),
('12342', 'Admin', 			'Ulla', 	'Nielsen',		'Frederiksvej 2, 2730 Herlev',	'100298-8462', 'passwordadminto'),
('7842', 'Salgsassistent', 	'Mohamad', 	'Elhady', 		'Højrevej 45, 2730 Herlev', 	'220198-7842', 'passworden'),
('4672', 'Salgsassistent', 	'Heritiér', 'Mugisha', 		'Venstrevej 19, 2860 Søborg', 	'190298-4672', 'passwordto'),
('8942', 'Salgsassistent', 	'Oliver', 	'Schönemann', 	'Midtvej 15, 2730 Herlev', 		'291097-8942', 'passwordtre'),
('1328', 'Salgsassistent', 	'Dejan', 	'Alija', 		'Vedsidenvej 99, 2860 Søborg', 	'220798-1328', 'passwordfire'),
('3180', 'Mekaniker', 		'Lars', 	'Povlsen', 		'Mekvej 23, 2860 Søborg', 		'311296-3180', 'passwordfem'),
('6474', 'Rengøring', 		'Sara', 	'Noor', 		'Sydvej 115, 2730 Herlev', 		'090798-6474', 'passwordseks'),
('3181', 'Rengøring', 		'Ludmilla', 'Høgh', 		'Mekvej 23, 2880 Bagsværd', 	'311296-3181', 'passwordsyv');

INSERT INTO nordic_motorhome_rental.customer(customer_id, customer_first_name, customer_last_name, customer_address, customer_driver_license_no, customer_cpr_no)
VALUES 
('012020', 'Lars', 		'Boss', 		'Hjortevej 45, 4930 Maribo', 					'DK12902378', '120198-1212'),
('022020', 'Hugo', 		'Rasmussen', 	'Store Kongensgade 19, 4800 Nykøbing Falster', 	'DK90432378', '291098-8924'),
('032020', 'Bente', 	'Jensen', 		'Margrethevænget 15, 4990 Sakskøbing', 			'DK45672894', '271097-6742'),
('042020', 'Birgit', 	'Jensen', 		'Hvidovrevej 99, 4700 Næstved', 				'DK88420245', '281198-7642'),
('052020', 'Michael', 	'Hansen', 		'H.C. Smidthsvej 99, 7100 Vejle', 				'DK66678653', '121298-7342');

INSERT INTO nordic_motorhome_rental.rental(rental_id, customer_id, motorhome_id, employee_id, date_start, date_end, total, valuta, paid)				
VALUES 
('20201', '012020', '101', 	'7842', 		'23-02-2020', 		'04-02-2020', 	'4,389 ', 		'DKK', 'true'), 
('20202', '022020', '801', 	'4672', 		'24-02-2020', 		'07-03-2020', 	'4,420', 		'DKK', 'true'),
('20203', '032020', '301', 	'8942', 		'24-02-2020', 		'09-03-2020', 	'5,385', 		'DKK', 'true'),
('20204', '042020', '401', 	'1328', 		'27-02-2020', 		'13-04-2020', 	'5,385', 		'DKK', 'true'),
('20205', '052020', '701', 	'4672', 		'27-02-2020', 		'15-05-2020', 	'6,103', 		'DKK', 'true');

INSERT INTO nordic_motorhome_rental.motorhome(motorhome_id, motorhome_price, motorhome_license_plate, motorhome_brand, motorhome_model, motorhome_year, motorhome_colour, motorhome_bedding)
VALUES 
('101', '399.00', 	'AB 50 123', 'Mercedes', 					'Marco Polo', '2018', 'Sort',	'2'),
('102', '399.00', 	'XY 83 706', 'Mercedes', 					'Marco Polo', '2018', 'Grå',	'3'),
('103', '399.00', 	'BV 22 778', 'Mercedes', 					'Marco Polo', '2018', 'Sort',	'4'),
('104', '399.00', 	'UI 92 467', 'Mercedes', 					'Marco Polo', '2018', 'Hvid',	'5'),

('201', '399.00', 	'OP 12 914', 'Mercedes', 					'Marco Polo', '2017', 'Hvid',	'3'),
('202', '399.00', 	'HJ 28 299', 'Mercedes', 					'Marco Polo', '2016', 'Sort',	'3'),
('203', '399.00', 	'YU 70 130', 'Mercedes', 					'Marco Polo', '2017', 'Grå',	'4'),
('204', '399.00', 	'VT 03 452', 'Mercedes', 					'Marco Polo', '2018', 'Hvid',	'6'),

('301', '359.00', 	'VN 72 424', 'Mercedes', 							'Tymer', '2019', 'Rød',	'6'),
('302', '359.00', 	'ID 81 019', 'Mercedes', 							'Tymer', '2016', 'Sort','4'),
('303', '359.00', 	'JK 68 913', 'Mercedes', 							'Tymer', '2013', 'Hvid','6'),
('304', '359.00', 	'DT 90 015', 'Mercedes', 							'Tymer', '2017', 'Grå',	'2'),

('401', '359.00', 	'XN 31 625', 'Mercedes', 						'Tymer', '2019', 'Rød','	6'),
('402', '359.00', 	'DK 31 625', 'Mercedes', 						'Tymer', '2019', 'Rød','	3'),
('403', '359.00', 	'DU 26 275', 'Mercedes', 						'Tymer', '2019', 'Rød','	4'),
('404', '359.00', 	'EQ 51 841', 'Mercedes', 						'Tymer', '2019', 'Rød','	1'),

('501', '460.00', 	'BB 30 421', 'Mercedes', 					'Marco Polo',	'2018', 'Hvid',	'5'),
('502', '460.00', 	'EU 67 182', 'Mercedes', 					'Marco Polo',	'2018', 'Hvid',	'4'),
('503', '460.00', 	'AQ 67 181', 'Mercedes', 					'Marco Polo',	'2018', 'Hvid',	'4'),
('504', '460.00', 	'OA 71 984', 'Mercedes', 					'Marco Polo',	'2018', 'Hvid',	'5'),

('601', '460.00', 	'OP 98 324', 'Mercedes', 						'Tymer',	'2020', 'Grå',	'2'),
('602', '460.00', 	'YU 69 087', 'Mercedes', 						'Tymer',	'2020', 'Grå',	'4'),
('603', '460.00', 	'ET 45 571', 'Mercedes', 						'Tymer',	'2020', 'Grå',	'5'),
('604', '460.00', 	'WQ 65 225', 'Mercedes', 						'Tymer',	'2020', 'Grå',	'6'),

('701', '340.00', 	'AN 50 987', 'Mercedes', 					'Marco Polo',	'2019', 'Blå',	'3'),
('702', '340.00', 	'YU 32 964', 'Mercedes', 					'Marco Polo',	'2019', 'Blå',	'5'),
('703', '340.00', 	'ER 57 882', 'Mercedes', 					'Marco Polo',	'2019', 'Blå',	'6'),
('704', '340.00', 	'OL 15 360', 'Mercedes', 					'Marco Polo',	'2019', 'Blå',	'4'),

('801', '340.00', 	'XY 40 082', 'Mercedes', 							'Tymer','2017', 'Blå',	'3'),
('802', '340.00', 	'OS 06 740', 'Mercedes', 							'Tymer','2017', 'Blå',	'4'),
('803', '340.00', 	'YU 92 137', 'Mercedes', 							'Tymer','2017', 'Blå',	'5'),
('804', '340.00', 	'DA 37 170', 'Mercedes', 							'Tymer','2017', 'Blå',	'6');