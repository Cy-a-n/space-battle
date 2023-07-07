package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;
import com.badlogic.gdx.math.Vector2;
import space.battle.entity.component.system.components.HasPlayerInput;

public class GreenFighter implements PlayerShipWithFrontalCannonsBehavior, VisualCollisionShapeBehavior {
	private final float frictionConstant;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 acceleration;
	private final @NotNull Vector2 position;
	private final @NotNull Vector2 velocity;
	private final @NotNull Polygon shape;
	private final int armorClass;
	private final int effectiveAgainstArmorClass;
	private final float rotationalFrictionConstant;
	private final float thrustLeft;
	private final float thrustRight;
	private final float thrustDown;
	private final float thrustUp;
	private final float thrustCounterclockwise;
	private final float thrustClockwise;
	private final PlayerId playerId;
	private final Class<? extends ProjectileBehavior> projectileClass;
	private final float projectilesPerMinute;
	private final float timeOfLastProjectile;
	private float rotationDegrees;
	private float health;
	private boolean positionChanged;
	private boolean rotationChanged;
	private boolean originChanged;
	private float rotationalVelocity;
	private float rotationalAcceleration;

	public GreenFighter (@NotNull Vector2 position, float rotationDegrees, @NotNull TextureAtlas textureAtlas,
						 PlayerId playerId) {
		this.playerId = playerId;
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
		health = 100;
		armorClass = 1;
		effectiveAgainstArmorClass = 1;
		rotationalVelocity = 0;
		rotationalAcceleration = 0;
		rotationalFrictionConstant = 0.01f;
		thrustLeft = 50;
		thrustRight = 100;
		thrustDown = 50;
		thrustUp = 50;
		thrustClockwise = 20;
		thrustCounterclockwise = 20;
		projectileClass = BulletSmall.class;
		projectilesPerMinute = 0.5f;
		timeOfLastProjectile = 0;
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
	public @NotNull Polygon getShape () {
		return shape;
	}

	@Override
	public float getRotationalAcceleration () {
		return rotationalAcceleration;
	}

	@Override
	public void setRotationalAcceleration (float rotationalAcceleration) {
		this.rotationalAcceleration = rotationalAcceleration;
	}

	@Override
	public float getRotationalVelocity () {
		return rotationalVelocity;
	}

	@Override
	public void setRotationalVelocity (float rotationalVelocity) {
		this.rotationalVelocity = rotationalVelocity;
	}

	@Override
	public float getRotationalFrictionConstant () {
		return rotationalFrictionConstant;
	}

	@Override
	public float getThrustLeft () {
		return thrustLeft;
	}

	@Override
	public float getThrustRight () {
		return thrustRight;
	}

	@Override
	public float getThrustDown () {
		return thrustDown;
	}

	@Override
	public float getThrustUp () {
		return thrustUp;
	}

	@Override
	public float getThrustClockwise () {
		return thrustClockwise;
	}

	@Override
	public float getThrustCounterclockwise () {
		return thrustCounterclockwise;
	}

	@Override
	public @NotNull HasPlayerInput.PlayerId getPlayerId () {
		return playerId;
	}

	@Override
	public Class<? extends ProjectileBehavior> getProjectileClass () {
		return projectileClass;
	}

	@Override
	public float getProjectilesPerMinute () {
		return projectilesPerMinute;
	}

	@Override
	public float getTimeOfLastProjectile () {
		return timeOfLastProjectile;
	}
}
