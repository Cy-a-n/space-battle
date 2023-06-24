package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsMovingConstant;
import space.battle.entity.component.system.behaviors.interfaces.IsMovingWithAcceleration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
public class MovingWithAccelerationLogic {
	private static Set<IsMovingWithAcceleration> movingEntities = new HashSet<>();

	/**
	 * Returns an unmodifiable set of entities moving with acceleration in the game.
	 *
	 * @return An unmodifiable set of entities moving with acceleration.
	 */
	public static Set<IsMovingWithAcceleration> getMovingEntities () {
		return Collections.unmodifiableSet(movingEntities);
	}

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param movingEntity The moving entity with acceleration to be added.
	 */
	static void addMovingEntity (@NotNull IsMovingWithAcceleration movingEntity) {
		movingEntities.add(movingEntity);
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration and the
	 * elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	static void update (float deltaTimeInSeconds) {
		for (IsMovingWithAcceleration movingEntity : movingEntities) {
			movingEntity.getVelocity().setX(movingEntity.getVelocity().getX() + movingEntity.getAcceleration().getX() * deltaTimeInSeconds);
			movingEntity.getVelocity().setY(movingEntity.getVelocity().getY() + movingEntity.getAcceleration().getY() * deltaTimeInSeconds);

			movingEntity.getPosition().setX(movingEntity.getPosition().getX() + movingEntity.getVelocity().getX() * deltaTimeInSeconds);
			movingEntity.getPosition().setY(movingEntity.getPosition().getY() + movingEntity.getVelocity().getY() * deltaTimeInSeconds);
		}
	}
}
