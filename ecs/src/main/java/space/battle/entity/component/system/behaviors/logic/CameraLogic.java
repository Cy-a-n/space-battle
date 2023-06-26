package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * This class provides logic for managing cameras in the game.
 */
public class CameraLogic {
	private final List<CameraBehavior> cameras = new ArrayList<>();
	private CameraBehavior mainCamera;

	/**
	 * Returns an unmodifiable set of cameras in the game.
	 *
	 * @return An unmodifiable set of cameras.
	 */
	public List<CameraBehavior> getCameras () {
		return Collections.unmodifiableList(cameras);
	}

	/**
	 * Returns the main camera of the game.
	 *
	 * @return The main camera.
	 */
	public CameraBehavior getMainCamera () {
		return mainCamera;
	}

	/**
	 * Sets the main camera of the game.
	 *
	 * @param camera The camera to be set as the main camera.
	 * @throws IllegalArgumentException If the specified camera is not found in the cameras set.
	 */
	public void setMainCamera (@NotNull CameraBehavior camera) {
		if (!cameras.contains(camera)) {
			throw new IllegalArgumentException("Camera not found in cameras set");
		}

		mainCamera = camera;
	}

	/**
	 * Adds a camera to the set of cameras.
	 *
	 * @param camera The camera to be added.
	 */
	void addCamera (@NotNull CameraBehavior camera) {
		cameras.add(camera);
		if (cameras.size() == 1) {
			mainCamera = camera;
		}
	}

	/**
	 * Updates the position of the OrthographicCamera based on the main camera's position.
	 *
	 * @param camera The OrthographicCamera to be updated.
	 */
	void update (@NotNull OrthographicCamera camera, @NotNull SpriteBatch batch) {
		if (mainCamera != null) {
			camera.position.x = mainCamera.getPosition().x;
			camera.position.y = mainCamera.getPosition().y;
			camera.update();
			batch.setProjectionMatrix(camera.combined);
		}
	}
}
