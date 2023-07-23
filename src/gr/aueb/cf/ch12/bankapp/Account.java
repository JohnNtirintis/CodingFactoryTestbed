package gr.aueb.cf.ch12.bankapp;

/**
 * This class represents an Account, with id, iban, firstName, lastName, ssn and balance.
 * @author Ntirintis John
 */
public class Account {
    private int id;
    private String iban;
    private String firstName;
    private String lastName;
    private String ssn;
    private double balance;

    // Service Layer, Public Api
    /**
     * Deposits a specific amount into the account.
     * @param amount the amount to deposit.
     * @throws IllegalArgumentException if the amount is negative.
     */
    public void deposit(double amount) throws IllegalArgumentException{
        try {
            if(amount > 0){
                balance += amount;
            } else{
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.err.println("Error! Negative amount!");
        }
    }

    /**
     * Withdows a specified amount from the account's balance.
     *
     * @param amount the amount to be withdrawn
     * @param ssn the account's ssn.
     * @throws IllegalArgumentException if the ssn is invalid
     */
    public void withdraw(double amount, String ssn) throws IllegalArgumentException {
        try {
            if(!isSsnValid(ssn)) throw new IllegalArgumentException("Invalid SSN");
            if(amount <= balance){
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient Balance");
            }
        } catch (IllegalArgumentException  e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *
     * @return the account's balance
     */
    public double getAccountBalance(){
        return getBalance();
    }

    /**
     *
     * @param ssn the account's ssn
     * @return true if the ssn matches the account's ssn
     */
    public boolean isSsnValid(String ssn){
        return this.ssn.equals(ssn);
    }

    // Default Constructor
    public Account() {}

    // Overloaded Constructors
    public Account(Account customer, String ssn, double balance) {
    }

    public Account(int id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(int id, String iban, String firstName, String lastName, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.balance = balance;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // To String

    public String getAccountState() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", balance=" + balance +
                '}';
    }
}
