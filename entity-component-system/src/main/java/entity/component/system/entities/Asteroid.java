package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import entity.component.system.behaviors.CollisionShapeBehavior;
import entity.component.system.behaviors.ConstantMovementBehavior;
import entity.component.system.behaviors.TextureBehavior;
import entity.component.system.components.CollisionShapeComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.TextureComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

public class Asteroid extends Entity implements ConstantMovementBehavior, TextureBehavior, CollisionShapeBehavior {
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;
	private final @NotNull CollisionShapeComponent collisionShapeComponent;
	private final @NotNull TextureComponent textureComponent;

	public Asteroid ( @NotNull final PositionRotationComponent positionRotationComponent,
					  @NotNull final VelocityComponent velocityComponent,
					  final @NotNull TextureAtlas textureAtlas ) {
		this.velocityComponent = velocityComponent;
		this.positionRotationComponent = positionRotationComponent;
		this.collisionShapeComponent = new CollisionShapeComponent ( new Polygon ( new float[] { 3,
																								 56,
																								 19,
																								 18,
																								 88,
																								 4,
																								 108,
																								 10,
																								 118,
																								 110,
																								 64,
																								 124,
																								 11,
																								 101 } ),
																	 1,
																	 1,
																	 30,
																	 80,
																	 CollisionShapeComponent.getUniqueNonCollidingGroupId ( ) );
		this.textureComponent = new TextureComponent ( textureAtlas.findRegion ( "asteroid" ) );
	}

	@Override public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}

	@Override public @NotNull CollisionShapeComponent getCollisionShapeComponent ( ) {
		return collisionShapeComponent;
	}

	@Override public @NotNull TextureComponent getTextureComponent ( ) {
		return textureComponent;
	}
}
