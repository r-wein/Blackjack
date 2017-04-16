package players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import player.Gambler;

public class GamblerTest {
	
	Gambler gamble;
	
	@Before
	public void setUp() {
		this.gamble = new Gambler();
	}
	
	@Test
	public void canPlaceBet() {
		assertTrue("FAIL - should be able to place bet", this.gamble.placeBet(50));
	}
	
	@Test
	public void cannotPlaceBet() {
		assertFalse("FAIL - should not be able to place bet", this.gamble.placeBet(150));
	}
	
	@Test
	public void startsWithCorrectAmount() {
		assertEquals("FAIL - shold have 100", 100, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void shouldHave50More() {
		this.gamble.placeBet(50);
		this.gamble.wonBet();
		assertEquals("FAIL - shold have 150", 150, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void shouldHave50Less() {
		this.gamble.placeBet(50);
		this.gamble.lostBet();
		assertEquals("FAIL - shold have 50", 50, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void shouldKeepBet() {
		this.gamble.placeBet(50);
		this.gamble.pushedHand();
		assertEquals("FAIL - shold have 100", 100, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void canDoubleDown() {
		this.gamble.placeBet(50);
		assertTrue("FAIL - should be able to double down", this.gamble.doubleDowns());
	}
	
	@Test
	public void cannotDoubleDown() {
		this.gamble.placeBet(100);
		assertFalse("FAIL - should not be able to double down", this.gamble.doubleDowns());
	}
	
	@Test
	public void doubleDownWin() {
		this.gamble.placeBet(50);
		this.gamble.doubleDowns();
		this.gamble.wonBet();
		assertEquals("FAIL - should have 200", 200, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void doubleDownLoss() {
		this.gamble.placeBet(25);
		this.gamble.doubleDowns();
		this.gamble.lostBet();
		assertEquals("FAIL - should have 50", 50, this.gamble.getTotalMoneyAmount());
	}
	
	@Test
	public void doubleDownPush() {
		this.gamble.placeBet(25);
		this.gamble.doubleDowns();
		this.gamble.pushedHand();
		assertEquals("FAIL - should have 100", 100, this.gamble.getTotalMoneyAmount());
	}
}
