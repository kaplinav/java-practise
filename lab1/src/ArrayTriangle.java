/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author User
 */
public class ArrayTriangle {
    private int m_arrayTriangle[][]; // triangle array 
    private int m_size; // triangle array size
    
    // Input array triangle size from keyboard
    public void createArrayTriangle()
    {
        do {
            m_size = Integer.parseInt(JOptionPane.showInputDialog("Input array triangle size"));
        } while (m_size <= 0);
        
        m_arrayTriangle = new int[m_size][];
        fillArrayTriangle();
    }
    
    //Fill array triangle from keyboard
    private void fillArrayTriangle()
    {
        // Count of numbers in array triangle
        int total = ((1 + m_size) * m_size) / 2;
        
        for (int i = 0; i < m_size; i++) {
            m_arrayTriangle[i] = new int[i + 1];
            
            //Input values from keyboard        
            for (int j = 0; j < i + 1; j++) {
                total--;
                m_arrayTriangle[i][j] = Integer.parseInt( JOptionPane.showInputDialog("Input value. Remain: "+total) );
            }
        }
        
        showArrayTriangle();
    }
    
    public int[][] getArrayTriangle()
    {
        return m_arrayTriangle;
    }
    
    // Output array triangle values on screen
    private void showArrayTriangle()
    {
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < i + 1; j++) System.out.print(m_arrayTriangle[i][j]+" ");
            System.out.print("\n"); 
        }
    }
}
