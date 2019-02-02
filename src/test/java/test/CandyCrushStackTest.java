package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.CandyCrushStack;
import main.CandyCrushStack.Power;


public class CandyCrushStackTest {

	@Test
	public void testEmptyPowerBar() {
		
		CandyCrushStack ccs = new CandyCrushStack();

		assertNull(ccs.getCurrentPower());

		//checking empty power bar on failure
		ccs.levelFailed();
		assertNull(ccs.getCurrentPower());
		
	}

	@Test
	public void testFullContest() {
		CandyCrushStack ccs = new CandyCrushStack();
		
		ccs.levelPassed();
		ccs.levelPassed();
		ccs.levelPassed();
		assertEquals(Power.DOUGHNUT, ccs.getCurrentPower());
		
		//checking max power up
		ccs.levelPassed();
		assertEquals(Power.DOUGHNUT, ccs.getCurrentPower());
	}
	
	
	@Test
	public void testContest() {
		
		//checking normal use case
		CandyCrushStack ccs = new CandyCrushStack();
		ccs.levelPassed();
		assertEquals(Power.STRIPED_CANDY, ccs.getCurrentPower());
		ccs.levelPassed();
		assertEquals(Power.WRAPPED_CANDY, ccs.getCurrentPower());
		ccs.levelPassed();
		assertEquals(Power.DOUGHNUT, ccs.getCurrentPower());
	}
}
