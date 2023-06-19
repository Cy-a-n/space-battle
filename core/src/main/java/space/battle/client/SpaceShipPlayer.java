package space.battle.client;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;

class SpaceShipPlayer implements Entity {

    final private int width = 32;
    final private int height = 16;
    private ArrayList<Entity> childEntities;
    private float x, y, rotationDegrees;


    public SpaceShipPlayer(ArrayList<Entity> childEntities, float x, float y, float rotationDegrees) {
        this.childEntities = (childEntities == null) ? new ArrayList<Entity>() : childEntities;
        this.childEntities.ensureCapacity(16);
        this.x = x;
        this.y = y;
        this.rotationDegrees = rotationDegrees;
    }

    @Override
    public ArrayList<Entity> getChildEntities() {
        return childEntities;
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
    public void update() {

    }


    @Override
    public void draw(SpriteBatch batch, ShapeDrawer shapeDrawer) {
        shapeDrawer.rectangle(x, y, width, height, 1, rotationDegrees);
    }
}
