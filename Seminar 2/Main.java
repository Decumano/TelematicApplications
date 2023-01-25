import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client();
        Client c2 = new Client();
        Client c3 = new Client();
        Server s = new Server();

        s.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c1.start();
        c2.start();
        c3.start();
        
        try {
            synchronized(s)
            {
                s.wait(30000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            synchronized (c1)
            {
                c1.wait(30000);
            }
            synchronized (c2)
            {
                c2.wait(30000);
            }
            synchronized (c3)
            {
                c3.wait(30000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
