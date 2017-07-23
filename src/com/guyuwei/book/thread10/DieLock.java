package com.guyuwei.book.thread10;

public class DieLock implements Runnable{
	
	Account fromAccount;
	Account toAccount;
	DollarAmount amount;
	
	
	
	public DieLock(Account fromAccount, Account toAccount, DollarAmount amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	@Override  
	public void run() {
		transferMoney(fromAccount, toAccount, amount);
		
	}
	
	public void transferMoney(Account fromAccount,Account toAccount,DollarAmount amount){
		synchronized(fromAccount){
			try { 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(toAccount){
				System.out.println("die lock"+Thread.currentThread().getName());
			}
			
		}
	}

}
