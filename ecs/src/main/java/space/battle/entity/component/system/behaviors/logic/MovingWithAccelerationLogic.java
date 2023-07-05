package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.MovingWithAccelerationBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
class MovingWithAccelerationLogic {
	private final Set<MovingWithAccelerationBehavior> entities = new HashSet<>();

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be added.
	 */
	void addEntity (@NotNull MovingWithAccelerationBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a moving entity with acceleration from the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be removed.
	 */
	void removeEntity (@NotNull MovingWithAccelerationBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (float deltaTimeInSeconds) {
		for (MovingWithAccelerationBehavior entity : entities) {
			float frictionConstant = entity.getFrictionConstant();
			Vector2 acceleration = entity.getAcceleration();
			Vector2 velocity = entity.getVelocity();
			Vector2 position = entity.getPosition();

			// Check roughly and without expensive calculations if the entity is decelerating due to friction and
			// close to standstill
			if (frictionConstant != 0 && acceleration.x == 0 && acceleration.y == 0 && velocity.x < 1f && velocity.x > -1f && velocity.y < 1f && velocity.y > -1f) {
				continue;
			}

			// Calculate the new velocity based on acceleration and friction.
			velocity.x += acceleration.x * deltaTimeInSeconds - velocity.x * frictionConstant;
			velocity.y += acceleration.y * deltaTimeInSeconds - velocity.y * frictionConstant;

			position.x += velocity.x * deltaTimeInSeconds;
			position.y += velocity.y * deltaTimeInSeconds;

			entity.setPositionChanged(true);
		}
	}
}
