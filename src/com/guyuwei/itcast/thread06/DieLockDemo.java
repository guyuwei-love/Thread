package com.guyuwei.itcast.thread06;

public class DieLockDemo {

	public static void main(String[] args) {
		DieLock dl1 = new DieLock(false);
		DieLock dl2 = new DieLock(true);
		
		
		Thread th1 = new Thread(dl1);
		Thread th2 = new Thread(dl2);
		
		th1.start();
		th2.start();

	}

}
