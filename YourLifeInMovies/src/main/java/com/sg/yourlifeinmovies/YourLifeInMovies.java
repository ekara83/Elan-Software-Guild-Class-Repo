/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.yourlifeinmovies;

import java.util.Scanner; 

/**
 *
 * @author elanaustin
 */
public class YourLifeInMovies {
    public static void main(String[] args) {  
   
    Scanner inputReader = new Scanner(System.in);
    
     String yourName;
     double yourBirth;
      int up = 2005;
      int hp = 1995;
      int sj = 1985;
      int park = 1975;
      int mash = 1965;
    
     
     System.out.println("Now let's play a game! What is your name?");
     yourName = inputReader.nextLine();
     
     System.out.println("Ok "  +  yourName   +   "  when were you born?");
     yourBirth = inputReader.nextDouble();
     
     System.out.println("Well  " + yourName + "  ...");
     
     if (yourBirth < 2005) {
         System.out.println( "Did you know that Pixar's 'Up' came out half a decade ago?");
     }
     
     if (yourBirth < 1995) {
         System.out.println ("That the first Harry Potter came out over 15 years ago!");
     }
     
     if (yourBirth < 1985) {
         System.out.println ("Also, Space Jam came out not last decade, but the one before THAT.");
     }
     
     if (yourBirth < 1975) {
         System.out.println ("And that the original Jurrasic Park release is closer to the lunar landing, than today?");
         
     }
     
     if (yourBirth < 1965) {
         System.out.println("Lastly, MASH has been around for almost have a century!");
     }
    
    
     }
    
}
