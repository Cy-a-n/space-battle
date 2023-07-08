package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class PositionComponent {
	private final @NotNull Vector2 vector2;
	private boolean changed;

	public PositionComponent (@NotNull final Vector2 vector2) {
		this.vector2 = vector2;
		this.changed = true;
	}

	public @NotNull Vector2 getVector2 () {
		return vector2;
	}

	public boolean isChanged () {
		return changed;
	}

	public void setChanged (final boolean changed) {
		this.changed = changed;
	}
}
