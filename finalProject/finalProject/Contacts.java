package finalProject.finalProject;

import java.io.*;

public class Contacts {
   protected String businessName, firstName, lastName, streetAddress, email, phoneNumber;
   protected int counter = 1;
   protected static int instanceCounter = 1;
   
   Contacts(String businessName, String firstName, String lastName, String streetAddress, String email, String phoneNumber) {
      this.businessName = businessName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.streetAddress = streetAddress;
      this.email = email;
      this.phoneNumber = phoneNumber;
      counter = instanceCounter;
      instanceCounter++;
   }
   
   // constructor used in change contact, where uniqueID should stay the same.
   Contacts(int uniqueID, String businessName, String firstName, String lastName, String streetAddress, String email, String phoneNumber) {
      counter = uniqueID;
      this.businessName = businessName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.streetAddress = streetAddress;
      this.email = email;
      this.phoneNumber = phoneNumber;
   }
   
   public void setBusinessName(String businessName) {
      this.businessName = businessName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   
   public String getBusinessName() { return businessName; }
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public String getStreetAddress() { return streetAddress; }
   public String getEmail() { return email; }
   public String getPhoneNumber() { return phoneNumber; }
   public int getUniqueID() { return counter; }
}