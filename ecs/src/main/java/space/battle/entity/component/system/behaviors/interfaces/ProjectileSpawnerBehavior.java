package space.battle.entity.component.system.behaviors.interfaces;

import space.battle.entity.component.system.components.HasSpawnableProjectiles;
import space.battle.entity.component.system.components.HasVelocity;

public interface ProjectileSpawnerBehavior extends Entity, PositionBehavior, RotationDegreesBehavior, HasVelocity,
		HasSpawnableProjectiles {}
