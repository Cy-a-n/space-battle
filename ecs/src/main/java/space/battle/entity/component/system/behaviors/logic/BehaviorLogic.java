package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;
import space.battle.entity.component.system.entities.Entity;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides behavior logic for entities that implement specific interfaces.
 * Logic classes are not static, so that they can be flagged for garbage collection, which reduces errors.
 */
public class BehaviorLogic {
	private static BehaviorLogic instance;

	public static @NotNull BehaviorLogic getInstance() {
		if (instance == null) {
			instance = new BehaviorLogic();
		}

		return instance;
	}

	public static void disposeInstance() {
		instance = null;
	}

	private final CameraLogic cameraLogic = new CameraLogic();
	private final DrawableLogic drawableLogic = new DrawableLogic();
	private final MovingConstantLogic movingConstantLogic = new MovingConstantLogic();
	private final MovingWithAccelerationLogic movingWithAccelerationLogic = new MovingWithAccelerationLogic();
	private final PlayerShipLogic playerShipLogic = new PlayerShipLogic();
	private final VisualShapeLogic visualShapeLogic = new VisualShapeLogic();
	private final RelativePositionAndRotationLogic relativePositionAndRotationLogic =
			new RelativePositionAndRotationLogic();
	private final Set<Entity> allEntities = new HashSet<>();

	/**
	 * Adds an entity to the corresponding logic system based on its implemented interfaces.
	 *
	 * @param entity The entity to be added.
	 */
	public void addEntity (@NotNull Entity entity) {
		if (allEntities.contains(entity))
			throw new IllegalArgumentException(String.format("%s already contains element %s. You cannot add the same "
					+ "instance of %s twice.", allEntities, entity, Entity.class));
		allEntities.add(entity);

		if (entity instanceof ConstantMovementBehavior)
			movingConstantLogic.addEntity((ConstantMovementBehavior) entity);

		if (entity instanceof MovingWithAccelerationBehavior)
			movingWithAccelerationLogic.addEntity((MovingWithAccelerationBehavior) entity);

		if (entity instanceof PlayerShipBehavior)
			playerShipLogic.addEntity((PlayerShipBehavior) entity);

		if (entity instanceof RelativePositionAndRotationBehavior) {
			relativePositionAndRotationLogic.addEntity((RelativePositionAndRotationBehavior) entity);
		}

		if (entity instanceof TextureBehavior)
			drawableLogic.addEntity((TextureBehavior) entity);

		if (entity instanceof CameraBehavior)
			cameraLogic.addEntity((CameraBehavior) entity);

		if (entity instanceof VisualShapeBehavior)
			visualShapeLogic.addEntity((VisualShapeBehavior) entity);
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public void update (float deltaTimeInSeconds) {
		playerShipLogic.update();
		movingConstantLogic.update(deltaTimeInSeconds);
		movingWithAccelerationLogic.update(deltaTimeInSeconds);
		relativePositionAndRotationLogic.update();
	}

	/**
	 * Updates the behavior logic for the entities with graphics with the specified delta time and camera.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 * @param batch              The SpriteBatch used for drawing.
	 * @param camera             The OrthographicCamera used for rendering.
	 */
	public void updateWithGraphics (float deltaTimeInSeconds, @NotNull SpriteBatch batch,
									@NotNull ShapeDrawer shapeDrawer, @NotNull OrthographicCamera camera) {
		update(deltaTimeInSeconds);
		cameraLogic.update(camera, batch);

		batch.begin();
		visualShapeLogic.update(shapeDrawer);
		drawableLogic.update(batch);
		batch.end();
	}

	private BehaviorLogic() {}
}
