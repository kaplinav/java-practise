/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author User
 */

public class Task10 extends JFrame implements ActionListener, DocumentListener{
    public Task10() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle();
        setLayout(new BorderLayout());
        // Create buttons
        setButtons();
        // Create menu
        setMenu();
        JPanel cPanel = new JPanel(new BorderLayout());
        cPanel.add(menuBar, BorderLayout.NORTH);
        cPanel.add(buttonLine, BorderLayout.WEST);
        add(cPanel, BorderLayout.NORTH);
        // Create text area 
        textArea = new JTextArea("", 8, 10);
        textArea.setBackground(new Color(238, 238, 238));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //textArea.setTabSize(10);
        textArea.setEditable(false);
        textArea.getDocument().addDocumentListener(this);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        // Set frame parameters
        setSize(400, 400);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x, y);
        setVisible(true);
    }

    @Override
    public void setTitle(String title) { super.setTitle(title += " * "+getMode()); }
    
    public void setTitle() { setTitle(header); }
    
    private String getMode(){ return editMode ? EDIT : VIEW; }
    
    private void setButtons() {
        // Buttons
        buttonLine = new JPanel();
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            ImageIcon icon = null;
            switch(i){
                case 0:
                    buttons[i].setActionCommand(OPEN);
                    buttons[i].setToolTipText("Open file");
                    icon = new ImageIcon("openIcon20.png");
                    break;
                case 1:
                    buttons[i].setActionCommand(CHANGE);
                    buttons[i].setToolTipText("Edit or view");
                    icon = new ImageIcon("editIcon20.png");
                    break;
                case 2:
                    buttons[i].setActionCommand(SAVE);
                    buttons[i].setToolTipText("Save file");
                    icon = new ImageIcon("saveIcon20.png");
                    break;
                case 3:
                    buttons[i].setActionCommand(CLOSE);
                    buttons[i].setToolTipText("Close app");
                    icon = new ImageIcon("closeIcon20.png");
                    break;
            }
            buttons[i].setIcon(icon);
            buttons[i].setUI(new BasicButtonUI());
            buttons[i].addActionListener(this);
            buttonLine.add(buttons[i]);
        }
    }
    
    private void setMenu() {
        menuBar = new JMenuBar();
        
        // Menu File
        fileMenu = new JMenu("File");
        // open
        openItem = new JMenuItem("Open");
        openItem.setActionCommand(OPEN);
        openItem.addActionListener(this);
        fileMenu.add(openItem);
        //save
        saveItem = new JMenuItem("Save");
        saveItem.setActionCommand(SAVE);
        saveItem.addActionListener(this);
        saveItem.setEnabled(false);
        fileMenu.add(saveItem);
        // close
        closeItem = new JMenuItem("Close");
        closeItem.setActionCommand(CLOSE);
        closeItem.addActionListener(this);
        fileMenu.add(closeItem);
        menuBar.add(fileMenu);
        
        // Menu File
        editMenu = new JMenu("Edit");
        // undo
        undoItem = new JMenuItem("Undo");
        undoItem.setActionCommand(UNDO);
        undoItem.addActionListener(this);
        undoItem.setEnabled(false);
        editMenu.add(undoItem);
        // change
        changeItem = new JMenuItem("Change");
        changeItem.setActionCommand(CHANGE);
        changeItem.addActionListener(this);
        editMenu.add(changeItem);
        menuBar.add(editMenu);
    }
    
    private void closeAction(){
        if (isChanged){
            int choise = JOptionPane.showConfirmDialog(this, "Exit without saving?", "Exit", JOptionPane.YES_OPTION);
            
            if (choise == 1) return;
        }
               
        System.exit(0);
    }
    
    private void openAction(){
        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose file");
        fileChooser.setFileFilter(new FilterTxt());

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = fileChooser.getSelectedFile();

            try {

                fileBytes = Files.readAllBytes(fileName.toPath());
                fileString = new String(fileBytes, StandardCharsets.UTF_8);
                textArea.setText(fileString);
                header = fileName.getName();
                setTitle();
                isOpen = true;

            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }
    
    private void changeAction(){
        if (!isOpen) {
            return;
        }
        
        editMode = !editMode;
        undoItem.setEnabled(editMode);
        saveItem.setEnabled(editMode);
        setTitle();
        if (editMode){
            textArea.setBackground(new Color(255, 255, 255));
        }else {
            textArea.setBackground(new Color(238, 238, 238));
        }
        textArea.setEditable(editMode);
    }
    
    private void undoAction(){
        if (fileBytes != null) { textArea.setText(fileString); }
    }
    
    private void saveAction(){
        String text = textArea.getText();
        if (text != null){
            try(FileWriter fw = new FileWriter(fileName);) {
                fw.write(text);
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
        isChanged = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        switch(e.getActionCommand()){
            case CLOSE:
                closeAction();
                break;
            case OPEN:
                openAction();
                break;
            case CHANGE:
                changeAction();
                break;
            case UNDO:
                undoAction();
                break;
            case SAVE:
                saveAction();
                break;       
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) { 
        if (isOpen) isChanged = true; 
    }

    @Override
    public void removeUpdate(DocumentEvent e) { }

    @Override
    public void changedUpdate(DocumentEvent e) { }
    
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        //setTitle("Task 10 - "+getHeader());
    }
    
    File fileName;
    byte[] fileBytes;
    String fileString = "";
    
    // TRUE - if file is changed
    boolean isChanged = false;
    // TRUE - change, FALSE - view
    boolean editMode = false;
    // TRUE - if file is open
    boolean isOpen = false;
    
    //ControlPanel controlPanel;
    JButton[] buttons = new JButton[4];
    JFileChooser fileChooser;
    JPanel buttonLine;
    JTextArea textArea;
    
    // Menu
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem, saveItem, closeItem;
    JMenu editMenu;
    JMenuItem undoItem, changeItem;
    
    // Code of operation 
    final static String OPEN = "OPEN";
    final static String CHANGE = "CHANGE";
    final static String UNDO = "UNDO";
    final static String SAVE = "SAVE";
    final static String CLOSE = "CLOSE";
    
    // For Frame title 
    private String header = "Untitled";
    final static String VIEW = "View";
    final static String EDIT = "Edit";
}