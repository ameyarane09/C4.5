package test;
import java.io.*;
public class UniquePair
{
	static int[] sort(int n[])
	{
		int temp=0;
		for(int i=0;i<n.length-1;i++)
		{
			for(int j=i+1;j<n.length;j++)
			{
				if(n[i]>n[j])
				{
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		return n;
	}
	public static void main(String args[])throws IOException
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.println("Enter the no of elements: ");
		int num = Integer.parseInt(in.readLine());
		int n[] = new int[num];
		System.out.println("Enter the elements: ");
		for(int i=0;i<num;i++)
		{
			n[i] = Integer.parseInt(in.readLine());
		}
		int []m = sort(n);
		for(int i=0;i<num-1;i++)
		{
			System.out.println(m[i]+" - "+m[i+1]);
		}
	}
}