package ProgrammingKnowledge;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {
	MyJUnit junit =new MyJUnit();
	@BeforeSuite
	public void addtest1() {
		
		int op1=junit.add(100, 201);
		assertEquals(301,op1);
	}
	@BeforeTest
	public void addString()
	{
		String s1=junit.concat("Anuj", "K");
		assertEquals("AnujK",s1);
	}
	@BeforeClass
	public void subtest() {
		MyJUnit junit =new MyJUnit();
		int op2=junit.sub(200, 100);
		assertEquals(300,op2);
	}
	@AfterMethod
	public void multest() {
		MyJUnit junit =new MyJUnit();
		long op3=junit.mul(200, 100);
		assertEquals(20000,op3);
	}
	@Test
	public void modtest() {
		MyJUnit junit =new MyJUnit();
		long op4=junit.mod(200, 100);
		assertEquals(20000,op4);
	}
	@afterMethod
	public void addString1()
	{
		String s1=junit.concat1("JKL", "K");
		assertEquals("MNO",s1);
	}
	@AfterClass
	public void addString2()
	{
		String s1=junit.concat2("XYZ", "K");
		assertEquals("XYZK",s1);
	}
	@AfterSuite
	public void addString3()
	{
		String s1=junit.concat3("ABCD", "K");
		assertEquals("AnujK",s1);
	}
	@Test
	public void addString4()
	{
		String s1=junit.concat4("Binary", "Hat");
		assertEquals("BinaryHat",s1);
	}
}
