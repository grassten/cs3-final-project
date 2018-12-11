package finalProject.finalProject;

import ch05.collections.*;

// Array based collection data structure used to hold search results
public class ContactsArrayCollection extends ArrayCollection<Contacts> {

   public ContactsArrayCollection() {
      elements = new Contacts[DEFCAP];
   }
   
   // return element by its index, used when printing full result set 
   public Contacts getIndex(int i) {
      return elements[i];
   }
   
   // mostly copied from textbook, does most of the work for merge sort
   // additional parameter fields say whether to sort by businessName or lastName, and ascending or desc
   private void merge (int leftFirst, int leftLast, int rightFirst, int rightLast, int field, int ascOrDesc) {
      Contacts[] tempArray = new Contacts[numElements];
      int index = leftFirst;
      int saveFirst = leftFirst;
      
      while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
         if (field == 1) {
            if (ascOrDesc == 1) {
               if (elements[leftFirst].getBusinessName().compareTo(elements[rightFirst].getBusinessName()) < 0) {
                  tempArray[index] = elements[leftFirst];
                  leftFirst++;
               } else {
                  tempArray[index] = elements[rightFirst];
                  rightFirst++;
               }
            } else {
               if (elements[leftFirst].getBusinessName().compareTo(elements[rightFirst].getBusinessName()) > 0) {
                  tempArray[index] = elements[leftFirst];
                  leftFirst++;
               } else {
                  tempArray[index] = elements[rightFirst];
                  rightFirst++;
               }            
            }
         } else {
            if (ascOrDesc == 1) {
               if (elements[leftFirst].getLastName().compareTo(elements[rightFirst].getLastName()) < 0) {
                  tempArray[index] = elements[leftFirst];
                  leftFirst++;
               } else {
                  tempArray[index] = elements[rightFirst];
                  rightFirst++;
               }
            } else {
               if (elements[leftFirst].getLastName().compareTo(elements[rightFirst].getLastName()) > 0) {
                  tempArray[index] = elements[leftFirst];
                  leftFirst++;
               } else {
                  tempArray[index] = elements[rightFirst];
                  rightFirst++;
               }            
            }   
         }
         index++;
      }
      
      while (leftFirst <= leftLast) {
         tempArray[index] = elements[leftFirst];
         leftFirst++;
         index++;
      }
      
      while (rightFirst <= rightLast) {
         tempArray[index] = elements[rightFirst];
         rightFirst++;
         index++;
      }
      
      for (index = saveFirst; index <= rightLast; index++) {
         elements[index] = tempArray[index];
      }
   }
   
   // splits array into a bunch (N) subarrays and passes to mergeSort
   private void mergeSort(int first, int last, int field, int ascOrDesc) {
      if (first < last) {
         int middle = (first + last) / 2;
         mergeSort(first, middle, field, ascOrDesc);
         mergeSort(middle + 1, last, field, ascOrDesc);
         merge(first, middle, middle+1, last, field, ascOrDesc);
      }
   }
   
   // method called by main ContactList program
   // simply starts off mergesort with the first & last element position of array
   public void sortElements(int field, int ascOrDesc) {
      mergeSort(0, numElements-1, field, ascOrDesc);         
   }
   
   // used by filter method
   private void removeElementByIndex(int i) {
      elements[i] = elements[numElements - 1];
      elements[numElements - 1] = null;
      numElements--;  
   }
   
   // filters by comparing either businessName or lastName
   // passed by user to the corresponding parameter of each object in the array.
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