
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class ThreeNums {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private int m_a, m_b, m_c;
    
    private void readNumbers()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("write number 1");
        m_a = in.nextInt();
        System.out.println("write number 2");
        m_b = in.nextInt();
        System.out.println("write number 3");
        m_c = in.nextInt();
    }
    
    public void printSort()
    {
        readNumbers();
        
        if (m_a > m_b)
        {
            int t = m_a;
            m_a = m_b;
            m_b = t;
        }
        
        if (m_b > m_c)
        {
            int t = m_b;
            m_b = m_c;
            m_c = t;
        }
        
        if (m_a > m_b)
        {
            int t = m_a;
            m_a = m_b;
            m_b = t;
        }
        
        System.out.println(m_a+" "+m_b+" "+m_c);
    }
    
    private int getRandom()
    {
        return MIN + (int)(Math.random() * MAX);
    }
}
