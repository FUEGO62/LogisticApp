package org.BankApp;

import java.util.ArrayList;

public class Bank {

    public PaymentProcessor processor;
    private String bankName;
    private ArrayList<Account> accounts = new ArrayList<>();
    private int counter;

    public Bank(String bankName) {
        processor.addBank(this);
        this.bankName = bankName;
        counter = 0;
    }

    public String getName() {
        return bankName;
    }

    public String createAccount( String firstName, String lastName , String pinCode) {

        counter ++;
        String fullName = firstName + " " + lastName;
        Account account = new Account(fullName, pinCode);
        account.setAccountNumber(generateAccountNumber(fullName));
        accounts.add(account);
        return account.getAccountNumber();
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccountByNumber(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount,String pinCode) {
        Account account = findAccountByNumber(accountNumber);
        account.withdraw(pinCode, amount);
    }

    public void transfer(String sender, String recipient, double amount,String pinCode) {
        Account senderAccount = findAccountByNumber(sender);
        Account recipientAccount = findAccountByNumber(recipient);
        senderAccount.withdraw(pinCode, amount);
        recipientAccount.deposit(amount);

    }

    public void transfer(String BankName,String sender, String recipient, double amount,String pinCode) {
        Bank bank = processor.getBank(BankName);
        withdraw(sender, amount, pinCode);
        bank.deposit(recipient, amount);
    }

    public void updatePinCode(String accountNumber, String oldPinCode, String newPinCode) {
        Account account = findAccountByNumber(accountNumber);
        account.updatePinCode(oldPinCode, newPinCode);
    }

    public double checkBalance(String accountNumber, String pinCode) {
        Account account = findAccountByNumber(accountNumber);
        return  account.checkBalance(pinCode);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    private String generateAccountNumber(String name) {
       String accountNumber = "";

       for (int i =0; i< 3;i++) {
           accountNumber += (int)bankName.charAt(i);
       }

      return String.format("%s%d", accountNumber,  counter);

    }

    private Account findAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }
}
