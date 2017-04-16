package players;

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
import player.Dealer;

public class DealerTest {
	
	Dealable aceOfSpades;
	Dealable tenOfHearts;
	Dealable fiveOfClubs;
	Dealable sevenOfHearts;
	Dealable queenOfSpades;
	Dealable sixOfDiamonds;
	Dealer dealer;
	
	@Before
	public void setUp() {
		this.dealer = new Dealer();
		this.aceOfSpades = new Ace(CardSuit.SPADES);
		this.tenOfHearts = new NumberCard(CardSuit.HEARTS, CardRank.TEN);
		this.fiveOfClubs = new NumberCard(CardSuit.CLUBS, CardRank.FIVE);
		this.sevenOfHearts = new NumberCard(CardSuit.HEARTS, CardRank.SEVEN);
		this.queenOfSpades = new FaceCard(CardSuit.SPADES, CardRank.QUEEN);
		this.sixOfDiamonds = new NumberCard(CardSuit.DIAMONDS, CardRank.SIX);
	}
	
	@Test
	public void canHitLessThan17() {
		this.dealer.hit(fiveOfClubs);
		this.dealer.hit(queenOfSpades);
		assertTrue("FAIL - should have hit", this.dealer.dealerHits());
	}
	
	@Test
	public void canHitSoft17() {
		this.dealer.hit(sixOfDiamonds);
		this.dealer.hit(aceOfSpades);
		assertTrue("FAIL - should have hit", this.dealer.dealerHits());
	}
	
	@Test
	public void mustHit17() {
		this.dealer.hit(sixOfDiamonds);
		this.dealer.hit(queenOfSpades);
		assertTrue("FAIL - should have hit", this.dealer.dealerHits());
	}
	
	@Test
	public void standOver17() {
		this.dealer.hit(sevenOfHearts);
		this.dealer.hit(aceOfSpades);
		assertFalse("FAIL - should not have hit", this.dealer.dealerHits());
	}
	
	@Test
	public void hasPlayerBust() {
		this.dealer.hit(fiveOfClubs);
		this.dealer.hit(queenOfSpades);
		this.dealer.hit(sevenOfHearts);
		this.dealer.hasBust();
		assertTrue("FAIL - should have bust", this.dealer.hasPlayerBust());
	}
	
	@Test
	public void hasPlayerNotBust() {
		this.dealer.hit(fiveOfClubs);
		this.dealer.hit(queenOfSpades);
		assertFalse("FAIL - should not have bust", this.dealer.hasPlayerBust());
	}
}
