package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;
import space.battle.entity.component.system.components.HasPlayerInput;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides behavior logic for entities that implement specific interfaces.
 * Logic classes are not static, so that they can be flagged for garbage collection, which reduces errors.
 */
public class BehaviorLogic {
	private static BehaviorLogic instance;
	private final OriginLogic originLogic = new OriginLogic();
	private final PositionLogic positionLogic = new PositionLogic();
	private final RotationDegreesLogic rotationDegreesLogic = new RotationDegreesLogic();
	private final CameraLogic cameraLogic = new CameraLogic();
	private final DrawableLogic drawableLogic = new DrawableLogic();
	private final ConstantMovementLogic constantMovementLogic = new ConstantMovementLogic();
	private final AcceleratedMovementLogic acceleratedMovementLogic = new AcceleratedMovementLogic();
	private final PlayerShipLogic playerShipLogic = new PlayerShipLogic();
	private final VisualCollisionShapeLogic visualCollisionShapeLogic = new VisualCollisionShapeLogic();
	private final RelativePositionAndRotationLogic relativePositionAndRotationLogic =
			new RelativePositionAndRotationLogic();
	private final CollisionShapeLogic collisionShapeLogic = new CollisionShapeLogic();
	private final Set<Entity> allEntities = new HashSet<>();
	private final Set<Entity> entitiesQueuedForRemoval = new HashSet<>();
	private final ConstantRotationLogic constantRotationLogic = new ConstantRotationLogic();
	private final AcceleratedRotationLogic acceleratedRotationLogic = new AcceleratedRotationLogic();

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

		if (entity instanceof PositionBehavior)
			positionLogic.addEntity((PositionBehavior) entity);

		if (entity instanceof RotationDegreesBehavior)
			rotationDegreesLogic.addEntity((RotationDegreesBehavior) entity);

		if (entity instanceof OriginBehavior)
			originLogic.addEntity((OriginBehavior) entity);

		if (entity instanceof PlayerShipBehavior)
			playerShipLogic.addEntity((PlayerShipBehavior) entity);

		if (entity instanceof AcceleratedMovementBehavior)
			acceleratedMovementLogic.addEntity((AcceleratedMovementBehavior) entity);

		if (entity instanceof AcceleratedRotationBehavior)
			acceleratedRotationLogic.addEntity((AcceleratedRotationBehavior) entity);

		if (entity instanceof ConstantMovementBehavior)
			constantMovementLogic.addEntity((ConstantMovementBehavior) entity);

		if (entity instanceof ConstantRotationBehavior)
			constantRotationLogic.addEntity((ConstantRotationBehavior) entity);

		if (entity instanceof ChildrenWithRelativePositionAndRotationDegreesBehavior)
			relativePositionAndRotationLogic.addEntity((ChildrenWithRelativePositionAndRotationDegreesBehavior) entity);

		if (entity instanceof CollisionShapeBehavior)
			collisionShapeLogic.addEntity((CollisionShapeBehavior) entity);

		if (entity instanceof RelativePositionAndRotationBehavior) {
			relativePositionAndRotationLogic.addEntity((RelativePositionAndRotationBehavior) entity);
		}

		if (entity instanceof CameraBehavior)
			cameraLogic.addEntity((CameraBehavior) entity);

		if (entity instanceof TextureBehavior)
			drawableLogic.addEntity((TextureBehavior) entity);

