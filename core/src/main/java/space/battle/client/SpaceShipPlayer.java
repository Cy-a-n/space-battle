package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

class SpaceShipPlayer implements Entity {
    float centerX
    final private Texture texture = new Texture("space_ship_player.png");

    @Override
    public float getCenterX() {
        return 0;
    }

    @Override
    public float getCenterY() {
        return 0;
    }

    @Override
    public int getCenterWidth() {
        return 0;
    }

    @Override
    public float getRotationDegrees() {
        return 0;
    }

    @Override
    public Sprite getTexture() {
        return null;
    }

    SpaceShipPlayer(float x, float y, float rotationDegrees) {
    }
}
