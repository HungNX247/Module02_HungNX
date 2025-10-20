package com.codegym.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);

        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);

        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);

        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);

        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.insertAfter(dll.head.next, 8);

        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        // dll.InsertBefore(dll.head.next.next, 5);

        System.out.println("Created DLL is: ");
        dll.printList(dll.head);

        dll.deleteNode(dll.head); /*delete first node*/
        dll.deleteNode(dll.head.next); /*delete middle node*/
        dll.deleteNode(dll.head.next); /*delete last node*/

        System.out.print(
                "\nModified Linked list ");
        dll.printList(dll.head);

        // Create the doubly linked list:
        // 10<->8<->4<->2<->5
        dll.push(10);
        dll.push(8);
        dll.push(4);
        dll.push(2);
        dll.push(5);

        int n = 3;//remove node 4

        // delete node at the given position 'n'
        dll.deleteNodeAtGivenPos(n);
        System.out.println("\nDoubly linked "
                +"list after deletion:");
        dll.printList(dll.head);
    }
}
