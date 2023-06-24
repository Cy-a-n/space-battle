package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// TODO: Tests

public class CameraLogic {
	private static final Set<IsCamera> cameras = new HashSet<>();
	private static IsCamera mainCamera;

	public static Set<IsCamera> getCameras () {
		return Collections.unmodifiableSet(cameras);
	}

	public static IsCamera getMainCamera () {
		return mainCamera;
	}

	public static void setMainCamera (@NotNull IsCamera camera) {
		if (!cameras.contains(camera)) {
			throw new IllegalArgumentException("Camera not found in cameras set");
		}

		mainCamera = camera;
	}

	static void addCamera (@NotNull IsCamera camera) {
		cameras.add(camera);
		if (cameras.size() == 1) {
			mainCamera = camera;
		}
	}

	static void update (@NotNull OrthographicCamera camera) {
		if (mainCamera != null) {
			camera.position.x = mainCamera.getPosition().getX();
			camera.position.y = mainCamera.getPosition().getY();
		}
	}
}
