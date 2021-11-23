package calcy;
import java.io.*;
public class Div
{
	DataInputStream d= new DataInputStream(System.in);
	double a,b,c=0;
	public void by()throws IOException
	{
		System.out.println("Enter First Number : ");
		a=Integer.parseInt(d.readLine());
		System.out.println("Enter Second Number : ");
		b=Integer.parseInt(d.readLine());
		System.out.println("Dividend No. is      "+a);
		System.out.println("Dividor No. is "+b);
		c=a/b;
		System.out.println("Division is       "+c);
	}
}