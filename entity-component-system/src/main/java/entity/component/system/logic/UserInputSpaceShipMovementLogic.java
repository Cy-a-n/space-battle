package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.SpaceShipLocalPlayerBehavior;
import entity.component.system.components.AccelerationComponent;
import entity.component.system.components.DirectionalThrustComponent;
import entity.component.system.components.UserInputSpaceShipComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.Gdx.input;

public class UserInputSpaceShipMovementLogic {
	private final @NotNull Set<SpaceShipLocalPlayerBehavior> entities = new HashSet<> ();

	void addEntity (final @NotNull SpaceShipLocalPlayerBehavior entity) {
		entities.add (entity);
	}

	void removeEntity (final @NotNull SpaceShipLocalPlayerBehavior entity) {
		entities.remove (entity);
	}

	void update () {
		for (final @NotNull SpaceShipLocalPlayerBehavior entity : entities) {
			final @NotNull UserInputSpaceShipComponent userInput = entity.getUserInputSpaceShipComponent ();
			final @NotNull DirectionalThrustComponent directionalThrust = entity.getDirectionalThrustComponent ();
			final @NotNull Vector2 translationalThrustDirection = new Vector2 ();
			float rotationalThrustDirection = 0;
			final @NotNull AccelerationComponent accelerationComponent = entity.getAccelerationComponent ();
			final @NotNull Vector2 translationalAcceleration = accelerationComponent.getTranslational ();

			// Get user input
			if (input.isKeyPressed (userInput.getForwards ()))
				translationalThrustDirection.x += 1;
			if (input.isKeyPressed (userInput.getBackwards ()))
				translationalThrustDirection.x -= 1;

			if (input.isKeyPressed (userInput.getRight ()))
				translationalThrustDirection.y -= 1;
			if (input.isKeyPressed (userInput.getLeft ()))
				translationalThrustDirection.y += 1;

			if (input.isKeyPressed (userInput.getSpinClockwise ()))
				rotationalThrustDirection -= 1;
			if (input.isKeyPressed (userInput.getSpinCounterClockwise ()))
				rotationalThrustDirection += 1;

			// Rotate the entity
			if (translationalThrustDirection.x > 0)
				translationalAcceleration.x = translationalThrustDirection.x * directionalThrust.getForwards ();
			else if (translationalThrustDirection.x < 0)
				translationalAcceleration.x = translationalThrustDirection.x * directionalThrust.getBackwards ();
			else
				translationalAcceleration.x = 0;

			if (translationalThrustDirection.y > 0)
				translationalAcceleration.y = translationalThrustDirection.y * directionalThrust.getLeft ();
			else if (translationalThrustDirection.y < 0)
				translationalAcceleration.y = translationalThrustDirection.y * directionalThrust.getRight ();
			else
				translationalAcceleration.y = 0;

			translationalAcceleration.rotateDeg (entity.getPositionRotationComponent ().getDegrees ());

			if (rotationalThrustDirection > 0)
				accelerationComponent.setDegreesPerSecondSquared (rotationalThrustDirection * directionalThrust.getClockwise ());
			else if (rotationalThrustDirection < 0)
				accelerationComponent.setDegreesPerSecondSquared (rotationalThrustDirection * directionalThrust.getCounterClockwise ());
			else
				accelerationComponent.setDegreesPerSecondSquared (0);
		}
	}
}
