package Patterns;

public class FlyWeigh {
	private int row;
	public FlyWeigh(int row)
	{
		this.row = row;
		System.out.println("CTOR :"  + this.row);
	}
	void report(int col)
	{
		System.out.print(  + row + col);
	}
}
class Factory
{
	private FlyWeigh[] pool;
 	public Factory(int maxRows)
	{
		pool = new FlyWeigh[maxRows];
	}
	public FlyWeigh getFlyweight(int row)
	{
		if (pool[row] == null)
		{
			pool[row] = new FlyWeigh(row);
		}
		return pool[row];
	}
}

