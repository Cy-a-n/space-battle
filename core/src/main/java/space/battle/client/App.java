package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.components.UserInputSpaceShipComponent;
import entity.component.system.entities.GreenFighter;
import entity.component.system.logic.BehaviorLogic;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * Implementation of {@link com.badlogic.gdx.ApplicationListener} shared by all platforms.
 */
public class App extends ApplicationAdapter {
	private TextureAtlas textureAtlas;
	private SpriteBatch batch;
	private ShapeDrawer shapeDrawer;
	private OrthographicCamera camera0;
	private OrthographicCamera camera1;
	private Viewport viewport0;
	private Viewport viewport1;
	private BehaviorLogic behaviorLogic;

	@Override public void create ( ) {
		// Many libgdx types can only be instantiated in the create method since they rely on native libraries
		batch = new SpriteBatch ( );
		textureAtlas = new TextureAtlas ( "texture_atlas.atlas" );
		// Disable linear filtering for all textures in the atlas
		for ( Texture texture : textureAtlas.getTextures ( ) ) {
			texture.setFilter ( Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest );
		}
		shapeDrawer = new ShapeDrawer ( batch, textureAtlas.findRegion ( "white_pixel" ) );

		camera0 = new OrthographicCamera ( );
		camera1 = new OrthographicCamera ( );
		viewport0 = new FitViewport ( 512f, 512f, camera0 );
		viewport1 = new FitViewport ( 512f, 512f, camera1 );

		behaviorLogic = BehaviorLogic.getInstance ( );

		// Instance entities and add them to the ECS.
		new GreenFighter ( viewport0, textureAtlas, UserInputSpaceShipComponent.PLAYER_ONE, new Vector2 ( 128f, 0f ), 0 );
		new GreenFighter ( viewport1, textureAtlas, UserInputSpaceShipComponent.PLAYER_TWO, new Vector2 ( -128f, 0f ), 180 );
	}

	@Override public void render ( ) {
		ScreenUtils.clear ( new Color ( 0.05f, 0.05f, 0.05f, 1f ) );
		behaviorLogic.updateWithGraphics ( Gdx.graphics.getDeltaTime ( ), batch, shapeDrawer, new Viewport[] { viewport0, viewport1 },
										   textureAtlas );
	}

	@Override public void resize ( int width, int height ) {
		// Update the viewports
		viewport1.update ( width / 2, height, true );
		viewport0.update ( width / 2, height, true );

		viewport0.setScreenX ( 0 );
		viewport1.setScreenX ( width / 2 );
	}

	@Override public void dispose ( ) {
		// Many libgdx types have to be disposed because they rely on libraries (mainly lwjgl) that bind to C or C++
		// code (mainly OpenGL). The OS might or might not do this automatically, so it's good practice to dispose
		// them instead of risking crashes.

		// Flagging these objects for garbage collection is crucial since they may still hold references to instances
		// of these types.
		behaviorLogic = null;
		shapeDrawer = null;
		BehaviorLogic.disposeInstance ( );

		textureAtlas.dispose ( );
		batch.dispose ( );
		// Might be overkill or not do anything, but still...
		textureAtlas = null;
		batch = null;
		viewport0 = null;
		viewport1 = null;
		camera0 = null;
		camera1 = null;
	}
}
