package savingAccount;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;


/**
 * FileName: SavingAccountTests
 * author: gxs
 * Date: 2022/8/11  10:08
 */
public class SavingAccountTest {
    @Test
    public void depositAndWithDrawal() {
        SavingAccount account = new SavingAccount();
        account.deposit(100);
        assertEquals("after deposit ", 100, account.balance());
        account.withdraw(50);
        assertEquals("after withdrawal", 50, account.balance());
    }

    @Test
    public void negativeBalanceIsFine() {
        SavingAccount account = new SavingAccount();
        account.withdraw(75);
        assertEquals(-75, account.balance());
    }
}
