package entity.component.system.logic;

import entity.component.system.components.RotationalAccelerationComponent;
import entity.component.system.components.RotationalVelocityComponent;
import org.jetbrains.annotations.NotNull;
import entity.component.system.behaviors.AcceleratedSpinBehavior;

import java.util.HashSet;
import java.util.Set;

class AcceleratedSpinLogic {
	private final @NotNull Set<AcceleratedSpinBehavior> entities = new HashSet<>();

	void addEntity (final @NotNull AcceleratedSpinBehavior entity) {
		entities.add(entity);
	}

	void removeEntity (final @NotNull AcceleratedSpinBehavior entity) {
		entities.remove(entity);
	}

	void update (final float deltaTimeInSeconds) {
		for (final @NotNull AcceleratedSpinBehavior entity : entities) {
			final @NotNull RotationalVelocityComponent velocity = entity.getRotationalVelocityComponent();
			final @NotNull RotationalAccelerationComponent acceleration = entity.getRotationalAcceleration();

			velocity.setDegreesPerSecond(velocity.getDegreesPerSecond() + acceleration.getDegreesPerSecondSquared() * deltaTimeInSeconds - velocity.getDegreesPerSecond() * acceleration.getFriction());
		}
	}
}
