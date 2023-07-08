package entity.component.system.behaviors;

import entity.component.system.components.RelativePositionAndRotationComponent;
import org.jetbrains.annotations.NotNull;

public interface RelativePositionAndRotationBehavior extends PositionBehavior, RotationBehavior, FactionBehavior {
	@NotNull RelativePositionAndRotationComponent getRelativePositionAndRotationComponent ();
}
