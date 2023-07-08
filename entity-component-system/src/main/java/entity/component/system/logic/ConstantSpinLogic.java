package entity.component.system.logic;

import entity.component.system.behaviors.ConstantSpinBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

// TODO: Doccomments

class ConstantSpinLogic {
	private final Set<ConstantSpinBehavior> entities = new HashSet<>();

	void addEntity (ConstantSpinBehavior entity) {entities.add(entity);}

	void removeEntity (ConstantSpinBehavior entity) {entities.remove(entity);}

	void update (final float deltaTimeInSeconds) {
		for (final @NotNull ConstantSpinBehavior entity : entities) {
			entity.getRotationComponent().setDegrees(entity.getRotationComponent().getDegrees() + entity.getRotationalVelocityComponent().getDegreesPerSecond() * deltaTimeInSeconds);
			entity.getRotationComponent().setChanged(true);
		}
	}
}
