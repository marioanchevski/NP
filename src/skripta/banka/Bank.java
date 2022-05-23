package skripta.banka;

import java.util.Arrays;

public class Bank {
    private String name;
    private Account[] accounts;
    private double totalTransactions;
    private double totalProvision;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = Arrays.copyOf(accounts, accounts.length);
        totalTransactions = 0;
        totalProvision = 0;
    }

    private boolean isInAccounts(long id) {
        for (Account account : accounts) {
            if (account.getId() == id)
                return true;
        }
        return false;
    }

    private Account getAcount(long id) {
        for (Account account : accounts)
            if (account.getId() == id)
                return account;
        return null;
    }

    public boolean makeTransaction(Transaction t) {
        Account account1 = getAcount(t.getFromId());
        Account account2 = getAcount(t.getToId());
        if (account1 == null || account2 == null) return false;
        if (t.getAmount() < account1.getBalance()) return false;

        // izvrhi transakcija

        return true;
    }

    public double totalTransfers() {
        return totalTransactions;
    }

    public double totalProvision() {
        return totalProvision;
    }

    public String toString() {
        return String.format("Name: %s", name);
    }
}
