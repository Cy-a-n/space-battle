package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasVelocity;

public interface ConstantMovementBehavior extends Entity, PositionBehavior, HasVelocity {}
