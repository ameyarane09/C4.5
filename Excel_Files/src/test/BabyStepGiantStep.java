package test;

import java.io.*;
import java.util.ArrayList;

public class BabyStepGiantStep
{
	public static void main(String args[])throws IOException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.println("g: ");
		int g = Integer.parseInt(in.readLine());
		System.out.println("p: ");
		int p = Integer.parseInt(in.readLine());
		System.out.println("k: ");
		int k = Integer.parseInt(in.readLine());
		long start = System.nanoTime();
		int count=1;
		while(Math.pow(count, 2)<(p-1))
		{
			count++;
		}
		//System.out.println(count);
		ArrayList<Double> arr1 = new ArrayList<Double>();
		ArrayList<Double> arr2 = new ArrayList<Double>();
		int index=1,r=1,x=1;
		double power=0;
		while(index<count)
		{
			arr1.add((Math.pow(g, index)%p));
			r=index*count;
			//arr2.add((b*(Math.pow(a, -r)))%p);
			power = Math.pow(g,r);
			while(((x*power)%p)!=1)
			{
				x++;
			}
			//arr2.add((double)x);
			arr2.add((double)(k*x)%p);
			x=1;
			index++;
		}
		//System.out.println(arr1);
		//sSystem.out.println(arr2);
		ArrayList<Double> arr3 = new ArrayList<Double>(arr1);
		//System.out.println(arr3);
		arr3.retainAll(arr2);
		//System.out.println(arr1); 
		//System.out.println(arr3);
		int i = arr2.indexOf(arr3.get(0));
		i = (i+1)*count;
		int j = arr1.indexOf(arr3.get(0));
		j=j+1;
		System.out.println("x = "+(i+j));
		System.out.println("Time Elapsed: "+((System.nanoTime()-start))+" nanoseconds");
	}
}
