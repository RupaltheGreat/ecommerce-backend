# E-commerce Backend System

## Overview
This project implements a backend system for an e-commerce platform using Spring Boot and MySQL.

## Features
- User registration and authentication
- JWT-based login system
- Product management
- Shopping cart functionality
- Order checkout
- Payment simulation (success/failure)

## Technologies Used
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- MySQL Database
- Hibernate / JPA
- Maven
- Postman
- Git & GitHub
- 
## System Architecture
The project follows a layered architecture:

Client → Controller → Service → Repository → Database

- Controller Layer: Handles HTTP requests
- Service Layer: Contains business logic
- Repository Layer: Handles database communication
- Entity Layer: Represents database tables

## API Testing
APIs tested using Postman.

## GitHub Repository
https://github.com/RupalTheGreat/ecommerce-backend
## How to Run Locally

1. Clone the repository
git clone https://github.com/RupalTheGreat/ecommerce-backend.git
2. Open the project in Eclipse or IntelliJ
3. Configure MySQL database in `application.properties`
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=<yourpassword>
4. Run the Spring Boot application
Run EcommerceApplication.java
Server will start on:
http://localhost:8082

## API Documentation
### Authentication APIs
POST `/api/auth/login`  
Login user and generate JWT token.

### Product APIs
GET `/api/products`  
Retrieve all products.

POST `/api/products`  
Add a new product.

PUT `/api/products/{id}`  
Update product.

DELETE `/api/products/{id}`  
Delete product.

### Cart APIs
POST `/api/cart/create/{userId}`  
Create a cart for a user.

POST `/api/cart/items/add/{cartId}/{productId}/{quantity}`  
Add product to cart.

GET `/api/cart/items/{cartId}`  
Retrieve cart items.

### Order APIs

POST `/api/orders/checkout/{userId}/{cartId}`  
Place an order.

GET `/api/orders`  
Retrieve order history.

## Database Schema
Main Entities:
- User
- Product
- Cart
- CartItem
- Order
- OrderItem

Relationships:
User → Cart (1:1)  
Cart → CartItem (1:M)  
Product → CartItem (1:M)  
User → Order (1:M)  
Order → OrderItem (1:M)

## API Testing
All APIs were tested using Postman.

https://rupalbiswal24-275152.postman.co/workspace/be5c72f7-6903-46fc-8d32-3aa60bac30e8/collection/52611589-55e2beed-58d1-422c-b88a-0839b9cc1c50?action=share&source=copy-link&creator=52611589

#screenshot
All the screenshots of APIs and DATAbase are in the folder after testing and getting the results of the project in the screenshot folder.
The ER diagram and the Architecture Diagram are also in the Diagrams folder.
EcommerceBackendProject/
README.md
ecommerce-postman-collection.json
schema.sql
screenshots/
   login-api.png
   product-api.png
   cart-api.png
   order-api.png
   database.png
diagrams/
   ER-diagram.png
   architecture-diagram.png

## GitHub Repository
https://github.com/RupalTheGreat/ecommerce-backend
