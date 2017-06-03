package com.guyuwei.book.thread03;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 每当需要对一组相关的数据以原子方式执行某个操做时，就可以考虑创建一个不可变的类来包含这些数据。
 * @author acer
 *
 */


public class OneValueCache {
	
	private  BigInteger lastNumber;
	private  BigInteger[] lastFactors;
	
	public OneValueCache(BigInteger i,BigInteger[] factors){
		lastNumber = i;
		factors = Arrays.copyOf(factors, factors.length);
	}
	
	public BigInteger[] getFactors(BigInteger i){
		if (lastNumber == null || !lastFactors.equals(i)){
			return null;
			
		}else{
			return Arrays.copyOf(lastFactors, lastFactors.length);
		}
	}

}
