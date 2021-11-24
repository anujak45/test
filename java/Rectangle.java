import java.io.*;
class Rectangle
{
	DataInputStream d=new DataInputStream(System.in);
	float length,breadth;
	void method1()throws IOException
	{	
		System.out.println("Enter Length of Rectangle :");
		length=Float.parseFloat(d.readLine());
		System.out.println("Enter breadth of Rectangle :");
		breadth=Float.parseFloat(d.readLine());
		float c=length*breadth;
		float p= 2*(length+breadth);
		System.out.println("Area of Rectangle is "+c+" Sq. Unit");
		System.out.println("Perimeter of Rectangle is "+p+" Unit");
	}
	public static void main(String ab[])throws IOException
	{
		Rectangle r1=new Rectangle();
		r1.method1();
	}
}