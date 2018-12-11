package finalProject.finalProject;

import java.io.*;
import ch05.collections.*;
import java.util.Scanner;
import java.util.*;

public class ContactList {
   
   public static void main(String[] args) {
      String fileName = "MOCK_DATA.csv";
      UsingContactsFile contactsFile = new UsingContactsFile(fileName);
      ContactsLinkedCollection contactList = contactsFile.importContactListCSV();
      Scanner scInt = new Scanner(System.in);
      Scanner scStr = new Scanner(System.in);
      int response = 0;
      
      while(response != 5) {
         System.out.println("\nWelcome to your contact list.");
         System.out.println("1. Search contacts.");
         System.out.println("2. Add contact.");
         System.out.println("3. Remove contact.");
         System.out.println("4. Change Contact.");
         System.out.println("5. Exit application.");
         System.out.print("Choice: ");
         response = scInt.nextInt();
         System.out.println();
         
         if(response == 1) { // search
            String businessName, lastName, searchTerm;
            ContactsArrayCollection searchReturn = null;
            Contacts newContact = null;
            int sortOrFilter = 0;
            
            System.out.print("Enter business name or last name: ");
            searchTerm = scStr.nextLine();

            searchReturn = contactList.getAll(searchTerm);
            
            // formats search return data 
            if(searchReturn.size() != 0){
               do {
                  String format = "%-10.10s %-15.15s %-15.15s %-15.15s %-30.30s %-30.30s %-20.20s%n";
                  
                  System.out.println("\n");
                  System.out.printf(format, "ID",
                                            "BusinessName",
                                            "FirstName",
                                            "LastName",
                                            "StreetAddress",
                                            "Email",
                                            "phoneNumber");
                                            
                  for(int i = 0; i < searchReturn.size(); i++) {
                     System.out.printf(format, searchReturn.getIndex(i).getUniqueID(),
                                        searchReturn.getIndex(i).getBusinessName(), 
                                        searchReturn.getIndex(i).getFirstName(),
                                        searchReturn.getIndex(i).getLastName(),
                                        searchReturn.getIndex(i).getStreetAddress(),
                                        searchReturn.getIndex(i).getEmail(),
                                        searchReturn.getIndex(i).getPhoneNumber());
                  }
                  
                  while(true) {
                     System.out.println("\nSort(1), filter results(2), or main menu(0)?: ");
                     sortOrFilter = scInt.nextInt();
                     if(sortOrFilter == 1 || sortOrFilter == 2 || sortOrFilter == 0) {
                        break;
                     }
                  }
                  
                  if(sortOrFilter == 1) { // sort dataset
                     while(true) {
                        System.out.println("Which field would you like to sort by?");
                        System.out.print("1 for business name, 2 for last name: ");
                        int sortByField = scInt.nextInt();
                        if(sortByField == 1 || sortByField == 2) {
                           System.out.print("Ascending(1) or descending(2)?: ");
                           int ascOrDesc = scInt.nextInt();
                           if(ascOrDesc == 1 || ascOrDesc == 2) {
                              searchReturn.sortElements(sortByField, ascOrDesc);
                              break;
                           }
                        }
                     }
                  }
                  
                  if(sortOrFilter == 2) { // filter dataset
                     while(true) {
                        System.out.println("Which field would you like to filter?");
                        System.out.print("1 for business name, 2 for last name: ");
                        int filterByField = scInt.nextInt();
                        if(filterByField == 1 || filterByField == 2) {
                           System.out.print("Filter term: ");
                           String filterTerm = scStr.nextLine();
                           searchReturn.filterElements(filterByField, filterTerm);
                           break;
                        }
                     }
                  }
               } while (sortOrFilter != 0);
            } else {
               System.out.println("No Results Found");
            }      
         
         } else if(response == 2) { // add contact
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
            System.out.println("Contact added!\n");
         
         } else if(response == 3) { // remove contact
            System.out.print("Enter ID of contact to remove: ");
            try {
               int idToRemove = scInt.nextInt();
               if(contactList.removeContact(idToRemove)) {
                  System.out.println("Contact removed successfully.");
               } else {
                  System.out.println("Contact not found");
               }
            } catch (Exception e) {
               System.out.println("Invalid Input");
            }
         
         } else if(response == 4) { // change contact
            System.out.print("Which record would you like to update? (input ID): ");
            int IDToUpdate = scInt.nextInt();
            
            if(!contactList.findByID(IDToUpdate)) {
               System.out.println("Contact not found.");
            } else {
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
            
               Contacts newContact = new Contacts(IDToUpdate, businessName, firstName, lastName, streetAddress, email, phoneNumber);
               contactList.changeContact(IDToUpdate, newContact);
               System.out.println("Contact updated!\n\n\n\n\n");
            }
         } else if (response == 5) {
         } else {
            System.out.println("Invalid Input.");
         }
      }
      
      // if user presses 5, writes final dataset to file
      try{
         contactsFile.writeToContactsCSV(contactList);
      } finally {
         return;
      }
   }
}
