package com.codegym.list;

public interface MyList<E> extends java.lang.Iterable<E> {
    public void add(E e); // Add element "e" at the end of the list.

    public void add(int index, E e); // Add elements "e" at the index position, the following elements are moved
                                     // down.

    public void clear(); // Delete all elements in the list.

    public boolean contains(E e); // Returns "true" if list contains elements "e".

    public E get(int index); // Get the elements at index position.

    public int indexOf(E e); // Returns the index of first found elements "e", or "-1" if none exists.

    public boolean isEmpty(); // Returns "true" if the list has no elements.

    public int lastIndexOf(E e); // Returns the last index of elements "e", or "-1" if none exists.

    public boolean remove(E e); // Remove the first elements equal to "e" in the list, returning "true" if the
                                // removal successful.

    public E remove(int index); // Remove the elements at the index position.

    public Object set(int index, E e); // Assign the element at the index position to "e" and returns the old value.

    public int size(); // Returns the numbers of the elements in the list.
}
