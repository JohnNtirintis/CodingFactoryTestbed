package gr.aueb.cf.ch12.bankapp;

/**
 * Main driver class for the bankapp package.
 * @author Ntirintis John
 */
public class Main {
    public static void main(String[] args) {
        // Create new Accounts
        Account mainAccount = new Account(123, "GR123", "John", "Ntirintis", "1345679SSN", 500);
        Account secondAccount = new Account(456, "GR456", "Fernando", "Alonso", "978654SSN", 33000);

        // Verify that the initial balances are correct
        System.out.println("Initial Balance of mainAccount: " + mainAccount.getAccountBalance());
        System.out.println("Initial Balance of secondAccount: " + secondAccount.getAccountBalance());

        // Test deposit
        mainAccount.deposit(100);
        secondAccount.deposit(1000);
        System.out.println("Balance of mainAccount after deposit: " + mainAccount.getAccountBalance());
        System.out.println("Balance of secondAccount after deposit: " + secondAccount.getAccountBalance());

        // Test withdrawal
        mainAccount.withdraw(200, mainAccount.getSsn());
        secondAccount.withdraw(500, secondAccount.getSsn());
        System.out.println("Balance of mainAccount after withdrawal: " + mainAccount.getAccountBalance());
        System.out.println("Balance of secondAccount after withdrawal: " + secondAccount.getAccountBalance());

        // Create JointAccount
        JointAccount jointAccount = new JointAccount(mainAccount, "123456111SSN", 700, secondAccount);

        // Test joint account deposit and withdrawal
        jointAccount.deposit(500);
        System.out.println("Balance of jointAccount after deposit: " + jointAccount.getAccountBalance());
        jointAccount.withdraw(300, mainAccount.getSsn());
        jointAccount.withdraw(300, secondAccount.getSsn());
        System.out.println("Balance of jointAccount after withdrawals: " + jointAccount.getAccountBalance());

        // Create OverdraftAccount
        OverdraftAccount overdraftAccount = new OverdraftAccount(mainAccount, "1345679SSN", 500);

        // Test overdraft account withdrawal beyond balance
        overdraftAccount.withdraw(700, mainAccount.getSsn());
        System.out.println("Balance of overdraftAccount after overdraft: " + overdraftAccount.getAccountBalance());
    }
}
