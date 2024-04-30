import java.util.Scanner;

// BankAccount class represents a bank account with deposit, withdrawal, and balance functionalities
class BankAccount {
    private double balance; // balance stores the current balance of the account

    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance for withdrawal
        }
    }

    // Method to retrieve the current balance of the account
    public double getBalance() {
        return balance;
    }
}

// ATM class represents an Automated Teller Machine with options for banking operations
class ATM {
    private BankAccount account; // account represents the bank account associated with the ATM
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user choices
    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check the balance of the account
    private void checkBalance() {
        System.out.println("Your balance is: R" + account.getBalance());
    }

    // Method to handle deposit operation
    private void deposit() {
        System.out.print("Enter the amount to deposit: R");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful! Your new balance is: R" + account.getBalance());
    }

    // Method to handle withdrawal operation
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: R");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Your new balance is: R" + account.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// Main class to demonstrate the ATM functionality
public class ATMMachine {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of 1000
        BankAccount account = new BankAccount(1000);
        // Create an ATM object with the bank account
        ATM atm = new ATM(account);
        // Display the ATM menu
        atm.displayMenu();
    }
}
