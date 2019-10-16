/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task9;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */

public class FindInFile {
    public FindInFile(File file, boolean findNum, boolean findWord) {
        this.m_file = file;
        this.m_findNum = findNum;
        this.m_findWord = findWord;
    }
    
    public void find() {
        
        FiniteAutomaton a = new WordAutomaton();
        String value = "";
        words = new ArrayList();
        
        try(FileReader fr = new FileReader(m_file)){
            while(true){
                int result = fr.read();
                
                if (result == -1) break;
                
                if (a.work((char)result) > 0 ){
                    value += (char)result;
                }else {
                    if (value.length() > 0) {
                        words.add(value);
                        value = "";
                    }
                }
            }
        } catch(IOException e){ }
        
        if (words.size() != 0) { processWords(); }
    }
    
    private void checkNumber(String word) {
        Matcher m = NUM_PATT.matcher(word);
        
        if (m.find()) numbers.add(word);
    }
    
    private void checkWord(String word) {
        Integer count = m_wordsCount.get(word);
        m_wordsCount.put(word, count == null ? 1 : ++count );
    }
    
    private void processWords() {
      
        m_wordsCount = new HashMap<>();
        numbers = new ArrayList();
        
        int wordsCount = words.size();
        for (int i = 0; i < wordsCount; i++) {
            if (m_findNum) { checkNumber(words.get(i) ); }
            if (m_findWord) { checkWord(words.get(i) ); }
        }
        
        if (!m_wordsCount.isEmpty() || !numbers.isEmpty()) {
            writeToFile();
        }
    }
    
    private void writeToFile() {
        int count = 0;
        int uniqueWordsCount = 0;
        String toWrite = "";
        
        if (numbers.size() > 0) {
            count = numbers.size();
                
            for (int i = 0; i < count; i++) {
                toWrite += numbers.get(i);

                if (i < count - 1) toWrite += "\n";
            }
                
            toWrite += "\n";
        }
          
        boolean first = true; 
            
        for (Map.Entry<String, Integer> e : m_wordsCount.entrySet() ) {
            if (e.getValue() == 1) {
                if (first) {
                    first = false;
                } else {
                    toWrite += "\n";
                }
                toWrite += e.getKey();
                uniqueWordsCount++;
            }
        }
        
        try(FileWriter fw = new FileWriter("output.txt")) {
            fw.write(toWrite);
        } catch(IOException e ) { }
        
        JOptionPane.showMessageDialog(null, count+" numbers\n"+uniqueWordsCount+" unique words"); 
    }
    
    File m_file;
    boolean m_findNum, m_findWord;
    ArrayList<String> numbers;
    ArrayList<String> uniqueWords;
    ArrayList<String> words;
    Map<String, Integer> m_wordsCount;
    
    final static Pattern NUM_PATT = Pattern.compile("^-?\\d*\\.\\d+$");
}
