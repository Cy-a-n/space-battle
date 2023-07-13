package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

public class Missile extends Projectile {
	public Missile ( final @NotNull PositionRotationComponent positionRotationComponent,
						 final @NotNull VelocityComponent velocityComponent,
						 final int nonCollidingGroupId,
						 final @NotNull TextureAtlas textureAtlas ) {
		super ( positionRotationComponent,
				velocityComponent,
				new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 24, 4, 24, 9, 0, 13 } ), 3, 3, 5, 300, nonCollidingGroupId ),
				new TextureComponent ( textureAtlas.findRegion ( "missile_by_msavioti" ) ),
				new LifeTimeComponent ( 50000 ) );
	}
}
