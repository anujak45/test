import java.io.*;
int k,l,m;
class pilllai
{
	DataInputStream d=new DataInputStream(System.in);
	void accept()
	{
	System.ot.println("Enter the Numbers :");	
	k=Integer.parseInt(d.readLine());
	l=Integer.parseInt(d.readLine());
	}
	void display()
	{
		m=k+l;
	System.out,println("Addition is" +m);
	}
}
class hoc extends pillai
{
	public static void main(String ab[])
	{
		hoc h=new hoc();
	}
}