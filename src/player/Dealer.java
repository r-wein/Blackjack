package player;

/**
 * The Dealer Class inherits from Player. It handles all the logic required for
 * the dealer's decision to hit or stand. The dealer will hit if their total is
 * 16 or less or on a soft 17 (an A and 6); the Dealer stands otherwise.
 * 
 * @author RossWeinstein
 */

public class Dealer extends Player {

	/** Constructs a Dealer ready to deal some blackjack */
	public Dealer() {
		super();
	}

	/**
	 * Determines if the dealer is able to hit or not
	 * 
	 * @return if the Dealer's hand is less than 17 or a soft 17, the dealer
	 *         must hit so return true; false otherwise
	 */
	public boolean dealerHits() {
		return super.getHandTotal() < 17 || (super.getHandTotal() == 17 && super.getHand().hasSoft17());
	}

	/**
	 * Returns the Dealer's blackjack hand total
	 * 
	 * @return String the Dealer's Hand total with 'Dealer Total' title
	 */
	public String showHandTotal() {
		return "Dealer Total: " + super.getHandTotal();
	}

	/**
	 * Returns each card in the Dealer's hand
	 * 
	 * @return String the Dealer's Hand in sequence with 'Dealer Hand' title
	 */
	public String showHand() {
		return "Dealer Hand: " + super.showHand();
	}

	/**
	 * Print only the Dealer's second card to screen
	 * 
	 * @return String until it is the Gambler's turn, we cannot show both of the
	 *         Dealer's card. This only returns the Dealer's second card where
	 *         the first card is only printed as 'X'
	 */
	public String openingHand() {
		return "Dealer Hand: X " + super.getHand().getCardsDealt().get(1).rank();
	}
}
