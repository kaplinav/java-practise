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

public class FacultyFrame extends InputFrame{
    public FacultyFrame(){
        setTitle("Faculty form");
        super.variableLabel.setText("Degree:");
        super.acceptBtn.addActionListener(this);
        super.clearBtn.addActionListener(this);
        super.closeBtn.addActionListener(this);
    }
    
    @Override
    protected void add(){ persons.add(new Faculty(super.nameText.getText(), super.variableText.getText())); }
    
    @Override
    protected boolean checkInput(){
        if (!super.nameText.getText().isBlank() ){
            if (!super.variableText.getText().isBlank() ){
                return true;
            }
        }
        return false;
    }
}