package finalProject.finalProject;

import java.io.*;
import ch07.trees.*;
import java.util.Scanner;

public class UsingContactsFile {

   String fileName;

   public UsingContactsFile(String fileName) {
      this.fileName = fileName;
   }
   
   public BinarySearchTree<Contacts> importContactListCSV() {
      File file = new File(fileName);
      
      Contacts newContact;
      BinarySearchTree<Contacts> contactList = new BinarySearchTree<Contacts>();
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
   
   public boolean overwriteContactListCSV() {
      
      return false;
   }

}