package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasAcceleration;
import space.battle.entity.component.system.components.HasFriction;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasVelocity;

public interface MovingWithAccelerationBehavior extends HasPosition, HasVelocity, HasAcceleration, HasFriction {
}
