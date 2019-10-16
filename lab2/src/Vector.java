/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Vector extends Matrix{
    public Vector() { super(); };
    public Vector(int i) { super(i,1); };
    public Vector(Vector other) { 
        this(other.m_i);
        
        for (int i = 0; i < other.m_i; i++) {
            m_matrix[i][0] = other.m_matrix[i][0];
        }
    };
    
    public double length() {
        int sum = 0;
        
        for (int i = 0; i < m_i; i++) {
            sum += Math.pow(m_matrix[i][0], 2);
        }
        
        return Math.sqrt(sum);
    }
}
