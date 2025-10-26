package com.codegym.excercise.queue;

public class Solution {
    private Queue queue = new Queue();
    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (queue.front == null) {
            queue.front = queue.rear = newNode;
            queue.rear.link = queue.front;
        } else {
            queue.rear.link = newNode;
            queue.rear = newNode;
            queue.rear.link = queue.front;
        }
    }

    public void deQueue() {
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        if (queue.front == queue.rear) {
            queue.front = queue.rear = null;
        } else {
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
    }

    public void displayQueue() {
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = queue.front;
        System.out.println("Elements: ");
        do {
            System.out.println(temp.data + " ");
            temp = temp.link;
            System.out.println();
        } while (temp != queue.front);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.enQueue(10);
        solution.enQueue(20);
        solution.enQueue(30);
        solution.displayQueue();
        solution.deQueue();
        solution.displayQueue();
    }
}
