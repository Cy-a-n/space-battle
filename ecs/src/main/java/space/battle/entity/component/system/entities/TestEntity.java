package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;
import space.battle.entity.component.system.behaviors.logic.Entity;
import space.battle.entity.component.system.components.HasRelativePosition;
import space.battle.entity.component.system.utilities.RelativePositionParentChildrenRelationship;

public class TestEntity extends Entity implements HasRelativePosition, TextureBehavior {
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull RelativePositionParentChildrenRelationship relativePositionParentChildrenRelationship;
	private @NotNull Vector2 position;
	private float rotationDegrees;

	public TestEntity (TextureAtlas textureAtlas) {
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.origin = new Vector2((float) textureRegion.getRegionWidth() / 2,
				(float) textureRegion.getRegionHeight() / 2);
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.position = new Vector2(0, 0);
		this.rotationDegrees = 0;
		this.relativePositionParentChildrenRelationship = new RelativePositionParentChildrenRelationship()
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
	public @NotNull RelativePositionParentChildrenRelationship relativePositionParentChildrenRelationship () {
		return null;
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
}
