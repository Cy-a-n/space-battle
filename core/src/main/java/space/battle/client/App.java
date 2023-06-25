package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.battle.entity.component.system.behaviors.logic.BehaviorLogic;
import space.battle.entity.component.system.dataclasses.Vector2;
import space.battle.entity.component.system.entities.GreenFighter;
import space.battle.entity.component.system.entities.StaticEntity;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
	TextureAtlas textureAtlas;
	SpriteBatch batch;
	ShapeDrawer shapeDrawer;
	OrthographicCamera camera;
	private Viewport viewport;


	@Override
	public void create () {
		// Many libgdx types can only be instantiated in the create method, since they rely on native libraries
		textureAtlas = new TextureAtlas("texture_atlas.atlas");
		batch = new SpriteBatch();
		shapeDrawer = new ShapeDrawer(batch, textureAtlas.findRegion("white_pixel"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1000, 1000);

		BehaviorLogic.addEntityWithGraphics(new GreenFighter(new Vector2(0, 0), 0f, textureAtlas));
		BehaviorLogic.addEntityWithGraphics(new StaticEntity(new Vector2(100, 100), 0f, textureAtlas));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		BehaviorLogic.updateWithGraphics(Gdx.graphics.getDeltaTime(), batch, camera);
	}


	@Override
	public void dispose () {
		// Many libgdx types have to be disposed, because they rely on libraries (mainly lwjgl) that bind to c or c++
		// code (mainly opengl).
		// The OS might or might not do this automatically, so it's good practice to make sure to dispose them all.
		textureAtlas.dispose();
		batch.dispose();
	}
}
