package space.battle.entity.component.system.behaviors.logic;

import space.battle.entity.component.system.behaviors.interfaces.ConstantMovementBehavior;
import space.battle.entity.component.system.behaviors.interfaces.ConstantRotationBehavior;

import java.util.HashSet;
import java.util.Set;

// TODO: Doccomments

class ConstantRotationLogic {
	private final Set<ConstantRotationBehavior> entities = new HashSet<>();

	void addEntity (ConstantRotationBehavior entity) {entities.add(entity);}

	void removeEntity (ConstantRotationBehavior entity) {entities.remove(entity);}

	void update (float deltaTimeInSeconds) {
		for (ConstantRotationBehavior entity : entities) {
			entity.setRotationDegrees(entity.getRotationDegrees() + entity.getRotationalVelocity() * deltaTimeInSeconds);
			entity.setRotationChanged(true);
		}
	}
}
