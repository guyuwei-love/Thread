package com.guyuwei.itcast.thread07;

public class SetThread implements Runnable{
	
	private Student s;
	
	private int x = 0;
	
	public SetThread(Student s){
		this.s = s;
	}

	@Override
	public void run() {
		while(true){
			synchronized(s){
				if(s.flag){
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(x % 2 == 0){
					s.name = "AAAAA";
					s.age = 18;
				}else{
					s.name = "BBBBB";
					s.age = 20;
				}
				
				x++;
				
				s.flag = true;
				
				s.notify();// 唤醒在此对象监视器上等待的单个线程。
			}
			
		}
		
	}

}
