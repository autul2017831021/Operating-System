/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guichat;

import java.awt.*;         
import javax.swing.*;      
 import javax.swing.text.DefaultCaret; //////
public class GUICHAT extends JFrame
{
    public JButton sendButton;
 
    public JTextArea rxArea;
   public JTextField txArea;
    public Container container;
public JScrollPane pane; ////   
    public GUICHAT (String title)
    {
    super (title);
    
        container = getContentPane();            
        container.setLayout( new FlowLayout() );
       
     txArea = new JTextField (40);
    
     rxArea = new JTextArea (6, 40);
   rxArea.setEditable (false);      /////
        pane = new JScrollPane (rxArea); /////
        
		DefaultCaret caret = (DefaultCaret)rxArea.getCaret();/////
    	caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);   //////
     sendButton = new JButton ("Send"); 
         
container.add (pane);
container.add (txArea);
     container.add (sendButton);
    }
}
