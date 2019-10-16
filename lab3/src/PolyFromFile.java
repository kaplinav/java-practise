
//import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class PolyFromFile extends JFrame{
    public PolyFromFile() {
        super("Draw polygon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PolyFromFilePanel sPanel = new PolyFromFilePanel();
        Container contentPane = getContentPane();
        contentPane.add(sPanel);
        setSize (400,400);
        setVisible(true);
    }
}


