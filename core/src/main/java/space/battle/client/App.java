package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.battle.entity.component.system.behaviors.logic.BehaviorLogic;
import space.battle.entity.component.system.components.HasPlayerInput;
import space.battle.entity.component.system.entities.BulletSmall;
import space.battle.entity.component.system.entities.GreenFighter;
import space.battle.entity.component.system.entities.TestEntity;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
	TextureAtlas textureAtlas;
	SpriteBatch batch;
	ShapeDrawer shapeDrawer;
	OrthographicCamera camera0;
	OrthographicCamera camera1;
	Viewport viewport0;
	Viewport viewport1;
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

		camera0 = new OrthographicCamera();
		camera1 = new OrthographicCamera();
		viewport0 = new FitViewport((float) 512, 512, camera0);
		viewport1 = new FitViewport((float) 512, 512, camera1);

		behaviorLogic = BehaviorLogic.getInstance();

		GreenFighter greenFighter = new GreenFighter(new Vector2(-50, -50), 0f, textureAtlas,
				HasPlayerInput.PlayerId.PLAYER_ONE);
		// Set up the entities
		behaviorLogic.addEntity(greenFighter);
		behaviorLogic.addEntity(new TestEntity(textureAtlas, greenFighter));
		behaviorLogic.addEntity(new GreenFighter(new Vector2(50, 50), 0f, textureAtlas,
				HasPlayerInput.PlayerId.PLAYER_TWO));
		behaviorLogic.addEntity(new BulletSmall(new Vector2(0, 0), 0f, new Vector2(10, 0), textureAtlas, teamHash));
	}

	@Override
	public void render () {
		ScreenUtils.clear(new Color(0.05f, 0.05f, 0.05f, 1f));
		behaviorLogic.updateWithGraphics(Gdx.graphics.getDeltaTime(), batch, shapeDrawer, camera0, camera1, viewport0,
				viewport1, textureAtlas);
	}

	@Override
	public void resize (int width, int height) {
		// Update the viewports
		viewport1.update(width / 2, height, true);
		viewport0.update(width / 2, height, true);

		viewport0.setScreenX(0);
		viewport1.setScreenX(width / 2);
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
