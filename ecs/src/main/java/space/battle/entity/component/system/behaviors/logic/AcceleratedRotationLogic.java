package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.AcceleratedMovementBehavior;
import space.battle.entity.component.system.behaviors.interfaces.AcceleratedRotationBehavior;

import java.util.HashSet;
import java.util.Set;

class AcceleratedRotationLogic {
	private final Set<AcceleratedRotationBehavior> entities = new HashSet<>();

	void addEntity (AcceleratedRotationBehavior entity) {
		entities.add(entity);
	}

	void removeEntity (AcceleratedRotationBehavior entity) {
		entities.remove(entity);
	}

	void update (float deltaTimeInSeconds) {
		for (AcceleratedRotationBehavior entity : entities)
			entity.setRotationalVelocity(entity.getRotationalVelocity() + entity.getRotationalAcceleration() * deltaTimeInSeconds - entity.getRotationalFrictionConstant() * entity.getRotationalVelocity());
	}
}
