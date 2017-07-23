package com.guyuwei.book.thread10;

public class DieLockDemo {

	public static void main(String[] args) {
		Account fromAccount = new Account();
		Account toAccount = new Account();
		DollarAmount amount = new DollarAmount();
		
		Thread t1 = new Thread(new DieLock(fromAccount,toAccount,amount));
		
		Thread t2 = new Thread(new DieLock(toAccount,fromAccount,amount));
		
		t1.start();
		t2.start();

	}

}
