package entity.component.system.components;

import com.badlogic.gdx.Input;
import org.jetbrains.annotations.NotNull;

public enum UserInputSpaceShipComponent {
	PLAYER_ONE(Input.Keys.W, Input.Keys.S, Input.Keys.A, Input.Keys.D, Input.Keys.Q, Input.Keys.E),
	PLAYER_TWO(Input.Keys.I, Input.Keys.K, Input.Keys.J, Input.Keys.L, Input.Keys.U, Input.Keys.O);
	private final @NotNull int forwards;
	private final @NotNull int backwards;
	private final @NotNull int left;
	private final @NotNull int right;
	private final @NotNull int spinCounterClockwise;
	private final @NotNull int spinClockwise;

	UserInputSpaceShipComponent (@NotNull final int forwards, @NotNull final int backwards, @NotNull final int left,
								 @NotNull final int right, @NotNull final int spinCounterClockwise,
								 @NotNull final int spinClockwise) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
		this.spinCounterClockwise = spinCounterClockwise;
		this.spinClockwise = spinClockwise;
	}

	public int getForwards () {
		return forwards;
	}

	public int getBackwards () {
		return backwards;
	}

	public int getLeft () {
		return left;
	}

	public int getRight () {
		return right;
	}

	public int getSpinCounterClockwise () {
		return spinCounterClockwise;
	}

	public int getSpinClockwise () {
		return spinClockwise;
	}
}
