package org.game.bowling;

public class Frame {

	private final static int MAX_PINS = 10;

	private boolean strike = false;
	private boolean spare = false;

	private int first_try = 0, second_try = 0;
	private int bonus = 0;
	private int extra_try = 0;

	public Frame(int first_try, int second_try) {
		this(first_try, second_try, 0);
	}

	public Frame(int first_try, int second_try, int extra_try) {
		this.setFirst_try(first_try);
		this.setSecond_try(second_try);
		this.setExtra_try(extra_try);
		setSpare();
		setStrike();
	}

	public int getBonus() {
		return bonus;
	}



	public void addBonus(int bonus) {
		this.bonus += bonus;
	}

	public int getScore() {
		return first_try + second_try;
	}

	public boolean IsStrike() {
		return strike;
	}

	public void setStrike() {
		if (first_try == MAX_PINS) {
			strike = true;
			spare = false;
		}
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare() {
		if ((first_try + second_try) == MAX_PINS)
			spare = true;
	}

	public int getFirst_try() {
		return first_try;
	}

	public void setFirst_try(int first_try) {
		this.first_try = first_try;
	}

	public int getSecond_try() {
		return second_try;
	}

	public void setSecond_try(int second_try) {
		this.second_try = second_try;
	}

	public int getExtra_try() {
		return extra_try;
	}

	public void setExtra_try(int extra_try) {
		this.extra_try = extra_try;
	}

}
