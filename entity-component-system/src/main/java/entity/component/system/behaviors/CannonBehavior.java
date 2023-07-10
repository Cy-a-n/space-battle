package entity.component.system.behaviors;

import entity.component.system.components.CannonComponent;
import org.jetbrains.annotations.NotNull;

public interface CannonBehavior extends PositionRotationBehavior, UserInputSpaceShipBehavior, CollisionShapeBehavior {
	@NotNull CannonComponent getCannonComponent ();
}
