/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ClosestToTen {
    
    private static final int TEN = 10;
    
    public static void findClosestNum(int a[][])
    {
        int size = a.length;
        int value, x,y;
        x = y = 0;
        value  = a[x][y];
        
        for (int i = 0; i < size; i++)
        {
            int subArrSize = a[i].length;
            
            for (int j = 0; j < subArrSize; j++) {
                if ( Math.abs(TEN - a[i][j]) < Math.abs(TEN - value) )
                {
                    x = i;
                    y = j;
                    value = a[i][j];
                }
            }
        }
        
        System.out.println("Closest to ten: "+value+" indexes: "+x+" "+y);
    }
}
