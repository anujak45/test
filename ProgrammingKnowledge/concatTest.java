package ProgrammingKnowledge;

import static org.junit.Assert.*;

import org.junit.Test;

public class concatTest {

	@Test
	public void test() {
		MyJUnit junit =new MyJUnit();
		String op1=junit.concat("Anuj", "K");
		assertEquals("AnujK",op1);
	}

}
