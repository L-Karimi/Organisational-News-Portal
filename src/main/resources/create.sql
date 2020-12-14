SET MODE PostgreSQL;

CREATE DATABASE myorg;
\c myorg;


CREATE TABLE IF NOT EXISTS departments (
id SERIAL PRIMARY KEY,
  departmentName VARCHAR,
  departmentDescription VARCHAR,
  departmentEmployeesNumber INTEGER
);

CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
  userName VARCHAR,
  userCompanyPosition VARCHAR,
  userCompanyRole VARCHAR,
  departmentId INTEGER
);

CREATE TABLE IF NOT EXISTS news (
id SERIAL PRIMARY KEY,
  newsTitle VARCHAR,
  newsContent VARCHAR,
  departmentId INTEGER
);

CREATE TABLE IF NOT EXISTS departments_users (
id SERIAL PRIMARY KEY,
departmentId INTEGER,
userId INTEGER
);

CREATE TABLE IF NOT EXISTS departments_news(
id SERIAL PRIMARY KEY,
departmentId INTEGER,
newsId INTEGER
);

CREATE DATABASE myorg_test WITH TEMPLATE myorg;