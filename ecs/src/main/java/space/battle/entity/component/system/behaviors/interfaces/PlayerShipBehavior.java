package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasHealth;
import space.battle.entity.component.system.components.HasShape;

public interface PlayerShipBehavior extends Entity, AcceleratedMovementBehavior, AcceleratedRotationBehavior,
		TextureBehavior, CameraBehavior, CollisionShapeBehavior {}
