/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author DANSO
 */
public class OrderSortedLinkedList <T extends Comparable<? super T>> implements OrderSortedListInterface<T>{
    private Node first;
    private int entry;
    private int length;
    
    public OrderSortedLinkedList(){
        first = null;
        length = 0;
    }
    
    public boolean add(T newEntry) {
        first = add(newEntry, first);
        length++;
        return true; 
    }
    
    private Node add(T newEntry, Node currNode){
      if((currNode == null)||newEntry.compareTo(currNode.data)<=0)
      {
          currNode = new Node(newEntry, currNode);
      }
      else
      {
          Node nodeAfter = add(newEntry, currNode.next);
          currNode.next = nodeAfter;
      }
      return currNode;
    }
    
    public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = first;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
    }
    
    public T remove(int givenPosition) {
    T result = null;                 // return value

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = first.data;     // save entry to be removed
        first = first.next;
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = first;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;  // save entry to be removed
        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      length--;
      }

    return result;                   // return removed entry, or
    // null if operation fails
    }
    
     public boolean contains(T anEntry) {
    
        boolean found = false;
        Node tempNode = first;
        int pos = 1;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.next;
                pos++;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry))
            return true;
        else 
            return false;
    }
    
    public int getNumberOfEntries() {
    return length;
    }
    
    public boolean isEmpty() {
    return (length == 0);
    }
    
    private class Node {

    private T data;
    private Node next;

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    }

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    }
  }
}
