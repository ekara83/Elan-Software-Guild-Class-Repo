/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVDLibrary;
import java.util.List;

/**
 *
 * @author elanaustin
 */
public interface DVDLibraryDao {
    
    DVDLibrary addDVD(String dvdTitle, DVDLibrary dvdLibrary) throws DVDLibraryDaoException ;
    
    DVDLibrary removeDVD(String dvdTitle) throws DVDLibraryDaoException ;
    
    DVDLibrary editDVD(String dvdTitle, DVDLibrary dvdLibrary) throws DVDLibraryDaoException;
     
    List<DVDLibrary>getAllDVDs() throws DVDLibraryDaoException ;
    
    DVDLibrary getDVD(String dvdTitle) throws DVDLibraryDaoException ;
    
    

   
     
    
}
