package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.battle.entity.component.system.behaviors.interfaces.IsCamera;
import space.battle.entity.component.system.behaviors.interfaces.IsDrawable;
import space.battle.entity.component.system.behaviors.interfaces.IsMovingConstant;
import space.battle.entity.component.system.dataclasses.*;

public class TestEntity implements IsDrawable, IsMovingConstant {
	private Position position;
	private TextureRegion textureRegion;
	private Origin origin;
	private Size size;
	private Scale scale;
	private float rotationDegrees;
	private Velocity velocity;


	public TestEntity (Position position, TextureRegion textureRegion, Velocity velocity) {
		this.position = position;
		this.textureRegion = textureRegion;
		this.velocity = velocity;
	}

	public TestEntity (Position position, TextureRegion textureRegion, Origin origin, Size size, Scale scale,
					   float rotationDegrees, Velocity velocity) {
		this.position = position;
		this.textureRegion = textureRegion;
		this.origin = origin;
		this.size = size;
		this.scale = scale;
		this.rotationDegrees = rotationDegrees;
		this.velocity = velocity;
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

	@Override
	public Velocity getVelocity () {
		return velocity;
	}
}
