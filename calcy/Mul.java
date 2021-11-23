package calcy;
import java.io.*;
public class Mul
{
	DataInputStream d= new DataInputStream(System.in);
	double a,b,c=0;
	public void into()throws IOException
	{
		System.out.println("Enter First Number : ");
		a=Integer.parseInt(d.readLine());
		System.out.println("Enter Second Number : ");
		b=Integer.parseInt(d.readLine());
		System.out.println("First No. is      "+a);
		System.out.println("Second No. is "+b);
		c=a*b;
		System.out.println("Multiplication is       "+c);
	}
}