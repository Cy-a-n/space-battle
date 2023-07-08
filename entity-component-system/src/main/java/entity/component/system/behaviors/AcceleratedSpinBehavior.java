package entity.component.system.behaviors;

import entity.component.system.components.RotationalAccelerationComponent;
import org.jetbrains.annotations.NotNull;

public interface AcceleratedSpinBehavior extends ConstantSpinBehavior {
	@NotNull RotationalAccelerationComponent getRotationalAcceleration ();
}
