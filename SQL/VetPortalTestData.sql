--
-- Create test data
--

INSERT INTO users
    (username, password)
VALUES
    -- This password is for inital testing only and should be changed to a hash
    ('testUser', 'Foobar!!');

INSERT INTO clients 
    (first_name, last_name, phone, email)
VALUES
    ('John', 'Doe', 11111111111, 'jdoe@mail.com'),
    ('Bob', 'McBobson', 2222222222, 'bmcbobson@mail.com'),
    ('Santa', 'Clause', 3333333333, 'santa@mail.com'),
    ('Random', 'Client', 4444444444, 'random@mail.com');

INSERT INTO pets
    (name, species, gender, dob, owner)
VALUES
    ('Isis', 'cat', 'FS', '2006-11-01', (SELECT client_id FROM clients WHERE first_name LIKE 'John')),
    ('Morrigan', 'cat', 'FS', '2010-6-01', (SELECT client_id FROM clients WHERE first_name LIKE 'John')),
    ('Butterscotch', 'cat', 'MN', '2000-2-01', (SELECT client_id FROM clients WHERE first_name LIKE 'Bob')),
    ('Candy', 'cat', 'FS', '2020-3-18', (SELECT client_id FROM clients WHERE first_name LIKE 'Bob')),
    ('Duke', 'dog', 'MN', '2020-3-18', (SELECT client_id FROM clients WHERE first_name LIKE 'Santa')),
    ('Polly', 'bird', 'F', '2020-3-18', (SELECT client_id FROM clients WHERE first_name LIKE 'Santa')),
    ('Sadie', 'dog', 'FS', '2020-3-18', (SELECT client_id FROM clients WHERE first_name LIKE 'Random')),
    ('Snowball', 'hamster', 'M', '2020-3-18', (SELECT client_id FROM clients WHERE first_name LIKE 'Random'));

INSERT INTO appointments
    (date, time, client, pet, reason)
VALUES
    ('2020-5-03', '09:00', (SELECT owner FROM pets WHERE name LIKE 'Isis'), (SELECT pet_id FROM pets WHERE name LIKE 'Isis'), 'annual exam'),
    ('2020-5-03', '11:00', (SELECT owner FROM pets WHERE name LIKE 'Candy'), (SELECT pet_id FROM pets WHERE name LIKE 'Candy'), 'excessive drooling'),
    ('2020-5-05', '15:00', (SELECT owner FROM pets WHERE name LIKE 'Duke'), (SELECT pet_id FROM pets WHERE name LIKE 'Duke'), 'recheck bloodwork'),
    ('2020-5-06', '13:00', (SELECT owner FROM pets WHERE name LIKE 'Sadie'), (SELECT pet_id FROM pets WHERE name LIKE 'Sadie'), 'retest for lyme'),
    ('2020-5-07', '13:00', (SELECT owner FROM pets WHERE name LIKE 'Snowball'), (SELECT pet_id FROM pets WHERE name LIKE 'Snowball'), 'follow up for diarrhea');