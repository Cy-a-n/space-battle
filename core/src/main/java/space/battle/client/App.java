package space.battle.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.utils.ShapeCache;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.battle.client.entities.TestEntity;
import space.battle.client.entities.behaviors.BehaviorLogic;
import space.battle.client.entities.components.PositionComponent;
import space.battle.client.entities.components.TextureRegionComponent;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
    TextureAtlas textureAtlas;
    SpriteBatch batch;
    OrthographicCamera camera;
    private Viewport viewport;


    @Override
    public void create() {
        // Many libgdx types can only be instantiated in the create method, since they rely on native libraries
        textureAtlas = new TextureAtlas("texture_atlas.atlas");
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 1000);

        // Instantiate initial entities
        BehaviorLogic.addEntity(new TestEntity(new PositionComponent(0, 0), new TextureRegionComponent(textureAtlas.findRegion("test_entity"))));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
    }


    @Override
    public void dispose() {
        // Many libgdx types have to be disposed, because they rely on libraries (mainly lwjgl) that bind to c or c++ code (mainly opengl).
        // The OS might or might not do this automatically, so it's good practice to make sure to dispose them all.
        textureAtlas.dispose();
        batch.dispose();
    }
}
