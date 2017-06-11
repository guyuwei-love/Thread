package com.guyuwei.itcast.thread08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		Callable<Integer> call = new Callable<Integer>(){
			
			public  int num;
			
			public Integer call(){
				
				int sum = 1;
				
				for(int i=0;i<num;i++){
					sum += i;
				}
				return sum;
			}

		};
		
		
		Future<Integer> submit = exec.submit(call);
		Future<Integer> submit2 = exec.submit(call);
		
		System.out.println(submit.get());
		System.out.println(submit2.get());
		
		exec.shutdown();
	}

}
