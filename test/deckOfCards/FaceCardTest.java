package deckOfCards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FaceCardTest {
	FaceCard aKing;
	
	@Before
	public void setUp() {
		this.aKing = new FaceCard(CardSuit.CLUBS, CardRank.KING);
	}
	
	@Test
	public void startsAt11() {
		assertEquals("FAIL - card value not 10", 10, this.aKing.value());
	}
	
	@Test
	public void correctRank() {
		assertEquals("FAIL - wrong rank", "K", this.aKing.rank());
	}
	
	@Test
	public void correctSuit() {
		assertEquals("FAIL - wrong suit", CardSuit.CLUBS.toString(), this.aKing.suit());
	}
	
	@Test
	public void didNotflip() {
		this.aKing.flip();
		assertEquals("FAIL - should not have flipped", 10, this.aKing.value());
	}
}
