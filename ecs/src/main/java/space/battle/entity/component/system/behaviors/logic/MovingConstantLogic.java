package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ConstantMovementBehavior;

import java.util.*;

/**
 * This class provides logic for managing entities that move constantly in the game.
 */
class MovingConstantLogic {
	private final List<ConstantMovementBehavior> entities = new ArrayList<>();

	/**
	 * Adds a constantly moving entity to the set of moving entities.
	 *
	 * @param entity The constantly moving entity to be added.
	 */
	void addEntity (@NotNull ConstantMovementBehavior entity) {
		entities.add(entity);
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
		}
	}
}
