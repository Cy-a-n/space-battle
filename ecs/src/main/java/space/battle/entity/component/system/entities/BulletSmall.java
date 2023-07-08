package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ProjectileBehavior;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;

public class BulletSmall implements ProjectileBehavior, VisualCollisionShapeBehavior {
	private final Vector2 origin;
	private final Vector2 position;
	private final Vector2 scale;
	private final Vector2 size;
	private final TextureRegion textureRegion;
	private final Vector2 velocity;
	private final int armorClass;
	private final int effectiveAgainstArmorClass;
	private final Polygon shape;
	private boolean originChanged;
	private boolean positionChanged;
	private float rotationDegrees;
	private boolean rotationChanged;
	private float health;
	private int teamId;

	public BulletSmall (@NotNull Vector2 position, float rotationDegrees, @NotNull Vector2 velocity,
						@NotNull TextureAtlas textureAtlas, int teamId) {
		this.textureRegion = textureAtlas.findRegion("bullet_small");
		this.teamId = teamId;
		this.origin = new Vector2((float) textureRegion.getRegionWidth() / 2,
				(float) textureRegion.getRegionHeight() / 2);
		this.originChanged = true;
		this.position = position;
		this.positionChanged = true;
		this.rotationDegrees = rotationDegrees;
		this.rotationChanged = true;
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.velocity = velocity;
		this.health = 10;
		this.armorClass = 1;
		this.effectiveAgainstArmorClass = 1;
		this.shape = new Polygon(new float[]{0, 0, 16, 0, 16, 3, 0, 3});
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
	public float getHealth () {
		return health;
	}

	@Override
	public void setHealth (float health) {
		this.health = health;
	}

	@Override
	public int getArmorClass () {
		return armorClass;
	}

	@Override
	public int getEffectiveAgainstArmorClass () {
		return effectiveAgainstArmorClass;
	}

	@Override
	public @NotNull Polygon getCollisionShape () {
		return shape;
	}

	@Override
	public int getTeamId () {
		return teamId;
	}

	@Override
	public void setTeamId (int teamId) {
		this.teamId = teamId;
	}
}
