 // Q. Write a Java program to demonstrate inheritance by creating suitable classes. 
import java.io.*;
class Book 
{
	DataInputStream d=new DataInputStream(System.in);
	String author;
	String publisher;
	String title;
	void accept1()
	{
		try{
		System.out.println("Enter the Author Name: ");
		author=d.readLine();
		System.out.println("Enter the Publisher of the Book ");
		publisher=d.readLine();
		System.out.println("Enter the Title of Book");
		title=d.readLine();
		}
		catch(Exception e)
		{
		}
	}
	void display1()
	{
		System.out.println("The Title is "+title+" of Author "+author+" Which Published By "+publisher+".");
		
	}
}
class ManasiA extends Book
{	
	int a,b,c;
	DataInputStream d=new DataInputStream(System.in);
	void accept2()throws IOException
	{
		System.out.println("Enter price of Book ?");
		a=Integer.parseInt(d.readLine());
		System.out.println("Enter the charges of Library ?");
		b=Integer.parseInt(d.readLine());
	}
	void display2()
	{
		System.out.println("Title is: "+title++" Price is :"+a);
		System.out.println("After returning Book u'll pay "+b+" Rupees ." );
	}
	public static void main(String args[])throws IOException
	{
		ManasiA m1[]=new ManasiA[5];
		for(int i=0;i<5;i++)
		{
			m1[i]=new ManasiA();
		}
		for(int i=0;i<5;i++)
		{
			m1[i].accept1();
			m1[i].display1();
			m1[i].accept2();
			m1[i].display2();
		}	
	}
}