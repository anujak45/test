import java.io.*;
class abc123
{
	int x,y;

	//float d,f;
	public static void main(String ar[])throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		System.out.println("Enter the Number");
		int x=Integer.parseInt(d.readLine());
		System.out.println("Enter the Another number :");
		int y=Integer.parseInt(d.readLine());
		int c=(x+y);
		int  k=x-y;
		int e=x*y;
		float f=x/y;
		System.out.println("Addition is =" +c);
		System.out.println("Substraction is =" +k);
		System.out.println("Multiplication is =" +e);
		System.out.println("Devision is =" +f);
	}
}