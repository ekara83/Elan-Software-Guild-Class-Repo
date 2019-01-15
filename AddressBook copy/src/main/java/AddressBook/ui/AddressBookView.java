/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook.ui;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author elanaustin
 */
public class AddressBookView {

    private UserIO io; 

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("Please select the operation you wish to perform:");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        return io.readInt("Please select from the above choices.", 1, 5);
    }
    public void displayAddAddress() {
        io.print("Add Address Menu");
    }

    public Address getNewAddressInfo() {

        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String streetAddress = io.readString("Please enter Street Address");
        String cityName = io.readString("Please enter City Name");
        String stateName = io.readString("Please enter State Name");
        String zipCode = io.readString("Please enter Zip Code");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreetAddress(streetAddress);
        currentAddress.setCityName(cityName);
        currentAddress.setStateName(stateName);
        currentAddress.setZipCode(zipCode);
        return currentAddress;
    }

    public void displayAddressAdded() {
        io.print("Address Added. Press 1 to return to Main Menu.");
    }

    public void displayDisplayAddressMenu() {
        io.print("List Addresses Menu: ");
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            io.print(currentAddress.getFirstName() + currentAddress.getFirstName());
            io.print(currentAddress.getStreetAddress());
            io.print(currentAddress.getCityName() + currentAddress.getStateName() + currentAddress.getZipCode());
        }
        io.readString("Please hit 1 to go to Main Menu.");
    }

    

    public void displayDisplayFindAddress() {
        io.print("Find Address Menu");
    }

    public String getLastNameAddress() {
        return io.readString("Please enter the last name of the address to find:");
    }

    public void displayAddress(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print(address.getStreetAddress());
            io.print(address.getCityName() + " " + address.getStateName() + address.getZipCode());
        } else {
            io.print("No such name.");
        }
        io.readString("Please hit 1 to return to Main Menu.");
    }

    public void displayRemoveAddress() {
        io.print("Remove Address");
    }
    
    public void displayRemoveAddressSuccess() {
        io.print("Address Deleted. Press 1 to return to Menu. ");
        
    }
    
    public void displayUnknownCommand() {
        io.print("Uknown Command");
    }
}
