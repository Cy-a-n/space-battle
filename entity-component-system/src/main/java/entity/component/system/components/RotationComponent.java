package entity.component.system.components;

public class RotationComponent {
	private float degrees;
	private boolean changed;

	public RotationComponent (final float degrees) {
		this.degrees = degrees;
		this.changed = true;
	}

	public float getDegrees () {
		return degrees;
	}

	public void setDegrees (final float degrees) {
		this.degrees = degrees;
	}

	public boolean isChanged () {
		return changed;
	}

	public void setChanged (final boolean changed) {
		this.changed = changed;
	}
}
