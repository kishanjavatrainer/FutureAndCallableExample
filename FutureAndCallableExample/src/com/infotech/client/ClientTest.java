package com.infotech.client;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.infotech.tasks.MyCallable;

public class ClientTest {

	public static void main(String[] args) {
		
		Callable<String> task1 = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "My Task is done";
			}

		};
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<String> future = executorService.submit(task1);
		if(future.isDone()){
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		MyCallable task2 = new MyCallable(10);
		Future<Integer> future2 = executorService.submit(task2);
		
		try {
			System.out.println(future2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
