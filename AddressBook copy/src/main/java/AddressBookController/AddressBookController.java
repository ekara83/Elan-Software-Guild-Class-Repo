/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookController;

import AddressBook.dto.Address;
import AddressBook.ui.AddressBookView;
import AddressBookDao.AddressBookDao;
import AddressBookDao.AddressBookDaoException;

import java.util.List;

/**
 *
 * @author elanaustin
 */
public class AddressBookController {

    AddressBookView view;
    AddressBookDao dao;

    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }
 

   

    // this class should do the following:
    // 1. Orchestrate all activities of the program
    // 2. Use the View and UserIOClass from the previous lab to handle the console input and output
    // 3. Use the AddressBookDao class to store Address objects
    public void run() throws AddressBookDaoException {

        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    createAddress();
                    break;
                case 2:
                   removeAddress();
                    break;
                case 3:
                    findAddress();
                    // will find address via Last Name
                    break;

                case 4:
                   getAddressCount();
                    // will list/count how many addresses are in the book
                    break;
                case 5:
                     listAddresses();
                    // will list All Addresses
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();

            }
        }
      
    } catch (AddressBookDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }


private void createAddress() throws AddressBookDaoException {
        view.displayAddAddress();
        Address addAddress = view.getNewAddressInfo();
        dao.addAddress(addAddress.getLastName(), addAddress);
        view.displayAddressAdded();
    }

private void removeAddress() throws AddressBookDaoException {
       view.displayRemoveAddress();
       String lastName = view.getLastNameAddress();
       dao.removeAddress(lastName);
       view.displayRemoveAddressSuccess();
   }

  private void findAddress () throws AddressBookDaoException {
       view.displayDisplayFindAddress();
       String lastName = view.getLastNameAddress();
       Address address = dao.findAddress(lastName);
       view.displayAddress(address);
   }   
    
   private void listAddresses() throws AddressBookDaoException {
       view.displayDisplayAddressMenu();
       List<Address> addressList = dao.getAllAddresses();
       view.displayAddressList(addressList);
   }
   
   private void getAddressCount() throws AddressBookDaoException {
      
       // displayAllAddressMenu
       List<Address> addressList = dao.getAllAddresses();
       view.displayAddressList(addressList);
   }
    

   
   
   
   private void unknownCommand() {
       view.displayUnknownCommand();
   }

   
        
    }
   
