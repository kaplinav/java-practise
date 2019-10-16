/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.Thread;

/**
 *
 * @author User
 */

public class DatabaseReader extends Thread {
    @Override
    public void run(){
        System.out.println("DatabaseReader: " + this.getId());
    }
}
