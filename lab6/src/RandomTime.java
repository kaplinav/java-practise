
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class RandomTime {
    private final static int MIN = 29;
    private final static int MAX = 1000;
    
    public static int getRandomTime(int min, int max) {
        return min + (int)(Math.random() * max);
    }
    
    public static int getRandomTime(int max) {
        return getRandomTime(MIN, max);
    }
    
    public static int getRandomTime() {
        return getRandomTime(MIN, MAX);
    }
}
