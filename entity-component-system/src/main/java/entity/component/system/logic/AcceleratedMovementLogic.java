package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.AcceleratedMovementBehavior;
import entity.component.system.components.AccelerationComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing entities that move with acceleration in the game.
 */
class AcceleratedMovementLogic {
	private final @NotNull Set<AcceleratedMovementBehavior> entities = new HashSet<> ( );

	/**
	 * Adds a moving entity with acceleration to the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be added.
	 */
	void addEntity ( final @NotNull AcceleratedMovementBehavior entity ) {
		entities.add ( entity );
	}

	/**
	 * Removes a moving entity with acceleration from the set of moving entities.
	 *
	 * @param entity The moving entity with acceleration to be removed.
	 */
	void removeEntity ( final @NotNull AcceleratedMovementBehavior entity ) {
		entities.remove ( entity );
	}

	/**
	 * Updates the position and velocity of moving entities with acceleration based on their acceleration, friction
	 * constant and the elapsed time.
	 *
	 * @param deltaTimeInSeconds The elapsed time since the last update, in seconds.
	 */
	void update ( final float deltaTimeInSeconds ) {
		for ( final @NotNull AcceleratedMovementBehavior entity : entities ) {
			if (entity.getEntityComponent ().isQueuedForRemoval ())
				continue;

			final float translationalFriction = entity.getAccelerationComponent ( ).getTranslationalFriction ( );
			final @NotNull AccelerationComponent acceleration = entity.getAccelerationComponent ( );
			final @NotNull Vector2 translationalAcceleration = acceleration.getTranslational ( );
			final @NotNull VelocityComponent velocity = entity.getVelocityComponent ( );
			final @NotNull Vector2 translationalVelocity = velocity.getTranslational ( );

			// Calculate the new velocity based on acceleration and friction.
			translationalVelocity.x += translationalAcceleration.x * deltaTimeInSeconds - translationalVelocity.x * translationalFriction;
			translationalVelocity.y += translationalAcceleration.y * deltaTimeInSeconds - translationalVelocity.y * translationalFriction;

			velocity.setDegreesPerSecond ( velocity.getDegreesPerSecond ( ) + acceleration.getDegreesPerSecondSquared ( ) * deltaTimeInSeconds -
										   velocity.getDegreesPerSecond ( ) * acceleration.getTranslationalFriction ( ) );
		}
	}
}
