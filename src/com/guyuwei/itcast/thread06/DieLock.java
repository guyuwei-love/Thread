package com.guyuwei.itcast.thread06;

/**
 * 
 * 同步的弊端
 *    A:效率低
 *    B：容易产生死锁(如果出现了同步嵌套，就容易产生死锁)
 * 
 * 死锁：
 *    两个或两个以上的线程在争夺资源的时候，产生一种互相等待的现象。
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
