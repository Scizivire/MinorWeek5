package com.example.OpdrachtWeek5.Models;

import javax.persistence.*;

@MappedSuperclass
@Table(name = "account")
public abstract class Account {
    @Id
    @GeneratedValue
    @Column(name = "accountId")
    private long accountId;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "iban")
    private String iban;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
