import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Client extends Thread {
    public static void main(String[] args) {
        
    }
    public void run()
    {
        try {
            ClientFunctionality();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int ClientFunctionality() throws 
    IOException, UnknownHostException, ClassNotFoundException, InterruptedException
    {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host, 8181);
              
        PrintWriter out = new PrintWriter
        (
            new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
            true
        );

        System.out.println("Client receiving message...");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));

        while (!in.ready()){}

        System.out.println(in.readLine());
        while(true)
        {
            String username = myinput.readLine();
            System.out.println("Client sending message " + username + "...");
            out.println(username);
            if (username.isEmpty()) break;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Client disconecting");
        socket.close();
        
        return 0;
    }
}