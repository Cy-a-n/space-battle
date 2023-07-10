package entity.component.system.logic;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.behaviors.CannonBehavior;
import entity.component.system.behaviors.ProjectileBehavior;
import entity.component.system.components.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.Gdx.input;

public class CannonLogic {
	private final @NotNull Set<CannonBehavior> entities = new HashSet<> ();

	void addEntity (final @NotNull CannonBehavior entity) {
		entities.add (entity);
	}

	void removeEntity (final @NotNull CannonBehavior entity) {
		entities.remove (entity);
	}

	void update (TextureAtlas textureAtlas) {
		for (final @NotNull CannonBehavior entity : entities) {
			if (input.isKeyPressed (entity.getUserInputSpaceShipComponent ()
											.getPrimaryCannons ())) {
				final @NotNull PositionRotationComponent positionRotationComponent = entity.getPositionRotationComponent ();
				final float rotationDegrees = positionRotationComponent.getDegrees ();

				try {
					ProjectileBehavior projectile = entity.getCannonComponent ()
							.getProjectile ()
							.getDeclaredConstructor (PositionRotationComponent.class,
													 VelocityComponent.class,
													 int.class,
													 TextureAtlas.class)
							.newInstance (new PositionRotationComponent (positionRotationComponent.getPosition ()
																				 .cpy (),
																		 rotationDegrees),
										  new VelocityComponent (new Vector2 (entity.getCannonComponent ()
																					  .getTranslationalVelocity (),
																			  0).rotateDeg (rotationDegrees),
																 0),
										  entity.getCollisionShapeComponent ()
												  .getNonCollidingGroupId (),
										  textureAtlas);
				} catch (InstantiationException e) {
					throw new RuntimeException (e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException (e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException (e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException (e);
				}
			}
		}
	}
}
