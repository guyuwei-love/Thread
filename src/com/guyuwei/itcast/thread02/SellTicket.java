package com.guyuwei.itcast.thread02;

public class SellTicket implements Runnable {

	private int tickets = 100;
	
	Object obj = new Object();
	
	@Override
	public void run() {
		
		while (true){
			synchronized(obj){
				if (tickets > 0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在售第" + (tickets--) +"张票");
				}
			}
			
		}

	}

}
