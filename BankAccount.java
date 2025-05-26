package Bank;

import java.util.Scanner;

public class BankAccount {
    private double balance;  // private variable to store account balance

    // constructor to initialize balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    // public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("\n[+] Successfully deposited: Php %.2f\n", amount);
            System.out.printf("[=] New balance: Php %.2f\n", balance);
        } else {
            System.out.println("\n[!] Invalid deposit amount.");
        }
    }

    // public method to withdraw money with conditions and validations
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("\n[!] Insufficient funds.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.printf("\n[-] Withdrawal successful: Php %.2f\n", amount);
            System.out.printf("[=] New balance: Php %.2f\n", balance);
        } else {
            System.out.println("\n[!] Invalid withdrawal amount.");
        }
    }

    // public method to check balance
    public double getBalance() {
        return balance;
    }

    // main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0); // an account with an initial balance of 0

        System.out.println("==============================================");
        System.out.println("                 ARC BANK SYSTEM              ");
        System.out.println("==============================================");

        while (true) { // front selection
            System.out.println("\n------------------- MENU --------------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Account Balance");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Choose an option (1-4): ");

            // Input validation for menu choice
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-4): ");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter deposit amount: Php ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Enter a valid amount: Php ");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("\nEnter withdrawal amount: Php ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid input. Enter a valid amount: Php ");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.printf("\n[=] Current account balance: Php %.2f\n", account.getBalance());
                    break;

                case 4:
                    System.out.println("\nThank you for using ARC BANK. Goodbye!");
                    System.out.println("==============================================");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n[!] Invalid choice. Please try again.");
            }
        }
    }
}