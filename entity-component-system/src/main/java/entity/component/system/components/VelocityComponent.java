package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class VelocityComponent {
	private final @NotNull Vector2 vector2;

	public VelocityComponent (@NotNull Vector2 vector2) {
		this.vector2 = vector2;
	}

	public @NotNull Vector2 getVector2 () {
		return vector2;
	}
}
