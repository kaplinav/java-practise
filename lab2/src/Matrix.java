/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import java.io.*;

public class Matrix implements IMatrix{
    
    protected int m_matrix[][];
    protected int m_i;
    protected int m_j;
    
    public Matrix(){ this(0,0); }
    public Matrix(int i, int j){ 
        m_i = i;
        m_j = j;
        m_matrix = new int[m_i][m_j];
    }
    public Matrix(Matrix m){
        this(m.m_i,m.m_j);
        
        for (int i = 0; i < m_i; i++) {
            System.arraycopy(m.m_matrix[i], 0, m_matrix[i], 0, m_j);
        }
    }
    
    private boolean indexIsCorrect(int i, int j){
        if (i < 1 || j < 1) 
            return false;
        if (i > m_matrix.length) 
            return false;
        if (j > m_matrix[i - 1].length) 
            return false;
        
        return true;
    }
    
    private boolean sizeIsEqual(IMatrix m) {
        try {
            for (int i = 1; i <= m_i; i++) { m.get(i, 1); }
            for (int j = 1; j <= m_j; j++) { m.get(1, j); }
        } catch (MatrixException e) {
            return false;
        }
        
        boolean isEqual = false;
        try {
            m.get(m_i + 1, 1);
        } catch (MatrixException e) { isEqual = true; }
        
        isEqual = false;
        try {
            m.get(m_i + 1, 1);
        } catch (MatrixException e) { isEqual = true; }
        
        return isEqual;
    }
    
    private int getDigit(FileReader fr) {
        String number = new String();
        
        try {
            char symbol = (char) fr.read();
            while(Character.isDigit(symbol)) {
                number += symbol;
                symbol = (char) fr.read();
            }
        } catch (IOException e) {
            
        }
        return Integer.parseInt(number);
    }
    
    @Override
    public IMatrix add(IMatrix other) throws MatrixException {
        if (other == null) throw new MatrixException("Null pointer");
        if (!sizeIsEqual(other)) throw new MatrixException("Wrong size");
        
        for (int i = 1; i <= m_i; i++) {
            for (int j = 1; j <= m_j; j++) {
                m_matrix[i - 1][j - 1] += other.get(i, j);
            }
        }
        return this;
    }

    @Override
    public boolean equals(IMatrix other) throws MatrixException {
        if (other == null) throw new MatrixException("Null pointer");
        
        for (int i = 1; i <= m_i; i++) {
            for (int j = 1; j <= m_j; j++) {
                try {
                    if (m_matrix[i - 1][j - 1] != other.get(i, j)) return false;
                } catch (MatrixException e) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int get(int i, int j) throws MatrixException {
        if (!indexIsCorrect(i,j))
            throw new MatrixException();
        
        return m_matrix[i - 1][j - 1];
    }

    @Override
    public void output() {
        
        for (int i = 0; i < m_i; i++) {
            for (int j = 0; j < m_j; j++) {
                System.out.print(m_matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public IMatrix read(String file) throws IOException {
        Matrix m = null;
        File f = new File(file);
        
        if (!f.exists()) throw new IOException();
        
        try (FileReader fr = new FileReader(file)) {
            int rows = getDigit(fr);
            int cols = getDigit(fr);
            m = new Matrix(rows, cols);
            
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    try {
                        m.set(i, j, getDigit(fr));
                    } catch (MatrixException e) {
                        throw new IOException();
                    }
                }
            }
        }catch (IOException e) {
            
        }
        
        return m;
    }

    @Override
    public int set(int i, int j, int value) throws MatrixException {
        if (!indexIsCorrect(i,j))
            throw new MatrixException();
        //int oldValue = m_matrix[i][j];
        m_matrix[i - 1][j - 1] = value;
        //return oldValue;
        return m_matrix[i - 1][j - 1];
    }

    @Override
    public void write(String file) throws IOException {
        File f = new File(file);
        String output = m_i + " " + m_j + "\n";
        
        for (int i = 0; i < m_i; i++) {
            for (int j = 0; j < m_j; j++) {
                output += m_matrix[i][j];
                if (j != m_j - 1) output += " ";
            }
            if (i != m_i - 1) output += "\n";
        }
        
        try (  FileWriter fw = new FileWriter(f) ) {
            fw.write(output);
        } catch (IOException e) {
            
        }
    }
}
