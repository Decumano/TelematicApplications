import java.net.*;
import java.io.*;

public class Server extends Thread {
    private static int port = 8181;

    public void run()
    {
        try {
            ServerFunctionality();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerFunctionality();
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int ServerFunctionality() throws IOException, ClassNotFoundException
    {
        int threadNum = 3;
        ClientThread[] thread = new ClientThread[threadNum];

        ServerSocket s = new ServerSocket(port);        

        System.out.println("Server started. Waiting for connections...");
      
        for(int i = 0; i < threadNum; i++){
            Socket socket = s.accept();
            System.out.println("Connection stablished.\n");
            thread[i] = new ClientThread(socket);  
        }
        for(int i = 0; i < threadNum; i++) 
            synchronized (thread[i])
            {
                try {
                    thread[i].wait(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        s.close();
        return 0;
    }
}