package test;
import java.io.*;
public class Equilibrium
{
    static void calc(int n[])
    {
        int l=n.length;
        int left=0,right=0,index=0;
        for(int i=1;i<l;i++)
        {
            index=i-1;
            while(index>=0)
            left+=n[index--];
            index=i+1;
            while(index<l)
            right+=n[index++];
            if(left==right)
            System.out.println("Index: "+i);
            left=0;
            right=0;
        }
    }
    public static void main(String args[])throws IOException
    {
    	long start = System.currentTimeMillis();
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the number of elements: ");
        int n = Integer.parseInt(in.readLine());
        System.out.println("Enter the elements: ");
        int m[] = new int[n];
        for(int i=0;i<n;i++)
        {
        	System.out.println("i="+i);
            m[i]=Integer.parseInt(in.readLine());
        }
        /*List<Integer> n = new ArrayList();
        int s=Integer.parseInt(in.readLine());
        while(s!=0)
        {
            n.add(s);
            s=0;
            s=Integer.parseInt(in.readLine());
        }
        for(int i=0;i<n.size();i++)
        {
            m[i] = n.get(i);
        }*/
        //System.out.println(start);
        calc(m);
        System.out.println(System.currentTimeMillis() - start);
        /*for(int i=0;i<n.size();i++)
        {
            System.out.println(m[i]);
        }*/
        //print
    }
}