/**
 * Author:  nanonexpy
 * Created: 16 oct. 2023
 */

CREATE TABLE employees (
    id INT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    document_number VARCHAR(20),
    gender VARCHAR(10),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    position VARCHAR(255),
    status VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);