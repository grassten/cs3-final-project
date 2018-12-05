//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems               Chapter 5
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//---------------------------------------------------------------------------

import support.LLNode;

public class LinkedCollection<T> implements CollectionInterface<T>  
{
   protected LLNode<T> head;       // head of the linked list
   protected int numElements = 0;  // number of elements in this collection

   // set by find method
   protected boolean found;        // true if target found, else false
   protected LLNode<T> location;   // node containing target, if found
   protected LLNode<T> previous;   // node preceding location

   public LinkedCollection()
   {
      numElements = 0;
      head = null;
   }

   public boolean add(T element)
    // Adds element to this collection.
   {
      LLNode<T> newNode = new LLNode<T>(element);
      newNode.setLink(head);
      head = newNode;
      numElements++;
      return true;
   }

   protected void find(T target)
    // Searches the collection for an occurence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true, location to node containing e, and previous
    // to the node that links to location. If not successful, sets 
    // found to false.
   {
      location = head;
      found = false;
   
      while (location != null) 
      {
         if (location.getInfo().equals(target))  // if they match
         {
            found = true;
            return;
         }
         else
         {
            previous = location;
            location = location.getLink();
         }
      }
   }

   public int size()
    // Returns the number of elements on this collection. 
   {
      return numElements;
   }

   public boolean contains (T target)
    // Returns true if this collection contains an element e such that 
    // e.equals(target); otherwise, returns false.
   {
      find(target);
      return found;
   }

   public boolean remove (T target)
    // Removes an element e from this collection such that e.equals(target)
    // and returns true; if no such element exists, returns false.
   {
      find(target);
      if (found)
      {
         if (head == location)     
            head = head.getLink();    // remove first node
         else
            previous.setLink(location.getLink());  // remove node at location
      
         numElements--;
      }
      return found;
   }

   public T get(T target)
    // Returns an element e from this collection such that e.equals(target);
    // if no such element exists, returns null.
   {
      find(target);    
      if (found)
         return location.getInfo();
      else
         return null;
   }
     
   public boolean isEmpty()
    // Returns true if this collection is empty; otherwise, returns false.
   {
      return (numElements == 0);  
   }

   public boolean isFull()
    // Returns true if this collection is full; otherwise, returns false.
   {
      return false;  // Linked implementation is never full
   }
   
   // creates and returns a string that correctly represents the current collection.
   public String toString() {
      LLNode<T> collectionElement = head;
      String collectionString = new String("");
   
      while (collectionElement != null) 
      {
         collectionString+=collectionElement.getInfo() + " ";
         collectionElement = collectionElement.getLink();
      }   
      return collectionString;
   }
   
   // returns a count of the number of elements e in the collection such that collectionElement.equals(target) is true.
   public int count(T target) {
      LLNode<T> collectionElement = head;
      int collectionCountMatch = 0;
         
      while (collectionElement != null) 
      {
         if(collectionElement.equals(target)) {
            collectionCountMatch++;
         }
         collectionElement = collectionElement.getLink();
      }   
      return collectionCountMatch;   
   }
   
   // removes all elements e from the collection such that e.equals(target) is true.
   public void removeAll(T target) {
      LLNode<T> collectionElement = head;
         
      while (collectionElement != null) {
         if (collectionElement.getInfo().equals(target)) {
            if(head == collectionElement) {
               head = head.getLink();
               collectionElement = head;  
            } else {
               previous.setLink(collectionElement.getLink());
            }
            numElements--;
         }
      }   
   }
   
   // Returns a new LinkedCollection that is the combination of this object and the argument object.
//    public LinkedCollection<T> combine(LinkedCollection<T> secondCollection) {
//       
//    }
}
