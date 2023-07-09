package entity.component.system.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.*;
import org.jetbrains.annotations.NotNull;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides behavior logic for entities that implement specific interfaces.
 * Logic classes are not static, so that they can be flagged for garbage collection, which reduces errors.
 */
public class BehaviorLogic {
	private static BehaviorLogic instance;
	private final @NotNull PositionLogic positionLogic = new PositionLogic();
	private final @NotNull CameraLogic cameraLogic = new CameraLogic();
	private final @NotNull TextureLogic textureLogic = new TextureLogic();
	private final @NotNull ConstantMovementLogic constantMovementLogic = new ConstantMovementLogic();
	private final @NotNull AcceleratedMovementLogic acceleratedMovementLogic = new AcceleratedMovementLogic();
	private final @NotNull VisualCollisionShapeLogic visualCollisionShapeLogic = new VisualCollisionShapeLogic();
	private final @NotNull RelativePositionAndRotationLogic relativePositionAndRotationLogic =
			new RelativePositionAndRotationLogic();
	private final @NotNull CollisionShapeLogic collisionShapeLogic = new CollisionShapeLogic();
	private final @NotNull UserInputSpaceShipLogic userInputSpaceShipLogic = new UserInputSpaceShipLogic();
	private final @NotNull Set<Behavior> allEntities = new HashSet<>();
	private final @NotNull Set<Behavior> entitiesQueuedForRemoval = new HashSet<>();

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
	public void addEntity (@NotNull Behavior entity) {
		if (allEntities.contains(entity))
			throw new IllegalArgumentException(String.format("%s already contains element %s. You cannot add the same "
					+ "instance of %s twice.", allEntities, entity, Behavior.class));
		allEntities.add(entity);

		if (entity instanceof PositionRotationBehavior)
			positionLogic.addEntity((PositionRotationBehavior) entity);

		if (entity instanceof AcceleratedMovementBehavior)
			acceleratedMovementLogic.addEntity((AcceleratedMovementBehavior) entity);

		if (entity instanceof ConstantMovementBehavior)
			constantMovementLogic.addEntity((ConstantMovementBehavior) entity);

		if (entity instanceof CollisionShapeBehavior)
			collisionShapeLogic.addEntity((CollisionShapeBehavior) entity);

		if (entity instanceof ParentWithPositionRotationBehavior)
			relativePositionAndRotationLogic.addEntity((ParentWithPositionRotationBehavior) entity);

		if (entity instanceof RelativePositionRotationBehavior)
			relativePositionAndRotationLogic.addEntity((RelativePositionRotationBehavior) entity);

		if (entity instanceof CameraBehavior)
			cameraLogic.addEntity((CameraBehavior) entity);

		if (entity instanceof TextureBehavior)
			textureLogic.addEntity((TextureBehavior) entity);

		if (entity instanceof VisualCollisionShapeBehavior)
			visualCollisionShapeLogic.addEntity((VisualCollisionShapeBehavior) entity);

		if (entity instanceof SpaceShipLocalPlayerBehavior)
			userInputSpaceShipLogic.addEntity((SpaceShipLocalPlayerBehavior) entity);
	}

	/**
	 * Queues an entity for removal from the system.
	 * All entities queued for removal will be removed at the beginning of the next frame.
	 *
	 * @param entity The entity to be queued for removal.
	 * @throws IllegalArgumentException If the entity was never added to the system.
	 */
	public void queueEntityForRemoval (final @NotNull Behavior entity) {
		if (!allEntities.contains(entity))
			throw new IllegalArgumentException(String.format("%s does not contain element %s. You cannot remove an " + "entity that was never added with %s.", allEntities, entity, Behavior.class, "space.battle.entity.component" + ".system.behaviors.logic.BehaviorLogic.addEntity()"));
		entitiesQueuedForRemoval.add(entity);
	}

	/**
	 * Remove all entities queued for removal from the game tree.
	 */
	private void removeEntities () {
		for (Behavior entity : entitiesQueuedForRemoval) {
			removeEntity(entity);
		}
		entitiesQueuedForRemoval.clear();
	}

	/**
	 * Remove an entity directly.
	 */
	void removeEntity (final @NotNull Behavior entity) {
		allEntities.remove(entity);

		if (entity instanceof ParentWithPositionRotationBehavior) {
			positionLogic.removeEntity((PositionRotationBehavior) entity);
		}

		if (entity instanceof AcceleratedMovementBehavior)
			acceleratedMovementLogic.removeEntity((AcceleratedMovementBehavior) entity);

		if (entity instanceof ConstantMovementBehavior)
			constantMovementLogic.removeEntity((ConstantMovementBehavior) entity);

		if (entity instanceof CollisionShapeBehavior)
			collisionShapeLogic.removeEntity((CollisionShapeBehavior) entity);

		if (entity instanceof ParentWithPositionRotationBehavior)
			relativePositionAndRotationLogic.removeEntity((ParentWithPositionRotationBehavior) entity);

		if (entity instanceof RelativePositionRotationBehavior) {
			relativePositionAndRotationLogic.removeEntity((RelativePositionRotationBehavior) entity);
		}

		if (entity instanceof CameraBehavior)
			cameraLogic.removeEntity((CameraBehavior) entity);

		if (entity instanceof TextureBehavior)
			textureLogic.removeEntity((TextureBehavior) entity);

		if (entity instanceof VisualCollisionShapeBehavior)
			visualCollisionShapeLogic.removeEntity((VisualCollisionShapeBehavior) entity);

		if (entity instanceof SpaceShipLocalPlayerBehavior)
			userInputSpaceShipLogic.removeEntity((SpaceShipLocalPlayerBehavior) entity);
	}

	public boolean containsEntity (final @NotNull Behavior entity) {
		return allEntities.contains(entity);
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public void update (final float deltaTimeInSeconds) {
		removeEntities();

		// Update user input
		userInputSpaceShipLogic.update();

		// Update position, rotation, etc
		acceleratedMovementLogic.update(deltaTimeInSeconds);
		constantMovementLogic.update(deltaTimeInSeconds);

		relativePositionAndRotationLogic.update();

		// Check for collisions
		collisionShapeLogic.update();

		// Reset the components
		positionLogic.update();
	}

	/**
	 * Updates the behavior logic for the entities with graphics with the specified delta time and camera.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 * @param batch              The SpriteBatch used for drawing.
	 */
	public void updateWithGraphics (final float deltaTimeInSeconds, final @NotNull SpriteBatch batch,
									final @NotNull ShapeDrawer shapeDrawer, final @NotNull Viewport[] viewports) {
		removeEntities();

		// Update user input
		userInputSpaceShipLogic.update();

		// Update position, rotation, etc
		acceleratedMovementLogic.update(deltaTimeInSeconds);
		constantMovementLogic.update(deltaTimeInSeconds);

		//		relativePositionAndRotationLogic.update();

		// Check for collisions
		collisionShapeLogic.update();

		// Draw camera0
		cameraLogic.update();

		for (Viewport viewport : viewports) {
			viewport.getCamera().update();
			batch.setProjectionMatrix(viewport.getCamera().combined);
			viewport.apply(); // Set viewport for camera0
			batch.begin();
			visualCollisionShapeLogic.update(shapeDrawer);
			textureLogic.update(batch);
			batch.end();
		}

		// Reset the components
		positionLogic.update();
	}
}
