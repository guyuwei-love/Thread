package com.guyuwei.book.thread16;

public class PossibleRecording {
	
	public static int x = 0, y = 0;
	public static int a = 0, b = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(new Runnable(){
			public void run(){
				a = 1;
				x = b;
			}
		});
		
	   Thread other = new Thread(new Runnable(){
		   public void run(){
			   b = 1;
			   y = a;
		   }
	   });
	   other.start();
	   one.start();
	   
	   //one.join();
	   other.join();
	   
	   System.out.println(" ( " + x + "," + y  + " )");
	}

}
