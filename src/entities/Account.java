package entities;

//abstract impede que a classe seja instanciada
public abstract class Account {
    private int number;
    private String holder;
    protected double balance;

    public Account() {
    }

    public Account(int number, String holder, double initialDeposit) {
        this.number = number;
        this.holder = holder;
        deposit(initialDeposit);
    }

    public Account(Integer number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }
    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value + 5.0;
    }

    @Override
    public String toString() {
        return "Account " + number +
                ", Holder: " + holder +
                ", Balance: $ " + String.format("%.2f", balance);
    }

}
