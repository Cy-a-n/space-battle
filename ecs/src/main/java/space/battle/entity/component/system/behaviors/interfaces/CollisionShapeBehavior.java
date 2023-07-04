package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasOrigin;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRotationDegrees;
import space.battle.entity.component.system.components.HasShape;

public interface CollisionShapeBehavior extends HasShape, PositionBehavior, RotationDegreesBehavior, OriginBehavior {}
