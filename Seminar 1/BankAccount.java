public class BankAccount {
    private int cashAmount;

    public BankAccount()
    {
        super();
        cashAmount = 0;
    }

    public BankAccount(int cashAmount)
    {
        super();
        this.cashAmount = cashAmount;
    }

    public int getCashAmount(){return cashAmount;}
    public void setCashAmount(int newCashAmount){cashAmount = newCashAmount;}

    public synchronized void updateCash()
    {
        cashAmount++;
    }
}
