package deckOfCards;

import java.util.*;

/**
 * Deck is where we bring the 52 cards together. Here we have the methods to
 * deal hands of Blackjack and a way of shuffling the deck when the deck gets
 * low.
 * 
 * @author RossWeinstein
 */

public class PlayableDeck {

	private List<Dealable> theDeck;
	private int cardPosition;

	/**
	 * Constructs a 52 card deck that is unshuffled. Deck will be composed of
	 * cards ordered from 2-A, Hearts to Clubs
	 * 
	 * @param numberOfDecks enum (DeckSize) for the desired number of decks for the game
	 */
	public PlayableDeck(DeckSize numberOfDecks) {
		this.theDeck = DeckFactory.buildDeck(numberOfDecks);
		this.cardPosition = 0;
	}

	/** Returns the Deck as an ArrayList
	 * 
	 * @return ArrayList the Deck itself
	 * */
	public List<Dealable> getDeck() {
		return this.theDeck;
	}

	/**
	 * Returns the current position of the card in the deck (i.e. 10 will return
	 * the 10th card in the deck)
	 * 
	 * @return int where we are currently positioned in the deck
	 */
	public int getCardPosition() {
		return this.cardPosition;
	}

	/**
	 * Returns the next Card in the Deck. Throws an exception if asked for a
	 * card outside the deck.
	 * 
	 * @return Card the next Card in the Deck
	 */
	public Dealable getNextCard() {

		if (this.cardPosition > 51) {
			throw new IndexOutOfBoundsException("Out of Cards!");
		}
		return this.theDeck.get(this.cardPosition++);

	}

	/** Rearranges the deck into a random order */
	public void shuffle() {

		// for debugging only
		// System.out.println("-----------------------SHUFFLING--------------------------------");
		this.prepDeckForShuffle();
		Collections.shuffle(this.theDeck);
	}

	/**
	 * Ensures deck is prepared to be shuffled. Card position is reset to 0 and
	 * all Ace values are converted back to 11
	 */
	private void prepDeckForShuffle() {
		// reset our counter for getNextCard
		this.cardPosition = 0;

		// turn all the aces back to 11
		this.revertAcesTo11();
	}

	/**
	 * Finds all the Aces in a deck and converts their value to 11 if their
	 * value had been previously changed to 1
	 */
	private void revertAcesTo11() {

		for (Dealable eachCard : this.theDeck) {
			
			if (eachCard.value() == 1) {
				eachCard.flip();
			}
		}
	}

	/** Prints to the console each card in its current order */
	public void showDeck() {
		for (int x = 0; x < 52; x++) {
			System.out.println(this.getNextCard());
		}
	}
}
