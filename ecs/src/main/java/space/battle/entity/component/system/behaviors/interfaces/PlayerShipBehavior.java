package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasHealth;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRotationDegrees;
import space.battle.entity.component.system.components.HasShape;

public interface PlayerShipBehavior extends MovingWithAccelerationBehavior, TextureBehavior, CameraBehavior,
        HasShape, HasPosition, HasRotationDegrees, HasHealth {
}
