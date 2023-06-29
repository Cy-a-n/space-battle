package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.RelativePositionAndRotationBehavior;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;
import space.battle.entity.component.system.components.HasChildrenWithRelativePosition;
import space.battle.entity.component.system.components.HasChildrenWithRelativeRotationDegrees;
import space.battle.entity.component.system.components.HasPosition;
import space.battle.entity.component.system.components.HasRotationDegrees;

public class TestEntity extends Entity implements RelativePositionAndRotationBehavior, TextureBehavior {
	private @NotNull Vector2 position;
	private float rotationDegrees;
	private final float relativeRotationDegrees;
	private final @NotNull TextureRegion textureRegion;
	private final @NotNull Vector2 relativePosition;
	private final @NotNull Vector2 origin;
	private final @NotNull Vector2 scale;
	private final @NotNull Vector2 size;
	private final @NotNull HasChildrenWithRelativePosition parentWithPosition;
	private final @NotNull HasChildrenWithRelativeRotationDegrees parentWithRotationDegrees;

	public TestEntity (TextureAtlas textureAtlas, HasChildrenWithRelativePosition parentWithPosition,
					   HasChildrenWithRelativeRotationDegrees parentWithRotationDegrees) {
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.relativePosition = new Vector2(100, 100);
		this.parentWithPosition = parentWithPosition;
		this.origin = new Vector2((float) textureRegion.getRegionWidth() / 2,
				(float) textureRegion.getRegionHeight() / 2);
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.position = new Vector2(0, 0);
		this.rotationDegrees = 0;
		relativeRotationDegrees = 90;
		this.parentWithRotationDegrees = parentWithRotationDegrees;
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
	public float getRelativeRotationDegrees () {
		return relativeRotationDegrees;
	}

	@Override
	public void setRelativeRotationDegrees (float relativeRotationDegrees) {
		return;
	}

	@Override
	public HasChildrenWithRelativeRotationDegrees getParentWithRotationDegrees() {
		return parentWithRotationDegrees;
	}

	@Override
	public @NotNull HasChildrenWithRelativePosition getParentWithPosition () {
		return parentWithPosition;
	}
}
