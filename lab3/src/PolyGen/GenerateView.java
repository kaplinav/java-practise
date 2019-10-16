/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyGen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author User
 */

public class GenerateView extends JFrame
{
    public GenerateView()
    {
        super("GeneratePolygon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Add control panel
        m_cPanel = new ControlPanel();
        add(m_cPanel, BorderLayout.NORTH);
        // Add panel with polygon
        m_dPanel = new DrawPanel();
        add(m_dPanel, BorderLayout.CENTER);
        
        setSize (450,450);
        setVisible(true);
    }
    
    class ControlPanel extends JPanel implements ActionListener
    {
        public ControlPanel()
        {
            setLayout(null); // Try to comment it …

            // Count of vertex
            JLabel label1 = new JLabel("Count of vertex");
            add(label1);
            label1.setLocation(10, 10);
            label1.setSize(100, 20);

            m_countFl = new JTextField("n", 10);
            add(m_countFl);
            m_countFl.setLocation(160,10);
            m_countFl.setSize(100, 20);

            // Center of Polygon
            JLabel lbl2 = new JLabel("Center of polygon, (x,y)");
            add(lbl2);
            lbl2.setLocation(10, 35);
            lbl2.setSize(150, 20);

            m_xFl = new JTextField("x", 10);
            add(m_xFl);
            m_xFl.setLocation(160, 35);
            m_xFl.setSize(100, 20);

            m_yFl = new JTextField("y", 10);
            add(m_yFl);
            m_yFl.setLocation(265, 35);
            m_yFl.setSize(100, 20);

            // Range of edge length
            JLabel lbl3 = new JLabel("Range of edge, (min,max)");
            add(lbl3);
            lbl3.setLocation(10, 60);
            lbl3.setSize(150, 20);

            m_minFl = new JTextField("Min", 10);
            add(m_minFl);
            m_minFl.setLocation(160, 60);
            m_minFl.setSize(100, 20);

            m_maxFl = new JTextField("Max", 10);
            add(m_maxFl);
            m_maxFl.setLocation(265, 60);
            m_maxFl.setSize(100, 20);

            // Button "Generate"
            buttGen = new JButton("Generate");
            add(buttGen);
            buttGen.setLocation(10, 90);
            buttGen.setSize(100, 20);
            buttGen.addActionListener(this);

            //button2 = new JButton("Blue");
            //add(button1);
            //add(button2);
            //button1.setLocation(10,10);
            //button1.setSize(80,20); // Try to comment it…
            //button2.setLocation(150,150);
            //button2.setSize(100,20);
            //button1.addActionListener(this);
            //button2.addActionListener(this);
        }

        @Override
        public void actionPerformed (ActionEvent event)
        {
            Object source = event.getSource();

            if (source == buttGen) {
                int count = Integer.parseInt(m_countFl.getText());
                int x = Integer.parseInt(m_xFl.getText());
                int y = Integer.parseInt(m_yFl.getText());
                int min = Integer.parseInt(m_minFl.getText());
                int max = Integer.parseInt(m_maxFl.getText());
                
                int dots[][] = GeneratePolygon.generateDots(count, x, y, min, max);
                m_dPanel.setDots(dots);
                
                m_dPanel.repaint();
            }

        // repaint();
        }
        
        //Sets the preferred size of this component. If preferredSize is null, 
        // the UI will be asked for the preferred size.
        @Override
        public Dimension getPreferredSize() {        
            return new Dimension(200, 200);
        }
        
        private void getDots(int n, int x, int y, int min, int max) {
            
            //int dots[][] = GeneratePolygon.generateDots(ERROR, x, y, min, max)
        }
        
        JButton buttGen;
        JTextField m_countFl, m_xFl, m_yFl, m_minFl, m_maxFl;
    }
    
    ControlPanel m_cPanel;
    DrawPanel m_dPanel;
}


class DrawPanel extends JPanel {
    
    public DrawPanel() {
        setLayout(null);
    }
    
    //Sets the preferred size of this component. If preferredSize is null, 
    // the UI will be asked for the preferred size.
    @Override
    public Dimension getPreferredSize() {        
        return new Dimension(200, 200);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawRect(20,100,300,200); // Initial coordinates and lengths
        
        if (m_dots != null)
            if (m_dots[0].length != 0) 
                g.drawPolyline(m_dots[0], m_dots[1], m_dots[0].length);
    }
    
    public void setDots(int dots[][]) {
        if (dots[0].length == 0 || dots[1].length == 0) return;
        
        m_dots = new int[2][];
        
        for (int i = 0; i < 2; i++) {
            int count = dots[i].length;
            m_dots[i] = new int[count];
            
            System.arraycopy(dots[i], 0, m_dots[i], 0, count);
        }
    }
    
    int m_dots[][];
}