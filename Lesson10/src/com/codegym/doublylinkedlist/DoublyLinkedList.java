package com.codegym.doublylinkedlist;

public class DoublyLinkedList {
    Node head; //head of list

    // Adding a node at the front of the list
    public void push(int newData) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(newData);

        /* 3. Make next of new node as head and previous as NULL
         */
        newNode.next = head;
        newNode.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = newNode;

        /* 5. move the head to point to the new node */
        head = newNode;
    }

    // Add a node before the given node
    public void insertBefore(Node nextNode, int newData) {
        /*Check if the given nx_node is NULL*/
        if (nextNode == null) {
            System.out.println(
                    "The given next node can not be NULL");
            return;
        }

        // Allocate node, put in the data
        Node newNode = new Node(newData);

        // Making prev of new node as prev of next node
        newNode.prev = nextNode.prev;

        // Making prev of next node as new node
        nextNode.prev = newNode;

        // Making next of new node as next node
        newNode.next = nextNode;

        // Check if new node is added as head
        if (newNode.prev != null)
            newNode.prev.next = newNode;
        else
            head = newNode;
    }

    /* Given a node as prev_node, insert a new node after the
     * given node */
    public void insertAfter(Node prevNode, int newData) {

        /*1. check if the given prev_node is NULL */
        if (prevNode == null) {
            System.out.println(
                    "The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node newNode = new Node(newData);

        /* 4. Make next of new node as next of prev_node */
        newNode.next = prevNode.next;

        /* 5. Make the next of prev_node as new_node */
        prevNode.next = newNode;

        /* 6. Make prev_node as previous of new_node */
        newNode.prev = prevNode;

        /* 7. Change previous of new_node's next node */
        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    // Add a node at the end of the list
    void append(int newData) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(newData);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        newNode.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = newNode;

        /* 7. Make last node as previous of new node */
        newNode.prev = last;
    }

    // This function prints contents of
    // linked list starting from the given node
    public void printList(Node node) {
        Node last = null;
        System.out.println(
                "Traversal in forward direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println(
                "Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    // Function to delete a node in a Doubly Linked List.
    // head_ref --> pointer to head node pointer.
    // del --> data of node to be deleted.
    void deleteNode(Node del) {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }

    // Function to delete the node at the
    // given position in the doubly linked list
    void deleteNodeAtGivenPos(int n) {
        /* if list in NULL or
          invalid position is given */
        if (head == null || n <= 0)
            return;

        Node current = head;
        int i;

        /*
        * traverse up to the node at
          position 'n' from the beginning
        */
        for (i = 1; current != null && i < n; i++)
        {
            current = current.next;
        }

        // if 'n' is greater than the number of nodes
        // in the doubly linked list
        if (current == null)
            return;

        // delete the node pointed to by 'current'
        deleteNode(current);
    }
}
