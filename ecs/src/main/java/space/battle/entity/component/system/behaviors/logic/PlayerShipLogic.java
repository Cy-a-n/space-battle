package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;

import java.util.HashSet;
import java.util.Set;

public class PlayerShipLogic {
	static private Set<PlayerShipBehavior> playerShips = new HashSet<>();

	static void addPlayerShip (PlayerShipBehavior playerShip) {
		playerShips.add(playerShip);
	}

	static void update () {
		float resultingAccelerationX = 0;
		float resultingAccelerationY = 0;

		if (Gdx.input.isKeyPressed(Input.Keys.A))
			resultingAccelerationX -= 100;
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			resultingAccelerationX += 100;

		if (Gdx.input.isKeyPressed(Input.Keys.S))
			resultingAccelerationY -= 100;
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			resultingAccelerationY += 100;

		for (PlayerShipBehavior playerShip : playerShips) {
			playerShip.getAcceleration().setX(resultingAccelerationX);
			playerShip.getAcceleration().setY(resultingAccelerationY);
		}
	}
}
