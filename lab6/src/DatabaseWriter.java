
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

public class DatabaseWriter extends DatabaseWorker {

    public DatabaseWriter(String name, Database db) {
        super(name, db);
    }
    
    @Override
    public void run(){
        while (true) {
            sendMessage("is sleeping");
            sleepSomeTime();
            sendMessage("wants to write");
            db.startWrite();
            sendMessage("is writing");
            Database.doIO();
            db.endWrite();
            sendMessage("is done writing");
        }
    }
}