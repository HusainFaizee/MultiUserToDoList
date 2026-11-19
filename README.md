# MultiUserToDoList
A web-based task management application using Java and Spring Boot with persistent MySQL storage, with mutiple users and completion timestamps.
Features:<br>
Multiple User Profiles:<br>
Create and select different user profiles.<br>
Individual Task Lists: Each profile has its own independent collection of tasks.<br>
Task Management: Add and manage tasks.<br>
Completion Tracking: Toggle task completion status.<br>
Completion Timestamps: Automatically record when a task is completed.<br>
Persistent Storage: Store users and tasks using MySQL.<br>

Technologies Used:<br>
Java<br>
Spring Boot (Libraries for GET and POST end-points)<br>
Spring Data JPA<br>
MySQL<br>
Thymeleaf (Front-end)<br>
Bootstrap (CSS)<br>
Maven<br>

Project Structure:<br>
controller – Handles HTTP requests and application routes.<br>
models – Contains the User and Task entities.<br>
repository – Handles database operations.<br>
services – Contains application business logic.<br>
templates – Contains the Thymeleaf frontend pages.<br>

Setup:
Clone the repository.<br>
Create a MySQL database named todo-app.<br>
Configure your database credentials using environment variables: DB_PASSWORD<br>
Run the application using Maven or IntelliJ IDEA.<br>
Open http://localhost:8080/users in your browser.<br>

Future Improvements:
Spring Security authentication and authorization.
Database-backed user accounts.
User-specific access control.
