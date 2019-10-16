
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class PolyFromFilePanel extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawString("Draw polygon by dots from file", 5, 10);
        
        DotsArray da = new DotsArray();
        da.getFromFile("dots.txt");
        
//        int[] xs = {25, 75, 125, 85, 125, 75, 25, 65, 25};
//        int[] ys = {50, 90, 50, 100, 150, 110, 150, 100, 50};
        
        g.drawPolyline(da.x, da.y, da.x.length);    

        //g.drawRect(20,20,400,330);
        //g.drawRect(20,100,300,200); // Initial coordinates and lengths
        //g.drawOval(20,100,300,200); // Initial coordinates and lengths of the surrounding rectangle
        //g.drawString("ABCDEF", 100,150);
        
    }
}
