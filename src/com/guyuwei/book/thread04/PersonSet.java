package com.guyuwei.book.thread04;

import java.util.HashSet;
import java.util.Set;

/**
 * ͨ����ջ�����ȷ���̰߳�ȫ��
 * @author Aaron
 *
 */
public class PersonSet {
	private final Set<Person> mySet = new HashSet<Person>();
	
	public synchronized void addPerson(Person p){
		mySet.add(p);
	}
	
	public synchronized boolean containsPerson(Person p){
		return mySet.contains(p);
	}
}
