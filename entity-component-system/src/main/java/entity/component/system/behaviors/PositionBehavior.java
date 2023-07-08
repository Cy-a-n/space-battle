package entity.component.system.behaviors;

import entity.component.system.components.PositionComponent;
import org.jetbrains.annotations.NotNull;

public interface PositionBehavior extends Behavior {
	@NotNull PositionComponent getPositionComponent ();
}
