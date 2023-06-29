package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRelativePosition;
import space.battle.entity.component.system.components.HasRelativeRotationDegrees;
import space.battle.entity.component.system.components.HasRotationDegrees;

public interface RelativePositionAndRotationBehavior extends HasRelativePosition, HasRelativeRotationDegrees,
		HasPosition, HasRotationDegrees {}
