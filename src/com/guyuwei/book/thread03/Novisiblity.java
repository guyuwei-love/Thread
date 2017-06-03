package com.guyuwei.book.thread03;

/**
 * 虽然NoVisibility看起来会输出42，但事实上很可能输出0或者根本无法终止。
 * 因为在代码中没有使用足够的同步机制，因此无法保证主线程写入的ready值和number值对于读线程来说是可见的。
 * 
 * @author acer
 *
 */
public class Novisiblity {
	private static boolean ready;
	private static int number;
	
	
	private static class ReaderThread extends Thread{
		@Override
		public void run() {
			System.out.println("run the readerThready ready:"+ready);
			while(!ready){
				Thread.yield();
				System.out.println("Thready:"+number);
			}
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		number = 42;
		ready = true;
	}
	
}
