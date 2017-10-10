package test;
import java.io.*;
public class Area
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the coordinates of x1,y1 of r1: ");
        int r1x1 = Integer.parseInt(in.readLine());
        int r1y1 = Integer.parseInt(in.readLine());
        System.out.println("Enter the coordinates of x2,y2 of r1: ");
        int r1x2 = Integer.parseInt(in.readLine());
        int r1y2 = Integer.parseInt(in.readLine());
        System.out.println("Enter the coordinates of x1,y1 of r2: ");
        int r2x1 = Integer.parseInt(in.readLine());
        int r2y1 = Integer.parseInt(in.readLine());
        System.out.println("Enter the coordinates of x2,y2 of r2: ");
        int r2x2 = Integer.parseInt(in.readLine());
        int r2y2 = Integer.parseInt(in.readLine());
        int r1left=0,r1top=0,r1bottom=0,r1right=0;
        int r2left=0,r2top=0,r2bottom=0,r2right=0;
        if(r1x1<r1x2)
        {
            r1left=r1x1;
            r1right=r1x2;
        }
        else
        {
            r1left=r1x2;
            r1left=r1x1;
        }
        if(r2x1<r2x2)
        {
            r2left=r2x1;
            r2right=r2x2;
        }
        else
        {
            r2left=r2x2;
            r2left=r2x1;
        }
        if(r1y1<r1y2)
        {
            r1bottom=r1y1;
            r1top=r1y2;
        }
        else
        {
            r1bottom=r1y2;
            r1top=r1y1;
        }
        if(r2y1<r2y2)
        {
            r2bottom=r2y1;
            r2top=r2y2;
        }
        else
        {
            r2bottom=r2y2;
            r2top=r2y1;
        }
        System.out.println("Left of r1: "+r1left);
        System.out.println("Top of r1: "+r1top);
        System.out.println("Right of r1: "+r1right);
        System.out.println("Bottom of r1: "+r1bottom);
        System.out.println("Left of r2: "+r2left);
        System.out.println("Top of r2: "+r2top);
        System.out.println("Right of r2: "+r2right);
        System.out.println("Bottom of r2: "+r2bottom);
        int leftx = Math.max(r1left, r2left);
        int rightx = Math.min(r1right, r2right);
        int bottomy = Math.max(r1bottom, r2bottom);
        int topy = Math.min(r1top, r2top);
        double r1area,r2area,intarea=0;
        if((rightx>leftx)&&(topy>bottomy))
        {
        	//intersection
        	int lleft = topy-bottomy;
        	int ltop = rightx-leftx;
        	intarea = lleft*ltop;
        }
        int lr1top = r1x2-r1x1;
        int lr1left = r1y2-r1y1;
        int lr2top = r2x2-r2x1;
        int lr2left = r2y2-r2y1;
        r1area = lr1top*lr1left;
        System.out.println("r1area = "+r1area);
        r2area = lr2top*lr2left;
        System.out.println("r2area = "+r2area);
        System.out.println("intersection = "+intarea);
        double totalarea = Math.abs(r1area) + Math.abs(r2area) - Math.abs(intarea);
        System.out.println("The total area of figure is: "+totalarea);
    }
}