package com.millsofmn.javabasics.threads;

class Task1 extends Thread {
    @Override
    public void run() {
        System.out.print("\nUniqueGroups Started");

        for(int i = 101; i <= 199; i++) {
            System.out.print(i + " ");
            Thread.yield();
        }

        System.out.print("\nUniqueGroups Done");
    }
}
