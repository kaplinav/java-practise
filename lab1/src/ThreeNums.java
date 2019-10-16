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
    private int m_a, m_b, m_c;
    
    public ThreeNums(int a, int b, int c)
    {
        m_a = a;
        m_b = b;
        m_c = c;
    }
    
    public void printSort()
    {
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
}
