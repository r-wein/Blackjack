package deckOfCards;

/**
 * For the Aces in each deck. Aces can have a value of 11 or 1.
 * 
 * @author RossWeinstein
 */

public class Ace extends Card implements Dealable {

	private boolean isEleven;

	/**
	 * Constructs an Ace card with an initial value of 11. Suit must be from
	 * CardSuit enum
	 * 
	 * @param suit
	 *            This denotes what suit the ace will be
	 */
	public Ace(CardSuit suit) {
		super(suit, CardRank.ACE);
		this.isEleven = true;
	}

	/**
	 * The current numerical value of the Ace card
	 * 
	 * @return int Returns the current value of the card; may be 1 or 11.
	 */
	@Override
	public int value() {
		return this.isEleven ? 11 : 1;
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
	 * Changes the value of a card. This only applies to Ace cards whose value
	 * can be 1 or 11.
	 */
	@Override
	public void flip() {
		if (this.isEleven) {
			this.isEleven = false;
		} else {
			this.isEleven = true;
		}
	}
}
