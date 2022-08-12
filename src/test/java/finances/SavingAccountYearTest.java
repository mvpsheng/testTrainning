package finances;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;


/**
 * FileName: SavingAccountTests
 * author: gxs
 * Date: 2022/8/11  10:08
 */
public class SavingAccountYearTest {
    @Test
    public void endingBalanceAppliesInterestRate() {
        SavingAccountYear account = newAccount();
        assertEquals(11000, account.endingBalance(25));
    }

    @Test
    public void interestRate() {
        SavingAccountYear account = newAccount();
        assertEquals(10, account.interestRate());
    }

    @Test
    public void thisYearEndingBalanceShouldEqualsNextYearStartingBalance() {
        SavingAccountYear account = newAccount();
        assertEquals(account.endingBalance(25), account.nextYear(25).startingBalance());
    }

    @Test
    public void nextYearInterestRateEqualsThisYearsInterestRate() {
        SavingAccountYear account = newAccount();
        assertEquals(account.interestRate(), account.nextYear(25).interestRate());
    }

    @Test
    public void withdrawingFundsOccursAtTheBeginningOfTheYear() {
        SavingAccountYear year = new SavingAccountYear(10000, 10);
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance(25));
    }

//    @Test
//    public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
//        SavingAccountYear year = new SavingAccountYear(10000, 7000,10);
//        year.withdraw(3000);
//        assertEquals(7700, year.endingBalance());
//        year.withdraw(5000);
//        assertEquals(2000 + 200 - (1250), year.endingBalance());
//    }

    @Test
    public void startingPrincipal() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        assertEquals(3000, year.startingPrincipal());
    }
    @Test
    public void endingPrincipal() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        assertEquals(3000, year.startingPrincipal());
        year.withdraw(2000);
        assertEquals(1000, year.endingPrincipal());
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        assertEquals("StartingPrincipal", 3000, year.startingPrincipal());
        year.withdraw(4000);
        assertEquals("endingPrincipal", 0, year.endingPrincipal());
    }
    @Test
    public void multipleWithdrawsInAYear() {
        SavingAccountYear year = new SavingAccountYear(10000, 10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals(3000, year.totalWithdrawn());
    }

    @Test
    public void capitalGainsWithdrawn() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        year.withdraw(2000);
        assertEquals(0, year.capitalGainsWithdraw());
        year.withdraw(4000);
        assertEquals(3000, year.capitalGainsWithdraw());
    }

    @Test
    public void capitalGainsTaxIncurred() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        year.withdraw(5000);
        assertEquals(2000, year.capitalGainsWithdraw());
        assertEquals(500, year.capitalGainsTaxIncurred(25));
    }

    @Test
    public void capitalGainsTaxIsIncludedInEndBalance() {
        SavingAccountYear year = new SavingAccountYear(10000, 3000, 10);
        year.withdraw(5000);
        assertEquals(500, year.capitalGainsTaxIncurred(25));
        assertEquals(10000 - 5000 - 50, year.endingBalance(25));

//        TODO: Need to withdraw enough money to cover capital gains tax;that money will also be taxed
    }
    public SavingAccountYear newAccount() {
        SavingAccountYear account = new SavingAccountYear(10000, 10);
        return account;
    }
}
