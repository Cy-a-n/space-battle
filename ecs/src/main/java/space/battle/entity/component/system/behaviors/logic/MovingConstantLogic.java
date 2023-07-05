package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ConstantMovementBehavior;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move constantly in the game.
 */
class MovingConstantLogic {
	private final Set<ConstantMovementBehavior> entities = new HashSet<>();

	/**
	 * Adds a constantly moving entity to the set of moving entities.
	 *
	 * @param entity The constantly moving entity to be added.
	 */
	void addEntity (@NotNull ConstantMovementBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a constantly moving entity from the set of moving entities.
	 *
	 * @param entity The constantly moving entity to be removed.
	 */
	void removeEntity (@NotNull ConstantMovementBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position of constantly moving entities based on their velocity and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (float deltaTimeInSeconds) {
		for (ConstantMovementBehavior entity : entities) {
			entity.getPosition().x += entity.getVelocity().x * deltaTimeInSeconds;
			entity.getPosition().y += entity.getVelocity().y * deltaTimeInSeconds;
			entity.setPositionChanged(true);
		}
	}
}
