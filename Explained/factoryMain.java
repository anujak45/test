import java.io.*;
interface Laptop
{
	void laptop_Spec();
}
class factoryMain
{
	public static void main(String[] z1)throws IOException
	{
		Factory f1=new Factory();
		Laptop l1=f1.order();
		l1.laptop_Spec();
	}
}
class Macbook implements Laptop
{
	public void laptop_Spec()
	{
		System.out.println(" Most Secure Laptop -> MaC ");
	}
}
class Dell implements Laptop
{
	public void laptop_Spec()
	{
		System.out.println(" Most Oredered Laptop -> DeLL");
	}
}
class HP implements Laptop
{
	public void laptop_Spec()
	{
		System.out.println(" Normal Use Laptop -> HP ");
	}
}
class Factory
{
	public Laptop order()throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		int a;
		System.out.println(" \n Select Specification \n");
		System.out.println("\n 1. Secured \n 2. Useful \n 3. Normal");
		a=Integer.parseInt(d.readLine());
		if(a==1){
			return new Macbook();
		}else if(a==2){
			return new Dell();
		}else return new HP();
	}
}