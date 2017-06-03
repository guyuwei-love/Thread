package com.guyuwei.book.thread03;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * ÿ����Ҫ��һ����ص�������ԭ�ӷ�ʽִ��ĳ������ʱ���Ϳ��Կ��Ǵ���һ�����ɱ������������Щ���ݡ�
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
