/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author elanaustin
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVDLibrary addDVD(String dvdTitle, DVDLibrary dvdLibrary) {
       DVDLibrary newDVD = dvds.put(dvdTitle, dvdLibrary);
       return newDVD;
    }

    @Override
    public DVDLibrary removeDVD(String dvdTitle) {
      DVDLibrary removedDVD = dvds.remove(dvdTitle);
      return removedDVD;
    }

    @Override
    public DVDLibrary editDVD(String dvdTitle, DVDLibrary dvdLibrary) {
      DVDLibrary editDVD = dvds.put(dvdTitle, dvdLibrary);
      return editDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVDs() {
        return new ArrayList<DVDLibrary>(dvds.values());
    }

    @Override
    public DVDLibrary getDVD(String dvdTitle) {
        return dvds.get(dvdTitle);     
    }

   
    
    private Map<String, DVDLibrary> dvds = new HashMap();
    
    private void loadDVD() throws DVDLibraryDaoException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
            
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException ("-_- Could not load roster data into memory.", e);
            
        } 
            String currentLine;
            String[] currentTokens;
            
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                // break up the line into tokens
                currentTokens = currentLine.split(DELIMITER);
                // create a new DVD object and put it into the map of DVDs
                // use the DVD Title which is the 
                DVDLibrary dvdLibrary = new DVDLibrary(currentTokens[1]);
                dvdLibrary.setDvdTitle(currentTokens[0]);
                dvdLibrary.setReleaseDate(currentTokens[1]);
                dvdLibrary.setMpaaRating(currentTokens[2]);
                dvdLibrary.setDirectorsName(currentTokens[3]);             
                dvdLibrary.setStudio(currentTokens[4]);
                dvdLibrary.setUserRating(currentTokens[5]);
            
            
            }
        
    }

      
}
