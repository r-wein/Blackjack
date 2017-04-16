package deckOfCards;

/**
 * FaceCard is for Jacks, Queens, and Kings of a deck.
 * 
 * @author RossWeinstein
 */

public class FaceCard extends Card implements Dealable {

	/**
	 * Constructs a FaceCard with a value of 10.
	 * 
	 * @param suit The suit of the given card: Hearts, Diamonds, Spades, or Clubs
	 * @param rank The face of the give card: J, Q, or K
	 */
	public FaceCard(CardSuit suit, CardRank rank) {
		super(suit, rank);
	}

	/**
	 * The current numerical value of the Number card
	 * 
	 * @return int Returns the current value of the card; will only be 10.
	 */
	@Override
	public int value() {
		return 10;
	}

	/**
	 * The card's rank
	 * 
	 * @return String Returns the card's rank
	 */
	@Override
	public String rank() {
		return super.getCardRank();
	}

	/**
	 * The card's suit
	 * 
	 * @return String Returns the card's suit
	 */
	@Override
	public String suit() {
		return super.getSuit();
	}

	/**
	 * Only applies to Aces. Face card values never change.
	 */
	@Override
	public void flip() {
		// nothing, this only applies to aces
	}
}
