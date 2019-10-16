package frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */

public class InputFrame extends JFrame{
    protected static ArrayList persons = new ArrayList();
    
    protected final static String ACCEPT = "ACCEPT";
    protected final static String CLEAR = "CLEAR";
    protected final static String CLOSE = "CLOSE";
    
    protected GroupLayout layout;
    protected JLabel nameLabel, variableLabel;
    protected JTextField nameText, variableText;
    protected JButton acceptBtn, clearBtn, closeBtn;
    
    public InputFrame(){
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        createComponents();
        tuneLayout();
        pack();
    }
    
    public ArrayList getPersons(){
        return persons;
    }
    
    private void createComponents(){
        nameLabel = new JLabel("Name:");
        nameText = new JTextField();
        variableLabel = new JLabel();
        variableText = new JTextField();

        acceptBtn = new JButton("Accept");
        acceptBtn.setActionCommand(ACCEPT);
        //acceptBtn.addActionListener(this);
        clearBtn = new JButton("Clear");
        clearBtn.setActionCommand(CLEAR);
        //clearBtn.addActionListener(this);
        closeBtn = new JButton("Close");
        closeBtn.setActionCommand(CLOSE);
        //closeBtn.addActionListener(this);
    }
    
    private void tuneLayout(){
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(nameLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nameText)
                            .addComponent(variableLabel)
                            .addComponent(variableText)
                        )
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(acceptBtn)
                            .addComponent(clearBtn)
                            .addComponent(closeBtn)
                        )
                )
        );
        
        layout.linkSize(SwingConstants.HORIZONTAL, acceptBtn, clearBtn, closeBtn);
        
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameText)
                    .addComponent(variableLabel)
                    .addComponent(variableText)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(acceptBtn)
                            .addComponent(clearBtn)
                            .addComponent(closeBtn)
            
            )
        );   
    }
     
    protected void clear(){
        nameText.setText("");
        variableText.setText("");
    }
    
    protected void hideFrame(){
        clear();
        this.dispose();
    }
}
