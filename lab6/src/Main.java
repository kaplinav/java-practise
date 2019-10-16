
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

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new DatabaseReader();
            t.start();
        }
        
    }
}
