package calcy;
import java.io.*;
public class Add
{
	DataInputStream d= new DataInputStream(System.in);
	double a,b,c=0;
	public void plus()throws IOException
	{
		System.out.println("Enter First Number : ");
		a=Integer.parseInt(d.readLine());
		System.out.println("Enter Second Number : ");
		b=Integer.parseInt(d.readLine());
		System.out.println("First No. is      "+a);
		System.out.println("Second No. is "+b);
		c=a+b;
		System.out.println("Addition is       "+c);
	}
}