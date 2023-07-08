package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.*;

public class TestEntity implements RelativePositionAndRotationBehavior, TextureBehavior, VisualCollisionShapeBehavior {
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull Vector2 position;
	private final @NotNull Vector2 relativePosition;
	private final @NotNull ParentWithRelativePositionAndRotationDegreesBehavior parentWithRelativePositionAndRotationDegreesBehavior;
	private final Polygon collisionShape;
	private final int armorClas;
	private final int effectiveAgainstArmorClass;
	private boolean positionChanged;
	private boolean rotationChanged;
	private float relativeRotationDegrees;
	private float rotationDegrees;
	private boolean originChanged;
	private int teamId;
	private float health;

	public TestEntity (@NotNull TextureAtlas textureAtlas,
					   @NotNull ParentWithRelativePositionAndRotationDegreesBehavior parent, int teamId) {
		this.relativeRotationDegrees = 90;
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.parentWithRelativePositionAndRotationDegreesBehavior = parent;
		this.origin = new Vector2((float) textureRegion.getRegionWidth() / 2,
				(float) textureRegion.getRegionHeight() / 2);
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.position = new Vector2(0, 0);
		this.rotationDegrees = 0;
		this.relativePosition = new Vector2(100, 100);

		positionChanged = true;
		rotationChanged = true;
		originChanged = true;
		collisionShape = new Polygon(new float[]{0, 13, 2, 0, 29, 10, 34, 17, 29, 24, 2, 34, 0, 21});
		this.teamId = teamId;
		armorClas = 1;
		effectiveAgainstArmorClass = 1;
		health = 100;
	}

	@Override
	public @NotNull Vector2 getPosition () {
		return position;
	}

	@Override
	public @NotNull Vector2 getRelativePosition () {
		return relativePosition;
	}

	@Override
	public @NotNull Vector2 getOrigin () {
		return origin;
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
	public ParentWithRelativePositionAndRotationDegreesBehavior getParentWithPositionAndRotationDegrees () {
		return parentWithRelativePositionAndRotationDegreesBehavior;
	}

	@Override
	public float getRelativeRotationDegrees () {
		return relativeRotationDegrees;
	}

	@Override
	public void setRelativeRotationDegrees (float relativeRotationDegrees) {
		this.relativeRotationDegrees = relativeRotationDegrees;
	}

	@Override
	public boolean positionChanged () {
		return positionChanged;
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
	public void setPositionChanged (boolean positionChanged) {
		this.positionChanged = positionChanged;
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
	public @NotNull Polygon getCollisionShape () {
		return collisionShape;
	}

	@Override
	public int getTeamId () {
		return teamId;
	}

	@Override
	public void setTeamId (int teamId) {
		this.teamId = teamId;
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
		return armorClas;
	}

	@Override
	public int getEffectiveAgainstArmorClass () {
		return effectiveAgainstArmorClass;
	}
}
