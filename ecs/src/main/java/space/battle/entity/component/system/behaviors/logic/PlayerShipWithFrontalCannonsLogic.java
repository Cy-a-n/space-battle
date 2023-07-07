package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import space.battle.entity.component.system.behaviors.interfaces.PlayerShipWithFrontalCannonsBehavior;
import space.battle.entity.component.system.behaviors.interfaces.ProjectileSpawnerBehavior;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.Gdx.input;

public class PlayerShipWithFrontalCannonsLogic {
	private Set<PlayerShipWithFrontalCannonsBehavior> entities = new HashSet<>();

	void addEntity (PlayerShipWithFrontalCannonsBehavior entity) {
		entities.add(entity);
	}

	void removeEntity (PlayerShipWithFrontalCannonsBehavior entity) {
		entities.remove(entity);
	}

	void update (TextureAtlas textureAtlas) throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		for (PlayerShipWithFrontalCannonsBehavior entity : entities) {
			switch (entity.getPlayerId()) {
				case PLAYER_ONE -> {
					if (input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
						BehaviorLogic.getInstance().addEntity(entity.getProjectileClass().getDeclaredConstructor(Vector2.class, float.class, Vector2.class, TextureAtlas.class).newInstance(entity.getPosition(), entity.getRotationDegrees(), entity.getVelocity(), textureAtlas));
					}
				}
			}
		}
	}
}
