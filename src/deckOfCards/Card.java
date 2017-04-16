package deckOfCards;

import java.util.Objects;

/**
 * This abstract class contains all of the getter and setter methods for Card.
 * Each child class will either be a number, ace, or face card. This class also
 * has a method which can check if the suit of a card is valid by being either
 * Hearts, Diamonds, Spades, or Clubs.
 * 
 * @author RossWeinstein
 */
public abstract class Card {

	private CardSuit suit;
	private CardRank cardRank;
	
	/** Constructs a card without provided suit, face, and value 
	 * 
	 * @param suit the suit of the card. Must be Hearts, Diamonds, Spades, or Clubs
	 * @param face the face of the card. Must be 2-10, J, Q, K, A
	 * */
	public Card(CardSuit suit, CardRank face) {
		this.suit = suit;
		this.cardRank = face;
	}

	/**
	 * All the important information about each instance of Card
	 * 
	 * @return String the Card's face, suit, and value
	 */
	@Override
	public String toString() {
		return "Card: " + this.cardRank + " of " + this.suit;
	}
	
	@Override
	public boolean equals(Object otherObj) {
		
		// quick check if we're the same object
		if (this == otherObj) {
			return true;
		}
		
		// quick check if there's anything there
		if (otherObj == null) {
			return false;
		}
		
		// check if we are dealing with an object of the same class
		if (getClass() != otherObj.getClass()) {
			return false;
		}
		
		// cast and compare
		Card otherCard = (Card) otherObj;
		return Objects.equals(cardRank, otherCard.cardRank)
				&& Objects.equals(suit, otherCard.suit);
		
	}

	/**
	 * Returns the suit of a given Card
	 * 
	 * @return String returns "Hearts", "Diamonds", "Spades", or "Clubs"
	 */
	public String getSuit() {
		return this.suit.toString();
	}

	/**
	 * Returns the face of a given Card
	 * 
	 * @return String the card rank
	 */
	public String getCardRank() {
		return this.cardRank.rank();
	}
}
