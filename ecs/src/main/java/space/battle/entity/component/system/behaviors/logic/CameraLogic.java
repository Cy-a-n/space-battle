package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

class CameraLogic {
	private final Set<CameraBehavior> entities = new HashSet<>();
	private CameraBehavior currentEntity;

	public void setCurrentEntity (@NotNull CameraBehavior currentEntity) {
		if (!entities.contains(currentEntity)) {
			throw new IllegalArgumentException(String.format("Cannot set %s to %s, because %s does not contain " +
					"this instance of %s. Make sure that you only pass entities to this method that have been " +
					"added to %s.", "space.battle.entity.component.system.behaviors.logic.CameraLogic.currentCamera",
					currentEntity, "space.battle.entity.component.system.behaviors.logic.CameraLogic.cameras",
					CameraLogic.class, "space.battle.entity.component.system.behaviors.logic.BehaviorLogic.addEntity()"
			));
		}
		this.currentEntity = currentEntity;
	}

	void addEntity (@NotNull CameraBehavior entity) {
		entities.add(entity);
		if (entities.size() == 1) {
			currentEntity = entity;
		}
	}

	void removeEntity (@NotNull CameraBehavior entity) {
		entities.remove(entity);
		if (currentEntity == entity) {
			currentEntity = entities.isEmpty() ? null : entities.iterator().next();
		}
	}

	void update (@NotNull OrthographicCamera camera, @NotNull SpriteBatch batch) {
		if (currentEntity != null) {
			camera.position.x = currentEntity.getPosition().x;
			camera.position.y = currentEntity.getPosition().y;
			camera.update();
			batch.setProjectionMatrix(camera.combined);
		}
	}
}
