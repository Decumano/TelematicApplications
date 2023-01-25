import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread
    {
        private Socket socket;

        public Socket getSocket(){return socket;}
        public void setSocket(Socket socket){this.socket = socket;}

        public ClientThread(Socket s) throws IOException
        {
            socket = s;

            start();
        }

        private void ClientThreadFunctionality() throws IOException
        {
            BufferedReader in = new BufferedReader(
                new InputStreamReader
                (
                    socket.getInputStream()
                )
            );

            PrintWriter out = new PrintWriter
            (
                new BufferedWriter
                (
                    new OutputStreamWriter(socket.getOutputStream())
                ),
                true
            );
            System.out.println("Server sending message...");
            out.println("Welcome! Enter your name please: ");
            System.out.println("Server reading message...");
            while (!in.ready()){}
            while(true)
            {
                String username = in.readLine();
                System.out.println("Welcome " + username + ".");
                if (username.isEmpty()) break;
            }

            socket.close();
        }

        public void run()
        {
            try {
                ClientThreadFunctionality();;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        public static void main(String[] args) {
            
        }
    }