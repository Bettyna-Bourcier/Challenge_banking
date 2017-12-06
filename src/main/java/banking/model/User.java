package banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(unique = true)
    private String clientNumber;

    @Column
    @JsonIgnore
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Outgoings> outgoingsList = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String clientNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientNumber = clientNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getClientNumber() {
        return clientNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Outgoings> getOutgoingsList() {
        return outgoingsList;
    }

    public void setOutgoingsList(List<Outgoings> outgoingsList) {
        this.outgoingsList = outgoingsList;
    }

    public void addOutgoing(Outgoings outgoing) {
        outgoingsList.add(outgoing);
        outgoing.setUser(this);
    }
}
