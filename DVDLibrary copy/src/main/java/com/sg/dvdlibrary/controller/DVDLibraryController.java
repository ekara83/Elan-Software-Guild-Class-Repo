/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
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
        try {
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
                        editDVD();
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
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private int getEditMenu() {
        return view.printEditMenu();
    }

    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVDLibrary newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getDvdTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVDLibrary> dvdList = dao.getAllDVDs();
        view.displayDVDLibrary(dvdList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDChoice();
        DVDLibrary dvdLibrary = dao.getDVD(dvdTitle);
        view.displayDVD(dvdLibrary);
    }

    private void editDVD() throws DVDLibraryDaoException {
        
        String dvdTitle = view.getDVDChoice();
        DVDLibrary dvdLibrary = dao.getDVD(dvdTitle);
        boolean keepEditing = true;
        int editMenu = 0;
        
        while (keepEditing) {
            editMenu = getEditMenu();

            switch (editMenu) {
                case 1:
                    
                    dao.removeDVD(dvdTitle);   
                    String newTitle = view.editDVDTitle();
                    dvdLibrary.setDvdTitle(newTitle);
                    dao.editDVD(dvdTitle, dvdLibrary);
                    break;

                case 2:
                    String releaseDate = view.editReleaseDate();
                    dvdLibrary.setReleaseDate(releaseDate);
                    dao.editDVD(dvdTitle, dvdLibrary);
                    

                    break;
                case 3:
                    String mpaaRating = view.editMpaaRating();
                    dvdLibrary.setMpaaRating(mpaaRating);
                    dao.editDVD(dvdTitle, dvdLibrary);
                    
                    break;
                case 4:
                   String directorsName = view.editDirectorsName();
                   dvdLibrary.setDirectorsName(directorsName);
                   dao.editDVD(dvdTitle, dvdLibrary);
                    break;
                case 5:
                    String studio = view.editStudio();
                    dvdLibrary.setStudio(studio);
                    dao.editDVD(dvdTitle, dvdLibrary);
                    break;
                case 6:
                    String userRating = view.editUserRating();
                    dvdLibrary.setUserRating(userRating);
                    dao.editDVD(dvdTitle, dvdLibrary);
                    break;
                case 7:
                    keepEditing = false;
                    break;
            }
        }
            view.displayEditedDVDSuccessBanner();
    }

    private void removeDVD() throws DVDLibraryDaoException {
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
