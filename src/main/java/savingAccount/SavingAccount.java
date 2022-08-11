package savingAccount;

/**
 * FileName: SavingAccount
 * author: gxs
 * Date: 2022/8/11  10:11
 */
public class SavingAccount {

    private int balance = 0;
    public void deposit(int amount) {
        balance = amount;
    }

    public int balance() {
        return balance;
    }

    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount();
        System.out.println(savingAccount.balance());
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}
