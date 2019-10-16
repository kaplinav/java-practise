/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TestValues {
    
    private static String m_names[] = {"EVE", "DANIEL", "LYDIA", "GEORGE",
        "HOLLIE", "JULIA", "SAMUEL", "AIMEE", 
        "JAMES", "JOSEPH", "WILLIAM", "EVELYN"};
    
    private static String m_jobs[] = {"Architect", "Designer", "Teacher",
        "Chemist", "Doctor", "Programmer", "Pilot", 
        "Consultant", "Mechanic", "Trainer", "Veterinarian"};
    
    public static String getRandJobs()
    {
        return m_jobs[getRandNum(m_jobs.length)];
    }
    
    public static String getRandName()
    {   
        return m_names[getRandNum(m_names.length)];
    }
    
    public static int getRandNum(int start, int end) 
    { 
        return start + (int) (Math.random() * end);
    }
    
    public static int getRandNum(int end) { return getRandNum(0, end); }
    
}
