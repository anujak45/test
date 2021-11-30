package Patterns;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Computer pc = Factory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = Factory.getComputer("server","16 GB","1 TB","2.9 GHz");
		System.out.println("Factory PC Config::"+pc);
		//assertEquals();
		System.out.println("Factory Server Config::"+server);
		//assertEquals();
	}

}
