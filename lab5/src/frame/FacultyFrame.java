/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frame;

import static frame.InputFrame.persons;
import java.awt.event.*;
import javax.swing.JOptionPane;
import person.*;

/**
 *
 * @author User
 */

public class FacultyFrame extends InputFrame implements ActionListener{
    public FacultyFrame(){
        setTitle("Faculty form");
        super.variableLabel.setText("Degree:");
        super.acceptBtn.addActionListener(this);
        super.clearBtn.addActionListener(this);
        super.closeBtn.addActionListener(this);
    }
    
    private void accept(){
        if (checkInput()){
            add();
            JOptionPane.showMessageDialog(this, "ACCEPTED");
        }else {
            JOptionPane.showMessageDialog(this, "Wrong Input");
        }
    }
    
    private void add(){ persons.add(new Faculty(super.nameText.getText(), super.variableText.getText())); }
    
    private boolean checkInput(){
        if (!super.nameText.getText().isBlank() ){
            if (!super.variableText.getText().isBlank() ){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch(e.getActionCommand()){
            case ACCEPT:
                accept();
                break;
            case CLEAR:
                clear();
                break;
            case CLOSE:
                clear();
                this.dispose();
                break;       
        }
    }
}