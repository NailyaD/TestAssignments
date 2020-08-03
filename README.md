## Project Description
RESTful Web Service for handling valid/invalid customer requests in order to make statistics using the Spring Boot, Hibernate, MySQL and Maven.

## Prerequisities

1. JDK :- 1.8
2. Mysql:- 8.x.x
3. Maven:- 5.x.x
4. Tomcat:- 1.7 or later

## Steps to Setup

### 1. Clone the application

``https://github.com/NailyaD/TestAssignments.git``

### 2. Create Mysql database

Using Command Line Client

``create database request_service``

Then create all necessary tables and insert values to ``ip_blacklist`` and ``ua_blacklist`` tables

### 3. Change mysql username and password as per your installation setting

* open ``src/main/resources/application.properties``
* change ``spring.datasource.username`` and ``spring.datasource.password`` as per your mysql installation settings

### 4. Build and run the app using Maven

``mvn clean package``

The app will start running at http://localhost:8080.

## Explore REST APIs

The app defines following APIs:

POST /api/customers

GET /api/stats/{customer_id}/from/{date_from}/to/{date_to}

GET /api/stats/{customer_id}/statuses/{request_status}

GET /api/stats/{customer_id}/statuses/{request_status}/from/{date_from}/to/{date_to}

You can test them using Postman or any other rest client.
