/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookDao;

import AddressBook.dto.Address;
import java.util.List;

/**
 *
 * @author elanaustin
 */
public interface AddressBookDao {
    
    Address addAddress(String getLastName, Address address)
            throws AddressBookDaoException;
    // adds address
    Address removeAddress(String getLastName)
            throws AddressBookDaoException;
    // removes Address based off Last Name
    Address findAddress(String getLastName)
            throws AddressBookDaoException;
    // finds address based off Last Name
    List<Address>getAddressCount();
    
  // need to add a list/hashmap where it will count all the addresses
    
    List<Address> getAllAddresses()
            throws AddressBookDaoException;
    // will list All Addresses
    
    
    
    
   
    
    
}
