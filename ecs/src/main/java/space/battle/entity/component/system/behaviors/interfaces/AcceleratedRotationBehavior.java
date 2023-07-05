package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasRotationalAcceleration;
import space.battle.entity.component.system.components.HasRotationalFrictionConstant;

public interface AcceleratedRotationBehavior extends Entity, ConstantRotationBehavior, HasRotationalAcceleration,
		HasRotationalFrictionConstant {}
