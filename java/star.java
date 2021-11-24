import java.io.*;
class star
{
	void htol(int a)
	{
		System.out.println("\n High To Low :\n");
		int i,j;
		for(i=0;i<a;i++)
		{
			System.out.println("\n");
			for(j=a;j>i;j--)
			{
				
				System.out.print(" * ");	
			}
		}
		System.out.println("\n----COMPLETED----\n");	
	}
	void ltoh(int b)
	{
		System.out.println("\n Low to High :\n");
		int i,j;
		for(i=0;i<b;i++)
		{
			System.out.println("\n");
			for(j=0;j<=i;j++)
			{
				
				System.out.print(" * ");	
			}
		}	
		System.out.println("\n----COMPLETED----\n");
	}
	void numbers_1(int b)
	{
		int i,j,k;
		int a=b;
		for(i=b;i>=1;i--)
		{
			for(j=1;j<=i;j++)
			{
				System.out.print(" "+a);
				
			}
			System.out.println(" ");
			a--;
		}
	}
	void mltoh(int l)
	{
		int i,j,k;
		int x=l;
		for(i=1;i<=l;i++)
		{
			for(k=1;k<=x;k++)
			{
				System.out.print(" ");
			}
			for(j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
			x--;
		}
	}
	void rltoh(int f)
	{
		int i,j,k;
		int x=f;
		for(i=0;i<f;i++)
		{
			for(k=0;k<=x;k++)
			{
				System.out.print(" ");
			}
			for(j=0;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println("");
			x--;
		}
	}
	public static void main(String xyz[ ])throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		star s1=new star();
		int ch1,a;
		do{
		System.out.println("\n1.High to Low Star\n2.Low to High Star\n3.Stars From Middle\n4.Reverse Star Low to High\n5.Numbers High to Low\n");
		System.out.println("\n Enter Your Choise From Above Options :\n");
		int ch=Integer.parseInt(d.readLine());
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter the Range : \n");
				a=Integer.parseInt(d.readLine());
				s1.htol(a);
			case 2:
				System.out.println("\nEnter the Range : \n");
				int b=Integer.parseInt(d.readLine());
				s1.ltoh(b);
			case 3:
				System.out.println("\nEnter the Range : \n");
				int l=Integer.parseInt(d.readLine());
				s1.mltoh(l);
			case 4:
				System.out.println("\n Enter the Range : \n");
				int m=Integer.parseInt(d.readLine());
				s1.rltoh(m);
			case 5:
				System.out.println("\nEnter the Range : \n");
				int h=Integer.parseInt(d.readLine());
				s1.numbers_1(h);			
		}
		System.out.println("\nDo you Want to Continue ? Press '1' \n");
		ch1=Integer.parseInt(d.readLine());
		}while(ch1!=0);
	}
}