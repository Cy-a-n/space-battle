package entity.component.system.behaviors;

import entity.component.system.components.CameraComponent;
import org.jetbrains.annotations.NotNull;

public interface CameraBehavior extends Behavior, PositionBehavior, RotationBehavior {
	@NotNull CameraComponent getCameraComponent ();
}
