package com.guyuwei.interview01;


/*
 * �ڶ��⣺�ֳɳ����е�Test���еĴ����ڲ��ϵز������ݣ�Ȼ�󽻸�TestDo.doSome()����ȥ�����ͺ����������ڲ��ϵز������ݣ��������ڲ����������ݡ�
	  �뽫����������10���߳������������߲��������ݣ���Щ�����߶�����TestDo.doSome()����ȥ���д�����ÿ�������߶���Ҫһ����ܴ����꣬
	  ����Ӧ��֤��Щ�������߳�����������������ݣ�ֻ����һ�����������������һ�������߲����������ݣ���һ����������˭�����ԣ�
	  ��Ҫ��֤��Щ�������߳��õ�����������˳��ġ�ԭʼ�������£�
 */
public class Test1 {

	public static void main(String[] args) {

		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		for (int i = 0; i < 10; i++) { // ���в��ܸĶ�
			String input = i + ""; // ���в��ܸĶ�
			String output = TestDo.doSome(input);
			System.out.println(Thread.currentThread().getName() + ":" + output);
		}
	}
}

// ���ܸĶ���TestDo��
class TestDo {
	public static String doSome(String input) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}