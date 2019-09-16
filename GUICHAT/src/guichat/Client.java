/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guichat;

/**
 *
 * @author Error_Coder
 */
import java.net.*;
import java.awt.event.*;   
import java.io.*;

public class Client extends GUICHAT
{
    String inputLine, outputLine;
    public ButtonHandler bHandler = new ButtonHandler();
    DatagramSocket socket;
    
    public Client (String title) throws IOException
    {
        super (title);
        bHandler = new ButtonHandler ();
        sendButton.addActionListener (bHandler);
        
        socket = new DatagramSocket (4466);
    }
    
    // Transmit Message
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed (ActionEvent event) //throws IOException
        {
            try
            {             
                DatagramSocket socket = new DatagramSocket ();
                byte[] buf = new byte[256];
                
                String outputLine = txArea.getText ();
                
                rxArea.setText ( rxArea.getText () + "Client : " + outputLine + "\n");
                
                buf = outputLine.getBytes ();
                InetAddress address = InetAddress.getByName ("127.0.0.1");
                DatagramPacket packet = new DatagramPacket (buf, buf.length, address, 4455);
                socket.send(packet);
            }
            catch (IOException e)
            {
            }        
        }
    }
    
    // Receive Message
    public void run () throws IOException
    {
        DatagramPacket packet;
        byte[] buf = new byte[256];
        
        while (true)
        {
            for (int i = 0; i < 256; i ++) buf [i] = 0x00;
            
            packet = new DatagramPacket (buf, buf.length);
            socket.receive (packet);
            String received = new String (packet.getData());
            //rxArea.setText (received);
            rxArea.setText (rxArea.getText () + "Server : " + received + "\n");
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        Client f = new Client ("Client");
        
        f.pack ();
        f.setSize (500, 200);
        f.setVisible (true);
        f.run ();
    }
}
