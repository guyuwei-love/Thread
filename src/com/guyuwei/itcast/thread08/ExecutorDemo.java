package com.guyuwei.itcast.thread08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * �̳߳صĺô����̳߳����ÿһ���̴߳�������󣬲����������������ٴλص��̳߳��г�Ϊ����״̬���ȴ���һ��������ʹ�á�
 * 
 * ���ʵ���̵߳Ĵ�����?
 * 		A:����һ���̳߳ض��󣬿���Ҫ���������̶߳���
 * 			public static ExecutorService newFixedThreadPool(int nThreads)
 * 		B:�����̳߳ص��߳̿���ִ�У�
 * 			����ִ��Runnable�������Callable���������߳�
 * 			��һ����ʵ��Runnable�ӿڡ�
 * 		C:�������·�������
 * 			Future<?> submit(Runnable task)
 *			<T> Future<T> submit(Callable<T> task)
 *		D:�Ҿ�Ҫ������������?
 *			���ԡ�
 */
public class ExecutorDemo {
	
	
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		Runnable run = new Runnable(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println(Thread.currentThread().getName()+";"+i);
				}
				
			}
		};
		
		exec.submit(run);
		exec.submit(run);
		
		exec.shutdown();
	}
	
}
