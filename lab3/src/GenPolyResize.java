
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
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


public class GenPolyResize implements ComponentListener {
    

    public GenPolyResize() {
        // create new frame
        mainFrame = new JFrame("Draw Shape By Resize");        
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add panel to container
        panel = new DrawPanel();
        cont = mainFrame.getContentPane();
        cont.add(panel);
        // add listener and show
        mainFrame.addComponentListener(this);
        mainFrame.setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) { }

    @Override
    public void componentMoved(ComponentEvent e) { }

    @Override
    public void componentShown(ComponentEvent e) { }

    @Override
    public void componentHidden(ComponentEvent e) { }
    
    JFrame mainFrame;
    DrawPanel panel;
    Container cont;
}

class DrawPanel extends JPanel
{
    public Graphics2D g2;
    
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
        g2 = (Graphics2D)g;
        
        for (int i = 1; i <= 12; i++) {
            Shape shape = getRandomShape();    
            g2.setPaint(getRandomColor());
            BasicStroke pen = new BasicStroke(getRandom(5,15));
            g2.setStroke(pen);
            g2.draw(shape);
        }
    }
}