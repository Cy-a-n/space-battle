package entity.component.system.components;

import com.badlogic.gdx.Input;

public enum UserInputSpaceShipComponent {
	PLAYER_ONE (Input.Keys.W,
				Input.Keys.S,
				Input.Keys.D,
				Input.Keys.A,
				Input.Keys.E,
				Input.Keys.Q,
				Input.Keys.SHIFT_LEFT),
	PLAYER_TWO (Input.Keys.I,
				Input.Keys.K,
				Input.Keys.L,
				Input.Keys.J,
				Input.Keys.O,
				Input.Keys.U,
				Input.Keys.SPACE);
	private int forwards;
	private int backwards;
	private int left;
	private int right;
	private int spinCounterClockwise;
	private int spinClockwise;
	private int primaryCannons;

	UserInputSpaceShipComponent (final int forwards,
								 final int backwards,
								 final int right,
								 final int left,
								 final int spinClockwise,
								 final int spinCounterClockwise,
								 final int primaryCannons) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
		this.spinCounterClockwise = spinCounterClockwise;
		this.spinClockwise = spinClockwise;
		this.primaryCannons = primaryCannons;
	}

	public int getPrimaryCannons () {
		return primaryCannons;
	}

	public void setPrimaryCannons (final int primaryCannons) {
		this.primaryCannons = primaryCannons;
	}

	public int getForwards () {
		return forwards;
	}

	public void setForwards (final int forwards) {
		this.forwards = forwards;
	}

	public int getBackwards () {
		return backwards;
	}

	public void setBackwards (final int backwards) {
		this.backwards = backwards;
	}

	public int getLeft () {
		return left;
	}

	public void setLeft (final int left) {
		this.left = left;
	}

	public int getRight () {
		return right;
	}

	public void setRight (final int right) {
		this.right = right;
	}

	public int getSpinCounterClockwise () {
		return spinCounterClockwise;
	}

	public void setSpinCounterClockwise (final int spinCounterClockwise) {
		this.spinCounterClockwise = spinCounterClockwise;
	}

	public int getSpinClockwise () {
		return spinClockwise;
	}

	public void setSpinClockwise (final int spinClockwise) {
		this.spinClockwise = spinClockwise;
	}
}
