package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class CannonGreen extends Cannon {
	public CannonGreen ( final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior,
						 final @NotNull TextureAtlas textureAtlas,
						 final int nonCollidingGroupId,
						 final @NotNull UserInputSpaceShipComponent userInputSpaceShipComponent ) {
		super ( relativePositionAndRotationBehavior,
				new TextureComponent ( textureAtlas.findRegion ( "green_cannon" ) ),
				new CannonComponent ( BulletSmall.class, 500, 60 ),
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 15, 2, 15, 9, 0, 10 } ), 1, 2, 10, 10, nonCollidingGroupId ),
				userInputSpaceShipComponent );
	}
}
