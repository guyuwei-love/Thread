package com.guyuwei.itcast.thread01;

public class SellTicket extends Thread{
	
	//private int tickets = 100;
	
	private static int tickets = 100;
	
	@Override
	public void run() {
		//int tickets = 100;
		
		while(true){
			if (tickets > 0) {
				System.out.println(getName() + "�����۵�" + (tickets--) +"��Ʊ");
			}	
		}
	}
}
