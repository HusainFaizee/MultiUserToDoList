# MultiUserToDoList
A web-based task management application using Java and Spring Boot with persistent MySQL storage, with mutiple users and completion timestamps.
Features:
Multiple User Profiles: Create and select different user profiles.
Individual Task Lists: Each profile has its own independent collection of tasks.
Task Management: Add and manage tasks.
Completion Tracking: Toggle task completion status.
Completion Timestamps: Automatically record when a task is completed.
Persistent Storage: Store users and tasks using MySQL.

Technologies Used:
Java
Spring Boot (Libraries for GET and POST end-points)
Spring Data JPA
MySQL
Thymeleaf (Front-end)
Bootstrap (CSS)
Maven

Project Structure:
controller – Handles HTTP requests and application routes.
models – Contains the User and Task entities.
repository – Handles database operations.
services – Contains application business logic.
templates – Contains the Thymeleaf frontend pages.

Setup:
Clone the repository.
Create a MySQL database named todo-app.
Configure your database credentials using environment variables:
DB_PASSWORD
Run the application using Maven or IntelliJ IDEA.
Open http://localhost:8080/users in your browser.

Future Improvements:
Spring Security authentication and authorization.
Database-backed user accounts.
User-specific access control.
