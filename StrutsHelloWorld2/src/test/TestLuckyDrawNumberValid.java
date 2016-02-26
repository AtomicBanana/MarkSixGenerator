package test;

import static org.junit.Assert.*;

import org.junit.Test;
import example.LuckyDrawAction;

public class TestLuckyDrawNumberValid {

	@Test
	public void testIsNumbersValid1() {
		LuckyDrawAction luckyDrawAction = new LuckyDrawAction();
		assertEquals(true, luckyDrawAction.isNumbersValid("1,2,3,4,5,6"));
	}
	
	@Test
	public void testIsNumbersValid2() {
		LuckyDrawAction luckyDrawAction = new LuckyDrawAction();
		assertEquals(false, luckyDrawAction.isNumbersValid("1,2,3,4,2,6"));
	}
	
	@Test
	public void testIsNumbersValid3() {
		LuckyDrawAction luckyDrawAction = new LuckyDrawAction();
		assertEquals(false, luckyDrawAction.isNumbersValid("1,2"));
	}
	
	@Test
	public void testIsNumbersValid4() {
		LuckyDrawAction luckyDrawAction = new LuckyDrawAction();
		assertEquals(false, luckyDrawAction.isNumbersValid("1,2,wegwe,23,4,7"));
	}

}
