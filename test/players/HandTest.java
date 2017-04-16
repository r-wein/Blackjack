package players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import deckOfCards.Ace;
import deckOfCards.CardRank;
import deckOfCards.CardSuit;
import deckOfCards.Dealable;
import deckOfCards.FaceCard;
import deckOfCards.NumberCard;
import player.Hand;

public class HandTest {
	
	Dealable aceOfSpades;
	Dealable tenOfHearts;
	Dealable fiveOfClubs;
	Dealable sevenOfHearts;
	Dealable queenOfSpades;
	Dealable sixOfDiamonds;
	Hand playerHand;
	
	@Before
	public void setUp() {
		this.playerHand = new Hand();
		this.aceOfSpades = new Ace(CardSuit.SPADES);
		this.tenOfHearts = new NumberCard(CardSuit.HEARTS, CardRank.TEN);
		this.fiveOfClubs = new NumberCard(CardSuit.CLUBS, CardRank.FIVE);
		this.sevenOfHearts = new NumberCard(CardSuit.HEARTS, CardRank.SEVEN);
		this.queenOfSpades = new FaceCard(CardSuit.SPADES, CardRank.QUEEN);
		this.sixOfDiamonds = new NumberCard(CardSuit.DIAMONDS, CardRank.SIX);
	}
	
	@Test
	public void playerCanDoubleDown() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(sixOfDiamonds);
		assertTrue("FAIL - player should be able to double down", this.playerHand.canDoubleDown());
	}
	
	@Test
	public void playerCannotDoubleDown() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(queenOfSpades);
		assertFalse("FAIL - player should not be able to double down", this.playerHand.canDoubleDown());
	}
	
	@Test
	public void playerHasCorrectTotal() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(sixOfDiamonds);
		assertEquals("FAIL - player hand total should be 11", 11, this.playerHand.getHandTotal());
	}
	
	@Test
	public void hadIsOver21() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(queenOfSpades);
		this.playerHand.cardDealt(tenOfHearts);
		assertTrue("FAIL - is less than or equal to 21", this.playerHand.isHandOver21());
	}
	
	@Test
	public void HadIsLessThanOrEqualTo21() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(queenOfSpades);
		assertFalse("FAIL - is greater than 21", this.playerHand.isHandOver21());
	}
	
	@Test
	public void flippedAces() {
		this.playerHand.cardDealt(fiveOfClubs);
		this.playerHand.cardDealt(queenOfSpades);
		this.playerHand.cardDealt(aceOfSpades);
		this.playerHand.FindAndFlipAces();
		assertEquals("FAIL - total should be 16", 16, this.playerHand.getHandTotal());
	}
	
	@Test
	public void playerHasSoft17() {
		this.playerHand.cardDealt(aceOfSpades);
		this.playerHand.cardDealt(sixOfDiamonds);
		assertTrue("FAIL - player should have soft 17", this.playerHand.hasSoft17());
	}
	
	@Test
	public void playerShouldNotHaveSoft17() {
		this.playerHand.cardDealt(aceOfSpades);
		this.playerHand.cardDealt(sixOfDiamonds);
		this.playerHand.cardDealt(tenOfHearts);
		this.playerHand.FindAndFlipAces();
		assertFalse("FAIL - player should not have soft 17", this.playerHand.hasSoft17());
	}
	
	@Test
	public void playerShouldAlsoNotHaveSoft17() {
		this.playerHand.cardDealt(sevenOfHearts);
		this.playerHand.cardDealt(tenOfHearts);
		this.playerHand.FindAndFlipAces();
		assertFalse("FAIL - player should not have soft 17", this.playerHand.hasSoft17());
	}
}
