package entity.component.system.behaviors;

import entity.component.system.components.RelativePositionRotationComponent;
import org.jetbrains.annotations.NotNull;

public interface RelativePositionRotationBehavior extends PositionRotationBehavior {
	@NotNull RelativePositionRotationComponent getRelativePositionAndRotationComponent ();
}
