/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author elanaustin
 */
public class DVDLibraryView {

    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("=== Main Menu === ");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Information");
        io.print("4. List All DVDs");
        io.print("5. Display DVD Information");
        io.print("6. Search DVD by Title");
        io.print("7. Exit");
      return io.readInt("Please select from the above choices.");
    }
    
    public DVDLibrary getNewDVDInfo() {
        String dvdTitle = io.readString("Please enter DVD Title");
        String dvdReleaseDate = io.readString("Please enter Release Date");
        String directorsName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter your User Rating");
        DVDLibrary currentDVD = new DVDLibrary(dvdTitle);
        return currentDVD;
               
    }
    
    public void displayCreateDVDBanner() {
        io.print("==== Create DVD ====");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("DVD successfully created. Please hit enter to continue");
    }
    
    public void displayDVDLibrary(List<DVDLibrary>dvdList) {
        for (DVDLibrary currentDVD : dvdList) {
            io.print(currentDVD.getDvdTitle() + " : " +  currentDVD.getReleaseDate() + " : "
            + currentDVD.getMpaaRating() + " : " + currentDVD.getDirectorsName() + " : " + currentDVD.getStudio() 
            + " : " + currentDVD.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print(" ==== Display All DVDS === ");
    }
    
    public void displayDisplayDVDsBanner() {
        io.print("=== Display DVDs === ");
    }
    
    public String getDVDChoice() {
        return io.readString("Please enter the DVD Title");
    }
    
    public void displayDVDBanner(DVDLibrary dvdLibrary) {
        if (dvdLibrary != null ){
            
            io.print(dvdLibrary.getDvdTitle());
            io.print(dvdLibrary.getReleaseDate());
            io.print(dvdLibrary.getMpaaRating());
            io.print(dvdLibrary.getDirectorsName());
            io.print(dvdLibrary.getStudio());
            io.print(dvdLibrary.getUserRating() + " ");  
        } else {
            io.print("No such DVD Title.");
        }
        io.readString("Please hit enter to continue.");
        
    }
   
    public void displayRemoveDVDBanner() {
        io.print(" === Remove DVD === ");
    }
    
    
    public void displayRemoveDVDSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }
    
   private DVDLibrary editDVDInfo() {
        String dvdTitle = io.readString("Please enter DVD Title");
        String dvdReleaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorsName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter your User Rating");
        DVDLibrary editedDVD = new DVDLibrary(dvdTitle);
        editedDVD.setDvdTitle(dvdTitle);
        editedDVD.setReleaseDate(dvdReleaseDate);
        editedDVD.setMpaaRating(mpaaRating);
        editedDVD.setDirectorsName(directorsName);
        editedDVD.setStudio(studio);
        editedDVD.setUserRating(userRating);
        return editedDVD;
    }
   
    public void displayeditDVDBanner() {
        io.print(" === Edit DVD === ");
    }
    
    
    public void displayEditedDVDSuccessBanner() {
        io.readString("DVD successfully edited. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!");
    }
    
    
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }
   
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
}

