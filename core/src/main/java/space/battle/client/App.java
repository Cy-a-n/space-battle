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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import entity.component.system.components.CameraComponent;
import entity.component.system.components.CollisionShapeComponent;
import entity.component.system.components.UserInputSpaceShipComponent;
import entity.component.system.entities.GreenFighter;
import entity.component.system.entities.Observer;
import entity.component.system.entities.Wall;
import entity.component.system.logic.BehaviorLogic;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * Implementation of {@link com.badlogic.gdx.ApplicationListener} shared by all platforms.
 */
public class App extends ApplicationAdapter {
	private TextureAtlas textureAtlas;
	private SpriteBatch batch;
	private ShapeDrawer shapeDrawer;
	private Viewport observerViewport;
	private Viewport player0Viewport;
	private Viewport player1Viewport;
	private OrthographicCamera observerCamera;
	private OrthographicCamera player0Camera;
	private OrthographicCamera player1Camera;
	private int screenWidth;
	private int screenHeight;
	private int observerViewportWidthHeight;
	private int playerViewportWidth;
	private int playerViewportHeight;
	private float playerViewportRelativeWidth;
	private float observerViewportRelativeWidth;

	@Override public void create ( ) {
		// Many libgdx types can only be instantiated in the create method since they rely on native libraries
		batch = new SpriteBatch ( );
		textureAtlas = new TextureAtlas ( "texture_atlas.atlas" );
		// Disable linear filtering for all textures in the atlas
		for ( Texture texture : textureAtlas.getTextures ( ) ) {
			texture.setFilter ( Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest );
		}
		shapeDrawer = new ShapeDrawer ( batch, textureAtlas.findRegion ( "white_pixel" ) );

		// Initialize values
		screenWidth = Gdx.graphics.getWidth ( );
		screenHeight = Gdx.graphics.getHeight ( );
		observerViewportWidthHeight = screenHeight;
		playerViewportWidth = ( screenWidth - observerViewportWidthHeight ) / 2;
		playerViewportHeight = screenHeight;
		playerViewportRelativeWidth = ( float ) playerViewportWidth / screenWidth;
		observerViewportRelativeWidth = ( float ) observerViewportWidthHeight / screenWidth;

		observerCamera = new OrthographicCamera ( );
		player0Camera = new OrthographicCamera ( );
		player1Camera = new OrthographicCamera ( );

		observerViewport = new ExtendViewport ( observerViewportWidthHeight, observerViewportWidthHeight, observerCamera );
		player0Viewport = new ExtendViewport ( playerViewportWidth, playerViewportHeight, player0Camera );
		player1Viewport = new ExtendViewport ( playerViewportWidth, playerViewportHeight, player1Camera );

		spawnEntities ( );
	}

	private void spawnEntities ( ) {
		// Spawn the players.
		GreenFighter player0 = new GreenFighter ( new CameraComponent ( player0Viewport ),
												  textureAtlas,
												  UserInputSpaceShipComponent.PLAYER_ONE,
												  new Vector2 ( -150f, 0f ),
												  0 );
		GreenFighter player1 = new GreenFighter ( new CameraComponent ( player1Viewport ),
												  textureAtlas,
												  UserInputSpaceShipComponent.PLAYER_TWO,
												  new Vector2 ( 150f, 0f ),
												  180 );
		BehaviorLogic.getInstance ( ).queueForAddition ( player0 );
		BehaviorLogic.getInstance ( ).queueForAddition ( player1 );
		BehaviorLogic.getInstance ( ).queueForAddition ( new Observer ( new CameraComponent ( observerViewport, player0, player1 ), player0 ) );

		// Spawn the kill zone.
		final int nonCollidingGroupId = CollisionShapeComponent.getUniqueNonCollidingGroupId ( );
		BehaviorLogic.getInstance ( ).queueForAddition ( new Wall ( nonCollidingGroupId, new Vector2 ( 1, 0 ) ) );
		BehaviorLogic.getInstance ( ).queueForAddition ( new Wall ( nonCollidingGroupId, new Vector2 ( -1, 0 ) ) );
		BehaviorLogic.getInstance ( ).queueForAddition ( new Wall ( nonCollidingGroupId, new Vector2 ( 0, 1 ) ) );
		BehaviorLogic.getInstance ( ).queueForAddition ( new Wall ( nonCollidingGroupId, new Vector2 ( 0, -1 ) ) );
	}

	@Override public void render ( ) {
		ScreenUtils.clear ( new Color ( 0.05f, 0.05f, 0.05f, 1f ) );
		BehaviorLogic.getInstance ( ).updateWithGraphics ( Gdx.graphics.getDeltaTime ( ),
														   batch,
														   shapeDrawer,
														   new Viewport[] { observerViewport, player0Viewport, player1Viewport },
														   textureAtlas );
	}

	@Override public void resize ( int width, int height ) {
		final int newPlayerViewportWidth = ( int ) ( width * playerViewportRelativeWidth );

		// Update the viewports
		observerViewport.update ( ( int ) ( width * observerViewportRelativeWidth ), height, true );
		player1Viewport.update ( newPlayerViewportWidth, height, true );
		player0Viewport.update ( newPlayerViewportWidth, height, true );

		player0Viewport.setScreenX ( 0 );
		observerViewport.setScreenX ( ( int ) ( newPlayerViewportWidth ) );
		player1Viewport.setScreenX ( ( int ) ( width - newPlayerViewportWidth ) );
	}

	@Override public void dispose ( ) {
		// Many libgdx types have to be disposed because they rely on libraries (mainly lwjgl) that bind to C or C++
		// code (mainly OpenGL). The OS might or might not do this automatically, so it's good practice to dispose
		// them instead of risking crashes.

		// Flagging these objects for garbage collection is crucial since they may still hold references to instances
		// of these types.
		shapeDrawer = null;
		BehaviorLogic.disposeInstance ( );

		textureAtlas.dispose ( );
		batch.dispose ( );
		// Might be overkill or not do anything, but still...
		textureAtlas = null;
		batch = null;
		player0Viewport = null;
		player1Viewport = null;
		player0Camera = null;
		player1Camera = null;
	}
}
