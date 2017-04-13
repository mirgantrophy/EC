/* This table holds all the data specific to a client. this is a table
	in the "clients" database.
	date: date the client got consultation
	birthdate 
	firstName
	lastName
	address
	phone
*/
CREATE TABLE clientData
(
		firstName VARCHAR(30) NOT NULL,
		lastName VARCHAR(30) NOT NULL,
		address VARCHAR(50) NULL,
		email VARCHAR(50) NULL,
		phoneNumber VARCHAR(10) NOT NULL,
		startDate DATE DEFAULT NOT NULL,
		clientID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);
