package entity.component.system.behaviors;

import entity.component.system.components.PositionRotationComponent;
import org.jetbrains.annotations.NotNull;

public interface PositionRotationBehavior extends Behavior {
	@NotNull PositionRotationComponent getPositionRotationComponent ();
}