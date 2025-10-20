package com.codegym.singlylinkedlist;

public class SinglyLinkedList {
    Node head; //head of list

    public static SinglyLinkedList insert(SinglyLinkedList list, int data) {
        Node newNode = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        } else {
            // Else traverse till the last node
            // and insert the newNode there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode; // Insert the newNode at last node
        }
        return list; // Return the list by head
    }

    public static void printList(SinglyLinkedList list) {
        Node currentNode = list.head;
        System.out.print("SinglyLinkedList: ");

        // Traverse through the SinglyLinkedList
        while (currentNode != null) {
            // Print the data at current node
            System.out.print(currentNode.data + " ");

            // Go to next node
            currentNode = currentNode.next;
        }
    }

    // **************DELETION BY KEY**************

    // Method to delete a node in the LinkedList by KEY
    public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key) {
        // Store head node
        Node currentNode = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currentNode != null && currentNode.data == key) {
            list.head = currentNode.next; // Changed head

            // Display the message
            System.out.println("\n" + key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currentNode != null && currentNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currentNode;
            currentNode = currentNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currentNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currentNode.next;

            // Display the message
            System.out.println("\n" + key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currentNode == null) {
            // Display the message
            System.out.println("\n" + key + " not found");
        }

        // return the List
        return list;
    }

    // Method to delete a node in the LinkedList by POSITION
    public static SinglyLinkedList deleteAtPosition(SinglyLinkedList list, int index) {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If index is 0, then head node itself is to be
        // deleted

        if (index == 0 && currNode != null) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println("\n" + index + " position element deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the index is greater than 0 but less than the
        // size of LinkedList
        //
        // The counter
        int counter = 0;

        // Count for the index to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null) {

            if (counter == index) {
                // Since the currNode is the required
                // position Unlink currNode from linked list
                prev.next = currNode.next;

                // Display the message
                System.out.println("\n" + index + " position element deleted");
                break;
            }
            else {
                // If current position is not the index
                // continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        // If the position element was found, it should be
        // at currNode Therefore the currNode shall not be
        // null
        //
        // CASE 3: The index is greater than the size of the
        // LinkedList
        //
        // In this case, the currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println("\n" + index + " position element not found");
        }

        // return the List
        return list;
    }
}
