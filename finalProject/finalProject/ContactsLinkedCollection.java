package finalProject.finalProject;

import java.io.*;
import java.util.*;
import ch05.collections.*;

public class ContactsLinkedCollection extends LinkedCollection<Contacts> {
   public ContactsLinkedCollection() {
      super();
   }
   
   public ContactsArrayCollection getAll(String target)
    // Searches the collection for an occurence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true, location to node containing e, and previous
    // to the node that links to location. If not successful, sets 
    // found to false.
   {
      ContactsArrayCollection searchResults = new ContactsArrayCollection();
      location = head;
      found = false;
   
      while (location != null) {
         if (location.getInfo().getBusinessName().contains(target)){
            searchResults.add(location.getInfo());
            previous = location;
            location = location.getLink();
         } else if (location.getInfo().getLastName().contains(target)) {
            searchResults.add(location.getInfo());
            previous = location;
            location = location.getLink();
         } else {
            previous = location;
            location = location.getLink();
         }
      }
      return searchResults;
   }
   
   public List<Contacts> fullList() {
      List<Contacts> searchResults = new ArrayList<Contacts>();
      location = head;
      while (location != null) {
         searchResults.add(location.getInfo());
         previous = location;
         location = location.getLink();
      }
      return searchResults;
   }
   
   protected boolean findByID(int uniqueID) {
      location = head;
      found = false;
   
      while (location != null) 
      {
         if (location.getInfo().getUniqueID() == uniqueID) {
            found = true;
            return found;       
         }
         else
         {
            previous = location;
            location = location.getLink();
         }
      }
      return found;
   }
   
   public boolean removeContact(int uniqueID) {
      findByID(uniqueID);
      if(found) {
         if (head == location) {    
            head = head.getLink();    // remove first node
         } else {
            previous.setLink(location.getLink());  // remove node at location
         }
         numElements--;
      }
      return found;
   }
   
   public boolean changeContact(int uniqueID, Contacts updatedContact) {
      findByID(uniqueID);
      if(found) {
         location.setInfo(updatedContact);
         return true;
      }
      return false;
   }
}