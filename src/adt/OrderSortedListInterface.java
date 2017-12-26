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
public interface OrderSortedListInterface<T extends Comparable<? super T>> {
    public boolean add(T newEntry);
    public T getEntry(int givenPosition);
    public T remove(int givenPosition);
    public int getNumberOfEntries() ;
    public boolean isEmpty();
    public boolean contains(T anEntry) ;
    
}
