/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookDao;

import AddressBook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elanaustin
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    @Override
    public Address addAddress(String getLastName, Address address) {
       Address newAddress = addresses.put(getLastName, address);
       return newAddress;
    }

    @Override
    public Address removeAddress(String getLastName) {
       Address removeAddress = addresses.remove(getLastName);
       return removeAddress;
    }

    @Override
    public Address findAddress(String getLastName) {
         return addresses.get(getLastName);
    }
    
     @Override
    public List<Address> getAddressCount() {
      return new ArrayList<Address>(addresses.size());
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<Address>(addresses.values());
    }
    private Map<String, Address> addresses = new HashMap();

   
}
