import java.io.*;
class DemoA
{
	void gcd(int par1,int par2)
	{
		par1=(par1>0)?par1:-par1;
		par2=(par2>0)?par2:-par2;
		while(par1!=par2)
		{
			if(par1>par2)
			{
				par1-=par2;
			}
			else
			{
				par2-=par1;
			}
		}
		System.out.println("gcd is " +par1);
	}
	public static void main(String ab[])throws IOException
	{
		DataInputStream d=new DataInputStream(System.in);
		DemoA d1=new DemoA();
		System.out.println("Enter two Integer :");
		int x=Integer.parseInt(d.readLine());
		int y=Integer.parseInt(d.readLine());
		//System.out.println("Enter two Integer :");
		d1.gcd(x,y);
	}
}