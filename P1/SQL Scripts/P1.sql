
--This will create a table for the user data
CREATE TABLE ers_users(

	--The ID is SERIAL type to increment with every new row added
     --The ID is denoted as the primary key

	id SERIAL PRIMARY KEY,

	--Username, password, and roles are VARCHAR type with a max of 250 characters to store them as strings 
--Username must be unique because we will query for single results of a given username

--None of these columns will be null when a new entry is created

username VARCHAR (250) UNIQUE NOT NULL,
password VARCHAR (250) NOT NULL, 
role VARCHAR (250) NOT NULL

);

--This is meant to create two default users in the ers_users table
--The only way to create a Manager, currently, is to put it directly in the database. 
--You will use the manager credentials to test your manager's functionality and reimbursement processing.

INSERT INTO ers_users(username, password, role)
VALUES('default', 'guest', 'Employee'),('admin', 'Manager');


--This will create a table for the re data

CREATE TABLE ers_reimbursements(

	--The ID is SERIAL type to increment with every new row added
     --The ID is denoted as the primary key

	id SERIAL PRIMARY KEY,

	--The author and resolver are both integer values
	--They store the primary key (ID) of the respective user
	--Author should never be null when a new entry is created; however, the resolver will be until processing

	author INT NOT NULL, 
	resolver INT,

	--The description must be stored as TEXT to ensure that longer description strings can be stored appropriately 
	--This field should never be null when a new entry is created
	description TEXT NOT NULL,
	
type VARCHAR (250) NOT NULL, 
status VARCHAR (250) NOT NULL,

	--The amount must be stored as a float to account for the double datatype
	--This value will have 2 decimal places and should never be null upon entry
	amount FLOAT NOT NULL,

	--We need to denote the foreign key relationships that the author and resolver IDs have to the ers_users table.
	--As you can see, we create new constraints that reference the ers_users primary key(id)

	CONSTRAINT fk_author
		FOREIGN KEY (author)
			REFERENCES ers_users(id),
	CONSTRAINT fk_resolver
		FOREIGN KEY (resolver)
			REFERENCES ers_users(id)

);

--Creating the necessary enum types for data storage
create type role as enum ('Employee', 'Manager');
create type type as enum ('Lodging', 'Travel', 'Food', 'Other');
create type status as enum ('Pending', 'Approved', 'Denied');









