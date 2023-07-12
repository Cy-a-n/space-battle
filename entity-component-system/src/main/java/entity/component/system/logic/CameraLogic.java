package entity.component.system.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import entity.component.system.behaviors.CameraBehavior;
import entity.component.system.behaviors.PositionRotationBehavior;
import entity.component.system.components.CameraComponent;
import entity.component.system.components.PositionRotationComponent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

class CameraLogic {
	private final @NotNull Set<CameraBehavior> entities = new HashSet<> ( );

	void addEntity ( final @NotNull CameraBehavior entity ) {
		entities.add ( entity );
	}

	void removeEntity ( final @NotNull CameraBehavior entity ) {
		entities.remove ( entity );
	}

	void update ( ) {
		for ( final CameraBehavior entity : entities ) {
			if ( entity.getEntityComponent ( ).isQueuedForRemoval ( ) )
				continue;

			final @NotNull CameraComponent cameraComponent = entity.getCameraComponent ( );
			final @NotNull OrthographicCamera camera = cameraComponent.getCamera ( );
			final @NotNull Vector3 cameraPosition = camera.position;
			final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent ( );
			final @NotNull Vector2 entityPosition = positionRotationComponent.getPosition ( );
			final @NotNull Set<PositionRotationBehavior> entitiesToAlwaysKeepInFrame = cameraComponent.getEntitiesAlwaysInFrame ( );
			float minX = entityPosition.x;
			float maxX = entityPosition.x;
			float minY = entityPosition.y;
			float maxY = entityPosition.y;
			final float rotationRadians = MathUtils.degreesToRadians * positionRotationComponent.getDegrees ( );

			for ( PositionRotationBehavior entityToAlwaysKeepInFrame : entitiesToAlwaysKeepInFrame ) {
				final @NotNull Vector2 entityToKeepInFramePosition = entityToAlwaysKeepInFrame.getPositionRotationComponent ( )
																							  .getPosition ( )
																							  .cpy ( );

				if ( entityToKeepInFramePosition.x < minX )
					minX = entityToKeepInFramePosition.x;
				if ( entityToKeepInFramePosition.x > maxX )
					maxX = entityToKeepInFramePosition.x;

				if ( entityToKeepInFramePosition.y < minY )
					minY = entityToKeepInFramePosition.y;
				if ( entityToKeepInFramePosition.y > maxY )
					maxY = entityToKeepInFramePosition.y;
			}

			// TODO: Potential for performance improvements
			camera.up.set ( 0, 1, 0 );
			camera.direction.set ( 0, 0, -1 );
			cameraPosition.x = ( minX + maxX ) / 2;
			cameraPosition.y = ( minY + maxY ) / 2;

			final float cameraWidth = Math.abs ( maxX - minX ) + 125;
			final float cameraHeight = Math.abs ( maxY - minY ) + 125 ;

			final float cameraWidthPerViewportWidth = cameraWidth / camera.viewportWidth;
			final float cameraHeightPerViewportHeight = cameraHeight / camera.viewportHeight;

			if (cameraWidthPerViewportWidth > cameraHeightPerViewportHeight) {
				camera.zoom = cameraWidthPerViewportWidth;
			} else {
				camera.zoom = cameraHeightPerViewportHeight;
			}
		}
	}
}
