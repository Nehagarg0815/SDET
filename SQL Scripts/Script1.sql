
create database sdet4_Neha;

use sdet4_Neha;
-- Create salesman table
CREATE TABLE salesman (
    salesman_id int primary key,
    name varchar(32),
    city varchar(32),
    commission int
);
DESCRIBE salesman;
-- Insert values one at a time
INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);

-- Insert multiple rows at once
INSERT INTO salesman VALUES
    (5002, 'Nail Knite', 'Paris', 13),
    (5005, 'Pit Alex', 'London', 11), 
    (5006, 'McLyon', 'Paris', 14), 
    (5007, 'Paul Adam', 'Rome', 13),
    (5003, 'Lauson Hen', 'San Jose', 12);

-- View all columns
SELECT * FROM salesman;
-- Show data from the salesman_id and city columns
SELECT salesman_id, city FROM salesman;

-- Show data of salesman from Paris
SELECT * FROM salesman WHERE city='Paris';

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE name='Paul Adam';

ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade=100;

Select * from salesman;