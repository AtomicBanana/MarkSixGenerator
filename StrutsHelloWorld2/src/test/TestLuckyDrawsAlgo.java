package test;

import static org.junit.Assert.*;

import org.junit.Test;

import example.LuckyDrawAction;

public class TestLuckyDrawsAlgo {

	@Test
	public void testMissingDoor1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,2,3,4,5,6};
		assertEquals(true, action.isMissingOneDoor(draws));
	}
	
	@Test
	public void testMissingDoor2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,12,23,34,45,16};
		assertEquals(false, action.isMissingOneDoor(draws));
	}
	
	@Test
	public void testMissingDoor3() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,12,13,34,35,46};
		assertEquals(true, action.isMissingOneDoor(draws));
	}
	
	@Test
	public void testisMoreThan2Odd1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,2,3,4,5,6};
		assertEquals(true, action.isMoreThan1Odd(draws));
	}
	
	@Test
	public void testisMoreThan2Odd2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,3,5,7,9,11};
		assertEquals(false, action.isMoreThan1Odd(draws));
	}
	
	@Test
	public void testisMoreThan2Odd3() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,3,6,8,10,12};
		assertEquals(true, action.isMoreThan1Odd(draws));
	}
	
	@Test
	public void testisMoreThan3ConsequencNo1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,2,3,4,6,7};
		assertEquals(true, action.isMoreThan3ConsequencNo(draws));
	}
	
	@Test
	public void testisMoreThan3ConsequencNo2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {7,2,8,4,10,9};
		assertEquals(true, action.isMoreThan3ConsequencNo(draws));
	}
	
	@Test
	public void testisMoreThan3ConsequencNo3() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {17,8,28,44,10,9};
		assertEquals(false, action.isMoreThan3ConsequencNo(draws));
	}
	
	@Test
	public void testisMoreThan3ConsequencNo4() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,3,8,9,10,11};
		assertEquals(true, action.isMoreThan3ConsequencNo(draws));
	}
	
	@Test
	public void testisSumBetween140And2101() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,3,8,9,10,11};
		assertEquals(false, action.isSumBetween140And210(draws));
	}
	
	@Test
	public void testisSumBetween140And2102() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {30,31,20,10,40,11};
		assertEquals(true, action.isSumBetween140And210(draws));
	}
	
	@Test
	public void testcheckIfAppearedPreviously1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {30,31,20,10,40,11};
		assertEquals(false, action.isAppearedPreviously("WebContent\\WEB-INF\\history.txt", draws));
	}
	
	@Test
	public void testcheckIfAppearedPreviously2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {12,23,31,37,40,45};
		assertEquals(true, action.isAppearedPreviously("WebContent\\WEB-INF\\history.txt", draws));
	}
	
	@Test
	public void testunluckyNoExist1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {6,16,25,37,46,49};
		assertEquals(true, action.unluckyNoExist("WebContent\\WEB-INF\\unluckyNo.txt", draws));
	}
	
	@Test
	public void testunluckyNoExist2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {6,15,22,27,46,47};
		assertEquals(true, action.unluckyNoExist("WebContent\\WEB-INF\\unluckyNo.txt", draws));
	}
	
	@Test
	public void testunluckyNoExist3() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {1,36,15,22,33,44};
		assertEquals(false, action.unluckyNoExist("WebContent\\WEB-INF\\unluckyNo.txt", draws));
	}
	
	@Test
	public void testunluckyNoExist4() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] draws = {5,31,33,38,47,49};
		assertEquals(true, action.unluckyNoExist("WebContent\\WEB-INF\\unluckyNo.txt", draws));
	}
	
	@Test
	public void testcountHits1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] drawsResult = {5,31,33,38,47,49};
		int[] sysdraws = {5,31,33,38,47,49};
		assertEquals(6, action.countHits(drawsResult, sysdraws));
	}
	
	@Test
	public void testcountHits2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] drawsResult = {5,31,33,38,47,49};
		int[] sysdraws = {7,40,28,12,6,49};
		assertEquals(1, action.countHits(drawsResult, sysdraws));
	}
	
	@Test
	public void testavgHitRate1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,1,1,1,1,1,1};
		assertEquals(1.0, action.avgHitRate(hits), 0.1);
	}
	
	@Test
	public void testavgHitRate2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,0,2,1,2,1,0};
		assertEquals(1.0, action.avgHitRate(hits), 0.1);
	}
	
	@Test
	public void testmaxHit1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,0,2,1,2,1,0};
		assertEquals(2, action.maxHit(hits));
	}
	
	@Test
	public void testmaxHit2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,0,2,1,2,1,4};
		assertEquals(4, action.maxHit(hits));
	}
	
	@Test
	public void testcountMax1() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,0,2,1,2,1,4};
		int max = 4;
		assertEquals(1, action.countMax(max, hits));
	}
	
	@Test
	public void testcountMax2() {
		LuckyDrawAction action = new LuckyDrawAction();
		int[] hits = {1,0,2,1,2,1,1};
		int max = 2;
		assertEquals(2, action.countMax(max, hits));
	}
	
	/*@Test
	public void testsetDrawsTable1(){
		LuckyDrawAction action = new LuckyDrawAction();
		assertEquals(2, action.setDrawsTable("WebContent\\WEB-INF\\unluckyNo.txt", hits));
		
	}*/
	
}
