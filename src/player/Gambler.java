package player;

/**
 * The Gambler Class inherits from Player. It adds the functionality of betting
 * and allowing the user to decide whether to hit or stand.
 * 
 * @author RossWeinstein
 */

public class Gambler extends Player {

	private int totalMoney;
	private int betAmount;
	private PlayerStatistics stats;
	private boolean hasDoubleDowned;

	/** Constructs a basic Gambler with $100 dollars available for betting */
	public Gambler() {
		super();
		this.totalMoney = 100;
		this.betAmount = 0;
		this.stats = new PlayerStatistics();
		this.hasDoubleDowned = false;
	}

	/*
	 * -------------------------------------------------------------------------
	 * --------------------------GENREAL GAMBLER MEHTODS------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Returns the Gambler's hand total
	 * 
	 * @return String the Gambler's Hand total with 'Gambler Total' title
	 */
	public String showHandTotal() {
		return "Player Total: " + super.getHandTotal();
	}

	/**
	 * Returns each card the Gambler's has in their hand
	 * 
	 * @return String the Gambler's Hand in sequence with 'Gambler Hand' title
	 */
	public String showHand() {
		return "Player Hand: " + super.showHand();
	}

	/**
	 * All of the Gambler's information
	 * 
	 * @return String the class, how much money they have, and their current bet
	 */
	public String toString() {
		return this.getClass() + "\nBank Roll: " + this.totalMoney + "\nCurrent Bet: " + this.betAmount;
	}

	/**
	 * Removes all cards from the Player's hand, resets PlayerBust and
	 * hasDoubleDowned to false
	 */
	public void clearHand() {
		super.theirHand = new Hand();
		super.playerBust = false;
		this.hasDoubleDowned = false;
	}

	/**
	 * Returns how much money the Gambler currently has
	 * 
	 * @return int the Gambler's current money total
	 */
	public int getTotalMoneyAmount() {
		return this.totalMoney;
	}

	/**
	 * Returns the Gambler's current bet amount
	 * 
	 * @return int how much has the Gambler bet
	 */
	public int getBetAmount() {
		return this.betAmount;
	}

	/** Clears the Gambler's bet amount. */
	public void clearBet() {
		this.betAmount = 0;
	}

	/**
	 * Returns all the Gambler's statistics as a String
	 * 
	 * @return String all of the Gambler's stats
	 */
	public String getStats() {
		return this.stats.toString();
	}

	/**
	 * Returns whether the Gambler has any money left
	 * 
	 * @return boolean true if the Gambler has at least $1
	 */
	public boolean hasMoney() {
		return this.totalMoney > 0;
	}

	/*
	 * -------------------------------------------------------------------------
	 * --------------------------GAMBLER BETTING MEHTODS------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Returns true if Gambler has enough money to place bet
	 * 
	 * @param betAmount
	 *            how much does the Gambler wish to bet
	 * @return boolean returns true if the Gambler is able to make their desired
	 *         bet; false otherwise
	 */
	private boolean canPlaceBet(int betAmount) {
		return betAmount <= this.totalMoney && betAmount > 0;
	}

	/**
	 * If the Gambler is able to place a bet, the bet amount is updated and the
	 * method returns true; false otherwise.
	 * 
	 * @param betAmount
	 *            how much does the Gambler wish to bet
	 * @return boolean if the Gambler can make their desired bet, update the bet
	 *         amount and return true; do not update the bet and return false
	 *         otherwise
	 * 
	 */
	public boolean placeBet(int betAmount) {

		if (this.canPlaceBet(betAmount)) {

			this.betAmount = betAmount;
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Returns whether the Gambler has double downed or not
	 * 
	 * @return boolean true if Gambler has double downed; false otherwise
	 */
	public boolean hasDoubleDowned() {
		return this.hasDoubleDowned;
	}

	/**
	 * Returns true if the gambler has sufficient funds to place a double down
	 * bet. If they do not, the bet is not updated and the method returns false
	 * 
	 * @return boolean if the Gambler has double downed, double the bet amount
	 *         and return true; do not update the bet and return false otherwise
	 */
	public boolean doubleDowns() {

		if (this.totalMoney - this.betAmount >= betAmount) {

			this.betAmount *= 2;
			this.hasDoubleDowned = true;
			return true;

		} else {
			return false;
		}
	}

	/*
	 * -------------------------------------------------------------------------
	 * --------------------------GAMBLER STATS MEHTODS--------------------------
	 * -------------------------------------------------------------------------
	 */

	/**
	 * Returns the PlayerStatistics object from the Gambler, allows to add a
	 * stat to the Gambler
	 * 
	 * @return PlayerStatistics all the stats of the Gambler
	 */
	public PlayerStatistics addStat() {
		return this.stats;
	}

	/** Sets the Gambler's money to 100 and clears all stats */
	public void resetGambler() {
		this.totalMoney = 100;
		this.stats.resetStats();
	}

	/** Gambler won: their total money is updated and bet is cleared */
	public void wonBet() {
		this.totalMoney += this.betAmount;
		this.stats.wonHand(this.betAmount);
		this.clearBet();
	}

	/** Gambler lost: their total money is updated and bet is cleared */
	public void lostBet() {
		this.totalMoney -= this.betAmount;
		this.stats.lostHand(this.betAmount);
		this.clearBet();
	}

	/**
	 * Gambler pushed: no change to their total money and their bet is cleared
	 */
	public void pushedHand() {
		this.stats.pushedHand();
		this.clearBet();
	}

	/** Updates the player's stats that the Gambler has double downed */
	public void playedDoubleDownHand() {
		this.stats.playedDoubleDownHand();
	}
}
