# Bank Management System (Java Swing)

A robust and feature-rich ATM-style Bank Management System implemented in Java with Swing for GUI, MySQL for backend data storage, and integrated email and SMS notifications. This project simulates a real-world banking environment with multiple user services including deposits, withdrawals, loans, and account management, designed for educational and demonstration use.

---

## Features

- **User Authentication:**  
  Secure login functionality via card number and PIN.

- **Cash Management:**  
  - Cash Deposit  
  - Cash Withdrawal  
  - Fast Cash withdrawal with preset amounts

- **Balance Enquiry:**  
  View current account balance calculated from transactions.

- **Transaction History (Mini-Statement):**  
  Displays recent transactions with credit and debit details in tabular form.

- **PIN Management:**  
  Safely change the ATM PIN with validation.

- **Loan Management:**  
  - Apply for loans  
  - Repay loans  
  - Check current loan status and outstanding amounts

- **Account Registration:**  
  Multi-page sign-up capturing detailed personal, contact, and account preferences.

- **Email & SMS Notifications:**  
  Sends transaction alerts and loan updates via email (JavaMail API) and SMS (Twilio API).

- **Data Persistence:**  
  Uses MySQL database accessed through JDBC for storing all user and transaction data.

- **User-Friendly GUI:**  
  Professional-looking Swing interfaces with background images, clear layouts, and real-time feedback.

---

## Project Structure

- `ASimulatorSystem` package containing all GUI screens and functional classes:
  - `Login`  
  - `Signup`, `Signup2`, `Signup3` (Multi-step user registration)  
  - `Deposit`, `Withdrawl`, `FastCash`  
  - `BalanceEnquiry`, `MiniStatement`, `Pin`  
  - `LoanApplication`, `LoanRepayment`, `LoanStatus`  
  - `Transactions` (Main menu)  
  - `Conn` (Database connectivity class)  
  - `EmailSender` (Email notification utility)  
  - `SmsSender` (SMS notification utility)

---

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- JDBC Driver for MySQL (Connector/J)
- Internet connection for email and SMS sending
- Libraries included in project:
  - JavaMail API (for email)
  - Twilio Java SDK (for SMS)

### Database Setup

1. Create a MySQL database named `bankmanagementsystem`.
2. Create the following key tables (basic structure example):

```
CREATE TABLE login (
  formno VARCHAR(20),
  cardno VARCHAR(16) PRIMARY KEY,
  pin VARCHAR(4)
);

CREATE TABLE bank (
  pin VARCHAR(4),
  date DATETIME,
  mode VARCHAR(20),
  amount VARCHAR(10)
);

CREATE TABLE signup (
  formno VARCHAR(20),
  name VARCHAR(100),
  fname VARCHAR(100),
  dob VARCHAR(15),
  gender VARCHAR(10),
  email VARCHAR(100),
  marital VARCHAR(20),
  address VARCHAR(200),
  city VARCHAR(100),
  pincode VARCHAR(10),
  state VARCHAR(100)
);

CREATE TABLE signup2 ( ... ); -- For additional user details
CREATE TABLE signup3 ( ... ); -- Account preferences and card/PIN info
CREATE TABLE loan (
  pin VARCHAR(4),
  date DATETIME,
  type VARCHAR(20),   -- 'Loan' or 'Repayment'
  amount VARCHAR(10)
);
```

3. Adjust database username/password in `Conn.java` accordingly.

### Building and Running

- Compile all Java files (use your IDE or command line):

```
javac -cp ".:/path/to/mysql-connector.jar:/path/to/mail.jar:/path/to/twilio.jar" ASimulatorSystem/*.java
```

- Run the application starting from the `Login` class:

```
java -cp ".:/path/to/mysql-connector.jar:/path/to/mail.jar:/path/to/twilio.jar" ASimulatorSystem.Login
```


## Usage Instructions

1. **Launch the app** and log in using your card number and PIN.
2. Navigate through the main menu to perform:
   - Deposit cash
   - Withdraw cash or fast cash options
   - View your current balance
   - Check mini statement (recent transactions)
   - Change your PIN securely
   - Apply for, repay, or check loan status
3. **New users** can register via the multi-page sign-up forms collecting detailed information.
4. Receive **notifications** on every transaction or loan action via email and SMS.

---

## Screenshots
![1](path/to/image1.png)
![2](path/to/image2.png)
![3](path/to/image3.png)
![4](path/to/image4.png)
![5](path/to/image5.png)

---

## Technologies Used

- Java SE (Swing framework for UI)
- MySQL with JDBC
- JavaMail API (Email notifications)
- Twilio Java SDK (SMS notifications)
- OOP principles and event-driven programming
- Images and icons for enhanced UI experience

---

## Limitations

- No real banking backend or network transactions; this is a simulation.
- SMS and email require valid Twilio/Gmail credentials and internet access.
- Error handling can be improved for some edge cases.
- PINs and sensitive data are stored in plaintext in DB – not secure for production use.

---

## Educational Value

This project demonstrates:

- Building GUI applications with Swing
- Database connectivity and operations in Java
- Working with external APIs (email/SMS) in Java
- Simulating banking workflows and user interaction
- Organizing a multi-class project with clean code structure

---
## License

This project is for educational and demonstration purposes only. Feel free to fork, modify, and learn from the code.
---
*Thank you for checking out the Bank Management System!*
