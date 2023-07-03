package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;
import space.battle.entity.component.system.components.HasOrigin;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRotationDegrees;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides behavior logic for entities that implement specific interfaces.
 * Logic classes are not static, so that they can be flagged for garbage collection, which reduces errors.
 */
public class BehaviorLogic {
	private static BehaviorLogic instance;
	private final HasOriginLogic hasOriginLogic = new HasOriginLogic();
	private final HasPositionLogic hasPositionLogic = new HasPositionLogic();
	private final HasRotationDegreesLogic hasRotationDegreesLogic = new HasRotationDegreesLogic();
	private final CameraLogic cameraLogic = new CameraLogic();
	private final DrawableLogic drawableLogic = new DrawableLogic();
	private final MovingConstantLogic movingConstantLogic = new MovingConstantLogic();
	private final MovingWithAccelerationLogic movingWithAccelerationLogic = new MovingWithAccelerationLogic();
	private final PlayerShipLogic playerShipLogic = new PlayerShipLogic();
	private final VisualCollisionShapeLogic visualCollisionShapeLogic = new VisualCollisionShapeLogic();
	private final RelativePositionAndRotationLogic relativePositionAndRotationLogic =
			new RelativePositionAndRotationLogic();
	private final Set<Entity> allEntities = new HashSet<>();

	private BehaviorLogic () {}

	public static @NotNull BehaviorLogic getInstance () {
		if (instance == null) {
			instance = new BehaviorLogic();
		}

		return instance;
	}

	public static void disposeInstance () {
		instance = null;
	}

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

		if (entity instanceof HasPosition)
			hasPositionLogic.addEntity((HasPosition) entity);

		if (entity instanceof HasRotationDegrees)
			hasRotationDegreesLogic.addEntity((HasRotationDegrees) entity);

		if (entity instanceof HasOrigin)
			hasOriginLogic.addEntity((HasOrigin) entity);

		if (entity instanceof ConstantMovementBehavior)
			movingConstantLogic.addEntity((ConstantMovementBehavior) entity);

		if (entity instanceof MovingWithAccelerationBehavior)
			movingWithAccelerationLogic.addEntity((MovingWithAccelerationBehavior) entity);

		if (entity instanceof PlayerShipBehavior)
			playerShipLogic.addEntity((PlayerShipBehavior) entity);

		if (entity instanceof ChildrenWithRelativePositionAndRotationDegreesBehavior) {
			relativePositionAndRotationLogic.addEntity((ChildrenWithRelativePositionAndRotationDegreesBehavior) entity);
		}

		if (entity instanceof RelativePositionAndRotationBehavior) {
			relativePositionAndRotationLogic.addEntity((RelativePositionAndRotationBehavior) entity);
		}

		if (entity instanceof TextureBehavior)
			drawableLogic.addEntity((TextureBehavior) entity);

		if (entity instanceof CameraBehavior)
			cameraLogic.addEntity((CameraBehavior) entity);

		if (entity instanceof VisualCollisionShapeBehavior)
			visualCollisionShapeLogic.addEntity((VisualCollisionShapeBehavior) entity);
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public void update (float deltaTimeInSeconds) {
		// Update position, rotation, etc
		playerShipLogic.update();
		movingConstantLogic.update(deltaTimeInSeconds);
		movingWithAccelerationLogic.update(deltaTimeInSeconds);
		relativePositionAndRotationLogic.update();

		// Reset the components
		hasPositionLogic.update();
		hasRotationDegreesLogic.update();
		hasOriginLogic.update();
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
		// Update position, rotation, etc
		playerShipLogic.update();
		movingConstantLogic.update(deltaTimeInSeconds);
		movingWithAccelerationLogic.update(deltaTimeInSeconds);
		relativePositionAndRotationLogic.update();

		// Draw
		cameraLogic.update(camera, batch);
		batch.begin();
		visualCollisionShapeLogic.update(shapeDrawer);
		drawableLogic.update(batch);
		batch.end();

		// Reset the components
		hasPositionLogic.update();
		hasRotationDegreesLogic.update();
		hasOriginLogic.update();
	}
}
