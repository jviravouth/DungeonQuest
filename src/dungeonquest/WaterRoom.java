/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonquest;

import java.util.Scanner;
import java.util.Random;

public class WaterRoom 
{
    static Room waterRoom = new Room("Waterways", "There is a barely man sized hole in "
            + "the opposite wall with water at its base. There is also a plaque "
            + "adjacent to the hole.", "A wooden door",
            "The door to this room is warped and covered in tar to keep in moisture." +
            "As the water slowly rises you start to "
            + "lose space for breathing and everything goes black.");
    
    public static void waterPuzzle()
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        boolean test = true;
        boolean hasTorch = false;
        boolean correctPath = true;
        
        int input;
        int length = 8;
        int timeLimit = 10;
        int turn;
        int[] path = new int[8];
        int[] pathTaken = new int[9];
        for(int i = 0;i < length; i++)
        {
            path[i] = rand.nextInt(3);
        }
        
        System.out.println("There is a torch next to the plaque");
        //Hub Room Actions
        while(test)
        {
            if(!hasTorch)
            {
                System.out.println("What will you do?\n1.Pick up the torch.\n"
                    + "2.Examine the plaque.\n3.Go through the hole.");
            
                input = sc.nextInt();
            }
            else
            {
                System.out.println("What will you do?\n1.Examine the plaque.\n"
                    + "2.Go through the hole.");
                input = sc.nextInt() + 1;
            }
            switch(input)
            {
                case 1:
                    System.out.println("You pick up the torch.");
                    hasTorch = true;
                    break;
                case 2:
                    if(hasTorch)
                    {
                        System.out.println(plaqueText(path));
                    }
                    else
                    {
                        System.out.println("It is too dark to fully make out what the plaque says.");
                    }
                    break;
                case 3:
                    System.out.println("You make your way into the tightly "
                            + "packed waterways. You have to crawl through this "
                            + "tiny labyrinth and as you do a bit of the rock "
                            + "beneath you gives way.\nYou have just triggered a "
                            + "trap and the waterways slowly start to fill with "
                            + "water. You will have to navigate quicly to survive and escape.");
                    if(!hasTorch)
                        System.out.print("Without the torch you will move much slower through the waterways.");
                    test = false;
                    break;
            };   
        }
        test = true;
        //Labyrinth actions
        turn = 0;
        while(test)
        {
            if(turn == 8){
                for(int i = 0; i < path.length; i++)
                    if(pathTaken[i] != path[i])
                    {
                        System.out.println(waterRoom.getDeathState());
                        correctPath = false;
                        test = false;
                        break;
                    }
                if(correctPath)
                {
                    System.out.println("You have made it out of the waterways");
                    test = false;
                    break;
                }
            }
            if(!hasTorch && turn == 7)
            {
                System.out.print("You can see light coming from ");
                switch(path[7])
                {
                    case 0:
                        System.out.print("the left.\n");
                        break;
                    case 1:
                        System.out.print("ahead.\n");
                        break;
                    case 2:
                        System.out.print("the right.\n");
                        break;
                }
            }
            if(timeLimit <= 0)
            {
                System.out.println(waterRoom.getDeathState());
                test = false;
                break;
            }
            System.out.println("What do you do?\n1.Go left\n2.Go forward\n3.Go right\n4.Go back");
            if(hasTorch)
                System.out.println("5.Extinguish torch");
            input = sc.nextInt();
            switch(input)
            {
                case 1:
                    pathTaken[turn] = 0;
                    turn++;
                    timeLimit--;
                    if(!hasTorch)
                        timeLimit--;
                    break;
                case 2:
                    pathTaken[turn] = 1;
                    turn++;
                    timeLimit--;
                    if(!hasTorch)
                        timeLimit--;
                    break;
                case 3:
                    pathTaken[turn] = 2;
                    turn++;
                    timeLimit--;
                    if(!hasTorch)
                        timeLimit--;
                    break;
                case 4:
                    if(turn == 0)
                    {
                        System.out.println("You cannot go back this early.");
                        break;
                    }
                    else
                    {
                        turn--;
                        timeLimit--;
                        if(!hasTorch)
                            timeLimit--;
                        break;
                    }
                case 5:
                    hasTorch = false;
                    break;
            }
        }
    }
    //Direction into text
    public static String direct(int x)
    {
       switch(x)
       {
           case 0: return "left";
           case 1: return "forward";
           case 2: return "right";
       };
       return "";
    }
    //Create plaque text
    public static String plaqueText(int[] path)
    {
        String text;
        String pathText = direct(path[0]);
        for(int i = 1; i < path.length - 2; i++)
            pathText = pathText + ", " + direct(path[i]);
        text = ("The plaque reads:\"A travelor comes to town and asks two locals, Bill and Tim, how to get to the next town over.\nBill wants to help the man while Tim wants to lead him down the wrong path.\n1Bill says to go " + pathText + ".");
        if(path[0] == 2)
            pathText = direct(0);
        else
            pathText = direct(path[0] + 1);
        for(int i = 1; i < path.length - 2; i++)
        {
            if(path[i] == 2)
                pathText = pathText + ", " + direct(0);
            else
                pathText = pathText + ", " + direct(path[i] + 1);
        }
        text = text + "\nTim says to go " + pathText + ".";
        switch(path[6])
        {
            case 0: 
                pathText = "\nBill then says to go forward, but he is incorrect, and Tim says to go right.";
                break;
            case 1:
                pathText = "\nBill then says to go left, but he is incorrect, and Tim says to go right.";
                break;
            case 2:
                pathText = "\nBill then says to go left, but he is incorrect, and Tim says to go forward.";
                break;
        }
        text = text + pathText;
        text = text + "\nThey both agree that the path from this point forward will be clear due to the glow of the town in the night.";
        return text;
    }
}
