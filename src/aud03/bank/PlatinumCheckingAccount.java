package aud03.bank;

public class PlatinumCheckingAccount extends InterestCheckingAccount {

    public PlatinumCheckingAccount(String accountOwner, double currentAmount) {
        super(accountOwner, currentAmount);
    }

    public void addInterest() {
        addAmount(getCurrentAmount() * INTEREST_RATE * 2);
    }
}
