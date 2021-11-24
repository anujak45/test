class Bank
{
	int i=20;
	void Transaction()
	{
		int i=10;
		System.out.println("i value in Local Variable is " +i);
	}
	public Static void main(String args[]){
	
	Bank b1=new Bank();
	b1.Transaction();
	System.out.println("i value in Global Variable is " +i);
}
}