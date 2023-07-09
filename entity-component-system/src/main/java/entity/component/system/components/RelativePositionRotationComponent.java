package entity.component.system.components;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ParentWithPositionRotationBehavior;
import org.jetbrains.annotations.NotNull;

public class RelativePositionRotationComponent {
	private final @NotNull Vector2 position;
	private final ParentWithPositionRotationBehavior parentWithPositionRotationBehavior;
	private float degrees;

	public RelativePositionRotationComponent (@NotNull final Vector2 position,
											  final ParentWithPositionRotationBehavior parentWithPositionRotationBehavior, final float degrees) {
		this.position = position;
		this.parentWithPositionRotationBehavior = parentWithPositionRotationBehavior;
		this.degrees = degrees;
	}

	public ParentWithPositionRotationBehavior getParentWithPositionRotationBehavior () {
		return parentWithPositionRotationBehavior;
	}

	public @NotNull Vector2 getPosition () {
		return position;
	}

	public float getDegrees () {
		return degrees;
	}

	public void setDegrees (final float degrees) {
		this.degrees = degrees;
	}
}
