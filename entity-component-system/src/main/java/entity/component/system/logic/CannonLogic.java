package entity.component.system.logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import entity.component.system.behaviors.CannonBehavior;
import entity.component.system.behaviors.ProjectileBehavior;
import entity.component.system.components.CannonComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.Gdx.input;

public class CannonLogic {
	private final @NotNull Set<CannonBehavior> entities = new HashSet<> ( );

	void addEntity ( final @NotNull CannonBehavior entity ) {
		entities.add ( entity );
		entity.getCannonComponent ( ).setMillisecondsOfLastProjectile ( 0 );
	}

	void removeEntity ( final @NotNull CannonBehavior entity ) {
		entities.remove ( entity );
	}

	void update ( TextureAtlas textureAtlas ) {
		for ( final @NotNull CannonBehavior entity : entities ) {
			final @NotNull CannonComponent cannonComponent = entity.getCannonComponent ( );

			if ( input.isKeyPressed ( entity.getUserInputSpaceShipComponent ( ).getPrimaryCannons ( ) ) &&
				 TimeUtils.timeSinceMillis ( cannonComponent.getMillisecondsOfLastProjectile ( ) ) >
				 cannonComponent.getMillisecondsPerProjectile ( ) ) {

				cannonComponent.setMillisecondsOfLastProjectile ( TimeUtils.millis ( ) );

				final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent ( );
				final float rotationDegrees = positionRotationComponent.getDegrees ( );

				try {
					ProjectileBehavior projectile = cannonComponent.getProjectile ( )
																   .getDeclaredConstructor ( PositionRotationComponent.class,
																							 VelocityComponent.class,
																							 int.class,
																							 TextureAtlas.class )
																   .newInstance ( new PositionRotationComponent ( positionRotationComponent.getPosition ( )
																																		   .cpy ( ),
																												  rotationDegrees ),
																				  new VelocityComponent ( new Vector2 ( cannonComponent.getTranslationalVelocity ( ),
																														0 ).rotateDeg (
																						  rotationDegrees ), 0 ),
																				  entity.getCollisionShapeComponent ( ).getNonCollidingGroupId ( ),
																				  textureAtlas );
				} catch ( InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e ) {
					throw new RuntimeException ( e );
				}
			}
		}
	}
}
