package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class VelocityComponent {
	private final @NotNull Vector2 translational;
	private float degreesPerSecond;

	public VelocityComponent (@NotNull Vector2 translational, final float degreesPerSecond) {
		this.translational = translational;
		this.degreesPerSecond = degreesPerSecond;
	}

	public float getDegreesPerSecond () {
		return degreesPerSecond;
	}

	public void setDegreesPerSecond (final float degreesPerSecond) {
		this.degreesPerSecond = degreesPerSecond;
	}

	public @NotNull Vector2 getTranslational () {
		return translational;
	}
}
