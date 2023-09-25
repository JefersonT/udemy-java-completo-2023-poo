package entities;

public class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(int number, String holder, double initialDeposit, Double interestRate) {
        super(number, holder, initialDeposit);
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double value) {
        balance -= value;
    }
}
