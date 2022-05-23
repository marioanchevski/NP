package aud03.bank;

public abstract class Account {

    private String accountOwner;
    private int id;
    private static int idSeed = 1000;
    private double currentAmount;
    private AccountType type;

    public Account(String accountOwner, double currentAmount) {
        this.accountOwner = accountOwner;
        this.id = idSeed++;
        this.currentAmount = currentAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void addAmount(double amount) {
        currentAmount += amount;
    }

    public void withdrawAmount(double amount) throws CanNotWithdrawMoneyException {
        if (currentAmount < amount)
            throw new CanNotWithdrawMoneyException(currentAmount, amount);
        currentAmount -= amount;
    }

    public abstract AccountType getAccountType();

    @Override
    public String toString() {
        return String.format("%d: %.2f", id, currentAmount);
    }
}
