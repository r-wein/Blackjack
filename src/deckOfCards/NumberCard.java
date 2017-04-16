package deckOfCards;

/**
 * NumberCard is for Cards 2-10 in a deck.
 * 
 * @author RossWeinstein
 */

public class NumberCard extends Card implements Dealable {
	
	private int value;

	/**
	 * Constructs a NumberCard with a value of 2-10. 
	 * 
	 * @param suit
	 *            The suit of the given card: Hearts, Diamonds, Spades, or Clubs
	 * @param rank
	 *            The rank of the card: 2, 3, 4, 5, 6, 7, 8, 9, or 10
	 */
	public NumberCard(CardSuit suit, CardRank rank) {
		super(suit, rank);
		this.value = rank.ordinal() + 1;
	}

	/**
	 * The current numerical value of the Number card
	 * 
	 * @return int Returns the current value of the card; may be 2-10
	 */
	@Override
	public int value() {
		return this.value;
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
	 * Only applies to Aces. Number card values never change.
	 */
	@Override
	public void flip() {}
}
