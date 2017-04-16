package players;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import player.PlayerStatistics;

public class PlayerStatisticsTest {
	
	PlayerStatistics stats;
	
	@Before
	public void setUp() {
		this.stats = new PlayerStatistics();
	}
	
	@Test
	public void hasNotPlayedHands() {
		assertEquals("FAIL - have not played any hands", 0, this.stats.getHandsPlayed());
	}
	
	@Test
	public void hasPlayedHands() {
		this.stats.wonHand(50);
		assertEquals("FAIL - has played 1 hand", 1, this.stats.getHandsPlayed());
	}
	
	@Test
	public void hasWonHands() {
		this.stats.wonHand(50);
		this.stats.wonHand(50);
		this.stats.wonHand(50);
		assertEquals("FAIL - has won 3 hands", 3, this.stats.getHandsWon());
	}
	
	@Test
	public void hasLostHands() {
		this.stats.lostHand(5);
		this.stats.lostHand(5);
		assertEquals("FAIL - has lost 3 hands", 2, this.stats.getHandsLost());
	}
	
	@Test
	public void hasPushedHands() {
		this.stats.pushedHand();
		assertEquals("FAIL - has pushed 1 hand", 1, this.stats.getHandsPlayed());
	}
	
	@Test
	public void hasDoubleDowned() {
		this.stats.playedDoubleDownHand();
		assertEquals("FAIL - has played 1 double down hand", 1, this.stats.getTotalDoubleDowns());
	}
	
	@Test
	public void winPercentage() {
		this.stats.wonHand(50);
		this.stats.lostHand(50);
		assertEquals("FAIL - has played won 50%", "50.0", this.stats.getPercentageWon());
	}
	
	@Test
	public void hasResetStats() {
		this.stats.wonHand(50);
		this.stats.lostHand(50);
		this.stats.resetStats();
		assertEquals("FAIL - everything should be 0", 0, this.stats.getHandsPlayed());
	}
}
