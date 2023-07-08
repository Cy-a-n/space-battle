package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.AcceleratedMovementBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
class AcceleratedMovementLogic {
	private final @NotNull Set<AcceleratedMovementBehavior> entities = new HashSet<>();

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be added.
	 */
	void addEntity (final @NotNull AcceleratedMovementBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a moving entity with acceleration from the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be removed.
	 */
	void removeEntity (final @NotNull AcceleratedMovementBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (final float deltaTimeInSeconds) {
		for (final @NotNull AcceleratedMovementBehavior entity : entities) {
			final float friction = entity.getAccelerationComponent().getFriction();

			Vector2 acceleration = entity.getAccelerationComponent().getVector2();
			Vector2 velocity = entity.getVelocityComponent().getVector2();

			// Calculate the new velocity based on acceleration and friction.
			velocity.x += acceleration.x * deltaTimeInSeconds - velocity.x * friction;
			velocity.y += acceleration.y * deltaTimeInSeconds - velocity.y * friction;
		}
	}
}
