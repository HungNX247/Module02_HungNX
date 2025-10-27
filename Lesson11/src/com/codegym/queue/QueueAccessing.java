package com.codegym.queue;

// Java program to iterate elements to a Queue

import java.util.*;

public class QueueAccessing {

    public static void main(String args[]) {
        Queue<String> pq = new PriorityQueue<>();

        pq.add("CodeGym");
        pq.add("C10");
        pq.add("Class");

        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
