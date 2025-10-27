package com.codegym.queue;

// Java program to remove elements from a Queue
import java.util.*;

public class QueueRemoving {

    public static void main(String args[]) {
        Queue<String> pq = new PriorityQueue<>();

        pq.add("CodeGym");
        pq.add("C10");
        pq.add("Class");

        System.out.println("Initial Queue " + pq);

        pq.remove("Class");

        System.out.println("After Remove " + pq);

        System.out.println("Poll Method " + pq.poll());

        System.out.println("Final Queue " + pq);
    }
}
