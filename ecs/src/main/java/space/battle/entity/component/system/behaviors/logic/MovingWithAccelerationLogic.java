package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.MovingWithAccelerationBehavior;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
public class MovingWithAccelerationLogic {
	private final List<MovingWithAccelerationBehavior> movingEntities = new ArrayList<>();

	/**
	 * Returns an unmodifiable set of entities moving with acceleration in the game.
	 *
	 * @return An unmodifiable set of entities moving with acceleration.
	 */
	public List<MovingWithAccelerationBehavior> getMovingEntities () {
		return Collections.unmodifiableList(movingEntities);
	}

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param movingEntity The moving entity with acceleration to be added.
	 */
	void addMovingEntity (@NotNull MovingWithAccelerationBehavior movingEntity) {
		movingEntities.add(movingEntity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (float deltaTimeInSeconds) {
		for (MovingWithAccelerationBehavior movingEntity : movingEntities) {
			float frictionConstant = movingEntity.getFrictionConstant();
			Vector2 acceleration = movingEntity.getAcceleration();
			Vector2 velocity = movingEntity.getVelocity();
			Vector2 position = movingEntity.getPosition();

			// Check roughly and without expensive calculations if the entity is decelerating due to friction and
			// close to standstill
			//			if (frictionConstant != 0 && acceleration.x == 0 && acceleration.y == 0 && velocity.x < 1f &&
			//			velocity.x > -1f && velocity.y < 1f && velocity.y > -1f) {
			//				continue;
			//			}

			// Calculate the new velocity based on acceleration and friction.
			velocity.x += acceleration.x * deltaTimeInSeconds;
			velocity.y += acceleration.y * deltaTimeInSeconds;

			position.x += velocity.x * deltaTimeInSeconds;
			position.y += velocity.y * deltaTimeInSeconds;
		}
	}
}
