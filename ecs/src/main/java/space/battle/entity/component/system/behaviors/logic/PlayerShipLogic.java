package space.battle.entity.component.system.behaviors.logic;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Input.Keys;

import static com.badlogic.gdx.Gdx.input;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;

/**
 * PlayerShipLogic class manages the behavior of player ships.
 * It holds a set of all PlayerShipBehavior entities,
 * allowing for easy addition and removal.
 */
class PlayerShipLogic {
	private Set<PlayerShipBehavior> entities = new HashSet<>();
	private PlayerShipBehavior currentEntity;

	/**
	 * Sets the current selected PlayerShipBehavior
	 * Throws IllegalArgumentException if the entity is not part of the set.
	 *
	 * @param currentEntity Entity to set as current
	 */
	void setCurrentEntity (@NotNull PlayerShipBehavior currentEntity) {
		if (!entities.contains(currentEntity))
			throw new IllegalArgumentException(String.format("Cannot set %s to %s, because %s does not contain " +
					"this instance of %s.", "PlayerShipLogic" + ".currentPlayerShip", (Object) currentEntity,
					"PlayerShipLogic.playerShips", PlayerShipBehavior.class));
		this.currentEntity = currentEntity;
	}

	/**
	 * Adds a new PlayerShipBehavior entity to the set.
	 * If it's the first entity, it will be set as current.
	 *
	 * @param entity Entity to add
	 */
	void addEntity (@NotNull PlayerShipBehavior entity) {
		entities.add(entity);
		if (entities.size() == 1) {
			this.currentEntity = entity;
		}
	}

	/**
	 * Removes a PlayerShipBehavior entity from the set.
	 *
	 * @param entity Entity to remove
	 */
	void removeEntity (@NotNull PlayerShipBehavior entity) {
		entities.remove(entity);
	}

	void update () {
		Vector2 resultingAcceleration = new Vector2();

		if (input.isKeyPressed(Keys.A))
			resultingAcceleration.x = -100;
		if (input.isKeyPressed(Keys.D))
			resultingAcceleration.x = 100;

		if (input.isKeyPressed(Keys.S))
			resultingAcceleration.y = -100;
		if (input.isKeyPressed(Keys.W))
			resultingAcceleration.y = 100;

		if (currentEntity != null) {
			currentEntity.getAcceleration().set(resultingAcceleration);
		}
	}
}

