
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class MatrixTest {
    public MatrixTest() {
        testGet();
        testSet();
        testAdd();    
        testEquals();
        testRead();
    }
    
    private void testGet(){
        try {
            m1x1.get(5, 2);
            messageError("get. wrong indexes");
        } catch (MatrixException ex) {
            messageOk("get. wrong indexes");
        }
        
        try {
            m1x1.get(1, 1);
            
            if (m1x1.get(1, 1) == 0) {
                messageOk("get. value");
            }else {
                messageError("get. value");
            }
            
        } catch (MatrixException ex) {
            ex.getMessage();
        }
    }
    
    private void testSet(){
        try {
            m1x1.get(5, 2);
            messageError("set. wrong indexes");
        } catch (MatrixException ex) {
            messageOk("set. wrong indexes");
        }
        
        try {
            int value = m1x1.get(1, 1);
            value++;
            
            if (m1x1.set(1, 1, value) == value) {
                messageOk("set. value");
            }else {
                messageError("set. value");
            }
            
        } catch (MatrixException ex) { ex.getMessage(); }
    }
    
    private void testAdd() {
        other = null;
        try {
            m1x1.add(other);
            messageError("add. null-matrix");
        } catch (MatrixException ex) {
            messageOk("add. null-matrix");
        }
        
        other = new Matrix(3, 3);
        try {
            m1x1.add(other);
            messageError("add. different size matrix");
        } catch (MatrixException ex) {
            messageOk("add. different size matrix");
        }
        
        other = new Matrix(1, 1);
        try {
            int value = m1x1.get(1, 1);
            value *= -1;
            other.set(1, 1, value);
            
            m1x1.add(other);
            if (m1x1.get(1, 1) == 0){
                messageOk("add. sum of matrices with same size");
            }else {
                messageError("add. sum of matrices with same size");
            }
            
        } catch (MatrixException ex) {
            messageError("add. sum of matrices with same size");
        }
    }
    
    private void testEquals() {
        other = null;
        try {
            m1x1.equals(other);
            messageError("equals. null-matrix");
        } catch (MatrixException ex) {
            messageOk("equals. null-matrix");
        }
        
        other = new Matrix(2, 3);
        try {
            if (!m1x1.equals(other) ){
                messageError("equals. different size matrix");
            }else {
                messageOk("equals. different size matrix");
            }
            
        } catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
        
        other = new Matrix(1, 1);
        //other.set(1, 1, 1);
        try {
            m1x1.equals(other);
            
            if (m1x1.equals(other) ){
                messageOk("equals. matrices with same size");
            }else {
                messageError("equals. matrices with same size");
            }
            
        } catch (MatrixException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void testRead() {
        try {
            other = m1x1.read("ainwefnwefiwinf'wefew.exex");
            messageError("read. wrong filename");
        } catch (IOException ex) {
            //Logger.getLogger(MatrixTest.class.getName()).log(Level.SEVERE, null, ex);
            messageOk("read. wrong filename");
        }
        
        
        
    }
        
    private void messageOk(String s) {
        System.out.println("OK Method "+s);
    }
    
    private void messageError(String s) {
        System.out.println("ERROR Method "+s);
    }
    
    IMatrix other = new Matrix();
    IMatrix m1x1 = new Matrix(1, 1);
}
