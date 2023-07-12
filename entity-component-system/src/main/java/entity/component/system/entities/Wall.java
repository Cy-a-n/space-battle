package entity.component.system.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.ConstantMovementBehavior;
import entity.component.system.behaviors.VisualCollisionShapeBehavior;
import entity.component.system.components.CollisionShapeComponent;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.VelocityComponent;
import org.jetbrains.annotations.NotNull;

public class Wall extends Entity implements ConstantMovementBehavior, VisualCollisionShapeBehavior {
	private final @NotNull CollisionShapeComponent collisionShapeComponent;
	private final @NotNull VelocityComponent velocityComponent;
	private final @NotNull PositionRotationComponent positionRotationComponent;

	public Wall ( final int nonCollidingGroupId, @NotNull final Vector2 direction ) {
		final @NotNull Vector2 normalizedDirection = direction.nor ();

		this.collisionShapeComponent = new CollisionShapeComponent ( new Polygon ( new float[] { 0, 0, 8192, 0, 8192, 8192, 0, 8192 } ),
																	 Integer.MAX_VALUE,
																	 Integer.MAX_VALUE,
																	 Integer.MAX_VALUE,
																	 Integer.MAX_VALUE,
																	 nonCollidingGroupId );
		this.velocityComponent = new VelocityComponent ( normalizedDirection.cpy ().scl ( -50 ), 0 );
		this.positionRotationComponent = new PositionRotationComponent ( normalizedDirection.cpy ().scl ( 8192 ), 0 );
	}

	@Override public @NotNull CollisionShapeComponent getCollisionShapeComponent ( ) {
		return collisionShapeComponent;
	}

	@Override public @NotNull VelocityComponent getVelocityComponent ( ) {
		return velocityComponent;
	}

	@Override public @NotNull PositionRotationComponent getPositionRotationComponent ( ) {
		return positionRotationComponent;
	}
}
