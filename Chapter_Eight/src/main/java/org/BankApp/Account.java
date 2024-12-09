package org.BankApp;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private String pinCode;

    public Account(String name, String pinCode) {
        this.name = name;
        this.pinCode = pinCode;
        this.balance = 0;
    }

    public void deposit(double amount) {
        validateNegative(amount);
        this.balance += amount;
    }

    public void withdraw(String pinCode,double amount) {
        validatePinCode(pinCode);
        validateWithdraw(amount);
        this.balance -= amount;
    }

    public void updatePinCode(String oldPinCode, String newPinCode) {
        validatePinCode(oldPinCode);
        this.pinCode = newPinCode;
    }

    public double checkBalance(String pinCode) {
        validatePinCode(pinCode);
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    private void validateNegative(double amount) {
        if (amount<=0) throw new IllegalArgumentException("Amount must be greater than zero");
    }

    private void validateWithdraw(double amount) {
        validateNegative(amount);
        if (amount>this.balance) throw new IllegalArgumentException("Insufficient funds");

    }

    private void validatePinCode(String pinCode) {
        if(!pinCode.equals(this.pinCode)) throw new IllegalArgumentException("PinCode does not match");
    }
}
