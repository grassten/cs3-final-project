package finalProject.finalProject;

import ch05.collections.*;

public class ContactsArrayCollection extends ArrayCollection<Contacts> {

   public ContactsArrayCollection() {
      elements = new Contacts[DEFCAP];
   }
   
   public Contacts getIndex(int i) {
      return elements[i];
   }
   
   public void sortElements(int field) {
      if(field == 1) {
           
      } else {
      
      }
   }
   
   protected void removeElementByIndex(int i) {
      elements[i] = elements[numElements - 1];
      elements[numElements - 1] = null;
      numElements--;  
   }
   
   public void filterElements(int field, String filterTerm) {
      if(field == 1) {
         for(int i = 0; i < numElements; i++) {
            if(!elements[i].getBusinessName().contains(filterTerm)) {
               removeElementByIndex(i);
               i=0;
            }
         }      
      } else {
         int i = 0;
         while(i < numElements) {
            if(!(elements[i].getLastName().contains(filterTerm))) {
               removeElementByIndex(i);
               i=0;
            } else {
               i++;
            }
         }
      }
   }
}