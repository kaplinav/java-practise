/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import person.*;

/**
 *
 * @author User
 */

public class StudentFrame extends InputFrame {
    String pattern = "^\\d+$";
    
    public StudentFrame(){
        setTitle("Student form");
        super.variableLabel.setText("Age:");
        super.acceptBtn.addActionListener(this);
        super.clearBtn.addActionListener(this);
        super.closeBtn.addActionListener(this);
    }
    
    protected void add(){ persons.add(new Student(super.nameText.getText(), Integer.parseInt(super.variableText.getText()))); }
    
    protected boolean checkInput(){
        if (!super.nameText.getText().isBlank()){
            if (!super.variableText.getText().isBlank() && super.variableText.getText().matches(pattern)){
                return true;
            }
        }
        return false;
    }
}