package com.codegym.singlylinkedlist;

import static com.codegym.singlylinkedlist.SinglyLinkedList.*;

public class Main {

    public static void main(String[] args) {
        /* Start with the empty list. */
        SinglyLinkedList list = new SinglyLinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION BY KEY******
        //

        // Delete node with value 1
        // In this case the key is ***at head***
        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        // Delete node with value 4
        // In this case the key is present ***in the
        // middle***
        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        // Delete node with value 10
        // In this case the key is ***not present***
        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);

        //
        // ******DELETION AT POSITION******
        //

        // Delete node at position 0
        // In this case the key is ***at head***
        deleteAtPosition(list, 0);

        // Print the LinkedList
        printList(list);

        // Delete node at position 2
        // In this case the key is present ***in the
        // middle***
        deleteAtPosition(list, 2);

        // Print the LinkedList
        printList(list);

        // Delete node at position 10
        // In this case the key is ***not present***
        deleteAtPosition(list, 10);

        // Print the LinkedList
        printList(list);
    }
}
