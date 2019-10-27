/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Bird extends Animal {
    
    public Bird(String name) { super(name); }
    
    //public Bird(String name) { m_name = name; }
    
    @Override
    public void moves(){ System.out.println("Fly!"); }
    
    @Override
    public void sound() { System.out.println("Chirp!"); }
}
