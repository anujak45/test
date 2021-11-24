import java.io.*;
import java.util.*;
class Line
{
	int a,b,c;
	void setValue(int p1,int p2,int p3)throws IOException
	{
		a=p1;
		b=p2;
		c=p3;
	}
	void slope()throws IOException
	{
		if(-(a/b)==0)
		{
			System.out.println("Lines are Parallel with X axis ! ");
		}
		else
		{
			System.out.println("Lines are Not Parallel with X axis! ");
		}
	}
	public static void main(String args[])throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		System.out.println("Consider ax+by+c=0 is a Line ! ");
		System.out.println("Enter Value of a,b,c :");
		int q1=Integer.parseInt(d.readLine());
		int q2=Integer.parseInt(d.readLine());
		int q3=Integer.parseInt(d.readLine());
		Line l1=new Line();
		l1.setValue(q1,q2,q3);
		l1.slope();
	}
}