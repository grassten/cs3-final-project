package finalProject.finalProject;

import java.io.*;

public class Contacts implements Comparable<Contacts> {
   public String businessName, firstName, lastName, streetAddress, email, phoneNumber;
   
   Contacts(String businessName, String firstName, String lastName, String streetAddress, String email, String phoneNumber) {
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

   
   public String toString() {
      String toStringResult = businessName + " " + firstName + " " + lastName;
      return toStringResult;
   }
   
   public int compareTo(Contacts o) {
      return this.businessName.compareToIgnoreCase(o.businessName);
   }
}