package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class AccelerationComponent {
	private final @NotNull Vector2 translational;
	private float degreesPerSecondSquared;
	private float translationalFriction;
	private float rotationalFriction;

	public AccelerationComponent (@NotNull final Vector2 translational, final float degreesPerSecondSquared,
								  final float translationalFriction, final float rotationalFriction) {
		this.translational = translational;
		this.degreesPerSecondSquared = degreesPerSecondSquared;
		this.translationalFriction = translationalFriction;
		this.rotationalFriction = rotationalFriction;
	}

	public float getRotationalFriction () {
		return rotationalFriction;
	}

	public void setRotationalFriction (final float rotationalFriction) {
		this.rotationalFriction = rotationalFriction;
	}

	public float getDegreesPerSecondSquared () {
		return degreesPerSecondSquared;
	}

	public void setDegreesPerSecondSquared (final float degreesPerSecondSquared) {
		this.degreesPerSecondSquared = degreesPerSecondSquared;
	}

	public @NotNull Vector2 getTranslational () {
		return translational;
	}

	public float getTranslationalFriction () {
		return translationalFriction;
	}

	public void setTranslationalFriction (final float translationalFriction) {
		this.translationalFriction = translationalFriction;
	}
}
