package entity.component.system.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import entity.component.system.behaviors.CameraBehavior;
import entity.component.system.components.PositionRotationComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

class CameraLogic {
	private final @NotNull Set<CameraBehavior> entities = new HashSet<>();

	void addEntity (final @NotNull CameraBehavior entity) {
		entities.add(entity);
	}

	void removeEntity (final @NotNull CameraBehavior entity) {
		entities.remove(entity);
	}

	void update () {
		for (final CameraBehavior entity : entities) {
			final OrthographicCamera camera = entity.getCameraComponent().getCamera();
			final @NotNull Vector3 cameraPosition = camera.position;
			final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent();
			final @NotNull Vector2 position = positionRotationComponent.getPosition();

			// TODO: Potential for performance improvements
			camera.up.set(0, 1, 0);
			camera.direction.set(0, 0, 1);
			cameraPosition.x = position.x;
			cameraPosition.y = position.y;
			camera.rotate(positionRotationComponent.getDegrees() - 90);
		}
	}
}
