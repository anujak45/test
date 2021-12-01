package Patterns;
import java.io.*;
interface Laptop
{
	String laptop_Spec();
}
class Factory12 {
	public Laptop order(int a1)throws IOException
	{
	/*DataInputStream d=new DataInputStream(System.in);
	int a1;
	System.out.println(" \n Select Specification \n");
	System.out.println("\n 1. Secured \n 2. Useful \n 3. Normal");
	a1=Integer.parseInt(d.readLine());*/
	if(a1==1){
		return new Macbook();
	}else if(a1==2){
		return new Dell();
	}else return new HP();
	}
}
class Macbook implements Laptop
{
	public String laptop_Spec()
	{
		String s1="Most Secure Laptop -> MaC";
		//System.out.println(" Most Secure Laptop -> MaC ");
		return s1;
	}
}
class Dell implements Laptop
{
	public String laptop_Spec()
	{
		//System.out.println(" Most Oredered Laptop -> DeLL");
		String s2="Most Ordered Laptop -> Dell";
		//System.out.println(" Most Secure Laptop -> MaC ");
		return s2;
	}
}
class HP implements Laptop
{
	public String laptop_Spec()
	{
		//System.out.println(" Normal Use Laptop -> HP ");
		String s3="Most Normal Laptop -> HP";
		//System.out.println(" Most Secure Laptop -> MaC ");
		return s3;
	}
}

