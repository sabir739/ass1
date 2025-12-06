/*
 * Java Programming - Assignment 01
 * Project Title: Banking Application for Account Management
 *
 * Student Name  : Sabir
 * Roll No       : 2501011308
 * Programme     : B.Tech CS (Core)
 * Section       : D
 * University    : K.R. Mangalam University
 * Faculty       : Dr. Manish Kumar
 */

import java.util.Scanner;

// ========================= Account Class =============================
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String accountHolderName, double balance,
                   String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Deposit method: amount must be positive
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive. Deposit failed.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    // Withdraw method: amount must be positive and balance must be enough
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive. Withdrawal failed.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("----- Account Details -----");
        System.out.println("Account Number   : " + accountNumber);
        System.out.println("Account Holder   : " + accountHolderName);
        System.out.println("Email            : " + email);
        System.out.println("Phone Number     : " + phoneNumber);
        System.out.println("Current Balance  : " + balance);
        System.out.println("---------------------------");
    }

    // Update contact details
    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully.");
    }
}

// ========================= User Interface Class ======================
class UserInterface {
    private Account[] accounts;
    private int accountCount;
    private Scanner sc;
    private int nextAccountNumber;

    public UserInterface() {
        // max 100 accounts for this assignment
        accounts = new Account[100];
        accountCount = 0;
        sc = new Scanner(System.in);
        nextAccountNumber = 1001; // starting account number
    }

    // Create a new account
    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = readNonEmptyString("Account holder name");

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = readPositiveDouble("Initial deposit amount");

        System.out.print("Enter email address: ");
        String email = readNonEmptyString("Email address");

        System.out.print("Enter phone number: ");
        String phone = readNonEmptyString("Phone number");

        if (accountCount >= accounts.length) {
            System.out.println("Cannot create more accounts. Limit reached.");
            return;
        }

        int accountNumber = nextAccountNumber++;
        Account newAccount = new Account(accountNumber, name, initialDeposit, email, phone);
        accounts[accountCount] = newAccount;
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    // Handle deposit operation
    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        Account account = findAccountByNumber(accNo);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = readPositiveDouble("Deposit amount");

        account.deposit(amount);
    }

    // Handle withdrawal operation
    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        Account account = findAccountByNumber(accNo);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = readPositiveDouble("Withdrawal amount");

        account.withdraw(amount);
    }

    // Show account details
    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        Account account = findAccountByNumber(accNo);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayAccountDetails();
    }

    // Update contact details
    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = readInt();

        Account account = findAccountByNumber(accNo);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter new email address: ");
        String email = readNonEmptyString("Email address");

        System.out.print("Enter new phone number: ");
        String phone = readNonEmptyString("Phone number");

        account.updateContactDetails(email, phone);
    }

    // Main menu method
    public void mainMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("Welcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 6.");
            }

        } while (choice != 6);
    }

    // ================= Helper Methods =================

    private Account findAccountByNumber(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    private int readInt() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }

    private double readPositiveDouble(String fieldName) {
        while (true) {
            String input = sc.nextLine();
            try {
                double value = Double.parseDouble(input.trim());
                if (value <= 0) {
                    System.out.print(fieldName + " must be positive. Enter again: ");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Enter " + fieldName + " again: ");
            }
        }
    }

    private String readNonEmptyString(String fieldName) {
        while (true) {
            String input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.print(fieldName + " cannot be empty. Enter again: ");
            } else {
                return input.trim();
            }
        }
    }
}

// ========================= Main Class =============================
public class BankingApplication {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
