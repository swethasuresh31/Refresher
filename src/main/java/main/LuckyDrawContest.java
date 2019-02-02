package main;

public class LuckyDrawContest {
	private String[] participantUserNames;
	private int numParticipants;
	
	public int getNumParticipants() {
		return numParticipants;
	}

	public LuckyDrawContest(int maxParticipants) {
		this.participantUserNames = new String[maxParticipants];
		numParticipants = 0;
	}
	
	public void addUserName(String participantUserName) {
		if(numParticipants == participantUserNames.length) {
			System.out.println("Sorry " + participantUserName + ". Contest is full");
			return;
		}
		this.participantUserNames[numParticipants++] = participantUserName;
	}
	public String[] getWinners(String stringToMatch, int maxWinners) {
		String[] winners = new String[maxWinners];
		int index = 0;
		for(String userName : participantUserNames) {
			if(index == maxWinners) break;
			
			if(userName != null && userName.contains(stringToMatch)) {
				winners[index++] = userName;
			}
		}
		return winners;
		
	}
	
	public void printWinners(String[] winners) {
		System.out.println("The winners are: ");
		int count = 0;
		for(String winner : winners) {
			if(winner != null) {
				System.out.println(winner);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("<none>");
		} else {
		System.out.println("Congratulations to the winners!!");
		}
	}
	
	public static void main(String[] args) {
		LuckyDrawContest luckyDrawContest = new LuckyDrawContest(5);
		
		//add users
		luckyDrawContest.addUserName("sampael");
		luckyDrawContest.addUserName("ella");
		luckyDrawContest.addUserName("daniel");
		luckyDrawContest.addUserName("michael");
		luckyDrawContest.addUserName("johnny");
		luckyDrawContest.addUserName("grahamel");
		
		//set contest
		String stringMatch = "el";
		int numPrizes = 3;
		
		//get winners
		String[] winners = luckyDrawContest.getWinners(stringMatch, numPrizes);
		
		System.out.println("The total number of particpants in the contest are: "+luckyDrawContest.getNumParticipants());
		
		luckyDrawContest.printWinners(winners);
	}

}
