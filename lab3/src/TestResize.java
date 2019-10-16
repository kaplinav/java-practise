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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class TestResize extends JFrame{
    public TestResize() {
        super("Draw by Resize Test");
        add(new DrawPanelTest());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
    }
}

class DrawPanelTest extends JPanel {
    
    int getRandom(int min, int max) {
        return min + (int) (Math.random() * max);
    }
    
    Color getRandomColor() {
        return new Color(getRandom(0, 255),getRandom(0, 255),getRandom(0, 255));
    }
    
    Shape getRandomShape()
    {
        int width = getRandom(100, 300);
        int height = getRandom(100, 300);
        int x = getRandom(getRandom(10,100),getRandom(100,200));
        int y = getRandom(getRandom(10,100),getRandom(100,200));
            
        switch (getRandom(1, 3)) 
        {
            case (1):
                return new Rectangle2D.Double(x, y, width, height);
            case (2):
                return new Ellipse2D.Double(x, y, width, height);
            case (3):
                return new Line2D.Double(x, y, width, height);
        }
        return null;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        for (int i = 1; i <= 12; i++) {
            Shape shape = getRandomShape();    
            g2.setPaint(getRandomColor());
            BasicStroke pen = new BasicStroke(getRandom(5,15));
            g2.setStroke(pen);
            g2.draw(shape);
        }
    }
} 
