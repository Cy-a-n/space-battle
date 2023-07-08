package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.*;

public interface CollisionShapeBehavior extends Entity, HasCollisionShape, PositionBehavior, RotationDegreesBehavior,
		OriginBehavior, HasHealth {}
