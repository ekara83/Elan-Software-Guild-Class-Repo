/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevens;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author elanaustin
 */
public class LuckySevens {

   
    public static void main(String[] args) {
        
         Scanner inputReader = new Scanner(System.in);
         Random generator = new Random();
         
            
            int dice1, dice2,
             dollars,
             maxDollars,
             count,
             countAtMax,
             diceRolls;
     
        countAtMax = 0;
        count = 0;
        
        System.out.println("How many dollars do you have?");
        dollars = inputReader.nextInt();
        
        
        while (dollars > 0) {
            count++;
            
            dice1 = generator.nextInt (6) + 1;
            dice2 = generator.nextInt (6) + 1;
            
            if (dice1 + dice2 == 7) {
                dollars +=4;
            } 
            else if (dice1 + dice2 != 7) {
                dollars -=1;
            }
                
            
                    
                    
            
            
        }
           
        
        System.out.println("You are broke after     rolls.");
        System.out.println("You should have quit after  rolls when you had $"  );
             
    }


}
