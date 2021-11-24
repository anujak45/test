import java.io.*;
interface State
{
	public void doAction();
}
class StartState implements State
{
	public void doAction()
	{
		System.out.println("Player is in Start State !");
	}
	public String toString()
	{
		return "Start State";
	}
}
class StopState implements State
{
	public void doAction()
	{
		System.out.println("Player is in Stop State !");
	}
	public String toString()
	{
		return "Stop State";
	}
}
 class Context
{
	private State state;
	public Context()
	{
		state=null;
	}
	public void getState(State state)
	{
		this.state=state;
		this.state.doAction();
	}
	public State getState()
	{
		return state;
	}
}
public class StatePattern
{
	public static void main(String[] z1)
	{
		Context context=new Context();
		StartState sta1=new StartState();
		StopState sto1=new StopState();
		context.getState(sta1);
		context.getState(sto1);
	}
}