🌟 ATM Simulator System 🌟

ATM Simulator System is a Java-based desktop application designed to simulate basic ATM operations. This project features a user-friendly graphical interface, secure user authentication, and database integration to manage user data efficiently.

🚀 Features

✅ User Authentication: Secure login functionality.
✅ Balance Inquiry: Check account balance in real-time.
✅ Deposit Funds: Add funds to your account.
✅ Withdraw Funds: Safely withdraw money.
✅ PIN Change: Update your account PIN securely.
✅ Mini-Statements: View recent transactions.

🛠️ Technologies Used

Programming Language: Java
Database: MySQL
Database Connectivity: JDBC (Java Database Connectivity)
User Interface: Java Swing


⚙️ Installation and Setup

Follow these steps to set up and run the ATM Simulator System:

Prerequisites

Java Development Kit (JDK) 8 or higher

MySQL Server

MySQL Connector/J

Steps

Clone the Repository:

git clone https://github.com/eigen04/ATM_SIMULATOR_SYSTEM.git

Import the Project:
Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

Set Up the Database:

Create a MySQL database using the provided script in database.sql.

Update the database connection details in the Java code (DBConnection.java):

String url = "jdbc:mysql://localhost:3306/your_database_name";
String username = "your_username";
String password = "your_password";

Build and Run:

Compile the project.

Run the main class to start the application.

🧑‍💻 Usage

Launch the application.

Log in using your credentials.

Perform various ATM operations like balance inquiry, deposit, and withdrawal.

View mini-statements or update your PIN as needed.

🤝 Contributing

Contributions are welcome! If you'd like to improve the project:

Fork the repository.

Create a feature branch.

Submit a pull request with a clear description of the changes.


🙏 Acknowledgments

Special thanks to all resources and tutorials that helped in building this project.


