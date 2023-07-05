package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.*;

public interface CollisionShapeBehavior extends Entity, HasShape, PositionBehavior, RotationDegreesBehavior,
		OriginBehavior, HasHealth {}
