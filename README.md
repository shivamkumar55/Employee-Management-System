
# Employee Management REST API

A backend REST API built using **Spring Boot** for managing employee records.  
This project is created as a practice project to understand **REST APIs, CRUD operations, layered architecture, Spring Data JPA, and MySQL**.

## 🚀 Features

- Create a new employee
- Get all employees
- Get employee by ID
- Update employee details
- Delete an employee
- RESTful API architecture
- MySQL database integration
- Spring Data JPA for database operations
- Layered architecture using Controller, Service, and Repository

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Postman
- IntelliJ IDEA / VS Code

## 🏗️ Architecture

The project follows a layered architecture:

```text
Client / Postman
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
MySQL Database
```

### Controller

Handles HTTP requests and responses.

### Service

Contains the application's business logic.

### Repository

Communicates with the database using Spring Data JPA.

### Entity

Represents the employee data and maps the Java object to the database table.
