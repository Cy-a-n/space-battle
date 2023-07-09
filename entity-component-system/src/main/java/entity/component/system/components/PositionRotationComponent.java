package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class PositionRotationComponent {
	private final @NotNull Vector2 position;
	private float degrees;
	private boolean changed;

	public PositionRotationComponent (@NotNull final Vector2 position, float degrees) {
		this.position = position;
		this.degrees = degrees;
		this.changed = true;
	}

	public float getDegrees () {
		return degrees;
	}

	public void setDegrees (final float degrees) {
		this.degrees = degrees;
	}

	public @NotNull Vector2 getPosition () {
		return position;
	}

	public boolean isChanged () {
		return changed;
	}

	public void setChanged (final boolean changed) {
		this.changed = changed;
	}
}
