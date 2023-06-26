package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ConstantMovementBehavior;

import java.util.*;

/**
 * This class provides logic for managing entities that move constantly in the game.
 */
public class MovingConstantLogic {
	private final List<ConstantMovementBehavior> movingEntities = new ArrayList<>();

	/**
	 * Returns an unmodifiable set of constantly moving entities in the game.
	 *
	 * @return An unmodifiable set of constantly moving entities.
	 */
	public List<ConstantMovementBehavior> getMovingEntities () {
		return Collections.unmodifiableList(movingEntities);
	}

	/**
	 * Adds a constantly moving entity to the set of moving entities.
	 *
	 * @param movingEntity The constantly moving entity to be added.
	 */
	void addMovingEntity (@NotNull ConstantMovementBehavior movingEntity) {
		movingEntities.add(movingEntity);
	}

	/**
	 * Updates the position of constantly moving entities based on their velocity and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (float deltaTimeInSeconds) {
		for (ConstantMovementBehavior movingEntity : movingEntities) {
			movingEntity.getPosition().x =
					movingEntity.getPosition().x + movingEntity.getVelocity().x * deltaTimeInSeconds;
			movingEntity.getPosition().y =
					movingEntity.getPosition().y + movingEntity.getVelocity().y * deltaTimeInSeconds;
		}
	}
}
