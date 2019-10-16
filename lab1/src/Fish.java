/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Fish extends Animal {
    
    public Fish(String name) { m_name = name; }
    
    @Override
    public void moves(){ System.out.println("Swim!"); }
    
    @Override
    public void sound() { System.out.println("nothing"); }
    
    @Override
    public void output() { System.out.println(m_name+" : Fish"); }
}
