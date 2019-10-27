
import com.sun.source.tree.CaseTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MainClass {
    
    public static void task3(){
        int count = 10;
        Employee emp[] = new Employee[count];
        
        for (int i = 0; i < count; i++) {
            int countOfParameters = TestValues.getRandNum(1, 3);
            
            // Creating objects with different parameters of constructor
            switch (countOfParameters){
                case 1:
                    emp[i] = new Employee(TestValues.getRandName());
                    break;
                case 2:
                    emp[i] = new Employee(TestValues.getRandName(), 
                            TestValues.getRandJobs());
                    break;
                case 3:
                    emp[i] = new Employee(TestValues.getRandName(), 
                            TestValues.getRandJobs(), TestValues.getRandNum(10000));
                    break;  
            }
        }
        
        Employee.showEmployeesList(emp);
    }
    
    public static void task4()
    {
        Animal an[] = {new Fish("Shark"),new Bird("Eagle"),
            new SeaMammal("Killer whale", "Die!"),new TerreMammal("Dog", "Don't lean!")};

        for (Animal a : an){
            a.output();
            a.moves();
            a.sound();
        }
    }
    
    public static void main(String[] args) {
        // Task 1
        //new ThreeNums().printSort();

        // Task 2
//        ArrayTriangle ar1 = new ArrayTriangle();
//        ar1.createArrayTriangle();
//        ClosestToTen.findClosestNum(ar1.getArrayTriangle());
        
        // Task 3
        //task3();
        
        //Task 4
        task4();
    }
}