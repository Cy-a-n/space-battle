package entity.component.system.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.CameraBehavior;
import entity.component.system.behaviors.ParentWithPositionRotationBehavior;
import entity.component.system.behaviors.PositionRotationBehavior;
import entity.component.system.behaviors.RelativePositionRotationBehavior;
import entity.component.system.components.CameraComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.RelativePositionRotationComponent;
import org.jetbrains.annotations.NotNull;

public class Observer extends Entity implements CameraBehavior, RelativePositionRotationBehavior {
	private final  @NotNull CameraComponent cameraComponent;
	private final  @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull RelativePositionRotationComponent relativePositionRotationComponent;

	public Observer ( @NotNull final Viewport viewport, @NotNull final ParentWithPositionRotationBehavior parent,
					  PositionRotationBehavior... entitiesAlwaysInFrame ) {
		this.cameraComponent = new CameraComponent ( viewport, 1028,  entitiesAlwaysInFrame);
		this.positionRotationComponent = new PositionRotationComponent ( Vector2.Zero.cpy (), 0);
		relativePositionRotationComponent = new RelativePositionRotationComponent ( Vector2.Zero,   parent, 0);
	}

	@Override public @NotNull CameraComponent getCameraComponent ( ) {
		return cameraComponent;
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}

	 public @NotNull RelativePositionRotationComponent getRelativePositionAndRotationComponent ( ) {
		return relativePositionRotationComponent;
	}
}
