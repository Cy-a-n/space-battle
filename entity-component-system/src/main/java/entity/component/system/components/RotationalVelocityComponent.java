package entity.component.system.components;

public class RotationalVelocityComponent {
	private float degreesPerSecond;

	public RotationalVelocityComponent (final float degreesPerSecond) {
		this.degreesPerSecond = degreesPerSecond;
	}

	public float getDegreesPerSecond () {
		return degreesPerSecond;
	}

	public void setDegreesPerSecond (final float degreesPerSecond) {
		this.degreesPerSecond = degreesPerSecond;
	}
}
