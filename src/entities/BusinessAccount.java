package entities;

public class BusinessAccount extends Account{

    private Double loanLimit;

    public BusinessAccount() {
    }

    public BusinessAccount(int number, String holder, double initialDeposit, Double loanLimit) {
        super(number, holder, initialDeposit);
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if (amount<=loanLimit){
            balance += amount - 10.00;
        }
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    //final no método evita que a metodo seja sobreescrito
    @Override
    public final void withdraw(double value) {
        super.withdraw(value);
        balance -= 2;
    }
}
