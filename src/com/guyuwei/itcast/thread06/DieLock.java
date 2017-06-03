package com.guyuwei.itcast.thread06;

/**
 * 
 * ͬ���ı׶�
 *    A:Ч�ʵ�
 *    B�����ײ�������(���������ͬ��Ƕ�ף������ײ�������)
 * 
 * ������
 *    �������������ϵ��߳���������Դ��ʱ�򣬲���һ�ֻ���ȴ�������
 * 
 * 
 * 
 * 
 * 
 * 
 * @author acer
 *
 */
public class DieLock implements Runnable{
	private boolean flag;
	
	public DieLock(boolean flag){
		this.flag = flag;
	}

	@Override
	public void run() {
		
		if(flag){
			synchronized(MyLock.objA){
				System.out.println("if ObjA...");
				synchronized(MyLock.objB){
					System.out.println("if ObjB...");
				}
			}
		}else{
			
			synchronized(MyLock.objB){
				System.out.println("else ObjB..");
				synchronized(MyLock.objA){
					System.out.println("else ObjA..");
				}
			}
		}
		
	}
}
