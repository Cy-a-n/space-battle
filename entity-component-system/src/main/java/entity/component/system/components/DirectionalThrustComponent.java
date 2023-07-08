package entity.component.system.components;

public class DirectionalThrustComponent {
	private float forwards;
	private float backwards;
	private float left;
	private float right;

	public DirectionalThrustComponent (final float forwards, final float backwards, final float left,
									   final float right) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
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
