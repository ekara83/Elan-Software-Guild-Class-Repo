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
        io.print("6. Exit");
      return io.readInt("Please select from the above choices.");
    }
    
    public DVDLibrary getNewDVDInfo() {
        String dvdID = io.readString("Please enter DVD ID");
        String dvdTitle = io.readString("Please enter DVD Title");
        String dvdReleaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorsName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter your User Rating");
        DVDLibrary currentDVD = new DVDLibrary(dvdTitle);
        
        currentDVD.setDvdID(dvdID);
        currentDVD.setDvdTitle(dvdTitle);
        currentDVD.setReleaseDate(dvdReleaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
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
            io.print(currentDVD.getDvdID() + " : " + currentDVD.getDvdTitle() + " : " +  currentDVD.getReleaseDate() + " : "
            + currentDVD.getMpaaRating() + " : " + currentDVD.getDirectorsName() + " : " + currentDVD.getStudio() 
            + " : " + currentDVD.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print(" ==== Display All DVDS === ");
    }
    
    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD === ");
    }
    
    public String getDVDChoice() {
        return io.readString("Please enter the DVD Title");
    }
    public String getDVDId() {
        return io.readString("Please enter the DVD ID");
    }
    public void displayDVD(DVDLibrary dvdLibrary) {
        if (dvdLibrary != null){
            io.print(dvdLibrary.getDvdID());
            io.print(dvdLibrary.getDvdTitle());
            io.print(dvdLibrary.getReleaseDate());
            io.print(dvdLibrary.getMpaaRating());
            io.print(dvdLibrary.getDirectorsName());
            io.print(dvdLibrary.getStudio());
            io.print(dvdLibrary.getUserRating());  
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
        
    }
   
    public void displayRemoveDVDBanner() {
        io.print(" === Remove DVD === ");
    }
    
    
    public void displayRemoveDVDSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }
   
    public void displayEditDVDBanner() {
        io.readString(" === Edit DVD === ");
    }
 
      public String editDVDTitle() {
        String newdvdTitle = io.readString("Please change DVD Title");
        return newdvdTitle;
    }
      
      public String editReleaseDate() {
          String newReleaseDate = io.readString("Please change Release Date");
          return newReleaseDate;
      }
      
    public String editMpaaRating() {
        String newMpaaRating = io.readString("Please change MPAA Rating");
        return newMpaaRating;
    }
    
    public String editDirectorsName() {
        String newDirectorsName = io.readString("Please change Director's Name");
        return newDirectorsName;
    }
    
    public String editStudio() {
        String newStudio = io.readString("Please change Studio Name");
        return newStudio;
    }
    
    public String editUserRating() {
        String newUserRating = io.readString("Please change your User Rating");
        return newUserRating;
    }
    public int printEditMenu() {
        io.print("=== Select which one you wish to Edit === ");
        io.print("1. DVD Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Directors Name");
        io.print("5. Studio");
        io.print("6. User Rating");
        io.print("7. Exit");
      return io.readInt("Please select from the above choices.");
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
    
    public void displayErrorMessage(String errorMsg) {
        io.print("==== ERROR === ");
        io.print(errorMsg);
    }
    
    public void displayNoDVDFound() {
        io.print("No DVD Found");
    }
    
    
}


