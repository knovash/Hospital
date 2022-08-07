package root.human.properties;

import java.math.BigDecimal;

public class Credit {

    private String bank;
    private String currency;
    private BigDecimal balance;

    public Credit(String bank, String currency, BigDecimal balance) {
        this.bank = bank;
        this.currency = currency;
        this.balance = balance;
    }

    public String toString() {
        return ("Credit: " + this.bank + " " + this.balance + " " + this.currency);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Credit other = (Credit) object;
        return this.bank.equals(other.bank) &&
                this.balance.equals(other.balance) &&
                this.currency.equals(other.currency);
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}