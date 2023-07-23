package gr.aueb.cf.ch11.model;

/**
 * @author Ntirintis John
 */
public class UserCredentials {
    private long id;
    private String username;
    private String password;

    // Default Cnstructor
    public UserCredentials(){}

    // Overloaded Constructor
    public UserCredentials(long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + id +
                "," + username +
                "," + password +
                '}';
    }
}
