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
        return ((i - 1) >= 0 && (i - 1) < m_i) && ((j - 1) >= 0 && (j - 1) < m_j);
    }
    
    public boolean sizeIsEqual(IMatrix m) {
        // check that m not less than this matrix
        try {
            for (int i = 1; i <= m_i; i++)
                m.get(i, m_j);
        } catch (MatrixException e) {
            return false;
        }
        
        // check that m not greater than this matrix
        boolean isGreater = true;
        try {
                m.get(m_i + 1, 1);
            } catch (MatrixException e) {
                isGreater = false;
            }
        if (isGreater)
            return false;
        
        // check that m not greater than this matrix
        for (int i = 1; i <= m_i; i++ )
        {
            isGreater = true;
            try {
                m.get(i, m_j + 1);
            } catch (MatrixException e) {
                isGreater = false;
            }
            if (isGreater)
                return false;
        }
        
        return true;
    }
    
    private int getNumber(FileReader fr) {
        StringBuilder number = new StringBuilder();
        
        try {
            char symbol = (char) fr.read();
            while(Character.isDigit(symbol)) {
                number.append(symbol);
                symbol = (char) fr.read();
            }
        } catch (IOException e) {
            
        }
        return Integer.parseInt(number.toString());
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
        if (!sizeIsEqual(other)) throw new MatrixException();
            
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
        FileReader fr = new FileReader(file);
        int rows = getNumber(fr);
        int cols = getNumber(fr);
        m = new Matrix(rows, cols);

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                try {
                    m.set(i, j, getNumber(fr));
                } catch (MatrixException e) {
                    fr.close();
                    throw new IOException();
                }
            }
        }
        fr.close();
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
        StringBuilder output = new StringBuilder(m_i + " " + m_j + "\n");
        
        for (int i = 0; i < m_i; i++) {
            for (int j = 0; j < m_j; j++) {
                output.append(m_matrix[i][j]);
                if (j != m_j - 1) output.append(" ");
            }
            if (i != m_i - 1) output.append("\n");
        }
        File f = new File(file);
        FileWriter fw = new FileWriter(f);
        fw.write(output.toString());
        fw.close();
    }
}
