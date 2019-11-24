// Java implementation of a simple bank account store
// Created: 2019-10-02
// Author: Xano Sweeting
// License: MIT


// $ javac BankAccount.java && java BankAccount
//
// Welcome to Xano's Bank, lets get you set up with a new account!
// -------------------------------------------------
// Your Name (e.g. John Doe): Captain Jack Sparrow
// Starting Balance (e.g. 100 for $100): 1333337
// Interest rate (e.g. 0.01 for 1%): 0.025
// -------------------------------------------------
// Creating new bank cccount for Captain Jack Sparrow:
// $1333337.00 starting balance (with 2.50% interest)...
// Congradulations, you now have an account Captain Jack Sparrow!
// -------------------------------------------------
// Bank Account for Captain Jack Sparrow: $1333337.00 (2.50% interest)

/*
import java.util.Scanner;


public class BankAccount {
    private String name;
    private double balance;
    private double interest;

    // Constructors
    public BankAccount() {
        this.name = "Unkown";
        this.balance = 0.0;
        this.interest = 0.001;
    }
    public BankAccount(String name) {
        this.name = name;
        this.balance = 0.0;
        this.interest = 0.001;
    }
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.interest = 0.001;
    }
    public BankAccount(String name, double balance, double interest) {
        this.name = name;
        this.balance = balance;
        this.interest = interest;
    }


    // Getters & Setters
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(double amount) {
        // Check to make sure we don't go into negative balance before withdraw
        if (balance - amount < 0) {
            throw new ArithmeticException(
                "You don't have enough money to withdraw that much"
            );
        }
        balance = balance - amount;
        return balance;
    }

    public double deposit(double amount) {
        balance = balance + amount;
        return balance;
    }


    // Helpers
    public String toString() {
        return String.format(
            // %s means put some text here (inserted from the arguments in order, e.g. name)
            // %.2f means put a number here but only show 2 decimal places *e.g. 
            // %% just prints % (bc % is a special symbol that has to be escaped)
            "Bank Account for %s: $%.2f (%.2f%% interest)",
            name, balance, interest * 100
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "Welcome to Xano's Bank, lets get you set up with a new account!"
        );
        System.out.println("-------------------------------------------------");
        
        System.out.print("Your Name (e.g. John Doe): ");
        String name = scanner.nextLine();

        System.out.print("Starting Balance (e.g. 100 for $100): ");
        double balance = scanner.nextDouble();

        System.out.print("Interest rate (e.g. 0.01 for 1%): ");
        double interest = scanner.nextDouble();

        System.out.println("-------------------------------------------------");
        
        System.out.printf(
            "Creating new bank cccount for %s:\n" +
            "$%.2f starting balance " + 
            "(with %.2f%% interest)...\n",
            name, balance, interest * 100
        );
        BankAccount account = new BankAccount(name, balance, interest);
        
        System.out.printf("Congradulations, you now have an account %s!\n", account.getName());
        
        System.out.println("-------------------------------------------------");
        
        System.out.println(account);

        
        // TODO: ask the user if they want to deposit/withdraw money
    }
}
