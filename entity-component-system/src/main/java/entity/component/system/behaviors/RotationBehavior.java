package entity.component.system.behaviors;

import entity.component.system.components.RotationComponent;
import org.jetbrains.annotations.NotNull;

public interface RotationBehavior extends Behavior {
	@NotNull RotationComponent getRotationComponent ();
}
