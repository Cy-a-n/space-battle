package entity.component.system.behaviors;

import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

public interface ConstantMovementBehavior extends PositionRotationBehavior {
	@NotNull VelocityComponent getVelocityComponent ( );
}
