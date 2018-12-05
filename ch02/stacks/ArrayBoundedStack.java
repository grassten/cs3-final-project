//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

package ch02.stacks;

public class ArrayBoundedStack<T> implements StackInterface<T> {
   protected final int DEFCAP = 100; // default capacity
   protected T[] elements;           // holds stack elements
   protected int topIndex = -1;      // index of top element in stack
   
   public ArrayBoundedStack() {
      elements = (T[]) new Object[DEFCAP];
   }
   
   public ArrayBoundedStack(int maxSize) {
      elements = (T[]) new Object[maxSize];
   }
   
   // Throws StackOverflowException if this stack is full,
   // otherwise places element at the top of this stack.
   
   public void push(T element) {      
      if (isFull())
         throw new StackOverflowException("Push attempted on a full stack.");
      else
      {
         topIndex++;
         elements[topIndex] = element;
      }
   }
   
   // Throws StackUnderflowException if this stack is empty,
   // otherwise removes top element from this stack.
   public void pop() {                  
      if (isEmpty())
         throw new StackUnderflowException("Pop attempted on an empty stack.");
      else
      {
         elements[topIndex] = null;
         topIndex--;
      }
   }
   
   // Throws StackUnderflowException if this stack is empty,
   // otherwise returns top element of this stack.
   public T top() {                 
      T topOfStack = null;
      if (isEmpty())
         throw new StackUnderflowException("Top attempted on an empty stack.");
      else
         topOfStack = elements[topIndex];
      return topOfStack;
   }
   
   // Returns true if this stack is empty, otherwise returns false.
   public boolean isEmpty() {              
      return (topIndex == -1); 
   }
  
   // Returns true if this stack is full, otherwise returns false.
   public boolean isFull() {              
      return (topIndex == (elements.length - 1));
   }
  
   // NEW METHODS
  
   public String toString() {
      System.out.println(elements.toString(a));
   }
  
   public int size() {
      return elements.length;
   }
  
   public void popSome(int count) {
      for(int i = 0; i < count; i++) {
         if (topIndex == -1)
            throw new StackUnderflowException("Pop attempted on an empty stack.");
         } else {
            elements[topIndex] = null;
            topIndex--;
         }
      }
   }
  
   public boolean swapStart() {
      if (elements.length >= 2) {
         topOfStack = elements[topIndex];
         elements[topIndex] = elements[topIndex-1];
         elements[topIndex-1] = topOfStack;
      }
      return (elements.length >= 2)
   }
  
   T poptop() {
      if (isEmpty())
         throw new StackUnderflowException("Poptop attempted on an empty stack.");
      else
      {
         topOfStack = elements[topIndex];
         elements[topIndex] = null;
         topIndex--;
      }
      return topOfStack;
   }  
}