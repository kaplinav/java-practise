
import java.lang.Thread;
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

public class Main {
    private Database db;
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main(){
        db = new Database();
        DatabaseReader t1 = new DatabaseReader("reader 1", db);
        t1.start();
        DatabaseReader t2 = new DatabaseReader("reader 2", db);
        t2.start();
        DatabaseReader t3 = new DatabaseReader("reader 3", db);
        t3.start();
        
        DatabaseWriter t4 = new DatabaseWriter("writer 1", db);
        t4.start();
        DatabaseWriter t5 = new DatabaseWriter("writer 2", db);
        t5.start();
    }   
}