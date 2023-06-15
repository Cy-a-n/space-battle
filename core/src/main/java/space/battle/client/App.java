package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    OrthographicCamera camera;
    private SpaceShipPlayer spaceShipPlayer;
    SpriteBatch batch;

    @Override
    public void create() {
        // A lot of libgdx objects can only be instantiated in the create method, since they rely on native libraries
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 256, 256);
        batch = new SpriteBatch();

        // Initialize attributes
        spaceShipPlayer = new SpaceShipPlayer(0, 0, 0);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0 , 0, 1);

        camera.position.x = spaceShipPlayer.getSprite().getX();
        camera.position.y = spaceShipPlayer.getSprite().getY();


        // Update the camera
        camera.update();

        // Set the projection matrix of the SpriteBatch to the camera's combined matrix
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        spaceShipPlayer.getSprite().draw(batch);
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
