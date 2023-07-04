package space.battle.entity.component.system.entities;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.CameraBehavior;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;
import space.battle.entity.component.system.behaviors.logic.Entity;

public class SimpleShapeEntity extends Entity implements VisualCollisionShapeBehavior, CameraBehavior {
	private final Vector2 origin;
	private final Vector2 position;
	private final Polygon shape;
	private boolean positionChanged;
	private float rotationDegrees;
	private boolean rotationChanged;
	private boolean originChanged;

	public SimpleShapeEntity (Vector2 position, float rotationDegrees) {
		this.shape = new Polygon(new float[]{0, 0, 0, 0x88, 0x88, 0});
		this.origin = new Vector2(shape.getBoundingRectangle().width / 2, shape.getBoundingRectangle().height / 2);
		this.position = position;
		this.positionChanged = true;
		this.rotationDegrees = rotationDegrees;
		this.rotationChanged = true;
		this.originChanged = true;
	}

	@Override
	public @NotNull Vector2 getOrigin () {
		return origin;
	}

	@Override
	public boolean originChanged () {
		return originChanged;
	}

	@Override
	public void setOriginChanged (boolean originChanged) {
		this.originChanged = originChanged;
	}

	@Override
	public @NotNull Vector2 getPosition () {
		return position;
	}

	@Override
	public boolean positionChanged () {
		return positionChanged;
	}

	@Override
	public void setPositionChanged (boolean positionChanged) {
		this.positionChanged = positionChanged;
	}

	@Override
	public float getRotationDegrees () {
		return rotationDegrees;
	}

	@Override
	public void setRotationDegrees (float rotationDegrees) {
		this.rotationDegrees = rotationDegrees;
	}

	@Override
	public boolean rotationChanged () {
		return rotationChanged;
	}

	@Override
	public void setRotationChanged (boolean rotationChanged) {
		this.rotationChanged = rotationChanged;
	}

	@Override
	public @NotNull Polygon getShape () {
		return shape;
	}
}
