package com.millsofmn.javabasics.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> welcomeFuture = executorService.submit(new CallableTask("Lyle"));
        System.out.println("New CallableTask(Lyle) executed");

        String welcomeMessage = welcomeFuture.get();
        System.out.println(welcomeMessage);
        System.out.println("Main Completed");

        executorService.shutdown();

    }
}
