package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.battle.entity.component.system.behaviors.logic.BehaviorLogic;
import space.battle.entity.component.system.entities.GreenFighter;
import space.battle.entity.component.system.entities.StaticEntity;
import space.earlygrey.shapedrawer.ShapeDrawer;

import static com.badlogic.gdx.Gdx.input;

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
		camera.setToOrtho(false, 512, 512);

		behaviorLogic = new BehaviorLogic();

		behaviorLogic.addEntityWithGraphics(new GreenFighter(new Vector2(0, 0), 0f, textureAtlas));
		behaviorLogic.addEntityWithGraphics(new StaticEntity(new Vector2(100, 100), 0f, textureAtlas));
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLUE);
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

		textureAtlas.dispose();
		batch.dispose();
		// Might be overkill or not do anything, but still...
		textureAtlas = null;
		batch = null;
	}
}
