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
    final static String[] itemNames = { "Student Data", "Faculty Data", "Print the List" };
    final static String[] actionNames = { STUDENT, FACULTY, PRINT };
    
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
        setJMenuBar(menuBar);
        //add(menuBar, BorderLayout.NORTH);
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
            menuItems[i] = new JMenuItem(itemNames[i]);
            menuItems[i].setActionCommand(actionNames[i]);
            menuItems[i].addActionListener(this);
            menuBar.add(menuItems[i]);
        }
    }
    
    private void print(){
        ArrayList persons = studentFrame.getPersons();
        StringBuilder text = new StringBuilder();
        
        for (int i = 0; i < persons.size(); i++) {
            text.append(persons.get(i).toString());
            
            if (i < persons.size() - 1){
                text.append("\n");
            }
        }
        
        textArea.setText(text.toString());
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