package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;

/**
 * This class provides behavior logic for entities that implement specific interfaces.
 */
public class BehaviorLogic {
	/**
	 * Adds an entity to the corresponding logic system based on its implemented interfaces.
	 *
	 * @param entity The entity to be added.
	 */
	public static void addEntity (@NotNull Object entity) {
		if (entity instanceof ConstantMovementBehavior)
			MovingConstantLogic.addMovingEntity((ConstantMovementBehavior) entity);

		if (entity instanceof MovingWithAccelerationBehavior)
			MovingWithAccelerationLogic.addMovingEntity((MovingWithAccelerationBehavior) entity);

		if (entity instanceof PlayerShipBehavior)
			PlayerShipLogic.addPlayerShip((PlayerShipBehavior) entity);
	}

	/**
	 * Adds an entity with graphics to the corresponding logic system based on its implemented interfaces.
	 *
	 * @param entity The entity with graphics to be added.
	 */
	public static void addEntityWithGraphics (@NotNull Object entity) {
		addEntity(entity);

		if (entity instanceof TextureBehavior)
			DrawableLogic.addDrawables((TextureBehavior) entity);

		if (entity instanceof CameraBehavior)
			CameraLogic.addCamera((CameraBehavior) entity);
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public static void update (float deltaTimeInSeconds) {
		MovingConstantLogic.update(deltaTimeInSeconds);
		MovingWithAccelerationLogic.update(deltaTimeInSeconds);
		PlayerShipLogic.update();
	}

	/**
	 * Updates the behavior logic for the entities with graphics with the specified delta time and camera.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 * @param batch              The SpriteBatch used for drawing.
	 * @param camera             The OrthographicCamera used for rendering.
	 */
	public static void updateWithGraphics (float deltaTimeInSeconds, @NotNull SpriteBatch batch,
										   @NotNull OrthographicCamera camera) {
		update(deltaTimeInSeconds);
		CameraLogic.update(camera);
		DrawableLogic.update(batch, camera);
	}
}
