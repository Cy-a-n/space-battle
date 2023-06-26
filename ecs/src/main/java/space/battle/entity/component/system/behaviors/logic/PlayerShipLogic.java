package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.Input.Keys;

import static com.badlogic.gdx.Gdx.input;

import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;

public class PlayerShipLogic {
	private PlayerShipBehavior playerShip;

	public PlayerShipBehavior getPlayerShip () {
		return playerShip;
	}

	void setPlayerShip (@NotNull PlayerShipBehavior playerShip) {
		this.playerShip = playerShip;
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

		playerShip.getAcceleration().set(resultingAcceleration);
	}
}
