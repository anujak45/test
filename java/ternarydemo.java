class ternarydemo
{
	public static void main(String pqr[])
	{
		int a,b,c,max;
		a=34;
		b=56;
		c=65;
		int d=a>b?a:b; // Dynamic initilisation
		
			System.out.println("max of "+a+"and"+b+" is "+d);
			max=(a>b?(a>b? a:c):(b>c?b:c)); //Nested ? Operator
			System.out.println("max of "+a+","+b+","+c+" is "+max);
			
	}
}