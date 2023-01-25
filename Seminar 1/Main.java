public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        BankClient client1 = new BankClient(account);
        BankClient client2 = new BankClient(account);

        client1.start();
        client2.start();

        synchronized (client1){
            client1.wait(1500);
        }
        synchronized (client2){
            client2.wait(1500);
        }
       
        System.out.println(account.getCashAmount());
    }    
}
