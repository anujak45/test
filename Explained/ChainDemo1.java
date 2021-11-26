import java.util.Random;
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

class Processor
{
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

public class ChainDemo1
{
	public static void main( String[] args )
	{
		Image[] inputImages = {new IR(), new IR(), new LS(), new IR(), new LS(), new LS()}; // Creating Array of Object of Interface Image of 6 Object
		Processor[] processors = {new Processor(), new Processor(), new Processor()};
		System.out.println(" Length = "+inputImages.length);
		for (int i=0, j; i < inputImages.length; i++) // To get length or Size of the Array of Objects
		{
			System.out.println("Operation #" + (i + 1) + ":");
        			j = 0;
			System.out.println("processors[j].execute(inputImages[i])"+" i is :"+i+"  j is   :"+j +" "+processors[j].execute(inputImages[i]));
			while (!processors[j].execute(inputImages[i])) // Getting True OR False
			{
				j = (j + 1) % processors.length; 
			}
			System.out.println();
		}	
	}
}