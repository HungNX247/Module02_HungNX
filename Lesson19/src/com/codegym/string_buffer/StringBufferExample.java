package com.codegym.string_buffer;

public class StringBufferExample {
    private static StringBuffer sharedBuffer = new StringBuffer();

    public static void main(String[] args) {
        Runnable writer = () -> {
            for (int i = 0; i < 5; i++) {
                sharedBuffer.append(Thread.currentThread().getName())
                        .append(" record data times ").append(i).append("\n");
            }
        };

        Thread t1 = new Thread(writer, "Thread-1");
        Thread t2 = new Thread(writer, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sharedBuffer.toString());
    }
}
