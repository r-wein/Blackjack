package deckOfCards;

public class CardFactory {

	/**
	 * Ensures the proper type of card is created based on input criteria. Will
	 * return either a Number, Face, or Ace Card.
	 * 
	 * 
	 * @param suit The suit of the card to be created: Hears,Diamonds,Spades,Clubs.
	 * @param rank The rank of the card to be created: A-K.
	 * @return Dealable A newly created Number, Face, or Ace Card.
	 */
	public static Dealable makeCard(CardSuit suit, CardRank rank) {

		if (rank == CardRank.ACE) {
			return new Ace(suit);
		} else if (rank == CardRank.JACK || rank == CardRank.QUEEN || rank == CardRank.KING) {
			return new FaceCard(suit, rank);
		} else {
			return new NumberCard(suit, rank);
		}
	}
}
