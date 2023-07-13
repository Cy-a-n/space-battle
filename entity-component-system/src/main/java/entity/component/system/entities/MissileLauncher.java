package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import entity.component.system.behaviors.VisualCollisionShapeBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class MissileLauncher extends Cannon implements VisualCollisionShapeBehavior {
	public MissileLauncher ( final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior,
						 final @NotNull TextureAtlas textureAtlas,
						 final int nonCollidingGroupId,
						 final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent ) {
		super ( relativePositionAndRotationBehavior,
				new TextureComponent ( textureAtlas.findRegion ( "missile_by_msavioti" ) ),
				new CannonComponent ( Missile.class, 500, 3000 ),
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 24, 4, 24, 9, 0, 13 } ), 1, 2, 50, 10, nonCollidingGroupId ),
				userInputSpaceShipComponent );
	}
}
