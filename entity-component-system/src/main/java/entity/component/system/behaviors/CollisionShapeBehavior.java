package entity.component.system.behaviors;

import entity.component.system.components.CollisionShapeComponent;
import org.jetbrains.annotations.NotNull;

public interface CollisionShapeBehavior extends PositionRotationBehavior {
	@NotNull CollisionShapeComponent getCollisionShapeComponent ();
}
