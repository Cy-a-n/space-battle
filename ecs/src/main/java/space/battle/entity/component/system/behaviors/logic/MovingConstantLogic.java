package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ConstantMovementBehavior;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move constantly in the game.
 */
public class MovingConstantLogic {
	private static Set<ConstantMovementBehavior> movingEntities = new HashSet<>();

	/**
	 * Returns an unmodifiable set of constantly moving entities in the game.
	 *
	 * @return An unmodifiable set of constantly moving entities.
	 */
	public static Set<ConstantMovementBehavior> getMovingEntities () {
		return Collections.unmodifiableSet(movingEntities);
	}

	/**
	 * Adds a constantly moving entity to the set of moving entities.
	 *
	 * @param movingEntity The constantly moving entity to be added.
	 */
	static void addMovingEntity (@NotNull ConstantMovementBehavior movingEntity) {
		movingEntities.add(movingEntity);
	}

	/**
	 * Updates the position of constantly moving entities based on their velocity and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	static void update (float deltaTimeInSeconds) {
		for (ConstantMovementBehavior movingEntity : movingEntities) {
			movingEntity.getPosition().setX(movingEntity.getPosition().getX() + movingEntity.getVelocity().getX() * deltaTimeInSeconds);
			movingEntity.getPosition().setY(movingEntity.getPosition().getY() + movingEntity.getVelocity().getY() * deltaTimeInSeconds);
		}
	}
}
