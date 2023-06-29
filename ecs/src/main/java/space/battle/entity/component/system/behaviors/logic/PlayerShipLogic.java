package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.Input.Keys;

import static com.badlogic.gdx.Gdx.input;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;

import java.util.ArrayList;
import java.util.List;

class PlayerShipLogic {
	private List<PlayerShipBehavior> entities = new ArrayList<>();
	private PlayerShipBehavior currentEntity;

	void setCurrentEntity (@NotNull PlayerShipBehavior currentEntity) {
		if (!entities.contains(currentEntity))
			throw new IllegalArgumentException(String.format("Cannot set %s to %s, because %s does not contain " +
					"this instance of %s. Make sure that you only pass entities to this method that have been " +
					"added to %s.", "space.battle.entity.component.system.behaviors.logic.PlayerShipLogic" +
					".currentPlayerShip", (Object) currentEntity, "space.battle.entity.component.system" + ".behaviors"
					+ ".logic.PlayerShipLogic.playerShips", PlayerShipBehavior.class, "space.battle" + ".entity" +
					".component" + ".system.behaviors.logic" + ".BehaviorLogic" + ".addEntity()"));
		this.currentEntity = currentEntity;
	}

	void addEntity (@NotNull PlayerShipBehavior entity) {
		entities.add(currentEntity);
		if (entities.size() == 1) {
			this.currentEntity = entity;
		}
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
