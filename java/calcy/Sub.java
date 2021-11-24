package calcy;
import java.io.*;
public class Sub
{
	DataInputStream d= new DataInputStream(System.in);
	double a,b,c=0;
	public void minus()throws IOException
	{
		System.out.println("Enter First Number : ");
		a=Integer.parseInt(d.readLine());
		System.out.println("Enter Second Number : ");
		b=Integer.parseInt(d.readLine());
		System.out.println("First No. is      "+a);
		System.out.println("Second No. is "+b);
		c=a-b;
		System.out.println("Substraction is       "+c);
	}
}