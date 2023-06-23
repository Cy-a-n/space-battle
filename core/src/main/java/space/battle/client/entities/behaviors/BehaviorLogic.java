package space.battle.client.entities.behaviors;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import space.battle.client.entities.Entity;
import space.battle.client.entities.components.HasCamera;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BehaviorLogic {
    private static final List<IsCamera> cameras = new ArrayList<>();
    private static final List<IsDrawable> drawables = new ArrayList<>();
    private static IsCamera mainCamera;

    public static void addEntity(Entity entity) {
        if (entity instanceof IsDrawable)
            drawables.add((IsDrawable) entity);

        if (entity instanceof IsCamera) {
            cameras.add((IsCamera) entity);
            if (cameras.size() == 1) {
                mainCamera = cameras.get(0);
            }
        }


    }

    public static void updateCamera(OrthographicCamera camera) {
        if (mainCamera != null) {
            camera.position.x = mainCamera.getPosition().x;
            camera.position.y = mainCamera.getPosition().y;
        }
        camera.update();
    }

    public static void draw(SpriteBatch batch, OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (IsDrawable drawable : drawables) {
            batch.draw(drawable.getTextureRegion().textureRegion, drawable.getPosition().x, drawable.getPosition().y);
        }
        batch.end();
    }
}
