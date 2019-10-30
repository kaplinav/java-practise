/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class Mammal extends Animal {
    protected String m_sound;
    
    public Mammal(String name, String sound) { super(name); m_sound = sound; }
    
    @Override
    public void sound() { System.out.println(m_sound); }
}
