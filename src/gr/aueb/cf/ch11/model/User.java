package gr.aueb.cf.ch11.model;

/**
 * @author Ntirintis John
 */
public class User {
    private long id;
    private String firstName;
    private String lastName;

    // Default Constructor
    public User(){}

    // Overloaded Constructor
    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" + id +
                "," + firstName +
                "," + lastName +
                '}';
    }
}
