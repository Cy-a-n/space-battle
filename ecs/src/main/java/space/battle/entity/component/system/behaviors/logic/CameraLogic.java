package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.components.HasPlayerInput;

import java.util.HashSet;
import java.util.Set;

class CameraLogic {
	private final Set<CameraBehavior> playerOneEntities = new HashSet<>();
	private final Set<CameraBehavior> playerTwoEntities = new HashSet<>();
	private CameraBehavior playerOneEntity;
	private CameraBehavior playerTwoEntity;

	public void setPlayerOneEntity (@NotNull CameraBehavior playerOneEntity) {
		if (!playerOneEntities.contains(playerOneEntity)) {
			throw new IllegalArgumentException(String.format("The provided instance of %s is not part of the " +
					"playerOneEntities set.", playerOneEntity.getClass().getSimpleName()));
		}
		this.playerOneEntity = playerOneEntity;
	}

	public void setPlayerTwoEntity (@NotNull CameraBehavior playerTwoEntity) {
		if (!playerTwoEntities.contains(playerTwoEntity)) {
			throw new IllegalArgumentException(String.format("The provided instance of %s is not part of the " +
					"playerTwoEntities set.", playerTwoEntity.getClass().getSimpleName()));
		}
		this.playerTwoEntity = playerTwoEntity;
	}

	void addEntity (@NotNull CameraBehavior entity) {
		switch (entity.getPlayerId()) {
			case PLAYER_ONE -> {
				playerOneEntities.add(entity);
				if (playerOneEntities.size() == 1)
					this.playerOneEntity = entity;
			}
			case PLAYER_TWO -> {
				playerTwoEntities.add(entity);
				if (playerTwoEntities.size() == 1)
					this.playerTwoEntity = entity;
			}
		}
	}

	void removeEntity (@NotNull CameraBehavior entity) {
		if (playerOneEntities.remove(entity))
			playerOneEntity = null;
		if (playerTwoEntities.remove(entity))
			playerTwoEntity = null;
	}

	void update (@NotNull OrthographicCamera camera, @NotNull SpriteBatch batch, HasPlayerInput.PlayerId playerId) {
		CameraBehavior currentEntity;
		if (playerId == HasPlayerInput.PlayerId.PLAYER_ONE) {
			currentEntity = playerOneEntity;
		} else if (playerId == HasPlayerInput.PlayerId.PLAYER_TWO) {
			currentEntity = playerTwoEntity;
		} else {
			throw new IllegalArgumentException("Invalid player ID");
		}

		if (currentEntity != null) {
			// TODO: Potential for performance improvements
			camera.up.set(0, 1, 0);
			camera.direction.set(0, 0, -1);
			camera.position.x = currentEntity.getPosition().x;
			camera.position.y = currentEntity.getPosition().y;
			camera.rotate(-currentEntity.getRotationDegrees() + 90);
			camera.update();
			batch.setProjectionMatrix(camera.combined);
		}
	}
}
