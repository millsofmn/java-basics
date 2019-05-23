package com.millsofmn.javabasics.threads;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> tasks = Arrays.asList(
                new CallableTask("Lyle"),
                new CallableTask("Hero"),
                new CallableTask("Gental")
        );

        List<Future<String>> results = executorService.invokeAll(tasks);

        for(Future<String> result : results){
            System.out.println(result.get());
        }
        executorService.shutdown();
    }
}
