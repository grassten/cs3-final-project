package finalProject.finalProject;

import java.io.*;
import ch07.trees.*;
import java.util.Scanner;
import java.util.*;

public class ContactList {
   
   public static void main(String[] args) {
      String fileName = "MOCK_DATA.csv";
      UsingContactsFile contactsFile = new UsingContactsFile(fileName);
      Object[] temp = contactsFile.importContactListCSV();
      BinarySearchTree<Contacts> contactListBN = (BinarySearchTree)temp[0];
      BinarySearchTree<Contacts> contactListLN = (BinarySearchTree)temp[1];
      Scanner scInt = new Scanner(System.in);
      Scanner scStr = new Scanner(System.in);
      int response = 0;
      
      while(response != 5) {
         System.out.println("\n\nWelcome to your contact list. What do you want to do?:");
         System.out.println("1. Search contacts.");
         System.out.println("2. Add contact.");
         System.out.println("3. Remove contact.");
         System.out.println("4. Change Contact.");
         System.out.println("5. Exit application.");
         System.out.print("Choice: ");
         response = scInt.nextInt();
         
         if(response == 1) {
            String businessName, lastName, searchTerm;
            List<Contacts> searchReturn = null;
            Contacts newContact = null;
            
            System.out.println("Which field would you like to filter by?");
            System.out.println("1. Business Name.");
            System.out.println("2. Last Name.");
            System.out.print("Your choice (enter corresponding number): ");
            int fieldFilter = scInt.nextInt();

            switch(fieldFilter) {
               case 1:
                  System.out.print("Enter business name: ");
                  searchTerm = scStr.nextLine();
                  businessName = searchTerm;    
                  
                  newContact = new Contacts(businessName, null, null, null, null, null);
                  searchReturn = contactListBN.getAll(newContact);
                  break;
               case 2:
                  System.out.print("Enter last name: ");
                  searchTerm = scStr.nextLine(); 
                  lastName = searchTerm;
                  
                  newContact = new Contacts(null, null, lastName, null, null, null);
                  searchReturn = contactListLN.getAll(newContact);
                  break;
            }
            
            if(searchReturn!=null){
               String format = "%-15.15s %-15.15s %-15.15s %-30.30s %-30.30s %-20.20s%n";
               System.out.printf(format, "BusinessName",
                                         "FirstName",
                                         "LastName",
                                         "StreetAddress",
                                         "Email",
                                         "phoneNumber");
                                         
               for(int i = 0; i < searchReturn.size(); i++) {
                  System.out.printf(format, searchReturn.get(i).getBusinessName(), 
                                     searchReturn.get(i).getFirstName(),
                                     searchReturn.get(i).getLastName(),
                                     searchReturn.get(i).getStreetAddress(),
                                     searchReturn.get(i).getEmail(),
                                     searchReturn.get(i).getPhoneNumber());
               }
            } else {
               System.out.println("No Results Found");
            }      
         } else if(response == 2) {
            System.out.println("Input the following data.");
            System.out.print("Business Name: ");
            String businessName = scStr.nextLine();
            
            System.out.print("First Name: ");
            String firstName = scStr.nextLine();
            
            System.out.print("Last Name: ");
            String lastName = scStr.nextLine();
            
            System.out.print("Street Address: ");
            String streetAddress = scStr.nextLine();
            
            System.out.print("Email: ");
            String email = scStr.nextLine();
            
            System.out.print("Phone Number: ");
            String phoneNumber = scStr.nextLine();
            
            Contacts newContact = new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
            contactListBN.add(newContact);
            contactListLN.add(newContact);
            System.out.println("Contact added!\n\n\n\n\n");
         } else if(response == 3) {
            
         } else if(response == 4) {
         
         } else if(response == 5) {
         } else {
            System.out.println("Invalid Input.");
         }
      }
      //overwrite old contacts file and save a backup possibly
   }
}