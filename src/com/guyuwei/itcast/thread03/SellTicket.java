package com.guyuwei.itcast.thread03;

public class SellTicket implements Runnable {

	private int tickets = 100;
	
	Object obj = new Object();
	
	private int x = 0;
	
	@Override
	public void run() {
		
		while (true){
			if (x % 2 == 0){
				synchronized(this){
					if (tickets > 0){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "正在售第" + (tickets--) +"张票");
					}
				}
			}else{
				execute();
			}
			
			x++;
			
		}
		
		

	}
	
	
	public synchronized void execute(){

		if (tickets > 0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在售第" + (tickets--) +"张票");
		}
	
	}
}
