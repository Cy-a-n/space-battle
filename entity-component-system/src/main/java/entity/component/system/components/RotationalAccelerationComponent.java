package entity.component.system.components;

public class RotationalAccelerationComponent {
	private float friction;
	private float degreesPerSecondSquared;

	public RotationalAccelerationComponent (final float friction, final float degreesPerSecondSquared) {
		this.friction = friction;
		this.degreesPerSecondSquared = degreesPerSecondSquared;
	}

	public float getFriction () {
		return friction;
	}

	public void setFriction (final float friction) {
		this.friction = friction;
	}

	public float getDegreesPerSecondSquared () {
		return degreesPerSecondSquared;
	}

	public void setDegreesPerSecondSquared (final float degreesPerSecondSquared) {
		this.degreesPerSecondSquared = degreesPerSecondSquared;
	}
}
