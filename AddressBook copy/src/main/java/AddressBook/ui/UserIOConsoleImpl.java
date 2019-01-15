/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.ui;

import java.util.Scanner;
/**
 *
 * @author elanaustin
 */
public class UserIOConsoleImpl implements UserIO {
    private Scanner userInput = new Scanner(System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        double numInput = Double.parseDouble(input);
        return numInput;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        double minInput = Double.parseDouble(input);
        
        System.out.println(prompt);
        input = userInput.nextLine();
        double maxInput = Double.parseDouble(input);
        return maxInput;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        float numInput = Float.parseFloat(input);
        return numInput;
        
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        float minInput = Float.parseFloat(input);
        
        System.out.println(prompt);
        input = userInput.nextLine();
        float maxInput = Float.parseFloat(input);
        return maxInput;
    }

    @Override
    public int readInt(String prompt) {
          System.out.println(prompt);
        String input = userInput.nextLine();
        int numInput = Integer.parseInt(input);
        return numInput;
       
    }

    @Override
    public int readInt(String prompt, int min, int max) {
          System.out.println(prompt);
        String input = userInput.nextLine();
        int minInput = Integer.parseInt(input);
        
       
        System.out.println(prompt);
        input = userInput.nextLine();
        int maxInput = Integer.parseInt(input);
        return maxInput;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        long numInput = Long.parseLong(input);
        return numInput;
        
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String input = userInput.nextLine();
        long minInput = Long.parseLong(input);
        
        System.out.println(prompt);
        input = userInput.nextLine();
        long maxInput = Long.parseLong(input);
        return maxInput;
        
        
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        
        return prompt;
    }

    
}
