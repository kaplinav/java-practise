
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Database {
    private final static int MIN = 120;
    private final static int MAX = 1000;
    private boolean w = false;
    private boolean r = false;
    private int readersCount; 
    
    public Database() {
        readersCount = 0;
        w = false;
        r = false;
    }
    
    public synchronized void startRead(){
        while (w) {
            
            try {
                wait();
            } catch (InterruptedException ex) { 
                System.err.println("exception read");
            }
        }
        readersCount++;
        
        if (readersCount == 1) r = true;
    }
    
    public synchronized void endRead(){
        readersCount--;
        
        if (readersCount == 0) r = false;
        
        notifyAll();
    }
    
    public synchronized void startWrite(){
        while (w || r) {
            try {
                wait();
            } catch (InterruptedException ex) { 
                ex.printStackTrace();
                System.err.println("exception write");
            }
        }
        
        w = true;
    }
    
    public synchronized void endWrite(){
        w = false;
        
        notifyAll();
    }
    
    public static void doIO()
    {
        try {
            Thread.sleep((int)(Math.random() * 5000)); 
        } catch (InterruptedException e) {
        }
    }
}
