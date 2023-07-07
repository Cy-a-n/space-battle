package space.battle.entity.component.system.components;

import space.battle.entity.component.system.behaviors.interfaces.ProjectileBehavior;

public interface HasSpawnableProjectiles {
	Class<? extends ProjectileBehavior> getProjectileClass ();

	float getProjectilesPerMinute ();

	float getTimeOfLastProjectile ();
}
