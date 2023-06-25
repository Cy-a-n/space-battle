package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.MovingWithAccelerationBehavior;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
public class MovingWithAccelerationLogic {
	private static Set<MovingWithAccelerationBehavior> movingEntities = new HashSet<>();

	/**
	 * Returns an unmodifiable set of entities moving with acceleration in the game.
	 *
	 * @return An unmodifiable set of entities moving with acceleration.
	 */
	public static Set<MovingWithAccelerationBehavior> getMovingEntities () {
		return Collections.unmodifiableSet(movingEntities);
	}

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param movingEntity The moving entity with acceleration to be added.
	 */
	static void addMovingEntity (@NotNull MovingWithAccelerationBehavior movingEntity) {
		movingEntities.add(movingEntity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	static void update (float deltaTimeInSeconds) {
		for (MovingWithAccelerationBehavior movingEntity : movingEntities) {
			// Check roughly if the entity is decelerating due to friction and close to standstill
			if (movingEntity.getFrictionConstant() != 0 && movingEntity.getAcceleration().getX() == 0 && movingEntity.getAcceleration().getY() == 0 && movingEntity.getVelocity().getX() < 1f && movingEntity.getVelocity().getX() > -1f && movingEntity.getVelocity().getY() < 1f && movingEntity.getVelocity().getY() > -1f) {
				continue;
			}
			movingEntity.getVelocity().setX(movingEntity.getVelocity().getX() + (movingEntity.getAcceleration().getX() + movingEntity.getVelocity().getX() * -movingEntity.getFrictionConstant()) * deltaTimeInSeconds);
			movingEntity.getVelocity().setY(movingEntity.getVelocity().getY() + (movingEntity.getAcceleration().getY() + movingEntity.getVelocity().getY() * -movingEntity.getFrictionConstant()) * deltaTimeInSeconds);

			movingEntity.getPosition().setX(movingEntity.getPosition().getX() + movingEntity.getVelocity().getX() * deltaTimeInSeconds);
			movingEntity.getPosition().setY(movingEntity.getPosition().getY() + movingEntity.getVelocity().getY() * deltaTimeInSeconds);
		}
	}
}
