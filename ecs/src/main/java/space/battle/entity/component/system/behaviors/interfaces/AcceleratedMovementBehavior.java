package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasAcceleration;
import space.battle.entity.component.system.components.HasFrictionConstant;

public interface AcceleratedMovementBehavior extends Entity, ConstantMovementBehavior, HasAcceleration,
		HasFrictionConstant {}
