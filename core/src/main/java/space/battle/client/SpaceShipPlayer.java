package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;-
import java.util.ArrayList;

class SpaceShipPlayer implements Entity {

    private ArrayList<Entity> childEntities;
    private float x, y, rotationDegrees;
    private int width, height;
    final private Texture texture = new Texture("space_ship_player.png");



    @Override
    public List<Entity> getChildEntities() {
        return childEntities;
    }

    @Override
    public float getCenterX() {
        return x;
    }

    @Override
    public float getCenterY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public float getRotationDegrees() {
        return rotationDegrees;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    public SpaceShipPlayer(List<Entity> childEntities, float x, float y, float rotationDegrees, int width, int height) {
        this.childEntities = (childEntities == null)? new List<Entity>() :
        this.x = x;
        this.y = y;
        this.rotationDegrees = rotationDegrees;
        this.width = width;
        this.height = height;
    }

    @Override
    public void updateBeforePhysicsSimulation() {

    }

    @Override
    public void updateAfterPhysicsSimulation() {

    }

    @Override
    public void draw(SpriteBatch batch) {

    }
}
