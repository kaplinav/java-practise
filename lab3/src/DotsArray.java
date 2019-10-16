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

public class DotsArray {
    public int x[];
    public int y[];
    
    private int getDigit(FileReader fr) throws IOException {

            String num = new String();
            char ch = (char) fr.read();

            while (!Character.isWhitespace(ch)) {
                num += ch;
                ch = (char) fr.read();
            }
            
            return Integer.parseInt(num);
    }
    
    private void readDots(FileReader fr, int count) throws IOException {
        x = new int[count + 1];
        y = new int[count + 1];
            
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < count; j++) {
                if (i == 0){
                    x[j] = getDigit(fr);
                } else {
                    y[j] = getDigit(fr);
                }
            }
        }
        
        x[count] = x[0];
        y[count] = y[0];
    }
    
    public void getFromFile(String fileName) {
        File f = new File(fileName);
        
        try (FileReader fr = new FileReader(f)) {
            int count = getDigit(fr);
            
            if (count < 0 )
                throw new IOException();
            
            readDots(fr, count);
        } catch (IOException e) {
            
        }
    }
}
