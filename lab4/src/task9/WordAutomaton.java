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

enum wordState {
    WAIT,
    ACCUMULATE
}

public class WordAutomaton implements FiniteAutomaton {
    
    public WordAutomaton() {
        state = wordState.WAIT;
    }
    
    @Override
    public int work(char s) {
        int result = 0;
        
        switch (state) {
            case WAIT:
                if ( (s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z') ) {
                    state = wordState.ACCUMULATE;
                    result = 1;
                } else {
                    state = wordState.WAIT;
                    result = 0;
                }
                
                break;
            case ACCUMULATE:
                if (s == ' '){
                    state = wordState.WAIT;
                    result = 0;
                } else {
                    state = wordState.ACCUMULATE;
                    result = 1;
                }
                
                break;
        }
        return result;
    }
    
    private wordState state;
}
