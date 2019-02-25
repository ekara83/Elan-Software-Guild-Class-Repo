/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessme;

import java.util.Scanner;

/**
 *
 * @author elanaustin
 */
public class GuessMe {
    
    public static void main(String[] args) {
            Scanner inputReader = new Scanner(System.in);
          
          int mine = 11;
         
               
          System.out.println("I've chosen a number. Betcha Can't guess it!");
           
          System.out.println("Please guess the number:");
           double yourGuess = inputReader.nextDouble();
           
          if (yourGuess < 11) {
              System.out.println("Ha! nice try - too low! I chose:" + mine);
          }
          
          if (yourGuess > 11) {
              System.out.println("Too bad, way too high! I chose:" + mine);
          }
          
          if (yourGuess == 11) {
              System.out.println("Wow, nice guess! That was it!");
          }
                

     
    }
    
}
