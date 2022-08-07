package root.human.properties;

public class Credit {
    //fields
    private String bank;
    private String currency;
    private int balance;

    public Credit(String bank, String currency, int balance) {
        this.bank = bank;
        this.currency = currency;
        this.balance = balance;
    }

    public String toString() {
        return ("Credit: " + this.bank + " " + this.balance + " " + this.currency);
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}