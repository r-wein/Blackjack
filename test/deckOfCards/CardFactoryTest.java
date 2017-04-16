package deckOfCards;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardFactoryTest {
	
	@Test
	public void makesNumberCard() {
		assertTrue("FAIL - did not make correct Dealable type: NumberCard", CardFactory.makeCard(CardSuit.HEARTS, CardRank.FIVE) instanceof NumberCard);
	}
	
	@Test
	public void makesFaceCard() {
		assertTrue("FAIL - did not make correct Dealable type: FaceCard", CardFactory.makeCard(CardSuit.HEARTS, CardRank.JACK) instanceof FaceCard);
	}
	
	@Test
	public void makesAceCard() {
		assertTrue("FAIL - did not make correct Dealable type: Ace", CardFactory.makeCard(CardSuit.HEARTS, CardRank.ACE) instanceof Ace);
	}
}
