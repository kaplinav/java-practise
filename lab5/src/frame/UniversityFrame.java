package frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import person.Person;

/**
 *
 * @author User
 */

public class UniversityFrame extends JFrame implements ActionListener {
    final static String STUDENT = "STUDENT";
    final static String FACULTY = "FACULTY";
    final static String PRINT = "PRINT";
    
    private JMenuBar menuBar;
    private JMenuItem menuItems[];
    private StudentFrame studentFrame;
    private FacultyFrame facultyFrame;
    private JTextArea textArea;

    public UniversityFrame() {
        setTitle("University");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createMenu();
        add(menuBar, BorderLayout.NORTH);
        textArea = new JTextArea(10,5);
        textArea.setEditable(false);
        textArea.setBackground(new Color(238, 238, 238));
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        studentFrame = new StudentFrame();
        facultyFrame = new FacultyFrame();
        
        setLocation(400, 400);
        pack();
        setVisible(true);
    }
    
    private void createMenu(){
        menuBar = new JMenuBar();
        menuItems = new JMenuItem[3];
        for (int i = 0; i < 3; i++) {
            String itemName = null;
            String actionName = null;
            
            switch(i)  {
                case 0:
                   itemName = "Student Data";
                   actionName = STUDENT;
                break;
                case 1:
                    itemName = "Faculty Data";
                    actionName = FACULTY;
                break;
                case 2:
                    itemName = "Print the List";
                    actionName = PRINT;
                break;
            }
            menuItems[i] = new JMenuItem(itemName);
            menuItems[i].setActionCommand(actionName);
            menuItems[i].addActionListener(this);
            menuBar.add(menuItems[i]);
        }
    }
    
    private void print(){
        ArrayList persons = studentFrame.getPersons();
        String text = "";
        
        for (int i = 0; i < persons.size(); i++) {
            text += persons.get(i).toString();
            
            if (i < persons.size() - 1){
                text += "\n";
            }
        }
        
        textArea.setText(text);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        switch(e.getActionCommand()){
            case STUDENT:
                studentFrame.setLocationRelativeTo(this);
                studentFrame.setVisible(true);
                break;
            case FACULTY:
                facultyFrame.setLocationRelativeTo(this);
                facultyFrame.setVisible(true);
                break;
            case PRINT:
                print();
                break;           
        }
    }
}