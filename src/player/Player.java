package player;

import deckOfCards.Dealable;

/**
 * This Player Abstract Class holds most of the functionality for both the
 * Gambler and Dealer. It contains the getters and setters, handles their Hand,
 * and determines with whether the play has bust or not.
 * 
 * @author RossWeinstein
 */

public abstract class Player {

	protected Hand theirHand;
	protected boolean playerBust;

	/** Constructs a basic player with a blank hand who has not busted */
	public Player() {
		this.theirHand = new Hand();
		this.playerBust = false;
	}

	/** Returns whether the Player's Hand is greater than 21 
	 * 
	 * @return boolean returns true if player has bust; false otherwise
	 * */
	public boolean hasPlayerBust() {
		return this.playerBust;
	}

	/** Sets the player's bust status to true */
	public void hasBust() {
		this.playerBust = true;
	}

	/** Allows a player to receive a new card from the deck 
	 * 
	 * @param nextCard takes an available card from the deck
	 * */
	public void hit(Dealable nextCard) {
		this.theirHand.cardDealt(nextCard);
	}

	/** Returns the Hand object 
	 * 
	 * @return Hand returns the Hand object from Player
	 * */
	public Hand getHand() {
		return this.theirHand;
	}

	/** Returns the current Player's Blackjack Hand Total 
	 * 
	 * @return int returns the Player's current Hand total
	 * */
	public int getHandTotal() {
		return this.theirHand.getHandTotal();
	}

	/** Returns each Card in the Hand 
	 * 
	 * @return String returns each Card in the Hand in sequence
	 * */
	public String showHand() {

		String result = "";

		for (Dealable eachCard : this.theirHand.getCardsDealt()) {
			result += eachCard.rank() + " ";
		}

		return result;
	}

	/**
	 * Returns Player's Blackjack Hand Total as String. Abstract method allows
	 * child classes to add appropriate title
	 * 
	 * @return String returns all the Player's Cards in sequence and their Hand total
	 */
	public abstract String showHandTotal();

	/** Removes all cards from the Player's hand */
	public void clearHand() {
		this.theirHand = new Hand();
		this.playerBust = false;
	}

	/**
	 * Prints to the console the Player's hand total and each card in their
	 * hand. If the player has busted, it appends the word 'BUST!!!' to their
	 * hand readout.
	 */
	public void printHandInfo() {

		if (!this.playerBust) {
			System.out.println(this.showHand());
		} else {
			System.out.println(this.showHand() + "BUST!!!");
		}

		System.out.println(this.showHandTotal());
		System.out.println();

	}
}
