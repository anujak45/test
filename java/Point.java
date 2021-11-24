import java.util.*;
import java.io.*;
class Point
{
	double c;
	double e;
	void setxy(float par1,float par2)
	{
		e=(par1*par1)+(par2*par2);
		c=Math.sqrt(e);	
		System.out.println("Distance from Origion to point is "+c+" Unit" );
	}
	public static void main(String ab[])throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		System.out.println("Enter Co-Ordinates of Point :");	
		float x=Float.parseFloat(d.readLine());
		float y=Float.parseFloat(d.readLine());
		Point p1=new Point();
		p1.setxy(x,y);
	}
}