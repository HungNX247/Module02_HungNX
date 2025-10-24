package com.codegym.doublylinkedlist;

public class Node {
    int data;
    Node prev;
    Node next;

    // Constructor to create a new node
    // next and prev is by default initialized as null
    Node(int value) { // A constructor is called here
        prev = null; // By default previous pointer is
        // pointed to NULL
        data = value; // value is assigned to the data
        next = null; // By default next pointer is pointed
        // to NULL
    }
}