# Haibazo Ecommerce Back End Test

# E-commerce API Project

## Introduction

This project is a comprehensive E-commerce API built using Spring Boot. It provides a complete CRUD (Create, Read, Update, Delete) functionality for various entities involved in an e-commerce platform. The API is designed to facilitate the management of products, customers, orders, payments, reviews, and shopping carts.

## Features

- **Entities and CRUD Operations:**
  - **Cart**: Manage shopping carts for customers.
  - **CartItem**: Handle items within a shopping cart.
  - **Category**: Organize products into categories.
  - **Customer**: Manage customer profiles and information.
  - **Order**: Process customer orders.
  - **OrderDetail**: Detail of products within each order.
  - **Payment**: Manage payment transactions.
  - **Product**: Handle product details and inventory.
  - **Review**: Allow customers to leave reviews for products.

- **Sample Data**: The project includes sample data for testing purposes.

- **Postman Collection**: A comprehensive Postman collection is provided to test all API endpoints easily.

## Technologies Used

- Java 17
- Spring Boot
- MySQL
- Postman for API testing

## API Endpoints

### Base URL
http://localhost:8081/api
## Authentication
This project does not implement authentication, but it is recommended to secure sensitive endpoints in a production environment.

### Sample Endpoints

- **Get All Products**: `GET /products/all_product`
- **Create Customer**: `POST /customers`
- **Get Payment by ID**: `GET /payments/{id}`
- **Create Order**: `POST /orders`

(Include more endpoints as necessary...)

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-name>
## application.properties file
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
