package com.guyuwei.itcast.thread07;

public class StudentMain {

	public static void main(String[] args) {
		Student s = new Student();
		
		
		GetThread gt = new GetThread(s);
		SetThread st = new SetThread(s);
		
		Thread th1 = new Thread(st);
		Thread th2 = new Thread(gt);
		
		th2.start();
		th1.start();
		
	}

}
