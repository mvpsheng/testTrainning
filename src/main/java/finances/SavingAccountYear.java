package finances;

/**
 * FileName: SavingAccount
 * author: gxs
 * Date: 2022/8/11  10:11
 */
public class SavingAccountYear {

    private int startingPrincipal = 0;
    private int startingbalance = 0;
    private int capitalGainsAmount = 0;
    private int totalWithdrawn = 0;
    private int interestRate = 0;
    public SavingAccountYear(int startingBalance, int interestRate) {
        this.startingbalance = startingBalance;
        this.interestRate = interestRate;
    }
    public SavingAccountYear(int startingBalance, int startingPrincipal, int interestRate) {
        this.startingbalance = startingBalance;
        this.startingPrincipal = startingPrincipal;
        this.capitalGainsAmount = startingBalance - startingPrincipal;
        this.interestRate = interestRate;
    }
    public SavingAccountYear() {
    }

//    public int balance() {
//        return startingbalance;
//    }
    public int startingBalance() {
        return startingbalance;
    }
    public void withdraw(int amount) {
        this.totalWithdrawn += amount;
    }
    public void deposit(int amount) {
        this.startingbalance = amount;
    }
    public int interestRate() {
    return interestRate;
}

    public int endingBalance(int capitalGainsTaxRate) {
        int modifiedStart = startingbalance - totalWithdrawn - capitalGainsTaxIncurred(capitalGainsTaxRate);
        return modifiedStart + (modifiedStart * interestRate / 100);
    }
    public SavingAccountYear nextYear(int capitalGainsTaxRate) {
        return  new SavingAccountYear(endingBalance(capitalGainsTaxRate), interestRate);
    }


    public int startingPrincipal() {
        return startingbalance - capitalGainsAmount;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn;
        return Math.max(result, 0);
    }

    public int totalWithdrawn() {
        return totalWithdrawn;
    }

    public int capitalGainsWithdraw() {
        return Math.max(totalWithdrawn - startingPrincipal(), 0);
    }

    public int capitalGainsTaxIncurred(int taxRate) {
        return capitalGainsWithdraw() * taxRate / 100;
    }
}
