package me.soulyana.soultrustbank.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Account {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    //Value displayed for bank account holdsers as a reference to their account
    private int acctNum;

    private double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "Transaction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Transaction> transactions;

    public Account(User user) {
        acctNum = ThreadLocalRandom.current().nextInt(1000, 9999);
        balance = 0.00;
        this.user = user;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
