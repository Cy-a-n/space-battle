package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class AccelerationComponent {
	private final @NotNull Vector2 vector2;
	private float friction;

	public AccelerationComponent (@NotNull final Vector2 vector2, final float friction) {
		this.vector2 = vector2;
		this.friction = friction;
	}

	public @NotNull Vector2 getVector2 () {
		return vector2;
	}

	public float getFriction () {
		return friction;
	}

	public void setFriction (final float friction) {
		this.friction = friction;
	}
}
