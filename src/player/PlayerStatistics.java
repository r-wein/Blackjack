package player;

/**
 * This class is able to calculate statistics to show how well the Gambler is
 * doing. It records wins and then is able to find the percentage of wins, how
 * many loses, if they double downed, etc.
 * 
 * @author RossWeinstein
 */

public class PlayerStatistics {

	private int handsPlayed;
	private int handsWon;
	private int handsLost;
	private int handsPushed;
	private int totalDoubleDowns;
	private int wonLoss;

	/** Constructs a basic PlayerStatistics object with all values set to 0 */
	public PlayerStatistics() {
		this.handsPlayed = 0;
		this.handsWon = 0;
		this.handsLost = 0;
		this.handsPushed = 0;
		this.totalDoubleDowns = 0;
		this.wonLoss = 0;
	}

	/**
	 * Returns all relevant information from PlayerStatistics Class
	 * 
	 * @return String the Players Money Won/Loss; Win Percentage; Hands Player;
	 *         Hands Won; Hands Lost; Hands Pushed; Number Of Double Down Hands
	 */
	public String toString() {
		return "Money Won/Loss:\t" + this.wonLoss + "\nWin Percentage:\t" + this.getPercentageWon()
				+ "\nHands Played:\t" + this.handsPlayed + "\nHands Won:\t" + this.handsWon + "\nHands Lost:\t"
				+ this.handsLost + "\nHands Pushed:\t" + this.handsPushed + "\nDouble Downs:\t" + this.totalDoubleDowns;
	}

	/** Denotes that the Gambler has played a hand */
	private void playedHand() {
		this.handsPlayed++;
	}

	/**
	 * If the player won their hand, update hand total, hands won, and add bet
	 * amount to Gambler's bank roll.
	 * 
	 * @param betAmount
	 *            how much is the Player's bet
	 */
	public void wonHand(int betAmount) {
		this.playedHand();
		this.handsWon++;
		this.wonLoss += betAmount;
	}

	/**
	 * If the player lost their hand, update hand total, hands lost, and
	 * subtract bet amount to Gambler's bank roll.
	 * 
	 * @param betAmount
	 *            how much is the Player's bet
	 */
	public void lostHand(int betAmount) {
		this.playedHand();
		this.handsLost++;
		this.wonLoss -= betAmount;
	}

	/** If player pushed with the dealer, increment hands pushed */
	public void pushedHand() {
		this.playedHand();
		this.handsPushed++;
	}

	/** Denote that the player has placed a Double Down bet */
	public void playedDoubleDownHand() {
		this.totalDoubleDowns++;
	}

	/** Returns all statistics back to 0. */
	public void resetStats() {
		this.handsPlayed = 0;
		this.handsWon = 0;
		this.handsLost = 0;
		this.totalDoubleDowns = 0;
		this.wonLoss = 0;
		this.handsPushed = 0;
	}

	/**
	 * Get the total number of blackjack hands played.
	 * 
	 * @return int how many hands has the Player played
	 */
	public int getHandsPlayed() {
		return this.handsPlayed;
	}

	/**
	 * Get the total number of blackjack hands won
	 * 
	 * @return int number of hands won
	 */
	public int getHandsWon() {
		return this.handsWon;
	}

	/**
	 * Get the total number of blackjack hands lost.
	 * 
	 * @return int number of hands lost
	 */
	public int getHandsLost() {
		return this.handsLost;
	}

	/**
	 * Get the percentage of blackjack hands won
	 * 
	 * @return String the percentage of hands the Player has won. If they have
	 *         not played any hands it return 0, rather than Nan
	 */
	public String getPercentageWon() {

		// print 0 if no hands have been played, without this it prints NaN
		if (this.getHandsPlayed() != 0) {
			return String.format("%.1f", ((double) this.handsWon / (double) this.handsPlayed) * 100);
		} else {
			return "0.0";
		}
	}

	/**
	 * Get the total number of Double Down hands played.
	 * 
	 * @return int how many times the Player has double downed
	 */
	public int getTotalDoubleDowns() {
		return this.totalDoubleDowns;
	}
}
