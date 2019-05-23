package com.millsofmn.javabasics.threads;

public class Task extends Thread {

    private int number;

    public Task(int number) {
        this.number = number;
    }

    public void run() {
        System.out.print("\nTask" + number + " Kicked Off");
        for (int i = number * 100; i <= number * 100 + 99; i++)
            System.out.print(i + " ");
        System.out.print("\nTask" + number + " Done");
    }
}
