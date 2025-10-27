package com.codegym.queue;


// Java program to add elements to a Queue
import java.util.*;

public class QueueInserting {

    public static void main(String args[]) {
        Queue<String> pq = new PriorityQueue<>();

        pq.add("CodeGym");
        pq.add("C10");
        pq.add("Class");

        System.out.println(pq);
    }
}
