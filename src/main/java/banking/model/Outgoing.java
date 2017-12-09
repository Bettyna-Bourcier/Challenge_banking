package banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OUTGOING")
public class Outgoing {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @Enumerated(EnumType.ORDINAL)
    private OutgoingTypeEnum outgoingType;

    @Column
    private float amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Outgoing() {
    }

    public Outgoing(Date date, OutgoingTypeEnum outgoingType, float amount) {
        this.date = date;
        this.outgoingType = outgoingType;
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

    public OutgoingTypeEnum getOutgoingType() {
        return outgoingType;
    }

    public void setOutgoingType(OutgoingTypeEnum outgoingType) {
        this.outgoingType = outgoingType;
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
