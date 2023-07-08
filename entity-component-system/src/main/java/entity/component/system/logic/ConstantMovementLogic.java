package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ConstantMovementBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move constantly in the game.
 */
class ConstantMovementLogic {
	private final @NotNull Set<ConstantMovementBehavior> entities = new HashSet<>();

	/**
	 * Adds a constantly moving entity to the set of moving entities.
	 *
	 * @param entity The constantly moving entity to be added.
	 */
	void addEntity (final @NotNull ConstantMovementBehavior entity) {
		entities.add(entity);
	}

	/**
	 * Removes a constantly moving entity from the set of moving entities.
	 *
	 * @param entity The constantly moving entity to be removed.
	 */
	void removeEntity (final @NotNull ConstantMovementBehavior entity) {
		entities.remove(entity);
	}

	/**
	 * Updates the position of constantly moving entities based on their velocity and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update (final float deltaTimeInSeconds) {
		for (final @NotNull ConstantMovementBehavior entity : entities) {
			final Vector2 position = entity.getPositionComponent().getVector2();
			final Vector2 velocity = entity.getVelocityComponent().getVector2();

			position.x += velocity.x * deltaTimeInSeconds;
			position.y += velocity.y * deltaTimeInSeconds;
			entity.getPositionComponent().setChanged(true);
		}
	}
}
