package ua.com.alevel.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity{

    private long balance;
    private String wallet;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "receiver")
    private List<Transaction> receiver;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> sender;

    public Account() {
        super();
        this.receiver = new ArrayList<>();
        this.sender = new ArrayList<>();
    }

    public List<Transaction> getTransaction() {
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.addAll(sender);
        transactionList.addAll(receiver);
        return transactionList;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<Transaction> receiver) {
        this.receiver = receiver;
    }

    public List<Transaction> getSender() {
        return sender;
    }

    public void setSender(List<Transaction> sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return user.getName();
    }
}
