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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    public DVDLibrary addDVD(String dvdTitle, DVDLibrary dvdLibrary)  throws DVDLibraryDaoException  {
       
       DVDLibrary newDVD = dvds.put(dvdTitle, dvdLibrary);
       writeDVD();
       return newDVD;
    }

    @Override
    public DVDLibrary removeDVD(String dvdTitle) throws DVDLibraryDaoException {
      DVDLibrary removedDVD = dvds.remove(dvdTitle);
      writeDVD();
      return removedDVD;
    }

    @Override
    public DVDLibrary editDVD(String dvdTitle, DVDLibrary dvdLibrary) throws DVDLibraryDaoException {
        DVDLibrary editDVD = dvds.put(dvdTitle, dvdLibrary);
        writeDVD();  
        return editDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVDs() throws DVDLibraryDaoException {
        loadDVD();
        return new ArrayList<DVDLibrary>(dvds.values());
    }

    @Override
    public DVDLibrary getDVD(String dvdTitle) throws DVDLibraryDaoException {
        loadDVD();
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
                
                DVDLibrary currentDVD = new DVDLibrary(currentTokens[0]);
                currentDVD.setDvdTitle(currentTokens[0]);
                currentDVD.setReleaseDate(currentTokens[1]);
                currentDVD.setMpaaRating(currentTokens[2]);
                currentDVD.setDirectorsName(currentTokens[3]);
                currentDVD.setStudio(currentTokens[4]);
                currentDVD.setUserRating(currentTokens[5]);
                
            dvds.put(currentDVD.getDvdTitle(), currentDVD);
            }
        
            scanner.close();
    }
    
    private void writeDVD() throws DVDLibraryDaoException { 
        PrintWriter out;
        
        try { 
               out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save student data.", e);
        }
        
        List<DVDLibrary>dvdList = this.getAllDVDs();
        for (DVDLibrary currentDVD : dvdList) {
            out.println(currentDVD.getDvdTitle() + DELIMITER 
            + currentDVD.getMpaaRating() + DELIMITER
            + currentDVD.getReleaseDate() + DELIMITER
            + currentDVD.getDirectorsName() + DELIMITER
            + currentDVD.getStudio() + DELIMITER
            + currentDVD.getUserRating());
            
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean Up
        out.close();
    }
    
    

   

      
}
