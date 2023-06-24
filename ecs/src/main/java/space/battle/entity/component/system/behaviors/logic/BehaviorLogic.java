package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;
import space.battle.entity.component.system.behaviors.interfaces.IsMovingConstant;

// TODO: Tests

public class BehaviorLogic {
	public static void addEntity (@NotNull Object entity) {
		if (entity instanceof IsMovingConstant) {
			MovingConstantLogic.addMovingEntity((IsMovingConstant) entity);
		}
	}

	public static void addEntityWithGraphics (@NotNull Object entity) {
		addEntity(entity);

		if (entity instanceof IsDrawable)
			DrawableLogic.addDrawables((IsDrawable) entity);

		if (entity instanceof IsCamera)
			CameraLogic.addCamera((IsCamera) entity);
	}

	public static void update (float deltaTimeInSeconds) {
		MovingConstantLogic.update(deltaTimeInSeconds);
	}

	public static void updateWithGraphics (float deltaTimeInSeconds, @NotNull SpriteBatch batch,
										   @NotNull OrthographicCamera camera) {
		update(deltaTimeInSeconds);
		CameraLogic.update(camera);
		DrawableLogic.update(batch, camera);
	}
}
