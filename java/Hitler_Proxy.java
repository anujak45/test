interface Germany
{
	 void meeting();
}
class Hitler implements Germany
{
	Hitler() //constructor
	{
		important_person();
	}
	public void meeting()
	{
		System.out.println("HITLER IS PRESENT !");
	}
	public void important_person()
	{
		System.out.println(" \"HITLER IS IMPORTANT FOR GERMANY ! \" ");
	}
}
class Hitler_Proxy implements Germany
{
	private static Germany g1;
	public void meeting()
	{
		if(g1==null)
		{
			g1=new Hitler();
			System.out.println("We are in IFFFF");
		}
		g1.meeting();
	}
	public static void main(String[] g)
	{
		Germany g3=new Hitler_Proxy();
		g3.meeting();
		g3.meeting();
		g3.meeting();
		Germany g2=new Hitler_Proxy();
		System.out.println(" \"HITLER IS IMPORTANT FOR G@ ! \" ");
		g2.meeting();
		g2.meeting();
		g2.meeting();
	}
}