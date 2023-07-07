package space.battle.entity.component.system.behaviors.logic;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Input.Keys;

import static com.badlogic.gdx.Gdx.input;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;
import space.battle.entity.component.system.components.HasPlayerInput;

/**
 * PlayerShipLogic class manages the behavior of player ships.
 * It holds a set of all PlayerShipBehavior entities,
 * allowing for easy addition and removal.
 */
class PlayerShipLogic {
	private final Set<PlayerShipBehavior> playerOneEntities = new HashSet<>();
	private final Set<PlayerShipBehavior> playerTwoEntities = new HashSet<>();
	private PlayerShipBehavior playerOneEntity;
	private PlayerShipBehavior playerTwoEntity;

	/**
	 * Sets the current selected PlayerShipBehavior for player one.
	 * Throws IllegalArgumentException if the provided entity is not part of the playerOneEntities set.
	 *
	 * @param playerOneEntity Entity to set as current for player one.
	 * @throws IllegalArgumentException if playerOneEntity is not part of playerOneEntities set.
	 */
	void setPlayerOneEntity (@NotNull PlayerShipBehavior playerOneEntity) {
		if (!playerOneEntities.contains(playerOneEntity)) {
			throw new IllegalArgumentException(String.format("The provided instance of %s is not part of the " +
					"playerOneEntities set.", playerOneEntity.getClass().getSimpleName()));
		}
		this.playerOneEntity = playerOneEntity;
	}

	/**
	 * Sets the current selected PlayerShipBehavior for player two.
	 * Throws IllegalArgumentException if the provided entity is not part of the playerTwoEntities set.
	 *
	 * @param playerTwoEntity Entity to set as current for player two.
	 * @throws IllegalArgumentException if playerTwoEntity is not part of playerTwoEntities set.
	 */
	void setPlayerTwoEntity (@NotNull PlayerShipBehavior playerTwoEntity) {
		if (!playerTwoEntities.contains(playerTwoEntity)) {
			throw new IllegalArgumentException(String.format("The provided instance of %s is not part of the " +
					"playerTwoEntities set.", playerTwoEntity.getClass().getSimpleName()));
		}
		this.playerTwoEntity = playerTwoEntity;
	}

	/**
	 * Adds a new PlayerShipBehavior entity to the set.
	 * If it's the first entity, it will be set as current.
	 *
	 * @param entity Entity to add
	 */
	void addEntity (@NotNull PlayerShipBehavior entity) {
		switch (entity.getPlayerId()) {
			case PLAYER_ONE -> {
				playerOneEntities.add(entity);
				if (playerOneEntities.size() == 1)
					this.playerOneEntity = entity;
			}
			case PLAYER_TWO -> {
				playerTwoEntities.add(entity);
				if (playerTwoEntities.size() == 1)
					this.playerOneEntity = entity;
			}
		}
	}

	/**
	 * Removes a PlayerShipBehavior entity from the set.
	 *
	 * @param entity Entity to remove
	 */
	void removeEntity (@NotNull PlayerShipBehavior entity) {
		if (playerOneEntities.remove(entity))
			playerOneEntity = null;
		if (playerTwoEntities.remove(entity))
			playerTwoEntity = null;
	}

	void update () {
		if (playerOneEntity != null) {
			Vector2 resultingAcceleration = new Vector2();

			if (input.isKeyPressed(Keys.S))
				resultingAcceleration.x = -playerOneEntity.getThrustLeft();
			if (input.isKeyPressed(Keys.W))
				resultingAcceleration.x = playerOneEntity.getThrustRight();

			if (input.isKeyPressed(Keys.D))
				resultingAcceleration.y = -playerOneEntity.getThrustUp();
			if (input.isKeyPressed(Keys.A))
				resultingAcceleration.y = playerOneEntity.getThrustDown();
			resultingAcceleration.rotateDeg(playerOneEntity.getRotationDegrees());

			float resultingRotationalAcceleration = 0;

			if (input.isKeyPressed(Keys.E))
				resultingRotationalAcceleration = -playerOneEntity.getThrustClockwise();
			if (input.isKeyPressed(Keys.Q))
				resultingRotationalAcceleration = playerOneEntity.getThrustCounterclockwise();

			playerOneEntity.getAcceleration().set(resultingAcceleration);
			playerOneEntity.setRotationalAcceleration(resultingRotationalAcceleration);
		}

		if (playerTwoEntity != null) {
			Vector2 resultingAcceleration = new Vector2();

			if (input.isKeyPressed(Keys.DOWN))
				resultingAcceleration.x = -playerTwoEntity.getThrustLeft();
			if (input.isKeyPressed(Keys.UP))
				resultingAcceleration.x = playerTwoEntity.getThrustRight();

			if (input.isKeyPressed(Keys.RIGHT))
				resultingAcceleration.y = -playerTwoEntity.getThrustUp();
			if (input.isKeyPressed(Keys.LEFT))
				resultingAcceleration.y = playerTwoEntity.getThrustDown();
			resultingAcceleration.rotateDeg(playerTwoEntity.getRotationDegrees());

			float resultingRotationalAcceleration = 0;

			if (input.isKeyPressed(Keys.E))
				resultingRotationalAcceleration = -playerTwoEntity.getThrustClockwise();
			if (input.isKeyPressed(Keys.Q))
				resultingRotationalAcceleration = playerTwoEntity.getThrustCounterclockwise();

			playerTwoEntity.getAcceleration().set(resultingAcceleration);
			playerTwoEntity.setRotationalAcceleration(resultingRotationalAcceleration);
		}
	}
}

