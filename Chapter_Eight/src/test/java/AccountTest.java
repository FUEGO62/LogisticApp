import org.BankApp.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void testThatNewAccountCreatedHasABalanceOfZero() {
        Account account = new Account("Name","correctPin");
        double balance = account.checkBalance("correctPin");
        assertEquals(balance,0);
    }

    @Test
    public void testThatDeposit2kBalanceIs2k(){
        Account account = new Account("Name","correctPin");
        account.deposit(2000);
        double balance = account.checkBalance("correctPin");
        assertEquals(balance,2000);
    }

    @Test
    public void testThatDeposit4kWithdraw2kBalanceIs2k(){
        Account account = new Account("Name","correctPin");
        account.deposit(4000);
        account.withdraw("correctPin",2000);
        double balance = account.checkBalance("correctPin");
        assertEquals(balance,2000);
    }

    @Test
    public void testThatDepositThrowsExceptionWithInvalidAmount(){
        Account account = new Account("Name","correctPin");
        assertThrows(IllegalArgumentException.class,()->account.deposit(-2000));
    }

    @Test
    public void testThatWithdrawThrowsExceptionWithInvalidAmount(){
        Account account = new Account("Name","correctPin");
        account.deposit(4000);
        assertThrows(IllegalArgumentException.class,()->account.withdraw("correctPin",-2000));
    }

    @Test
    public void testThatWithdrawThrowsExceptionWithAmountLargerThanBalance(){
        Account account = new Account("Name","correctPin");
        assertThrows(IllegalArgumentException.class,()->account.withdraw("correctPin",2000));
    }

    @Test
    public void testThatWithdrawThrowsExceptionWithInvalidPinCode(){
        Account account = new Account("Name","correctPin");
        account.deposit(4000);
        assertThrows(IllegalArgumentException.class,()->account.withdraw("wrongPin",10));
    }
}
