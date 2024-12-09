package org.BankApp;

import java.util.ArrayList;

public class PaymentProcessor {

    private static ArrayList<Bank> banks = new ArrayList<>();

    public static void addBank(Bank bank){
        banks.add(bank);
    }

    public static  int getNumberOfBanks(){
        return banks.size();
    }

    public static Bank getBank(String bankName){
        for(Bank bank : banks){
            if(bank.getName().equals(bankName)){
                return bank;
            }
        }
        throw new IllegalArgumentException("Bank not found");
    }

}
