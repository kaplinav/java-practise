
import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Monitor extends JFrame {
    private static Monitor m;
    private JTextArea textArea;
    
    private Monitor() {
        setTitle("Thread Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        textArea = new JTextArea(50, 10);
        textArea.setBackground(new Color(238, 238, 238));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);
        //add(scrollPane, BorderLayout.CENTER);
        setSize(300, 500);
        setVisible(true);
    }
    
    public static Monitor getMonitor(){
        if (m == null) 
            m = new Monitor();
        return m;
    }
    
    public void sendMessage(String message){
        this.m.textArea.append(message + "\n");
    }
}
