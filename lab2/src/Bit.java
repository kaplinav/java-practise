/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Bit implements IBit {
    
    private int bits[];
    
    public Bit() {
        bits = new int [128];
    }
    
    private boolean indexIsCorrect(int n) {
        return (n >= 0 || ((n / 32) - 1) < bits.length);
    }
    
    private int setMask(int n) {
        int mask = 1;
        return ( mask <<= (n % 32) );
    }
    
    @Override
    public boolean checkBit(int n) throws Exception {
        if (!indexIsCorrect(n))
            throw new Exception();
        
        int mask = setMask(n);
        int b = bits[(n / 32)] & mask;
        return (b != 0);
    }

    @Override
    public boolean turnOnBit(int n) throws Exception {
        if (!indexIsCorrect(n))
            throw new Exception();
        
        // false - если значение бита уже было равно 1
        if (checkBit(n))
            return false;
        
        int mask = setMask(n);
        bits[(n / 32)] |= mask;
        return true;
    }

    @Override
    public boolean turnOffBit(int n) throws Exception {
        if (!indexIsCorrect(n))
            throw new Exception();
        
        // false - если значение бита уже было равно 0
        if (!checkBit(n))
            return false;
        
        int mask = setMask(n);
        bits[(n / 32)] ^= mask;
        
        return true;
        
    }

    @Override
    public boolean invertBit(int n) throws Exception {
        if (!indexIsCorrect(n))
            throw new Exception();
        
        return checkBit(n) ? turnOffBit(n) : turnOnBit(n);
    }
}
