/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.spacerustlers;

/**
 *
 * @author elanaustin
 */
public class SpaceRustlers {
    
    public static void main(String[] args) {
        
        int spaceships = 10;
        int aliens = 25;
        int cows = 100;
        
        if(aliens > spaceships){
            System.out.println("Vrroom, vroom!Let's get going!" );
        } 
      
        
        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        
        }
        if(aliens > cows){
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } 
        
    }
    
}
