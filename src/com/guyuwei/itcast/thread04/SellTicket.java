package com.guyuwei.itcast.thread04;

public class SellTicket implements Runnable {

    //volatile �������ε����ݼ��ı�������Ϊvolatile�ı���ֻ��ȷ���ɼ��ԣ����ܱ�֤ԭ���ԣ�
	private volatile int tickets = 100;
	
	Object obj = new Object();
	
	@Override
	public void run() {
		
		while (true){
			if (tickets > 0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "�����۵�" + (tickets--) +"��Ʊ");
			}
			
		}

	}

}
