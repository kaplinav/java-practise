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

public abstract class InputFrame extends JFrame implements ActionListener{
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
    
    protected abstract void add();
    
    protected void accept(){
        if (checkInput()){
            add();
            JOptionPane.showMessageDialog(this, "ACCEPTED");
        }else {
            JOptionPane.showMessageDialog(this, "Wrong Input");
        }
    }
    
    protected void clear(){
        nameText.setText("");
        variableText.setText("");
    }
    
    protected abstract boolean checkInput();
    
    protected void hideFrame(){
        clear();
        this.dispose();
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
