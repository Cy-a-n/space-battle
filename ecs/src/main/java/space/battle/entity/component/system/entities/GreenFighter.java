package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ChildrenWithRelativePositionAndRotationDegreesBehavior;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;
import com.badlogic.gdx.math.Vector2;
import space.battle.entity.component.system.behaviors.logic.Entity;

public class GreenFighter extends Entity implements PlayerShipBehavior, VisualCollisionShapeBehavior,
		ChildrenWithRelativePositionAndRotationDegreesBehavior {
	private final float frictionConstant;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 acceleration;
	private final @NotNull Vector2 position;
	private final @NotNull Vector2 velocity;
	private final @NotNull Polygon shape;
	private float rotationDegrees;
	private int health;
	private boolean positionChanged;
	private boolean rotationChanged;
	private boolean originChanged;

	public GreenFighter (@NotNull Vector2 position, float rotationDegrees, @NotNull TextureAtlas textureAtlas) {
		this.frictionConstant = 0.01f;
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.acceleration = new Vector2(0, 0);
		this.origin = new Vector2((float) textureRegion.getRegionWidth() / 2,
				(float) textureRegion.getRegionHeight() / 2);
		this.position = position;
		this.rotationDegrees = rotationDegrees;
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.velocity = new Vector2(0, 0);
		this.health = 10;
		this.shape = new Polygon(new float[]{0, 13, 2, 0, 29, 10, 34, 17, 29, 24, 2, 34, 0, 21});
		positionChanged = true;
		rotationChanged = true;
		originChanged = true;
	}

	@Override
	public @NotNull Vector2 getAcceleration () {
		return acceleration;
	}

	@Override
	public float getFrictionConstant () {
		return frictionConstant;
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
	public @NotNull Vector2 getScale () {
		return scale;
	}

	@Override
	public @NotNull Vector2 getSize () {
		return size;
	}

	@Override
	public @NotNull TextureRegion getTextureRegion () {
		return textureRegion;
	}

	@Override
	public @NotNull Vector2 getVelocity () {
		return velocity;
	}

	@Override
	public int getHealth () {
		return health;
	}

	@Override
	public void setHealth (int health) {
		this.health = health;
	}

	@Override
	public @NotNull Polygon getShape () {
		return shape;
	}
}
