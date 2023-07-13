package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.CannonBehavior;
import entity.component.system.behaviors.ParentWithPositionRotationBehavior;
import entity.component.system.behaviors.VisualCollisionShapeBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class GreenCruiser extends SpaceShipLocalPlayer {
	public GreenCruiser ( final @NotNull Viewport viewport,
						  final @NotNull TextureAtlas textureAtlas,
						  final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent,
						  final @NotNull Vector2 position,
						  final float rotationDegrees ) {
		super ( new TextureComponent ( textureAtlas.findRegion ( "green_cruiser_by_stephen_challener_on_open_game_art" ) ),
				new PositionRotationComponent ( position, rotationDegrees ),
				new VelocityComponent ( new Vector2 ( 0, 0 ), 0 ),
				new AccelerationComponent ( new Vector2 ( 0, 0 ), 0, 0.01f, 0.05f ),
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 5, 0, 29, 9, 42, 25, 42, 35, 30, 50, 6, 59, 0, 58 } ),
											  2,
											  2,
											  150,
											  100,
											  CollisionShapeComponent.getUniqueNonCollidingGroupId ( ) ),
				viewport,
				new DirectionalThrustComponent ( 150, 100, 100, 100, 100, 100 ),
				userInputSpaceShipComponent );

		// Queue cannons
		getEntityComponent ( ).addEntityToQueueOnAdditionForAddition ( new MissileLauncher ( new RelativePositionRotationComponent ( new Vector2 ( 10, 0 ),
																																 this,
																																 0 ),
																						 textureAtlas,
																						 getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																						 userInputSpaceShipComponent ) );
		getEntityComponent ( ).addEntityToQueueOnAdditionForAddition ( new MissileLauncher ( new RelativePositionRotationComponent ( new Vector2 ( 0,
																																				   15 ),
																																	 this,
																																	 0 ),
																							 textureAtlas,
																							 getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																							 userInputSpaceShipComponent ) );
		getEntityComponent ( ).addEntityToQueueOnAdditionForAddition ( new MissileLauncher ( new RelativePositionRotationComponent ( new Vector2 ( 0,
																																				   -15 ),
																																	 this,
																																	 0 ),
																							 textureAtlas,
																							 getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																							 userInputSpaceShipComponent ) );
	}
}
