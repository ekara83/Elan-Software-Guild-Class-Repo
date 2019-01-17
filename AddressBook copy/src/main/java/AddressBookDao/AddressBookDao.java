/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookDao;

import AddressBook.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elanaustin
 */
public interface AddressBookDao {
    
    Address addAddress(String getLastName, Address address) throws AddressBookDaoException;
           
    // adds address
    Address removeAddress(String getLastName) throws AddressBookDaoException;
        
    // removes Address based off Last Name
    Address findAddress(String getLastName) throws AddressBookDaoException;
           
    // finds address based off Last Name
    int getAddressCount(Map<String, Address> address) throws AddressBookDaoException;
        
  // will count how many addresses are in the system
    
    List<Address> getAllAddresses() throws AddressBookDaoException;
           
    // will list All Addresses entered
    
    
    
    
   
    
    
}
