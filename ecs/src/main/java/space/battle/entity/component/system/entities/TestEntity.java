package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.ChildrenWithRelativePositionAndRotationDegreesBehavior;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionAndRotationBehavior;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;
import space.battle.entity.component.system.behaviors.interfaces.Entity;
import space.battle.entity.component.system.components.HasChildrenWithRelativeRotationDegrees;

public class TestEntity implements RelativePositionAndRotationBehavior, TextureBehavior {
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull Vector2 position;
	private final @NotNull Vector2 relativePosition;
	private final @NotNull ChildrenWithRelativePositionAndRotationDegreesBehavior parentWithRelativePosition;
	private final HasChildrenWithRelativeRotationDegrees parentWithRelativeRotationDegrees;
	private boolean positionChanged;
	private boolean rotationChanged;
	private float relativeRotationDegrees;
	private float rotationDegrees;
	private boolean originChanged;

	public TestEntity (@NotNull TextureAtlas textureAtlas,
					   @NotNull ChildrenWithRelativePositionAndRotationDegreesBehavior parent) {
		this.relativeRotationDegrees = 90;
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.parentWithRelativePosition = parent;
		this.parentWithRelativeRotationDegrees = parent;
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
	public @NotNull ChildrenWithRelativePositionAndRotationDegreesBehavior getParentWithPosition () {
		return parentWithRelativePosition;
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
	public @NotNull HasChildrenWithRelativeRotationDegrees getParentWithRotationDegrees () {
		return parentWithRelativeRotationDegrees;
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
}
