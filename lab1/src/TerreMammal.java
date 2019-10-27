/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TerreMammal extends Mammal{
    
    public TerreMammal(String name, String sound){
        super(name, sound);
    }

    @Override
    public void moves() {
        System.out.println("Run!");
    }

    @Override
    public void sound() {
        System.out.println(m_sound);
    }
}
