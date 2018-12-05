package finalProject.finalProject;

import java.io.*;
import ch07.trees.*;
import java.util.Scanner;

public class ContactList {
   
   public static void main(String[] args) {
      String fileName = "MOCK_DATA.csv";
      UsingContactsFile contactsFile = new UsingContactsFile(fileName);
      BinarySearchTree<Contacts> contactList = contactsFile.importContactListCSV();
      Scanner scInt = new Scanner(System.in);
      Scanner scStr = new Scanner(System.in);
      int response = 0;
      
      while(response != 5) {
         System.out.println("Welcome to your contact list. What do you want to do?:");
         System.out.println("1. Search contacts.");
         System.out.println("2. Add contact.");
         System.out.println("3. Remove contact.");
         System.out.println("4. Change Contact.");
         System.out.println("5. Exit application.");
         System.out.print("Choice: ");
         response = scInt.nextInt();
         
         if(response == 1) {
            String businessName = null;
            String firstName = null;
            String lastName = null;
            String streetAddress = null;
            String email = null;
            String phoneNumber = null;
            String searchTerm = null;
            
            int additionalFilter = 0;            
            do {
               System.out.println("Which field would you like to filter by?");
               System.out.println("1. Business Name.");
               System.out.println("2. First Name.");
               System.out.println("3. Last Name.");
               System.out.println("4. Street Address.");
               System.out.println("5. Email.");
               System.out.println("6. Phone number.");
               System.out.print("Your choice (enter corresponding number): ");
               int fieldFilter = scInt.nextInt();
   
               switch(fieldFilter) {
                  case 1:
                     System.out.print("Enter business name: ");
                     searchTerm = scStr.nextLine();
                     businessName = searchTerm;            
                     break;
                  case 2:
                     System.out.print("Enter first name: ");
                     searchTerm = scStr.nextLine(); 
                     firstName = searchTerm;
                     break;
                  case 3:
                     System.out.print("Enter last name: ");
                     searchTerm = scStr.nextLine(); 
                     lastName = searchTerm;
                     break;
                  case 4:
                     System.out.print("Enter street address: ");
                     searchTerm = scStr.nextLine(); 
                     streetAddress = searchTerm;
                     break;
                  case 5:
                     System.out.print("Enter email: ");
                     searchTerm = scStr.nextLine(); 
                     email = searchTerm;
                     break;
                  case 6:
                     System.out.print("Enter phone number: ");
                     searchTerm = scStr.nextLine(); 
                     phoneNumber = searchTerm;
                     break;
                  }
                  
                  System.out.println("Filter by an additional term?(1 for yes, 0 for no): ");
                  additionalFilter = scInt.nextInt();
               } while(additionalFilter == 1);
            
            Contacts newContact = new Contacts(businessName, firstName, lastName, streetAddress, email, phoneNumber);
            Contacts searchReturn = contactList.get(newContact);
            if(searchReturn!=null){
               System.out.println(searchReturn.toString());
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
            contactList.add(newContact);
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