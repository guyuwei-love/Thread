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
						s.wait();//�ȴ��������ͷ����������ѹ�����ʱ��Ҳ�Ǵ������ѹ����ġ�
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(s.name + "-------" + s.age);
				
				s.flag = false;
				s.notify();// �����ڴ˶���������ϵȴ��ĵ����̡߳����ǻ���֮�󲢲�һ������ִ�У����뻻��ǿCPU��ִ��Ȩ��
			}
			
		}
	    
	}

}
