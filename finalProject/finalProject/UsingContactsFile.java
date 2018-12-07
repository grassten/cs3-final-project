package finalProject.finalProject;

import java.io.*;
import ch07.trees.*;
import java.util.Scanner;
import java.util.*;

public class UsingContactsFile {

   String fileName;

   public UsingContactsFile(String fileName) {
      this.fileName = fileName;
   }
   
   public Object[] importContactListCSV() {
      File file = new File(fileName);
      
      Contacts newContact;
      BinarySearchTree<Contacts> contactListBN = new BinarySearchTree<Contacts>(new BusinessNameComp());
      BinarySearchTree<Contacts> contactListLN = new BinarySearchTree<Contacts>(new LastNameComp());
      try{
         BufferedReader bufRdr = new BufferedReader(new FileReader(file));
         String line = null;
         while((line = bufRdr.readLine()) != null) {
            String[] strings = line.split(",");
            newContact = new Contacts(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
            contactListBN.add(newContact);
            contactListLN.add(newContact);
         }
         
         bufRdr.close();
      } catch(Exception e) {
         e.printStackTrace();      
      }
      return new Object[]{contactListBN, contactListLN};
   }
   
   public boolean overwriteContactListCSV() {
      
      return false;
   }

}

class BusinessNameComp implements Comparator<Contacts> {
   @Override
   public int compare(Contacts c1, Contacts c2) {
      if (c1.getBusinessName().compareTo(c2.getBusinessName()) > 0) {
         return 1;
      } else if (c1.getBusinessName().equals(c2.getBusinessName())) {
         return 0;
      } else {
         return -1;
      }
   }  
}

class LastNameComp implements Comparator<Contacts> {
   @Override
   public int compare(Contacts c1, Contacts c2) {
      if (c1.getLastName().compareTo(c2.getLastName()) > 0) {
         return 1;
      } else if (c1.getLastName().equals(c2.getLastName())) {
         return 0;
      } else {
         return -1;
      }
   }  
}