package entity.component.system.logic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.*;
import entity.component.system.components.EntityComponent;
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
	private final @NotNull PositionLogic positionLogic = new PositionLogic ( );
	private final @NotNull CameraLogic cameraLogic = new CameraLogic ( );
	private final @NotNull TextureLogic textureLogic = new TextureLogic ( );
	private final @NotNull ConstantMovementLogic constantMovementLogic = new ConstantMovementLogic ( );
	private final @NotNull AcceleratedMovementLogic acceleratedMovementLogic = new AcceleratedMovementLogic ( );
	private final @NotNull VisualCollisionShapeLogic visualCollisionShapeLogic = new VisualCollisionShapeLogic ( );
	private final @NotNull RelativePositionAndRotationLogic relativePositionAndRotationLogic = new RelativePositionAndRotationLogic ( );
	private final @NotNull CollisionShapeLogic collisionShapeLogic = new CollisionShapeLogic ( );
	private final @NotNull UserInputSpaceShipMovementLogic userInputSpaceShipMovementLogic = new UserInputSpaceShipMovementLogic ( );
	private final @NotNull CannonLogic cannonLogic = new CannonLogic ( );
	private final @NotNull LifeTimeLogic lifeTimeLogic = new LifeTimeLogic ( );
	private final @NotNull Set<EntityBehavior> allEntities = new HashSet<> ( );
	private  @NotNull Set<EntityBehavior> entitiesQueuedForAddition = new HashSet<> ( );
	private  @NotNull Set<EntityBehavior> entitiesQueuedForRemoval = new HashSet<> ( );

	private BehaviorLogic ( ) { }

	public static @NotNull BehaviorLogic getInstance ( ) {
		if ( instance == null ) {
			instance = new BehaviorLogic ( );
		}

		return instance;
	}

	public static void disposeInstance ( ) {
		instance = null;
	}

	public void queueForAddition ( EntityBehavior entity ) {
		entitiesQueuedForAddition.add ( entity );
		entity.getEntityComponent ( ).setQueuedForAddition ( true );
	}

	private void addEntities ( ) {
		final @NotNull Set<EntityBehavior> entitiesToBeAdded = new HashSet<> ( entitiesQueuedForAddition );
		entitiesQueuedForAddition = new HashSet<> ();

		for ( EntityBehavior entity :  entitiesToBeAdded  )
			addEntity ( entity );
	}

	/**
	 * Adds an entity to the corresponding logic system based on its implemented interfaces.
	 *
	 * @param entity The entity to be added.
	 */
	private void addEntity ( @NotNull EntityBehavior entity ) {
		if ( !allEntities.add ( entity ) )
			throw new IllegalArgumentException ( String.format (
					"%s already contains element %s. You cannot add the same " + "instance of %s " + "twice.", allEntities, entity, EntityBehavior.class ) );

		EntityComponent entityComponent = entity.getEntityComponent ();
		entityComponent.setQueuedForAddition ( false );
		entityComponent.setAddedToBehaviorLogic ( true );
		entitiesQueuedForAddition.addAll ( entityComponent.getQueueEntitiesOnAdditionForAddition ( ) );


		if ( entity instanceof PositionRotationBehavior )
			positionLogic.addEntity ( ( PositionRotationBehavior ) entity );

		if ( entity instanceof AcceleratedMovementBehavior )
			acceleratedMovementLogic.addEntity ( ( AcceleratedMovementBehavior ) entity );

		if ( entity instanceof ConstantMovementBehavior )
			constantMovementLogic.addEntity ( ( ConstantMovementBehavior ) entity );

		if ( entity instanceof CollisionShapeBehavior )
			collisionShapeLogic.addEntity ( ( CollisionShapeBehavior ) entity );

		if ( entity instanceof ParentWithPositionRotationBehavior )
			relativePositionAndRotationLogic.addEntity ( ( ParentWithPositionRotationBehavior ) entity );

		if ( entity instanceof RelativePositionRotationBehavior )
			relativePositionAndRotationLogic.addEntity ( ( RelativePositionRotationBehavior ) entity );

		if ( entity instanceof CameraBehavior )
			cameraLogic.addEntity ( ( CameraBehavior ) entity );

		if ( entity instanceof TextureBehavior )
			textureLogic.addEntity ( ( TextureBehavior ) entity );

		if ( entity instanceof VisualCollisionShapeBehavior )
			visualCollisionShapeLogic.addEntity ( ( VisualCollisionShapeBehavior ) entity );

		if ( entity instanceof SpaceShipLocalPlayerBehavior )
			userInputSpaceShipMovementLogic.addEntity ( ( SpaceShipLocalPlayerBehavior ) entity );

		if ( entity instanceof CannonBehavior )
			cannonLogic.addEntity ( ( CannonBehavior ) entity );

		if ( entity instanceof LifeTimeBehavior )
			lifeTimeLogic.addEntity ( ( LifeTimeBehavior ) entity );


	}

	/**
	 * Queues an entity for removal from the system.
	 * All entities queued for removal will be removed at the beginning of the next frame.
	 *
	 * @param entity The entity to be queued for removal.
	 * @throws IllegalArgumentException If the entity was never added to the system.
	 */
	public void queueEntityForRemoval ( final @NotNull EntityBehavior entity ) {
		entitiesQueuedForRemoval.add ( entity );
		entity.getEntityComponent ( ).setQueuedForRemoval ( true );
	}

	/**
	 * Remove all entities queued for removal from the game tree.
	 */
	private void removeEntities ( ) {
		final @NotNull Set<EntityBehavior> entitiesToBeRemoved = new HashSet<> ( entitiesQueuedForRemoval );
		entitiesQueuedForRemoval = new HashSet<> ();

		for ( EntityBehavior entity : new HashSet<> ( entitiesToBeRemoved )   )
			removeEntity ( entity );
	}

	/**
	 * Remove an entity directly.
	 */
	private void removeEntity ( final @NotNull EntityBehavior entity ) {
		if ( !allEntities.remove ( entity ) ) {
			//			throw new IllegalArgumentException ( String.format (
			//					"%s does not contain element %s. You cannot remove an " + "entity that was never added with %s.",
			//					allEntities,
			//					entity,
			//					EntityBehavior.class,
			//					"space.battle.entity.component" + ".system.behaviors.logic.BehaviorLogic.addEntity()" ) );}
		}

		EntityComponent entityComponent = entity.getEntityComponent ();
		entityComponent.setQueuedForRemoval ( true );
		entityComponent.setAddedToBehaviorLogic ( false );
		entitiesQueuedForRemoval.addAll ( entityComponent.getQueueEntitiesOnRemovalForRemoval ( ) );
		entitiesQueuedForAddition.addAll ( entityComponent.getQueueEntitiesOnRemovalForAddition ( ) );

		if ( entity instanceof ParentWithPositionRotationBehavior ) {
			positionLogic.removeEntity ( ( PositionRotationBehavior ) entity );
		}

		if ( entity instanceof AcceleratedMovementBehavior )
			acceleratedMovementLogic.removeEntity ( ( AcceleratedMovementBehavior ) entity );

		if ( entity instanceof ConstantMovementBehavior )
			constantMovementLogic.removeEntity ( ( ConstantMovementBehavior ) entity );

		if ( entity instanceof CollisionShapeBehavior )
			collisionShapeLogic.removeEntity ( ( CollisionShapeBehavior ) entity );

		if ( entity instanceof ParentWithPositionRotationBehavior )
			relativePositionAndRotationLogic.removeEntity ( ( ParentWithPositionRotationBehavior ) entity );

		if ( entity instanceof RelativePositionRotationBehavior )
			relativePositionAndRotationLogic.removeEntity ( ( RelativePositionRotationBehavior ) entity );

		if ( entity instanceof CameraBehavior )
			cameraLogic.removeEntity ( ( CameraBehavior ) entity );

		if ( entity instanceof TextureBehavior )
			textureLogic.removeEntity ( ( TextureBehavior ) entity );

		if ( entity instanceof VisualCollisionShapeBehavior )
			visualCollisionShapeLogic.removeEntity ( ( VisualCollisionShapeBehavior ) entity );

		if ( entity instanceof SpaceShipLocalPlayerBehavior )
			userInputSpaceShipMovementLogic.removeEntity ( ( SpaceShipLocalPlayerBehavior ) entity );

		if ( entity instanceof CannonBehavior )
			cannonLogic.removeEntity ( ( CannonBehavior ) entity );

		if ( entity instanceof LifeTimeBehavior )
			lifeTimeLogic.removeEntity ( ( LifeTimeBehavior ) entity );
	}

	public boolean containsEntity ( final @NotNull EntityBehavior entity ) {
		return allEntities.contains ( entity );
	}

	/**
	 * Updates the behavior logic for the entities with the specified delta time.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 */
	public void update ( final float deltaTimeInSeconds ) {
		// TODO: Implementation
	}

	/**
	 * Updates the behavior logic for the entities with graphics with the specified delta time and camera.
	 *
	 * @param deltaTimeInSeconds The time that has passed since the last update in seconds.
	 * @param batch              The SpriteBatch used for drawing.
	 */
	public void updateWithGraphics ( final float deltaTimeInSeconds,
									 final @NotNull SpriteBatch batch,
									 final @NotNull ShapeDrawer shapeDrawer,
									 final @NotNull Viewport[] viewports,
									 TextureAtlas textureAtlas ) {
		addEntities ( );
		removeEntities ( );

		// Update user input
		userInputSpaceShipMovementLogic.update ( );
		cannonLogic.update ( textureAtlas );

		// Update position, rotation, etc
		acceleratedMovementLogic.update ( deltaTimeInSeconds );
		constantMovementLogic.update ( deltaTimeInSeconds );

		relativePositionAndRotationLogic.update ( );

		// Check for collisions
		collisionShapeLogic.update ( );
		lifeTimeLogic.update ( );

		// Draw camera0
		cameraLogic.update ( );

		for ( Viewport viewport : viewports ) {
			viewport.getCamera ( ).update ( );
			batch.setProjectionMatrix ( viewport.getCamera ( ).combined );
			viewport.apply ( ); // Set viewport for camera0
			batch.begin ( );
			visualCollisionShapeLogic.update ( shapeDrawer );
			textureLogic.update ( batch );
			batch.end ( );
		}

		// Reset the components
		positionLogic.update ( );
	}
}
