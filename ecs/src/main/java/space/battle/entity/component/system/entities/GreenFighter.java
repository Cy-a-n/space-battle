package space.battle.entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipBehavior;
import space.battle.entity.component.system.behaviors.interfaces.VisualShapeBehavior;
import com.badlogic.gdx.math.Vector2;

public class GreenFighter extends Entity implements PlayerShipBehavior, VisualShapeBehavior {
	private final float frictionConstant;
	private Vector2 acceleration;
	private Vector2 origin;
	private Vector2 position;
	private float rotationDegrees;
	private Vector2 scale;
	private Vector2 size;
	private TextureRegion textureRegion;
	private Vector2 velocity;
	private int health;
	private Polygon shape;

	public GreenFighter (Vector2 position, float rotationDegrees, TextureAtlas textureAtlas) {
		this.frictionConstant = 0.2f;
		this.textureRegion = textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art");
		this.acceleration = new Vector2(0, 0);
		this.origin = new Vector2((float) -textureRegion.getRegionWidth() / 2,
				(float) -textureRegion.getRegionHeight() / 2);
		this.position = position;
		this.rotationDegrees = rotationDegrees;
		this.scale = new Vector2(1, 1);
		this.size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
		this.velocity = new Vector2(0, 0);
		this.health = 10;
		this.shape = new Polygon(new float[]{100, 100, 100, -100, -100, -100, -100, 100});
	}

	@Override
	public Vector2 getAcceleration () {
		return acceleration;
	}

	@Override
	public float getFrictionConstant () {
		return frictionConstant;
	}

	@Override
	public Vector2 getOrigin () {
		return origin;
	}

	@Override
	public Vector2 getPosition () {
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
	public Vector2 getScale () {
		return scale;
	}

	@Override
	public Vector2 getSize () {
		return size;
	}

	@Override
	public TextureRegion getTextureRegion () {
		return textureRegion;
	}

	@Override
	public Vector2 getVelocity () {
		return velocity;
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
	public Polygon getShape () {
		return shape;
	}
}
