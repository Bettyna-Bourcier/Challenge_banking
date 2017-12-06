package banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OUTGOINGS")
public class Outgoings {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @Enumerated(EnumType.ORDINAL)
    private OutgoingsTypeEnum outgoingsType;

    @Column
    private float amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Outgoings() {
    }

    public Outgoings(Date date, OutgoingsTypeEnum outgoingsType, float amount) {
        this.date = date;
        this.outgoingsType = outgoingsType;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OutgoingsTypeEnum getOutgoingsType() {
        return outgoingsType;
    }

    public void setOutgoingsType(OutgoingsTypeEnum outgoingsType) {
        this.outgoingsType = outgoingsType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
