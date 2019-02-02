package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.LuckyDrawContest;

public class LuckyDrawContestTest {

	@Test
	public void testEmptyContest() {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(5);

		// set contest
		String stringMatch = "el";
		int numPrizes = 3;

		assertEquals(0, luckyDrawContest.getNumParticipants());

		// get winners
		String[] winners = luckyDrawContest.getWinners(stringMatch, numPrizes);
		for (String winner : winners) {
			assertNull(winner);
		}
	}

	@Test
	public void testFullContest() {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(5);

		// add 5 users
		luckyDrawContest.addUserName("sampael");
		luckyDrawContest.addUserName("ella");
		luckyDrawContest.addUserName("daniel");
		luckyDrawContest.addUserName("michael");
		luckyDrawContest.addUserName("johnny");

		assertEquals(5, luckyDrawContest.getNumParticipants());

		// add 6th user to full contest
		luckyDrawContest.addUserName("grahamel");
		assertEquals(5, luckyDrawContest.getNumParticipants());

	}

	@Test
	public void testNoWinners() {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(5);

		// add 5 users
		luckyDrawContest.addUserName("sampal");
		luckyDrawContest.addUserName("ella");
		luckyDrawContest.addUserName("daniel");
		luckyDrawContest.addUserName("michael");
		luckyDrawContest.addUserName("johnny");

		// set contest
		String stringMatch = "abcd";
		int numPrizes = 3;

		// get winners
		String[] winners = luckyDrawContest.getWinners(stringMatch, numPrizes);
		for (String winner : winners) {
			assertNull(winner);
		}
	}

	@Test
	public void testMaxWinners() {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(5);

		// add 5 users
		luckyDrawContest.addUserName("sampal");
		luckyDrawContest.addUserName("ella");
		luckyDrawContest.addUserName("daniel");
		luckyDrawContest.addUserName("michael");
		luckyDrawContest.addUserName("elavie");
		luckyDrawContest.addUserName("johnny");

		// set contest
		String stringMatch = "el";
		int numPrizes = 3;

		// get winners
		String[] winners = luckyDrawContest.getWinners(stringMatch, numPrizes);
		int countWinners = 0;
		for (String winner : winners) {
			if (winner != null) {
				countWinners++;
			}
		}
		assertEquals(numPrizes, countWinners);
	}

	@Test
	public void testContest() {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(20);
		
		//add users
		luckyDrawContest.addUserName("sampael");
		luckyDrawContest.addUserName("ella");
		luckyDrawContest.addUserName("daniel");
		luckyDrawContest.addUserName("michael");
		luckyDrawContest.addUserName("johnny");
		luckyDrawContest.addUserName("grahamel");
		
		//set contest
		String stringMatch = "el";
		int numPrizes = 6;
		
		//get winners
		String[] winners = luckyDrawContest.getWinners(stringMatch, numPrizes);
		
		int countWinners = 0;
		for (String winner : winners) {
			if (winner != null) {
				countWinners++;
			}
		}
		assertEquals(5, countWinners);
		
	}
}
