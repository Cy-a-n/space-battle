package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import entity.component.system.components.*;
import entity.component.system.logic.BehaviorLogic;
import org.jetbrains.annotations.NotNull;

public class BulletSmall extends Projectile {
	public BulletSmall ( final @NotNull PositionRotationComponent positionRotationComponent,
						 final @NotNull VelocityComponent velocityComponent,
						 final int nonCollidingGroupId,
						 final @NotNull TextureAtlas textureAtlas ) {
		super ( positionRotationComponent,
				velocityComponent,
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 15, 0, 15, 3, 0, 3 } ), 1, 1, 10, 10, nonCollidingGroupId ),
				new TextureComponent ( textureAtlas.findRegion ( "bullet_small" ) ),
				new LifeTimeComponent ( 5000 ) );

		BehaviorLogic.getInstance ( ).queueForAddition ( this );
	}
}
