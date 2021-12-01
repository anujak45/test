package Patterns;

import java.io.*;
interface Strategy
{
	public int doOperation(int num1,int num2);
}
class AddOperation implements Strategy
{
	public int doOperation(int num1,int num2)
	{
		return num1+num2;
	}
}
class SubOperation implements Strategy
{
	public int doOperation(int num1,int num2)
	{
		return num1-num2;
	}
}
class MulOperation implements Strategy
{
	public int doOperation(int num1,int num2)
	{
		return num1*num2;
	}
}
class Context
{
	Strategy strategy;
	public Context(Strategy strategy)
	{
		this.strategy=strategy;
	}
	public int executeStrategy(int num1,int num2)
	{
		return strategy.doOperation(num1,num2);
	}
}
