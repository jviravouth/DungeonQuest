/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasttest;

import java.util.Scanner;
public class HastTest {

    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        GraphObj[] list = new GraphObj[5];
        
        list[0] = new GraphObj("Fire Room");
        list[1] = new GraphObj("Mirror Room");
        list[2] = new GraphObj("Waterways");
        list[3] = new GraphObj("Earth Room");
        list[4] = new GraphObj("Stone Room");
        
        list[0].createLinks(new GraphObj[]{list[1], list[3], list[4]});
        list[1].createLinks(new GraphObj[]{list[0], list[2], list[4]});
        list[2].createLinks(new GraphObj[]{list[0], list[1], list[3]});
        list[3].createLinks(new GraphObj[]{list[0], list[2]});
        list[4].createLinks(new GraphObj[]{list[0], list[1]});
        int x = 0;
        GraphObj walker = list[0];
        while(true)
        {
            x = 0;
            System.out.println("Current Room: " + walker.objName);
            System.out.println("Room Choices");
            while(x < walker.objLinks.length)
            {
               System.out.println((x + 1) + ". " + walker.objLinks[x].objName);
               x++;
            }
            walker = walker.objLinks[sc.nextInt() - 1];
        }
    }
}
