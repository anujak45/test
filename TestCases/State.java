package Patterns;

import java.io.*;
interface State
{
	public String doAction();
}
class StartState implements State
{
	public String doAction()
	{
		String s1="Player is in Start State !";
		System.out.println(s1);
		return s1;
	}
	public String toString()
	{
		return "Start State";
	}
}
class StopState implements State
{
	public String doAction()
	{
		String s2="Player is in Stop State !";
		System.out.println(s2);
		return s2;
	}
	public String toString()
	{
		return "Stop State";
	}
}
 class ContextA
{
	private State state;
	public ContextA()
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
