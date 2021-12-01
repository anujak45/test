package Patterns;

import java.util.Random;

public class ChainDemo {
	private static final Random RANDOM = new Random(); // Random Class is used to  Generate Pseudo-random Numbers
	private static int nextID = 1;
	private int id = nextID++;
	public boolean execute(Image img)
	{
		if (RANDOM.nextInt(2) != 0) // It Generates New Random Integer Number
		{
			System.out.println("   Processor " + id + " is busy");
			return false;
		}
		System.out.println("Processor " + id + " - " + img.process());
		return true;
	}

}
interface Image // Interface Declaration
{
	String process(); //Methom Declaration Data Tupe is String
}
class IR implements Image 
{
	public String process() // Method Definition
	{
		return "IR"; // Data Type is String , Returning String Value
	}
}
class LS implements Image
{
	public String process()
	{
		return "LS";
	}
}
/*class Processor
{
	
}*/

