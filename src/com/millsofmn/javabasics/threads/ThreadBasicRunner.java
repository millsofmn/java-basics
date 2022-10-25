package com.millsofmn.javabasics.threads;

public class ThreadBasicRunner {
    public static void main(String[] args) throws InterruptedException {

        // Thread States
        // * NEW
        // * RUNNABLE
        // * RUNNING
        // * BLOCKED/WAITING
        // * TERMINATED/DEAD

        System.out.print("\nUniqueGroups Kicked Off");
        Task1 task1 = new Task1();
        task1.setPriority(Thread.MIN_PRIORITY); // no real affect due to cpu utilization
        task1.start();


        System.out.print("\nAlabetical Kicked Off");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(Thread.MAX_PRIORITY);
        task2Thread.start();

        // wait for task1 to complete
//        task1.join();
        task2Thread.join();

        System.out.print("\nBanana Kicked Off");
        for(int i = 101; i <= 199; i++)
            System.out.print(i + " ");
        System.out.print("\nBanana Done");

        System.out.print("\nMain Done");
    }
}
