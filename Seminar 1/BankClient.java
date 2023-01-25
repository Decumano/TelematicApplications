public class BankClient extends Thread {
    
    private BankAccount account;

    public BankClient(BankAccount account)
    {
        super();
        this.account = account;
    }

    public void run()
    {
        for (int i = 0; i < 10000; i++)
            account.updateCash();
    }
}
