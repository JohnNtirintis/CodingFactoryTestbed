package gr.aueb.cf.ch12.bankapp;

/**
 * This class represents an OverdraftAccount, which extends the Account class
 * and modifies the withdraw behavior to allow for overdrafts.
 * @author Ntirintis John
 */
public class OverdraftAccount extends Account {

    // Default Constructor
    public  OverdraftAccount() {}

    // Overloaded Constructor
    public OverdraftAccount(Account customer, String ssn, double balance){
        super(customer, ssn, balance);
    }

    /**
     * Overrides the withdraw method of the Account class to allow for overdrafts.
     * @param amount the amount to withdraw.
     * @param ssn the social security number associated with the account.
     * @throws IllegalArgumentException if the ssn is not valid.
     */
    @Override
    public void withdraw(double amount, String ssn) throws IllegalArgumentException {
         try{
             if(amount <= 0) throw new IllegalArgumentException("Error! Amount zero or negative");
             if(!isSsnValid(ssn)) throw new IllegalArgumentException("Invalid SSN!");

             setBalance(getBalance() - amount);
         } catch (IllegalArgumentException e){
             e.printStackTrace();
             throw e;
         }
    }
}
