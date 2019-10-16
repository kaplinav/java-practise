/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPlace extends JFrame {
    public TestPlace() {
        super("TestPlace");
        
        add(new ControlPanel(), BorderLayout.NORTH);
        dp = new DrawPanel(70, 80); 
        add(dp, BorderLayout.CENTER);
        
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * max);
    }
    
    class ControlPanel extends JPanel implements ActionListener {

        public ControlPanel() {
            setLayout(null);

            numText = new JTextField("text");
            numText.setLocation(10, 10);
            numText.setSize(100, 20);
            add(numText);


            genButton = new JButton("generate");
            genButton.setLocation(10, 30);
            genButton.setSize(100, 20);
            genButton.addActionListener(this);
            add(genButton); 


        }

        //Sets the preferred size of this component. If preferredSize is null, 
        // the UI will be asked for the preferred size.
        @Override
        public Dimension getPreferredSize() {        
            return new Dimension(200, 200);
        }

        JButton genButton;
        JTextField numText; 

        @Override
        public void actionPerformed(ActionEvent e) {
            dp.width = getRandomInt(80, 170);
            dp.height = getRandomInt(50, 200);
            dp.repaint();
        }
    }
    
    
    
    
    
    DrawPanel dp;
}



class DrawPanel extends JPanel {
    
    public DrawPanel(int height, int width) {
        this.height = height;
        this.width = width;
        setLayout(null);
    }
    
    //Sets the preferred size of this component. If preferredSize is null, 
    // the UI will be asked for the preferred size.
    @Override
    public Dimension getPreferredSize() {        
        return new Dimension(200, 200);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawRect(10, 10, width, height);
        
        //Graphics2D g2 = (Graphics2D) g;
        //g2.setColor( getForeground() );
        //g2.fill(circle);

    }
    
    
    public int height, width;
}





