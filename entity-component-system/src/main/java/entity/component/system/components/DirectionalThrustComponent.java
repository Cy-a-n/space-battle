package entity.component.system.components;

public class DirectionalThrustComponent {
	private float forwards;
	private float backwards;
	private float left;
	private float right;
	private float clockwise;
	private float counterClockwise;

	public DirectionalThrustComponent (final float forwards, final float backwards, final float left,
									   final float right, final float clockwise, final float counterClockwise) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
		this.clockwise = clockwise;
		this.counterClockwise = counterClockwise;
	}

	public float getClockwise () {
		return clockwise;
	}

	public void setClockwise (final float clockwise) {
		this.clockwise = clockwise;
	}

	public float getCounterClockwise () {
		return counterClockwise;
	}

	public void setCounterClockwise (final float counterClockwise) {
		this.counterClockwise = counterClockwise;
	}

	public float getForwards () {
		return forwards;
	}

	public void setForwards (final float forwards) {
		this.forwards = forwards;
	}

	public float getBackwards () {
		return backwards;
	}

	public void setBackwards (final float backwards) {
		this.backwards = backwards;
	}

	public float getLeft () {
		return left;
	}

	public void setLeft (final float left) {
		this.left = left;
	}

	public float getRight () {
		return right;
	}

	public void setRight (final float right) {
		this.right = right;
	}
}
