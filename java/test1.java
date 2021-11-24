class test
{
	void show()
	{
		System.out.println("1");
	}
}
class test1 extends test
{
	void show()
	{
		System.out.println("2");
	}
	public static void main(String[] args)
	{
		test t=new test();
		t.show();
		test1 t1=new test1();
		t1.show();
	}
}