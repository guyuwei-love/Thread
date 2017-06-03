package com.guyuwei.itcast.thread05;

public class SellTicketsDemo {
	public static void main(String[] args) {
		SellTicket st = new SellTicket();
		
		Thread th1 = new Thread(st,"´°¿Ú1");
		Thread th2 = new Thread(st,"´°¿Ú2");
		Thread th3 = new Thread(st,"´°¿Ú3");
		
		th1.start();
		th2.start();
		th3.start();
	}
}
