package finalProject.finalProject;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import ch05.collections.*;

// handles file import and export
public class UsingContactsFile {

   String fileName;

   public UsingContactsFile(String fileName) {
      this.fileName = fileName;
   }
   
   // reads the input file line by line, splits into array of strings,
   // and then uses array of strings to build contact objects.
   // then adds each contact object to a Linked Collection
   public ContactsLinkedCollection importContactListCSV() {
      File file = new File(fileName);
      
      Contacts newContact;
      ContactsLinkedCollection contactList = new ContactsLinkedCollection();

      try{
         BufferedReader bufRdr = new BufferedReader(new FileReader(file));
         String line = null;
         while((line = bufRdr.readLine()) != null) {
            String[] strings = line.split(",");
            newContact = new Contacts(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
            contactList.add(newContact);
         }
         
         bufRdr.close();
      } catch(Exception e) {
         e.printStackTrace();      
      }
      return contactList;
   }
   
   public boolean writeToContactsCSV(ContactsLinkedCollection contactList) throws Exception {
      int numContactsToWrite = contactList.size();
      PrintStream writer = new PrintStream(fileName);
      List<Contacts> searchResults = contactList.fullList();
      for(Contacts contact: searchResults) {
         writer.println(contact.getBusinessName() + "," + contact.getFirstName() + "," + 
                        contact.getLastName() + "," + contact.getStreetAddress() + "," + 
                        contact.getEmail() + "," + contact.getPhoneNumber());
      }
      writer.close();
      return false;
   }

}