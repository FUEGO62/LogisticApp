package org.BankApp;

import java.util.Scanner;

public class Main {

    static Bank bank = new Bank("FirstBank");
    static Bank bank2 = new Bank("SecondBank");

    public static void main(String[] args) {

        mainMenu();
    }

    public static void mainMenu() {
        int choice = 0;
        try {
            choice = Integer.parseInt(input("""
                    
                    Welcome to FirstBank
                    
                    1.) create an account.
                    2.) deposit
                    3.) withdraw
                    4.) transfer
                    5.) check balance
                    6.) change password
                    7.) transfer to an account in another bank
                    8.) exit
                    
                    """));
        } catch (IllegalArgumentException e) {
            display("Integer values only");
            mainMenu();
        } finally {
            processInput(choice);
        }
    }

    public static void display(String content){
        System.out.println(content);
    }

    public static String input(String content){
        display(content);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void processInput(int choice){

        switch(choice){
            case 1: createAccount(); break;
            case 2: deposit(); break;
            case 3: withdraw(); break;
            case 4: transfer(); break;
            case 5: checkBalance(); break;
            case 6: changePin(); break;
            case 7: transferToBank(); break;
            case 8: System.exit(0); break;
            default: display("Invalid choice");

        }
        mainMenu();
    }

    public static void createAccount() {
        String firstName = input("Enter your first name: ");
        String lastName = input("Enter your last name: ");
        String pinCode = input("Enter your PIN code: ");
       String acctNo = bank.createAccount(firstName, lastName, pinCode);
        display("Your account number is: " + acctNo);
    }

    private static void checkBalance() {
        String accountNumber = input("Enter account number: ");
        String password = input("Enter password: ");
        try {
            display(bank.checkBalance(accountNumber, password) + "");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }
    }

    public static void deposit() {
        String acctNo = input("Enter account number");
        double amount =0;
        try {
            amount = Double.parseDouble(input("Enter amount to deposit"));
            bank.deposit(acctNo, amount);
            display("Deposited " + amount + " to " + acctNo);
        }
        catch (NumberFormatException e) {
            display("Number values only");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }
    }

    public static void withdraw() {
        String acctNo = input("Enter account number");
        String pin = input("Enter pin code");
        try {
            double amount = Double.parseDouble(input("Enter amount to withdraw"));
            bank.withdraw(acctNo, amount, pin);
            display("Withdrawn " + amount + " from " + acctNo);
        }
        catch (NumberFormatException e) {
            display("Number values only");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }
    }

    public static void transfer() {
        String sender = input("Enter your account number");
        String recipient = input("Enter recipients account number");
        String pinCode = input("Enter your PIN code");
        try {
            double amount = Double.parseDouble(input("Enter amount to transfer"));
            bank.transfer(sender, recipient, amount, pinCode);
            display("Transferred " + amount + " to " + recipient);
        }
        catch (NumberFormatException e) {
            display("Number values only");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }
    }

    public static void transferToBank() {

        createRandomAccounts();

        String sender = input("Enter your account number");
        String bankName = input("Enter bank name");
        String recipient = input("Enter recipients account number");
        String pinCode = input("Enter your PIN code");
        try {
            double amount = Double.parseDouble(input("Enter amount to transfer"));
            bank.transfer(bankName,sender, recipient, amount, pinCode);
            display("Transferred " + amount + " to " + recipient);
        }
        catch (NumberFormatException e) {
            display("Number values only");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }
    }

    public static void changePin() {
        try {
            String accountNumber = input("Enter account number");
            String pinCode = input("Enter old pin code");
            String newPinCode = input("Enter new pin code");
            bank.updatePinCode(accountNumber, pinCode, newPinCode);
            display("pin code changed successfully");
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            mainMenu();
        }

    }

    public static void createRandomAccounts() {
        bank2.createAccount("name","name","pincode");
        bank2.createAccount("name","name","pincode");
        bank2.createAccount("name","name","pincode");
        
    }
}
