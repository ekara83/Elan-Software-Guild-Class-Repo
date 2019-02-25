/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowsmaster;

import java.util.Scanner;

/**
 *
 * @author elanaustin
 */
public class WindowsMaster {
    public static void main(String[] args) {
        float height;
        float width;
       
        
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        
        Scanner sc = new Scanner(System.in);
       
        height = readValue("Please enter the window height:");
        width = readValue("Please enter window width:");
        
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
        
        System.out.println("Window Height = " + height);
        System.out.println("Window Width = "  + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
    
    public static float readValue(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String input = sc.nextLine();
        float floatVal = Float.parseFloat(input);
        return floatVal;
        
}

}