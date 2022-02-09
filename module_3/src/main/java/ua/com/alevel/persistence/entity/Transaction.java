package ua.com.alevel.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private long amount;

    @ManyToOne()
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Account sender;

    @ManyToOne()
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Account receiver;

    public Transaction() {
        super();
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }
}
