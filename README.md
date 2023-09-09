# Books App

## Description

This is a Spring Boot application for managing a list of books. The application allows users to add, update, and delete books, as well as search for books by title for further modification.

## Prerequisites

- JDK 17
- Spring Boot 3

## Role-Based Functionality

The application incorporates Spring Security to implement role-based access control. Depending on the role assigned to a user, different functionalities are available:

### User Role

- **Find Book**: Users with the "User" role can search for books by title. This is useful for finding specific books for further reading or analysis.

### Admin Role

- **Save Book**: Admins can add new books to the database, complete with all relevant details.

- **Update Book**: Admins have the privilege to update the details of existing books, such as the title, author, or ISBN number.

- **Delete Book**: Admins can remove books from the database.

## Default Credentials

### User:

- **Username**: `user`
- **Password**: `password`

### Admin:

- **Username**: `admin`
- **Password**: `adminPass`

## Security Measures

- Passwords for users and admins are encrypted using BCrypt.

- Access to different functionalities is controlled through role-based permissions, ensuring that unauthorized actions are prevented.

## Technologies Used

- **Spring Framework**
    - ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=flat-square&logo=spring-boot)
    - ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=flat-square&logo=spring&logoColor=white)
    - ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white)
    - ![Spring Web](https://img.shields.io/badge/Spring_Web-6DB33F?style=flat-square&logo=spring&logoColor=white)
- **Frontend**
    - ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white)
    - ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white)
    - ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)
    - ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=flat-square&logo=bootstrap&logoColor=white)
- **Others**
    - ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white)
    - ![H2 Database](https://img.shields.io/badge/H2_Database-1BA8D4?style=flat-square&logo=h2-database&logoColor=white)
    - ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)

## Architectural Pattern

The application strictly adheres to the Model-View-Controller (MVC) architectural pattern, which allows for modular and maintainable code structure. It makes use of Spring's annotations to define Controllers, Services, and Repositories.

## Screenshots

Here are some screenshots demonstrating the functionalities of the application:

![List of Books](./images/list.png)
![Update Book](./images/update.png)
![Find Book By Title](./images/find-title.png)
![Validation](./images/validate.png)
![Logout](./images/logout.png)
