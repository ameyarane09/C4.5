package test;

import java.util.ArrayList;

public class PohligHellmanAlgorithm 
{
	ArrayList<Integer> xvalues = new ArrayList<Integer>();
	public static void factors(int q, int f, int a, int b, int p)
	{
		if(f>0){
		//System.out.println(q+" - "+f);
		/*System.out.println(q);
		System.out.println(a);
		System.out.println(b);
		System.out.println(p);*/
		int l = ((int) Math.pow(b, ((p-1)/q)))%p;
		int r = ((int) Math.pow(a, ((p-1)/q)))%p;
		int n=0;
		int m=0;
		boolean bol = true;
		while(bol)
		{
			m = ((int) Math.pow(r, n))%p;
			if(m==l)
				bol=false;
			else
				n++;
		}
		/*System.out.println(l);
		System.out.println(r);*/
		//System.out.println(n);
		int newb=0;
		int newq=0;
		int k=0;
		boolean bo=true;
		while(bo)
		{
			int right = b%p;
			int left = ((int) (Math.pow(a, n)))%p;
			left = (left*k)%p;
			//System.out.println(left);
			//System.out.println(right);
			if(left==right)
			{
				bo=false;
			}
			else
			{
				k++;
			}
		}
		//System.out.println(k);
		newb=k;
		newq=(int)Math.pow(q, 2);
		//factors(newq,f--,a,newb,p);
		}
	}
	public static void main(String args[])
	{
		int p = 201;
		int a = 7;
		int b = 12;
		int n = p-1;
		int flag1=0,flag2=0;
		int prod=1;
		int freq[] = new int[100];
		for(int i=1;i<=9;i++)
		{
			freq[i] = 0;
		}
		ArrayList<Integer> primefactors = new ArrayList<Integer>();
		while(n%2 == 0)
		{
//			if(flag1==0)
			//primefactors.add(2);
			prod*=2;
			n=n/2;
			freq[2]++;
			flag1=1;
		}
		primefactors.add(prod);
		prod=1;
		for(int i=3;i<=Math.sqrt(n);i=i+2)
		{
			if(n%i==0){
			while(n%i==0)
			{
				//if(flag2==0)
				//primefactors.add(i);
				prod*=i;
				freq[i]++;
				n=n/i;
				flag2=1;
			}
			primefactors.add(prod);
			prod=1;
			}
		}
		if(n>2)
		{
			primefactors.add(n);
			freq[n]++;
		}
		System.out.println(primefactors);
		//factors(primefactors.get(0),/*freq[primefactors.get(0)]*/1,a,b,p);
		for(int i=0;i<100;i++)
		{
			if(freq[i]>0)
			System.out.println("Freq of "+i+" = "+freq[i]);
		}
		/*ArrayList<Integer> can = new ArrayList<Integer>();
		int prod=1;
		int val = primefactors.get(0);
		prod=val;
		for(int i=1;i<primefactors.size();i++)
		{
			if(val==primefactors.get(i))
			{
				prod=prod*val;
			}
			else
			{
				can.add(prod);
				val=primefactors.get(i);
				prod=val;
			}
		}
		can.add(prod);
		System.out.println(can);*/
	}
}
