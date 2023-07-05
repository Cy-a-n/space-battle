package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.AcceleratedMovementBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
class AcceleratedMovementLogic {
	private final Set<AcceleratedMovementBehavior> entities = new HashSet<>();

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be added.
	 */
	void addEntity (@NotNull AcceleratedMovementBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a moving entity with acceleration from the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be removed.
	 */
	void removeEntity (@NotNull AcceleratedMovementBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (float deltaTimeInSeconds) {
		for (space.battle.entity.component.system.behaviors.interfaces.AcceleratedMovementBehavior entity : entities) {
			float frictionConstant = entity.getFrictionConstant();
			Vector2 acceleration = entity.getAcceleration();
			Vector2 velocity = entity.getVelocity();

			// Calculate the new velocity based on acceleration and friction.
			velocity.x += acceleration.x * deltaTimeInSeconds - velocity.x * frictionConstant;
			velocity.y += acceleration.y * deltaTimeInSeconds - velocity.y * frictionConstant;
		}
	}
}
