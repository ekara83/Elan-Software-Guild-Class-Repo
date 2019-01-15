/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import AddressBook.ui.AddressBookView;
import AddressBook.ui.UserIO;
import AddressBook.ui.UserIOConsoleImpl;
import AddressBookController.AddressBookController;
import AddressBookDao.AddressBookDao;
import AddressBookDao.AddressBookDaoFileImpl;

/**
 *
 * @author elanaustin
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(myView, myDao);
        controller.run();
    }
}
