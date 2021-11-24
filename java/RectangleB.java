import java.io.*;
class RectangleB
{
	DataInputStream d=new DataInputStream(System.in);
	float length,breadth;
	float c,p;
	void accept()throws IOException
	{
		System.out.println("Enter Length of Rectangle");
		length=Float.parseFloat(d.readLine());
		System.out.println("Enter Breadth of Rectangle");
		breadth=Float.parseFloat(d.readLine());
	}
	void area()
	{
		c=length*breadth;
		System.out.println("AREA of Rectangle is "+c+" Sq. Unit");
	}
	void perimeter()
	{
		p=2*(length+breadth);
		System.out.println("PERIMETER of Rectangle is "+p+" Unit");
	}
	public static void main(String ab[])throws IOException
	{
		RectangleB r2=new RectangleB();
		r2.accept();
		r2.area();
		r2.perimeter();
	}
}