package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.*;

public interface RelativePositionAndRotationBehavior extends Entity, HasRelativePosition, PositionBehavior,
		HasRelativeRotation, RotationDegreesBehavior {}
