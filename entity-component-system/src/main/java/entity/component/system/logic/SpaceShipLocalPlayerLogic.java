package entity.component.system.logic;

import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.SpaceShipLocalPlayerBehavior;
import entity.component.system.components.DirectionalThrustComponent;
import entity.component.system.components.UserInputSpaceShipComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.Gdx.input;

public class SpaceShipLocalPlayerLogic {
	private final @NotNull Set<SpaceShipLocalPlayerBehavior> entities = new HashSet<>();

	void addEntity (final @NotNull SpaceShipLocalPlayerBehavior entity) {
		entities.add(entity);
	}

	void removeEntity (final @NotNull SpaceShipLocalPlayerBehavior entity) {
		entities.remove(entity);
	}

	void update () {
		for (final @NotNull SpaceShipLocalPlayerBehavior entity : entities) {
			UserInputSpaceShipComponent userInput = entity.getUserInputSpaceShipBehavior();
			Vector2 thrustDirection = new Vector2();
			DirectionalThrustComponent directionalThrust = entity.getDirectionalThrustComponent();
			Vector2 acceleration = entity.getAccelerationComponent().getVector2();

			if (input.isKeyPressed(userInput.getForwards()) && input.isKeyPressed(userInput.getBackwards()))
				thrustDirection.x = 0;
			else if (input.isKeyPressed(userInput.getForwards()))
				thrustDirection.x = 1;
			else if (input.isKeyPressed(userInput.getBackwards()))
				thrustDirection.x = -1;

			if (input.isKeyPressed(userInput.getLeft()) && input.isKeyPressed(userInput.getRight()))
				thrustDirection.y = 0;
			else if (input.isKeyPressed(userInput.getLeft()))
				thrustDirection.y = 1;
			else if (input.isKeyPressed(userInput.getRight()))
				thrustDirection.y = -1;

			thrustDirection.nor();

			if (thrustDirection.x > 0)
				acceleration.x = thrustDirection.x * directionalThrust.getForwards();
			else if (thrustDirection.x < 0)
				acceleration.x = thrustDirection.x * directionalThrust.getBackwards();
			else
				acceleration.x = 0;

			if (thrustDirection.y > 0)
				acceleration.y = thrustDirection.y * directionalThrust.getLeft();
			else if (thrustDirection.y < 0)
				acceleration.y = thrustDirection.y * directionalThrust.getRight();
			else
				acceleration.y = 0;
		}
	}
}
