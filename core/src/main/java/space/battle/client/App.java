package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import space.battle.entity.component.system.behaviors.logic.BehaviorLogic;
import space.battle.entity.component.system.entities.GreenFighter;
import space.battle.entity.component.system.entities.StaticEntity;
import space.battle.entity.component.system.entities.TestEntity;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashSet;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
	TextureAtlas textureAtlas;
	SpriteBatch batch;
	ShapeDrawer shapeDrawer;
	OrthographicCamera camera;
	BehaviorLogic behaviorLogic;

	@Override
	public void create () {
		// Many libgdx types can only be instantiated in the create method, since they rely on native libraries
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("texture_atlas.atlas");
		// Disable linear filtering for all textures in the atlas
		for (Texture texture : textureAtlas.getTextures()) {
			texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
		}
		shapeDrawer = new ShapeDrawer(batch, textureAtlas.findRegion("white_pixel"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, (float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);

		behaviorLogic = BehaviorLogic.getInstance();

		GreenFighter greenFighter = new GreenFighter(new Vector2(0, 0), 180f, textureAtlas);
		behaviorLogic.addEntity(greenFighter);
		behaviorLogic.addEntity(new TestEntity(textureAtlas, greenFighter));
		behaviorLogic.addEntity(new StaticEntity(new Vector2(0, 0), 0f, textureAtlas));

		Integer int1 = Integer.valueOf(0);
		Integer int2 = Integer.valueOf(1);
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		HashSet<HashSet<Integer>> set3 = new HashSet<>();
	}

	@Override
	public void render () {
		ScreenUtils.clear(new Color(0.05f, 0.05f, 0.05f, 1f));
		behaviorLogic.updateWithGraphics(Gdx.graphics.getDeltaTime(), batch, shapeDrawer, camera);
	}

	@Override
	public void dispose () {
		// Many libgdx types have to be disposed, because they rely on libraries (mainly lwjgl) that bind to c or c++
		// code (mainly opengl). The OS might or might not do this automatically, so it's good practice to dispose
		// them instead of risking crashes.

		// Flagging these objects for garbage collection is crucial, since they may still hold references to instances
		// of these types.
		behaviorLogic = null;
		shapeDrawer = null;
		BehaviorLogic.disposeInstance();

		textureAtlas.dispose();
		batch.dispose();
		// Might be overkill or not do anything, but still...
		textureAtlas = null;
		batch = null;
	}
}
