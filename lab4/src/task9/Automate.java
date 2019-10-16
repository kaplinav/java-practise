/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task9;

/**
 *
 * @author User
 */

public class Automate {
    public Automate() { state = aState.WAIT; }
    
    public int work(char s) {
        int result = 0;
        switch(state) {
            case WAIT:
                if (s == ' ' || s == ',' || s == '.' || s == ';')
                    state = aState.BEFORE_DOT;
                result = 0;
                break;
            case BEFORE_DOT:
                if (s >= '0' && s <= '9' ) {
                    state = aState.BEFORE_DOT;
                    result = 1;
                } else if (s == '.') {
                    state = aState.AFTER_DOT;
                    result = 1;
                } else {
                    state = aState.WAIT;
                    //value = "";
                    result = 0;
                }   
                break;
            case AFTER_DOT:
                if (s >= '0' && s <= '9' ) {
                    state = aState.AFTER_DOT;
                    result = 1;
                } else if (s == ' ' || s == ',' || s == '.' || s == ';') {
                    state = aState.WAIT;
                    //System.out.println(value);
                    //value = "";
                    result = 0;
                } else {
                    state = aState.WAIT;
                    //value = "";
                    result = 0;
                }
                break;
        }
        return result;
    }
    
    aState state;
    String value = "";
}
