package person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class Faculty extends Person{
    public Faculty(String name, String degree) {
        super(name);
        this.degree = degree;
    }
    
    public String toString() {
        return this.m_name + " " + this.degree;
    }
    
    private String degree;
}