		if (entity instanceof VisualCollisionShapeBehavior)
			visualCollisionShapeLogic.addEntity((VisualCollisionShapeBehavior) entity);
	}

	/**
	 * Queues an entity for removal from the system.
	 * All entities queued for removal will be removed at the beginning of the next frame.
	 *
	 * @param entity The entity to be queued for removal.
	 * @throws IllegalArgumentException If the entity was never added to the system.
	 */
	public void queueEntityForRemoval (Entity entity) {
		if (!allEntities.contains(entity))
			throw new IllegalArgumentException(String.format("%s does not contain element %s. You cannot remove an " + "entity that was never added with %s.", allEntities, entity, Entity.class, "space.battle.entity.component.system.behaviors.logic.BehaviorLogic.addEntity()"));
		entitiesQueuedForRemoval.add(entity);
	}

	/**
	 * Remove all entities queued for removal from the game tree.
	 */
	private void removeEntities () {
		for (Entity entity : entitiesQueuedForRemoval) {
			removeEntity(entity);
		}
		entitiesQueuedForRemoval.clear();
	}

	/**
	 * Remove an entity directly.
	 */
	void removeEntity (Entity entity) {
		allEntities.remove(entity);

		if (entity instanceof PositionBehavior)
			positionLogic.removeEntity((PositionBehavior) entity);

		if (entity instanceof RotationDegreesBehavior)
			rotationDegreesLogic.removeEntity((RotationDegreesBehavior) entity);

		if (entity instanceof OriginBehavior)
			originLogic.removeEntity((OriginBehavior) entity);

		if (entity instanceof PlayerShipBehavior)
			playerShipLogic.removeEntity((PlayerShipBehavior) entity);

		if (entity instanceof AcceleratedMovementBehavior)
			acceleratedMovementLogic.removeEntity((AcceleratedMovementBehavior) entity);

		if (entity instanceof AcceleratedRotationBehavior)
			acceleratedRotationLogic.addEntity((AcceleratedRotationBehavior) entity);

		if (entity instanceof ConstantMovementBehavior)
			constantMovementLogic.removeEntity((ConstantMovementBehavior) entity);

		if (entity instanceof ConstantRotationBehavior)
			constantRotationLogic.removeEntity((ConstantRotationBehavior) entity);

		if (entity instanceof ChildrenWithRelativePositionAndRotationDegreesBehavior)
			relativePositionAndRotationLogic.removeEntity((ChildrenWithRelativePositionAndRotationDegreesBehavior) entity);

		if (entity instanceof RelativePositionAndRotationBehavior)
			relativePositionAndRotationLogic.removeEntity((RelativePositionAndRotationBehavior) entity);

		if (entity instanceof CollisionShapeBehavior)
			collisionShapeLogic.removeEntity((CollisionShapeBehavior) entity);

		if (entity instanceof CameraBehavior)
			cameraLogic.removeEntity((CameraBehavior) entity);

		if (entity instanceof TextureBehavior)
			drawableLogic.removeEntity((TextureBehavior) entity);

		if (entity instanceof VisualCollisionShapeBehavior)
			visualCollisionShapeLogic.removeEntity((VisualCollisionShapeBehavior) entity);
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public void update (float deltaTimeInSeconds) {
		removeEntities();
		playerShipLogic.update();

		// Update position, rotation, etc
		acceleratedMovementLogic.update(deltaTimeInSeconds);
		acceleratedRotationLogic.update(deltaTimeInSeconds);
		constantMovementLogic.update(deltaTimeInSeconds);
		constantRotationLogic.update(deltaTimeInSeconds);

		relativePositionAndRotationLogic.update();

		// Check for collisions
		collisionShapeLogic.update();

		// Reset the components
		positionLogic.update();
		rotationDegreesLogic.update();
		originLogic.update();
	}

	/**
	 * Updates the behavior logic for the entities with graphics with the specified delta time and camera.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 * @param batch              The SpriteBatch used for drawing.
	 * @param camera             The OrthographicCamera used for rendering.
	 */
	public void updateWithGraphics (float deltaTimeInSeconds, @NotNull SpriteBatch batch,
									@NotNull ShapeDrawer shapeDrawer, @NotNull OrthographicCamera camera0,
									@NotNull OrthographicCamera camera1, @NotNull Viewport viewport0,
									@NotNull Viewport viewport1) {
		removeEntities();
		playerShipLogic.update();

		// Update position, rotation, etc
		acceleratedMovementLogic.update(deltaTimeInSeconds);
		acceleratedRotationLogic.update(deltaTimeInSeconds);
		constantMovementLogic.update(deltaTimeInSeconds);
		constantRotationLogic.update(deltaTimeInSeconds);

		relativePositionAndRotationLogic.update();

		// Check for collisions
		collisionShapeLogic.update();

		// Draw camera0
		viewport0.apply(); // Set viewport for camera0
		cameraLogic.update(camera0, batch, HasPlayerInput.PlayerId.PLAYER_ONE);
		batch.begin();
		visualCollisionShapeLogic.update(shapeDrawer);
		drawableLogic.update(batch);
		batch.end();

		// Draw camera1
		viewport1.apply(); // Set viewport for camera1
		cameraLogic.update(camera1, batch, HasPlayerInput.PlayerId.PLAYER_TWO);
		batch.begin();
		visualCollisionShapeLogic.update(shapeDrawer);
		drawableLogic.update(batch);
		batch.end();

		// Reset the components
		positionLogic.update();
		rotationDegreesLogic.update();
		originLogic.update();
	}
}
