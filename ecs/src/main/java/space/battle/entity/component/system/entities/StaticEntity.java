package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;
import com.badlogic.gdx.math.Vector2;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;
import space.battle.entity.component.system.behaviors.interfaces.Entity;

public class StaticEntity implements TextureBehavior, VisualCollisionShapeBehavior {
	private Vector2 origin;
	private Vector2 position;
	private float rotationDegrees;
	private Vector2 scale;
	private Vector2 size;
	private TextureRegion textureRegion;
	private boolean positionChanged;
	private boolean rotationChanged;
	private boolean originChanged;
	private Polygon shape;
	private int health;

	public StaticEntity (Vector2 position, float rotationDegrees, TextureAtlas textureAtlas) {
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.origin = new Vector2(-textureRegion.getRegionWidth() / 2, -textureRegion.getRegionHeight() / 2);
		this.position = position;
		this.rotationDegrees = rotationDegrees;
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.shape = new Polygon(new float[]{0, 13, 2, 0, 29, 10, 34, 17, 29, 24, 2, 34, 0, 21});
		positionChanged = true;
		rotationChanged = true;
		originChanged = true;
		health = 100;
	}

	@Override
	public @NotNull Vector2 getOrigin () {
		return origin;
	}

	@Override
	public @NotNull Vector2 getPosition () {
		return position;
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
	public @NotNull Polygon getShape () {
		return shape;
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
	public int getArmorClass () {
		return 1;
	}

	@Override
	public int effectiveAgainstArmorClass () {
		return 2;
	}
}
