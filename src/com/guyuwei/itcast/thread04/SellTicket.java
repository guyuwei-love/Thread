package com.guyuwei.itcast.thread04;

public class SellTicket implements Runnable {

    //volatile 不宜修饰递增递减的变量（因为volatile的变量只能确保可见性，不能保证原子性）
	private volatile int tickets = 100;
	
	Object obj = new Object();
	
	@Override
	public void run() {
		
		while (true){
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
