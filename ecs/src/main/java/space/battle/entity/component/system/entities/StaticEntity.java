package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.TextureBehavior;
import com.badlogic.gdx.math.Vector2;
import space.battle.entity.component.system.behaviors.logic.Entity;

public class StaticEntity extends Entity implements TextureBehavior {
	private Vector2 origin;
	private Vector2 position;
	private float rotationDegrees;
	private Vector2 scale;
	private Vector2 size;
	private TextureRegion textureRegion;

	public StaticEntity (Vector2 position, float rotationDegrees, TextureAtlas textureAtlas) {
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.origin = new Vector2(-textureRegion.getRegionWidth() / 2, -textureRegion.getRegionHeight() / 2);
		this.position = position;
		this.rotationDegrees = rotationDegrees;
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
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
}
