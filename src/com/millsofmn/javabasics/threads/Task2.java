package com.millsofmn.javabasics.threads;

class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.print("\nTask2 Started");

        for(int i = 201; i <= 299; i++)
            System.out.print(i + " ");

        System.out.print("\nTask2 Done");
    }
}
