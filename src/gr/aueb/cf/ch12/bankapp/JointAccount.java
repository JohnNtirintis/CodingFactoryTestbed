package gr.aueb.cf.ch12.bankapp;



/**
 * This class represents a JointAccount, which extends the Account class and
 * adds a second customer to the account.
 * @author Ntirintis John
 */
public class JointAccount extends Account{

    // Default Constructor
    private Account secondCustomer;

    /**
     * Constructs a JointAccount with the specified secondCustomer.
     * @param secondCustomer the second customer of the account.
     */

    // Default Constructor
    public JointAccount(Account secondCustomer){
        this.secondCustomer = secondCustomer;
    }

    /**
     * Overrides the withdraw function from the account function.
     * Allows withdrawing money from both users SSN.
     *
     * @param amount the amount to be withdrawn
     * @param ssn the account's ssn.
     * @throws IllegalArgumentException
     */
    @Override
    public void withdraw(double amount, String ssn) throws IllegalArgumentException {
        // Accepts both users ssn.
        try {
            if(!isSsnValid(ssn) || !isSsnValid(secondCustomer.getSsn())) throw new IllegalArgumentException("Invalid SSN");
            if(amount <= super.getBalance()){
                super.setBalance(super.getBalance() - amount);
            } else {
                throw new IllegalArgumentException("Insufficient Balance");
            }
        } catch (IllegalArgumentException  e){
            e.printStackTrace();
            throw e;
        }
    }

    // Overloaded Constructor
    public JointAccount(Account customer, String ssn, double balance, Account secondCustomer){
        super(customer,ssn,balance);
        this.secondCustomer = secondCustomer;
    }

    public Account getSecondCustomer() {
        return secondCustomer;
    }

    public void setSecondCustomer(Account secondCustomer) {
        this.secondCustomer = secondCustomer;
    }

    @Override
    public String toString() {
        return "JointAccount{" +
                "secondCustomer=" + secondCustomer +
                '}';
    }

    /**
     * Check to see if the ssn matches either of the accounts ssn
     *
     * @param ssn  the ssn the user entered
     * @return true if the ssn matches the ssn of one of the accounts
     */
    @Override
    public boolean isSsnValid(String ssn) {
        return super.isSsnValid(ssn) || secondCustomer.isSsnValid(ssn);
    }
}
