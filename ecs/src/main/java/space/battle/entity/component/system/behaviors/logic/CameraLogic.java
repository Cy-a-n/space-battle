package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides logic for managing cameras in the game.
 */
public class CameraLogic {
	private static final Set<CameraBehavior> cameras = new HashSet<>();
	private static CameraBehavior mainCamera;

	/**
	 * Returns an unmodifiable set of cameras in the game.
	 *
	 * @return An unmodifiable set of cameras.
	 */
	public static Set<CameraBehavior> getCameras () {
		return Collections.unmodifiableSet(cameras);
	}

	/**
	 * Returns the main camera of the game.
	 *
	 * @return The main camera.
	 */
	public static CameraBehavior getMainCamera () {
		return mainCamera;
	}

	/**
	 * Sets the main camera of the game.
	 *
	 * @param camera The camera to be set as the main camera.
	 * @throws IllegalArgumentException If the specified camera is not found in the cameras set.
	 */
	public static void setMainCamera (@NotNull CameraBehavior camera) {
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
	static void addCamera (@NotNull CameraBehavior camera) {
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
	static void update (@NotNull OrthographicCamera camera) {
		if (mainCamera != null) {
			camera.position.x = mainCamera.getPosition().getX();
			camera.position.y = mainCamera.getPosition().getY();
		}
	}
}
