package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;
import space.battle.entity.component.system.dataclasses.Origin;
import space.battle.entity.component.system.dataclasses.Position;
import space.battle.entity.component.system.dataclasses.Scale;
import space.battle.entity.component.system.dataclasses.Size;

public class TestEntity implements IsDrawable, IsCamera {
	private Position position;
	private TextureRegion textureRegion;
	private Origin origin;
	private Size size;
	private Scale scale;
	private float rotationDegrees;


	public TestEntity (Position position, TextureRegion textureRegion) {
		this.position = position;
		this.textureRegion = textureRegion;
	}

	public TestEntity (Position position, TextureRegion textureRegion, Origin origin, Size size, Scale scale,
					   float rotationDegrees) {
		this.position = position;
		this.textureRegion = textureRegion;
		this.origin = origin;
		this.size = size;
		this.scale = scale;
		this.rotationDegrees = rotationDegrees;
	}

	@Override
	public Position getPosition () {
		return position;
	}

	@Override
	public TextureRegion getTextureRegion () {
		return textureRegion;
	}

	@Override
	public Origin getOrigin () {
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
	public Scale getScale () {
		return scale;
	}

	@Override
	public Size getSize () {
		return size;
	}
}
