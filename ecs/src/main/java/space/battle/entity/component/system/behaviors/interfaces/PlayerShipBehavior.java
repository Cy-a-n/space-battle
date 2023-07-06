package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasChildrenWithRelativePosition;
import space.battle.entity.component.system.components.HasThrustVectoring;

public interface PlayerShipBehavior extends Entity, AcceleratedMovementBehavior, AcceleratedRotationBehavior,
		TextureBehavior, CameraBehavior, CollisionShapeBehavior, HasThrustVectoring {}
