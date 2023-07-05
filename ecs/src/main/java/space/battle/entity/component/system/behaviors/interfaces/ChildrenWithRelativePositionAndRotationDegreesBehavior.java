package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasChildrenWithRelativePosition;
import space.battle.entity.component.system.components.HasChildrenWithRelativeRotationDegrees;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRotationDegrees;

public interface ChildrenWithRelativePositionAndRotationDegreesBehavior extends Entity,
		HasChildrenWithRelativePosition, PositionBehavior, HasChildrenWithRelativeRotationDegrees,
		RotationDegreesBehavior {}
