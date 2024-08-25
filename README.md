# Bank Management System

## Project Overview

The Bank Management System is a web-based application developed in Java using Servlets and SQL for database management. The application allows users to create bank accounts, log in to their accounts, and perform various banking operations such as depositing, withdrawing, and deleting their accounts. The system is designed with simplicity in mind, providing an intuitive user interface and secure management of account details.

## Features

### Account Creation:
- Users can create a new bank account by providing their details such as name, account type, account number, balance, and password.
- After account creation, users can view their account information and have the option to either return to the home page or log in to their account.

### Account Login:
- Users can log in to their accounts using their account number and password.
- Upon successful login, users can view their account details and choose from the following options:
  - **Withdraw:** Allows users to withdraw money by entering the desired amount and their account number.
  - **Deposit:** Allows users to deposit money by entering the amount to be deposited and their account number.
  - **Delete Account:** Users can permanently delete their account from the system, receiving a confirmation message upon successful deletion.

## Technologies Used
- **Java:** Core programming language for the application.
- **Servlets:** To handle the server-side processing of requests and responses.
- **SQL (XAMPP):** For database management, where user account information is stored. The database consists of a single table named `account`.

## Database Schema

The application uses an SQL database with a single table `account`. Below is the schema for the account table:

- **acc_no:** Primary Key, unique identifier for each account (Integer).
- **name:** Name of the account holder (String).
- **atype:** Type of the account (String).
- **balance:** Current balance in the account (Double).
- **password:** Account password (String).

## Installation and Setup

### Clone the Repository:
Clone this project repository to your local machine.

### Set Up the Database:
- Use XAMPP or any other SQL server to set up the database.
- Create a database and a table named `account` with the schema provided above.
- Import the `accounts.sql` file provided in the project directory to populate the database schema.

### Configure the Project:
- Open the project in your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).
- Ensure that the Java Servlet API and SQL connector are correctly added to the project’s classpath.
- Update the database connection details in the Java code to match your local setup.

### Run the Application:
- Deploy the application on a servlet container like Apache Tomcat.
- Access the application via the web browser using `http://localhost:8080/YourAppName/`.

## Usage

### Home Page:
The home page (`index.jsp`) welcomes the user and offers two options: Create Account or Login.

### Create Account:
- Choose the "Create Account" option to fill out the account creation form with necessary details.
- Submit the form to create the account and view the account details.

### Login:
- Choose the "Login" option to enter your account number and password.
- Upon successful login, you will be able to view your account details and perform transactions (withdraw, deposit, delete account).

## Future Enhancements
- Adding more functionalities such as transaction history, account transfer, and profile management.
- Implementing user authentication and security measures to protect sensitive information.
- Improving the user interface with modern design practices.

## Contributing
Contributions to the project are welcome! Please feel free to fork the repository and submit pull requests.

## License
This project is licensed under the MIT License.
