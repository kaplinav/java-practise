
import java.lang.Thread;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class DatabaseWorker extends Thread {
    private final static int MIN = 100;
    private final static int MAX = 999;
    protected Database db;
       
    public DatabaseWorker(String name, Database db) {
        super(name);
        this.db = db;
    }
    
    public void sleepSomeTime() {
        try {
            sleep(RandomTime.getRandomTime(MIN, MAX));
        } catch (InterruptedException ex) {
            ex.getMessage();
        }
    }
    
    public void sendMessage(String message) {
        Monitor.getMonitor().sendMessage(super.getName() + " " + message);
    }
}
