
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

public class DatabaseReader extends DatabaseWorker {

    public DatabaseReader(String name, Database db) {
        super(name, db);
    }
    
    @Override
    public void run(){
        while (true) {
            sendMessage("is sleeping");
            //System.err.println(super.getName() + " is sleeping");
            sleepSomeTime();
            sendMessage("wants to read");
            //System.err.println(super.getName() + " wants to read");
            db.startRead();
            sendMessage("is reading");
            //System.err.println(super.getName() + " is reading");
            Database.doIO();
            db.endRead();
            sendMessage("is done reading");
            //System.err.println(super.getName() + " is reading");
        }
    }
}
