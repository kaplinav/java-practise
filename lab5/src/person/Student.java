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

public class Student extends Person {
    public Student(String name, int age) {
        super(name);
        this.age = age;
    }
    
    @Override
    public String toString() {
        return this.m_name + " " + age;
    }
    
    private int age;
}

