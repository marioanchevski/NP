package skripta.banka;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction {
    private int percent;

    public FlatPercentProvisionTransaction(long fromId, long toId, double amount, int centsPerDolar) {
        super(fromId, toId, "FlatPercent", amount);
        this.percent = centsPerDolar;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return percent == that.percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent);
    }

    @Override
    public double getProvision() {
        long amount = (long) this.getAmount() / 100;
        return percent * amount;
    }
}
