package entity.component.system.behaviors;

import entity.component.system.components.AccelerationComponent;
import org.jetbrains.annotations.NotNull;

public interface AcceleratedMovementBehavior extends ConstantMovementBehavior {
	@NotNull AccelerationComponent getAccelerationComponent ();
}
