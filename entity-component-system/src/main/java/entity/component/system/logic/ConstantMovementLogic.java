package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ConstantMovementBehavior;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.entities.GreenFighter;
import entity.component.system.entities.TestSpaceShipLocalPlayer;
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
			final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent();
			final @NotNull Vector2 position = entity.getPositionRotationComponent().getPosition();
			final @NotNull Vector2 translationalVelocity = entity.getVelocityComponent().getTranslational();

			position.x += translationalVelocity.x * deltaTimeInSeconds;
			position.y += translationalVelocity.y * deltaTimeInSeconds;
			positionRotationComponent.setDegrees(positionRotationComponent.getDegrees() + entity.getVelocityComponent().getDegreesPerSecond() * deltaTimeInSeconds);
			entity.getPositionRotationComponent().setChanged(true);
		}
	}
}
