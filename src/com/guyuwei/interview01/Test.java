package com.guyuwei.interview01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
	
	public static void main(String[] args){
        
		final BlockingQueue<String> fileQueue = new ArrayBlockingQueue<String>(16);
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*ģ�⴦��16����־������Ĵ��������16����־���󣬵�ǰ������Ҫ����16����ܴ�ӡ����Щ��־��
		�޸ĳ�����룬���ĸ��߳�����16��������4���Ӵ��ꡣ
		*/
		for(int n=0;n<4;n++){
			new Thread(){
				public void run(){
					try {
						while(true){
							String log = fileQueue.take();
							parseLog(log);
						}
						
					} catch (InterruptedException e) {
						//11111111111111
						e.printStackTrace();
					}
				}
			}.start();
		}
		
		
		for(int i=0;i<16;i++){  //���д��벻�ܸĶ�
			final String log = ""+(i+1);//���д��벻�ܸĶ�
			try {
				fileQueue.put(log);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	public  void exe(String log){
		for(int i=0;i<4;i++){
			new Thread(){
				public void run(){
					Test.parseLog(log);
				}
			}.start();
		}
	}
	
	//parseLog�����ڲ��Ĵ��벻�ܸĶ�
	public static void parseLog(String log){
		System.out.println(log+":"+(System.currentTimeMillis()/1000));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}