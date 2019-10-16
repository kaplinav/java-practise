/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task9;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author User
 */

public class Task9 extends JFrame {
    public Task9() {
        super("Task 9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel cPanel = new ControlPanel();
        getContentPane().add(cPanel);
        setPreferredSize(new Dimension(260, 150));
        
        // Causes this Window to be sized to fit the preferred size and 
        // layouts of its subcomponents. The resulting width and height of the window 
        // are automatically enlarged if either of dimensions is less than 
        // the minimum size as specified by the previous call to the setMinimumSize method.
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class ControlPanel extends JPanel implements ActionListener{
    public ControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalStrut(10));
        // Find real numbers in text if TRUE
        m_numCh = new JCheckBox("real number", true);
        m_numCh.setAlignmentX(CENTER_ALIGNMENT);
        add(m_numCh);
        // // Find unique words in text if TRUE
        m_wordCh = new JCheckBox("unique words", true);
        m_wordCh.setAlignmentX(CENTER_ALIGNMENT);
        add(m_wordCh);
        
        JButton choseBut = new JButton("Choose");
        choseBut.setAlignmentX(CENTER_ALIGNMENT);
        add(choseBut);
        choseBut.addActionListener(this);
        add(Box.createVerticalStrut(15));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showDialog(null, "Choose file");
        
        if (result == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            FindInFile finder = new FindInFile(file, m_numCh.isSelected(), m_wordCh.isSelected());
            finder.find();
        }    
    }
    
    JCheckBox m_numCh, m_wordCh;
}