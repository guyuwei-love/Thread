package com.guyuwei.book.thread03;

/**
 * ��ȻNoVisibility�����������42������ʵ�Ϻܿ������0���߸����޷���ֹ��
 * ��Ϊ�ڴ�����û��ʹ���㹻��ͬ�����ƣ�����޷���֤���߳�д���readyֵ��numberֵ���ڶ��߳���˵�ǿɼ��ġ�
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
