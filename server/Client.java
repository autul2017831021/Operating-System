package server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        try {
            System.out.println("Client started");
            System.out.println("Give an Ip Address :");

            String host = inp.next();

            Socket socket = new Socket(host, 9806);

            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                System.out.println("Enter a string");
                String str = userinput.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(str);

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(input.readLine());
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }
}
