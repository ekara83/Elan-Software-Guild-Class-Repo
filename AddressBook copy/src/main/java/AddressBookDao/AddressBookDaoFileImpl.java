/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookDao;

import AddressBook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author elanaustin
 */
public class AddressBookDaoFileImpl implements AddressBookDao {
private Map<String, Address> addresses = new HashMap();
  
public static final String ADDRESS_FILE = "address.txt";
public static final String DELIMITER = " :: ";

    @Override
    public Address addAddress(String getLastName, Address address) throws AddressBookDaoException {
       Address newAddress = addresses.put(getLastName, address);
       writeAddress();
       return newAddress;
    }

    @Override
    public Address removeAddress(String getLastName) throws AddressBookDaoException {
       Address removedAddress = addresses.remove(getLastName);
       writeAddress();
       return removedAddress;
    }

    @Override
    public Address findAddress(String getLastName) throws AddressBookDaoException {
        loadAddress();
         return addresses.get(getLastName);
    }
    
   @Override
    public int getAddressCount(Map<String, Address> address) throws AddressBookDaoException {
        int getAddressCount = addresses.size();
        loadAddress();
         return getAddressCount;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        loadAddress();
        return new ArrayList<Address>(addresses.values());
    }
    
private void loadAddress() throws AddressBookDaoException {
    Scanner scanner;
    
    try {
        scanner = new Scanner (new BufferedReader(new FileReader(ADDRESS_FILE)));
    } catch (FileNotFoundException e) {throw new AddressBookDaoException("-_- Could not load roster data into memory.", e);
    }
    
 String currentLine;    
 String[] currentTokens;
 while (scanner.hasNextLine()) {
     currentLine = scanner.nextLine();
     
     currentTokens = currentLine.split(DELIMITER);
     
     Address currentAddress = new Address(currentTokens[1]);
     
     currentAddress.setFirstName(currentTokens[0]);
     currentAddress.setLastName(currentTokens[1]);
     currentAddress.setStreetAddress(currentTokens[2]);
     currentAddress.setCityName(currentTokens[3]);
     currentAddress.setStateName(currentTokens[4]);
     currentAddress.setZipCode(currentTokens[5]);
     
     addresses.put(currentAddress.getLastName(), currentAddress);
     
 }
    scanner.close();
}

private void writeAddress() throws AddressBookDaoException{
    PrintWriter out;
    
    try { out = new PrintWriter(new FileWriter(ADDRESS_FILE)); 
    } catch (IOException e) { throw new AddressBookDaoException("Could not save address data.", e);
    }
    List<Address> addressList = this.getAllAddresses();
    for (Address currentAddress : addressList) {
        out.println(currentAddress.getFirstName() + DELIMITER 
        + currentAddress.getLastName() + DELIMITER + currentAddress.getStreetAddress() 
                + DELIMITER + currentAddress.getCityName() + DELIMITER + currentAddress.getStateName() 
                + DELIMITER + currentAddress.getZipCode());
        out.flush();
    }
    out.close();
}

    
}
