/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.DVDLibrary;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author elanaustin
 */
public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;
    private UserIO io = (UserIO) new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    io.print("Edit DVD Information: To Be Implemented");
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break; 
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();

            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVDLibrary newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDvdTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    
    private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVDLibrary> dvdList = dao.getAllDVDs();
        view.displayDVDLibrary(dvdList);
    }
    
    private void viewDVD() {
        view.displayDisplayDVDsBanner();
        String dvdTitle = view.getDVDChoice();
        DVDLibrary dvdLibrary = dao.getDVD(dvdTitle);
        view.displayDisplayDVDsBanner();
    }
    
    private void editedDVD() {
       view.displayeditDVDBanner();
       DVDLibrary newDVD = view.getNewDVDInfo();
       dao.editDVD(newDVD.getDvdTitle(), newDVD);
       view.displayEditedDVDSuccessBanner();
        
    }
    
    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDChoice();
        dao.removeDVD(dvdTitle);
        view.displayRemoveDVDSuccessBanner();
    }
      
  
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
}

