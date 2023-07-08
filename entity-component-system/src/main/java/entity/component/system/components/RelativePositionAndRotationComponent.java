package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ParentWithPositionAndRotationBehavior;
import org.jetbrains.annotations.NotNull;

public class RelativePositionAndRotationComponent {
	private final @NotNull Vector2 vector2;
	private final @NotNull ParentWithPositionAndRotationBehavior parentWithPositionAndRotationBehavior;
	private float degrees;

	public RelativePositionAndRotationComponent (@NotNull final Vector2 vector2,
												 final @NotNull ParentWithPositionAndRotationBehavior parentWithPositionAndRotationBehavior, final float degrees) {
		this.vector2 = vector2;
		this.parentWithPositionAndRotationBehavior = parentWithPositionAndRotationBehavior;
		this.degrees = degrees;
	}

	public @NotNull ParentWithPositionAndRotationBehavior getParentWithPositionAndRotationBehavior () {
		return parentWithPositionAndRotationBehavior;
	}

	public @NotNull Vector2 getVector2 () {
		return vector2;
	}

	public float getDegrees () {
		return degrees;
	}

	public void setDegrees (final float degrees) {
		this.degrees = degrees;
	}
}
