package test;

import java.math.BigInteger;
import java.util.ArrayList;

public class PohligTest 
{
	public static long power(long a, long m, long n)
	{
		// Find a^m mod n
		BigInteger base = BigInteger.valueOf(a);
		BigInteger exponent = BigInteger.valueOf(m);
		BigInteger module = BigInteger.valueOf(n);
		BigInteger p = base.modPow(exponent, module);
		return p.longValue();
	}
	public static long inverse(long a, long n)
	{
		// Find a^(-1) mod n
		BigInteger r1 = BigInteger.valueOf(a);
		BigInteger r2 = BigInteger.valueOf(n);
		BigInteger inv = r1.modInverse(r2);
		return inv.longValue();		
	}
	public static void main(String args[])
	{
		//long[] primes = {8,5};
		long p = 97;//p  41
		long alpha = 29;//g  7
		long beta = 61;//k  12
		long phi = 0;
		long n = p-1;
		phi=n;
		long prod=1;
		ArrayList<Long> primefactors = new ArrayList<Long>();
		while(n%2 == 0)
		{
			prod*=2;
			n=n/2;
		}
		primefactors.add(prod);
		prod=1;
		for(int i=3;i<=Math.sqrt(n);i=i+2)
		{
			if(n%i==0){
			while(n%i==0)
			{
				prod*=i;
				n=n/i;
			}
			primefactors.add(prod);
			prod=1;
			}
		}
		if(n>2)
		{
			primefactors.add(n);
		}
		long[] b = new long[primefactors.size()];
		System.out.println(primefactors);
		for (int i=0; i<primefactors.size(); i++) 
		{
			long e = phi/primefactors.get(i);
			long betaPow = power(beta, e, p);
			long alphaPow = power(alpha, e, p);
			for (long j=0; j<primefactors.get(i); j++) 
			{
				long a1 = power(alphaPow, j, p);
				if (a1 == betaPow) 
				{
					b[i] = j; 
					//System.out.println(b[i]);
					break;
				}
			}
		}
		for (int i=0; i<b.length; i++) 
		{
			System.out.println("b" + (i+1) + " = " + b[i]);
		}
		long M = 1;
		long[] m = new long[b.length];
		for (int i=0; i<primefactors.size(); i++) 
			M = M*primefactors.get(i);
		//System.out.println(M);
		for (int i=0; i<primefactors.size(); i++) 
		{
			m[i] = inverse(M/primefactors.get(i), primefactors.get(i));
			System.out.println(m[i]);
		}
		long answer = 0;
		for (int i=0; i<b.length; i++) 
		{
			answer = (answer + b[i]*m[i]*M/primefactors.get(i))%M;
			System.out.println(answer);
		}
		System.out.println("Answer = " + answer);
	}
}
