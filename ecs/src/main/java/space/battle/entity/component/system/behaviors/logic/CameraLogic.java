package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides logic for managing cameras in the game.
 */
class CameraLogic {
	private final List<CameraBehavior> entities = new ArrayList<>();
	private CameraBehavior currentEntity;

	/**
	 * Sets the main currentCamera of the game.
	 *
	 * @param currentEntity The currentCamera to be set as the main currentCamera.
	 * @throws IllegalArgumentException If the specified currentCamera is not found in the cameras set.
	 */
	public void setCurrentEntity (@NotNull CameraBehavior currentEntity) {
		if (!entities.contains(currentEntity)) {
			throw new IllegalArgumentException(String.format("Cannot set %s to %s, because %s does not contain " +
					"this instance of %s. Make sure that you only pass entities to this method that have been " +
					"added to %s.", "space.battle.entity.component.system.behaviors.logic.CameraLogic.currentCamera",
					(Object) currentEntity, "space.battle.entity.component.system.behaviors.logic.CameraLogic.cameras"
					, CameraLogic.class, "space.battle.entity.component.system.behaviors.logic.BehaviorLogic" +
							".addEntity()"));
		}

		this.currentEntity = currentEntity;
	}

	/**
	 * Adds a entity to the set of cameras.
	 *
	 * @param entity The entity to be added.
	 */
	void addEntity (@NotNull CameraBehavior entity) {
		entities.add(entity);
		if (entities.size() == 1) {
			currentEntity = entity;
		}
	}

	/**
	 * Updates the position of the OrthographicCamera based on the main camera's position.
	 *
	 * @param camera The OrthographicCamera to be updated.
	 */
	void update (@NotNull OrthographicCamera camera, @NotNull SpriteBatch batch) {
		if (currentEntity != null) {
			camera.position.x = currentEntity.getPosition().x;
			camera.position.y = currentEntity.getPosition().y;
			camera.update();
			batch.setProjectionMatrix(camera.combined);
		}
	}
}
