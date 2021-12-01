package Patterns;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.Test;

public class FlyWeightTest {

	private static final int COLS = 6;
	private static final int ROWS = 10;

	@Test
	public void test() {
		Factory theFactory = new Factory(ROWS);
		for (int i=0; i <ROWS; i++)
		{
			for (int j=0; j <COLS; j++)
			theFactory.getFlyweight(i).report(j);
			System.out.println();
		}
	}
	@Test
	public void chain()
	{
		Image[] inputImages = {new IR(), new IR(), new LS(), new IR(), new LS(), new LS()}; // Creating Array of Object of Interface Image of 6 Object
		ChainDemo[] processors = {new ChainDemo(), new ChainDemo(), new ChainDemo()};
		System.out.println(" Length = "+inputImages.length);
		for (int i=0, j; i < inputImages.length; i++) // To get length or Size of the Array of Objects
		{
			System.out.println("Operation #" + (i + 1) + ":");
        			j = 0;
			System.out.println("processors[j].execute(inputImages[i])"+" i is :"+i+"  j is   :"+j +" "+processors[j].execute(inputImages[i]));
			while (!processors[j].execute(inputImages[i])) // Getting True OR False
			{
				
					System.out.println(" Before j= "+j);
					j = (j + 1) % processors.length; 
					System.out.println(" After j= "+j);
			}
			System.out.println();
		}	
	}
	@Test
	public void factory1()throws IOException
	{
		Factory12 f1=new Factory12();
		Laptop l1=f1.order(3);
		String s4=l1.laptop_Spec();
		assertNotEquals("Passed","Most Ordered Laptop -> Dell",s4);
	}
	@Test
	public void Strategy()
	{
		Context context=new Context(new AddOperation());
		int z=context.executeStrategy(5,6);
		assertNotEquals(13,z);
		Context context1=new Context(new MulOperation());
		int z1=context1.executeStrategy(2,2);
		assertEquals(4,z1);
		Context context2=new Context(new SubOperation());
		int z2=context1.executeStrategy(z,z1);
		assertEquals(7,z2);
	}
	@Test
	public void state()
	{
		ContextA contextz=new ContextA();
		StartState sta1=new StartState();
		StopState sto1=new StopState();
		contextz.getState(sta1);
		contextz.getState(sto1);
	}

}
