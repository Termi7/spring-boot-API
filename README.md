# Spring Boot Backend END

This is a simple backend API project that responds to requests and provides data to a customer-facing application.

## Features

- Implements CRUD operations (Create, Read, Update, Delete)
- Provides RESTful API endpoints for the customer application
- Built using Spring Boot framework
- Uses a MySQL database to store and retrieve data
- Provides error handling and input validation

## Technologies Used

- Java 10
- Spring Boot


## Getting Started

To run this project, follow these steps:

1. Clone this repository to your local machine
2. Import the project into your preferred IDE (e.g. IntelliJ, Eclipse)
3. Configure the MySQL database connection in the `application.properties` file
4. Run the application

## Usage

The API endpoints can be tested using a tool like Postman or a web browser. Here are some example requests:

- `GET /api/customers`: Get a list of all customers
- `GET /api/customers/{id}`: Get a single customer by ID
- `POST /api/customers`: Create a new customer
- `PUT /api/customers/{id}`: Update an existing customer
- `DELETE /api/customers/{id}`: Delete a customer by ID

