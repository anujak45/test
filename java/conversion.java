import java.io.*;
class conversion
{
	public static void main(String jkl[])throws IOException
	{
		DataInputStream q=new DataInputStream(System.in);
		byte b;
		int i;
		double d=323.142;
		System.out.println("Conversion into Byte : ");
		System.out.println("Enter value for i ? ");
		i=Integer.parseInt(q.readLine());
		b=(byte)i;
		System.out.println("i = "+i+", b = "+b);
		i=(int)d;
		b=(byte)i;
		System.out.println("i = "+i+", b = "+b);
	}
}