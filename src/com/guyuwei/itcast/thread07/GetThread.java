package com.guyuwei.itcast.thread07;

public class GetThread implements Runnable{
	
	private Student s;
	
	public GetThread(Student s){
		this.s = s;
	}

	@Override
	public void run() {
		while(true){
			synchronized(s){
				if(!s.flag){
					try {
						s.wait();//等待后，立即释放锁。将来醒过来的时候，也是从这里醒过来的。
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(s.name + "-------" + s.age);
				
				s.flag = false;
				s.notify();// 唤醒在此对象监视器上等待的单个线程。但是唤醒之后并不一定立即执行，必须换得强CPU的执行权。
			}
			
		}
	    
	}

}
