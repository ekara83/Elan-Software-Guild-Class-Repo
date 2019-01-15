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
    
    Address addAddress(String getLastName, Address address);
    // adds address
    Address removeAddress(String getLastName);
    // removes Address based off Last Name
    Address findAddress(String getLastName);
    // finds address based off Last Name
    List<Address>getAddressCount();
    
  // need to add a list/hashmap where it will count all the addresses
    
    List<Address> getAllAddresses();
    // will list All Addresses
    
    
    
    
   
    
    
}
