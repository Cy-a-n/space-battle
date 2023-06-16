package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    SpriteBatch batch;
    OrthographicCamera camera;
    private SpaceShipPlayer spaceShipPlayer;

    @Override
    public void create() {
        // A lot of libgdx objects can only be instantiated in the create method, since they rely on native libraries
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 256, 256);
        batch = new SpriteBatch();


        // Initialize attributes
        spaceShipPlayer = new SpaceShipPlayer(null, 100f, 100f, 0f);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0 , 0, 1);


        // Update the camera
        camera.zoom = 20f;
        camera.update();

        
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
