--
--  Create application tables
--

CREATE TABLE users (
    user_id INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(255) NOT NULL,
    -- this should be a hash
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE clients (
    client_id INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    phone BIGINT NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,  
    CONSTRAINT pk_clients PRIMARY KEY (client_id)
);

CREATE TABLE pets (
    pet_id INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    gender CHAR(2) NOT NULL,
    dob DATE NOT NULL,
    owner INTEGER NOT NULL,
    CONSTRAINT pk_pets PRIMARY KEY (pet_id),
    CONSTRAINT fkpet_client FOREIGN KEY (owner) 
    REFERENCES clients(client_id) on delete cascade  
);

CREATE TABLE appointments (
    date DATE NOT NULL,
    time TIME NOT NULL,
    client INTEGER NOT NULL,
    pet INTEGER NOT NULL,
    reason VARCHAR(255) NOT NULL,
    CONSTRAINT pk_appoint PRIMARY KEY (date, time),
    CONSTRAINT fkappoint_client FOREIGN KEY (client) 
    REFERENCES clients(client_id) ON DELETE CASCADE,
    CONSTRAINT fkappoint_pet FOREIGN KEY (pet) 
    REFERENCES pets(pet_id) ON DELETE CASCADE 
);