package space.battle.client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

class SpaceShipPlayer implements Entity {

    private ArrayList<Entity> childEntities;
    private float x, y, rotationDegrees;
    final private int width = 32;
    final private int height = 16;



    @Override
    public ArrayList<Entity> getChildEntities() {
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

    public SpaceShipPlayer(ArrayList<Entity> childEntities, float x, float y, float rotationDegrees) {
        this.childEntities = (childEntities == null)? new ArrayList<Entity>() : childEntities;
        this.childEntities.ensureCapacity(16);
        this.x = x;
        this.y = y;
        this.rotationDegrees = rotationDegrees;
    }

    @Override
    public void updateBeforePhysicsSimulation() {

    }

    @Override
    public void updateAfterPhysicsSimulation() {

    }

    @Override
    public void drawShapes(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(x, y, 0, 0, width, height, 0, 0, rotationDegrees, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN);
    }

    @Override
    public void drawTexture(SpriteBatch batch) {

    }
}
