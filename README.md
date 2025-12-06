📘 Java Programming – Assignment 01
Banking Application for Account Management
School of Engineering & Technology (SOET)
Session: 2025–26
🧑‍🎓 Student Details
Field	Information
Name	Sabir
Roll No.	2501011308
Programme	B.Tech CS (Core)
Semester	3rd
Section	D
University	K.R. Mangalam University
Father’s Name	Ali Mohammad
Date of Birth	07/01/2003
📚 Course Information

Department: SOET

Course Name: Java Programming

Course Code: ENCS201, ENCA203, ENBC205

Faculty: Dr. Manish Kumar

Assignment Number: 01

Total Marks: 10

Contribution to Internal: 10%

📝 Project Title
Banking Application for Account Management
📌 Problem Statement

Design and implement a Banking Application in Java that allows users to manage their bank accounts by performing the following operations:

Create account

Deposit money

Withdraw money

View account details

Update contact details

The application must use Java control structures, arrays, strings, and OOP concepts.

🎯 Project Objectives (CO1)

Apply Java basics such as data types, variables, operators, and type casting.

Use control structures for decisions and loops.

Implement input handling using the Scanner class.

Handle single-dimensional arrays to store multiple accounts.

Manipulate strings using Java’s String class and methods.

📘 Learning Outcomes

After completing this assignment, students will:

Gain foundational understanding of Java programming.

Learn to write menu-driven console applications.

Understand real-life application development using arrays & strings.

Manage and share code using GitHub.

🧱 Project Requirements & Design
✔ 1. Account Class
Attributes
Attribute	Type	Description
accountNumber	Integer	Unique identifier
accountHolderName	String	Customer name
balance	Double	Current balance
email	String	Contact email
phoneNumber	String	Contact phone
Methods
Method	Description
deposit(double amount)	Deposits money (amount must be positive)
withdraw(double amount)	Withdraws money (must have sufficient balance)
displayAccountDetails()	Displays account information
updateContactDetails(email, phone)	Updates customer contact info
✔ 2. UserInterface Class
Attributes

Array of Account objects

Scanner object for input

Counter for number of accounts

Methods
Method	Description
createAccount()	Creates new bank account
performDeposit()	Deposits amount to selected account
performWithdrawal()	Withdraws amount
showAccountDetails()	Displays full details of an account
updateContact()	Updates email and phone number
mainMenu()	Menu-driven interaction loop
🧪 Sample Interaction
Welcome to the Banking Application!

1. Create a new account
2. Deposit money
3. Withdraw money
4. View account details
5. Update contact details
6. Exit

Enter your choice: 1
Enter account holder name: John Doe
Enter initial deposit amount: 1000.0
Enter email address: john.doe@example.com
Enter phone number: 1234567890

Account created successfully with Account Number: 1001

🧹 Validation & Error Handling

Positive amount required for deposit/withdraw

Prevent withdrawal beyond balance

Input validation for numeric fields

Non-empty validation for strings

🧩 Technologies Used

Java 8+

OOP (Classes, Objects, Methods)

Arrays for data storage

Scanner API

Control Structures (if, switch, loops)

String Handling

🏆 Evaluation Rubric (10 Marks)
Criterion	Points
Account Class Implementation	2
User Interface Operations	2
Proper Use of Control Structures	1
Array & Data Management	1
String Handling	1
Input Validation	1
Modularity & Code Quality	1
Comments & Readability	1
▶️ How to Run the Program
1. Compile
javac BankingApplication.java

2. Run
java BankingApplication

📤 Submission Instructions

Submit individually via GitHub

Upload the repository link to the KRMU LMS

Deadline: 5th September, 2025

Must follow classroom formatting rules

Use of ChatGPT is strictly prohibited in written submission

✔️ Author

Sabir
Roll No. 2501011308
B.Tech CS (Core), Section D
K.R. Mangalam University
