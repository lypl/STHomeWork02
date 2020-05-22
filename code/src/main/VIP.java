package main;

public class VIP {
	private int score;
	
	VIP() {
		this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int sc) {
		score += sc;
	}
}
