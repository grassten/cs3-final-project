package finalProject.finalProject;

import ch05.collections.*;

public class ContactsArrayCollection extends ArrayCollection<Contacts> {

   public ContactsArrayCollection() {
      elements = new Contacts[DEFCAP];
   }
   
   public Contacts getIndex(int i) {
      return elements[i];
   }
   
   private void swap(int firstIndex, int secondIndex) {
      Contacts temp = elements[firstIndex];
      elements[firstIndex] = elements[secondIndex];
      elements[secondIndex] = temp;
   }
   
   private void merge (int leftFirst, int leftLast, int rightFirst, int rightLast, int field) {
      Contacts[] tempArray = new Contacts[numElements];
      int index = leftFirst;
      int saveFirst = leftFirst;
      
      while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
         if (field == 1) {
            if (elements[leftFirst].getBusinessName().compareTo(elements[rightFirst].getBusinessName()) < 0) {
               tempArray[index] = elements[leftFirst];
               leftFirst++;
            } else {
               tempArray[index] = elements[rightFirst];
               rightFirst++;
            }
         } else if (field == 2) {
            if (elements[leftFirst].getLastName().compareTo(elements[rightFirst].getLastName()) < 0) {
               tempArray[index] = elements[leftFirst];
               leftFirst++;
            } else {
               tempArray[index] = elements[rightFirst];
               rightFirst++;
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
   
   public void mergeSort(int first, int last, int field) {
      if (first < last) {
         int middle = (first + last) / 2;
         mergeSort(first, middle, field);
         mergeSort(middle + 1, last, field);
         merge(first, middle, middle+1, last, field);
      }
   }
   
   public void sortElements(int field) {
      mergeSort(0, numElements-1, field);         
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