package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.behaviors.ParentWithPositionRotationBehavior;
import entity.component.system.components.*;
import entity.component.system.logic.BehaviorLogic;
import org.jetbrains.annotations.NotNull;

public class GreenFighter extends SpaceShipLocalPlayer implements ParentWithPositionRotationBehavior {
	public GreenFighter ( final @NotNull CameraComponent cameraComponent,
						  final @NotNull TextureAtlas textureAtlas,
						  final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent,
						  final @NotNull Vector2 position,
						  final float rotationDegrees ) {
		super ( new TextureComponent ( textureAtlas.findRegion ( "green_fighter_by_stephen_challener_on_open_game_art" ) ),
				new PositionRotationComponent ( position, rotationDegrees ),
				new VelocityComponent ( new Vector2 ( 0, 0 ), 0 ),
				new AccelerationComponent ( new Vector2 ( 0, 0 ), 0, 0.01f, 0.03f ),
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 13, 2, 0, 29, 10, 34, 15, 34, 19, 29, 24, 2, 34, 0, 21 } ),
											  3,
											  2,
											  50,
											  25,
											  CollisionShapeComponent.getUniqueNonCollidingGroupId ( ) ),
				cameraComponent,
				new DirectionalThrustComponent ( 300, 250, 150, 150, 50, 50 ),
				userInputSpaceShipComponent );
		getEntityComponent ( ).addEntityToQueueOnAddition ( new CannonGreen ( new RelativePositionRotationComponent ( new Vector2 ( 0, 10 ),
																													  this,
																													  0 ),
																			  textureAtlas,
																			  getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																			  userInputSpaceShipComponent ) );

		getEntityComponent ( ).addEntityToQueueOnAddition ( new CannonGreen ( new RelativePositionRotationComponent ( new Vector2 ( 0, -10 ),
																													  this,
																													  0 ),
																			  textureAtlas,
																			  getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																			  userInputSpaceShipComponent ) );
	}
}
