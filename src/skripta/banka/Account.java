package skripta.banka;

import java.util.Objects;
import java.util.Random;

public class Account {

    private String name;
    private long id;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.id = new Random().nextLong();
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %s\n", name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(account.balance, balance) == 0 && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, balance);
    }
}
