/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public abstract class Animal {
    protected String m_name;
    
    public Animal(String name) { m_name = name; }
    
    public abstract void moves();
    public abstract void sound();
    public void output() { System.out.println(this.getClass()+" name "+m_name); };
}
