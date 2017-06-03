package com.guyuwei.book.thread04;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过封闭机制来确保线程安全。
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
