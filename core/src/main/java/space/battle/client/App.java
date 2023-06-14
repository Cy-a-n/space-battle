package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    OrthographicCamera camera;
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    SpriteBatch batch;

    @Override
    public void create() {
        // A lot of libgdx objects can only be instantiated in the create method, since they rely on native libraries
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        batch = new SpriteBatch();

        entities.add(new SpaceShipPlayer(0,0,0));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0 , 0, 1);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose() {

    }
}
