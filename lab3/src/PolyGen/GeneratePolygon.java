/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyGen;

/**
 *
 * @author User
 */

public class GeneratePolygon {    
    public static int[][] generateDots(int vertexCount, int xO, int yO, int minEdge, int maxEdge) {
        int angle = getRandomInt(0, 360);
        
        double m = minEdge / (2 * Math.sin((180 / vertexCount) * (Math.PI / 180)));
        double M = maxEdge / (2 * Math.sin((180 / vertexCount) * (Math.PI / 180)));
        
        int length = getRandomInt((int) m, (int) M);
        
        int fi = getRandomInt(0, (360 / vertexCount)) - (360 / vertexCount) / 2;
        
        int dots[][] = new int[2][vertexCount];
        
            
        for (int i = 1; i <= vertexCount ; i++) {
            
            double x = xO + Math.cos(angle + ((360 / vertexCount) * i + fi) * Math.PI / 180 ) * length;
            dots[0][i - 1] = (int) x;
            
            double y = xO + Math.sin(angle + ((360 / vertexCount) * i + fi) * Math.PI / 180 ) * length;
            dots[1][i - 1] = (int) y;
        }
        
        
//        for (int i = 0; i < vertexCount; i++) {
//            System.out.print(dots[0][i]);
//            
//            if (i != (vertexCount - 1)) System.out.print(" ");
//        }
//        
//        System.out.print("\n");
//        
//        for (int i = 0; i < vertexCount; i++) {
//            System.out.print(dots[1][i]);
//            
//            if (i != (vertexCount - 1)) System.out.print(" ");
//        }
        
        return dots;
    }
    
    private static int getRandomInt(int min, int max) {
        return min + (int) (Math.random() * max);
    }
}
