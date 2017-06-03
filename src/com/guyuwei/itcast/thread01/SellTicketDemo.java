package com.guyuwei.itcast.thread01;

public class SellTicketDemo {
	public static void main(String[] args) {
		SellTicket st1 = new SellTicket();
		SellTicket st2 = new SellTicket();
		SellTicket st3 = new SellTicket();
		
		st1.setName("´°¿Ú1");
		st2.setName("´°¿Ú2");
		st3.setName("´°¿Ú3");
		
		
		st1.start();
		st2.start();
		st3.start();
	}
}
