package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.utils.ShapeCache;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.utils.ScreenUtils;
import space.earlygrey.shapedrawer.ShapeDrawer;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    TextureAtlas textureAtlas;
    SpriteBatch batch;
    ShapeDrawer shapeDrawer;
    OrthographicCamera camera;


    @Override
    public void create() {
        // Many libgdx types can only be instantiated in the create method, since they rely on native libraries
        textureAtlas = new TextureAtlas("texture_atlas.atlas");
        batch = new SpriteBatch();
        shapeDrawer = new ShapeDrawer(batch, textureAtlas.findRegion("white_pixel"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 256, 256);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0 , 0, 1);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        new SpaceShipPlayer(null, 0, 0,0 );
        batch.end();
    }


    @Override
    public void dispose() {
        // Many libgdx types have to be disposed, because they rely on libraries (mainly lwjgl) that bind to c or c++ code (mainly opengl).
        // The OS might or might not do this automatically, so it's good practice to make sure to dispose them all.
        textureAtlas.dispose();
        batch.dispose();
    }
}
