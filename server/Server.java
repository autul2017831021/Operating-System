package server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner inpu = new Scanner(System.in);

        try{
            System.out.println("Waiting for client");
            ServerSocket ss = new ServerSocket(9806);
            Socket socket = ss.accept();
            System.out.println("Ready to communicate");

            while(true){

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String str = in.readLine();

                System.out.println("Client says : "+str);

                str = inpu.nextLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Server says : " + str);


            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
