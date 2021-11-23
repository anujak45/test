import calcy.*;
import java.io.*;
public class User
{
	
	public static void main(String[] z1)throws IOException
	{
		DataInputStream d= new DataInputStream(System.in);
		int x,y;
		do
		{
			System.out.println("Select Method from Below :");
			System.out.println("\n 1. Addition \n 2. Substraction \n 3. Multiplication \n 4. Division \n");
			x=Integer.parseInt(d.readLine());
			switch(x)
			{
				case 1:
					System.out.println(" This is Addition Method : ");
					Add a1=new Add();
					a1.plus();
					break;
				case 2:
					System.out.println(" This is Substraction Method : ");
					Sub s1=new Sub();
					s1.minus();
					break;
				case 3:
					System.out.println(" This is Multiplication Method : ");
					Mul m1=new Mul();
					m1.into();
					break;
				case 4:
					System.out.println(" This is Division Method : ");
					Div d1=new Div();
					d1.by();
					break;
			}
			System.out.println("\n  ********** For Repeat Press '1' *********** \n" );
			y=Integer.parseInt(d.readLine());
		}while(y==1);
	}		
}