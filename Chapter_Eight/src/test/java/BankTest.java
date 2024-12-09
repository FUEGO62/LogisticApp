import org.BankApp.Bank;
import org.BankApp.PaymentProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    @Test
    public void testThatBankCanCreateAccountAndReturnAcctNumber() {
        Bank bank = new Bank("Guarantee trust");
        String acctNo = bank.createAccount("firstName","lastName","correctPin");
        assertEquals(acctNo, "10001");
        assertEquals(1,bank.getNumberOfAccounts());
    }

    @Test
    public void testThatBankCanTransfer(){
        Bank bank = new Bank("Guarantee trust");
        String sender = bank.createAccount("firstName","lastName","correctPin");
        String recipient = bank.createAccount("secondName","lastName","correctPin");
        bank.deposit(sender,3000);
        bank.transfer(sender,recipient,1000,"correctPin");
        assertEquals(2000,bank.checkBalance(sender,"correctPin"));
        assertEquals(1000,bank.checkBalance(recipient,"correctPin"));
    }

    @Test
    public void testThatBankCanTransferToOtherBanks(){
        Bank GTB = new Bank("Guarantee trust");
        Bank access = new Bank("Access");

        String sender = GTB.createAccount("firstName","lastName","correctPin");
        String recipient = access.createAccount("secondName","lastName","correctPin");

        GTB.deposit(sender,3000);
        GTB.transfer("Access",sender,recipient,1000,"correctPin");
        assertEquals(1000,access.checkBalance(recipient,"correctPin"));

    }

    @Test
    public void testThatBankThrowsExceptionWithAccountNotFound(){
        Bank bank = new Bank("Guarantee trust");
        assertThrows(IllegalArgumentException.class, () ->bank.deposit("invalidNumber",1000));
    }

}
