package entity.component.system.behaviors;

import entity.component.system.components.RotationalVelocityComponent;
import org.jetbrains.annotations.NotNull;

public interface ConstantSpinBehavior extends RotationBehavior {
	@NotNull RotationalVelocityComponent getRotationalVelocityComponent ();
}
