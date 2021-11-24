class sample
{
	int a=10,b=115,c; // global Variable
	sample() // Local
	{
		int a,b,c;
		int c=a+b;
		System.out.println("A+B is "+c);
	}
	
	public static void main(String args[])
	{
		
		int c=a+b;
		System.out.println("A+B is "+c);
		sample s1=new sample();
	}
}