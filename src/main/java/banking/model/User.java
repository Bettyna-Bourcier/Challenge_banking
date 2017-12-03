package banking.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique=true)
    private String clientNumber;

    @Column
    private String password;

    public User() {}

    public User(String firstName, String lastName, String password, String clientNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setPassword(password);
        this.clientNumber = clientNumber;
    }

    public int getId() {
        return id;
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

    public String getClientNumber() {
        return clientNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // TODO : use bCrypt for password
        this.password = password;//  bCryptPasswordEncoder.encode(password);
    }
}
