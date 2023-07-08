package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasChildrenWithRelativePosition;
import space.battle.entity.component.system.components.HasChildrenWithRelativeRotationDegrees;

public interface ParentWithRelativePositionAndRotationDegreesBehavior extends Entity, HasChildrenWithRelativePosition
		, PositionBehavior, HasChildrenWithRelativeRotationDegrees, RotationDegreesBehavior {}
