package space.battle.client;

import com.badlogic.gdx.graphics.Texture;

class SpaceShip implements Entity {
    private float x;
    private float y;
    final private Texture texture = new Texture("space_ship.png");

    @Override
    public float getX() {
        return x;
    }
    @Override
    public float getY() {
        return y;
    }
    @Override
    public Texture getTexture() {
        return texture;
    }

    public SpaceShip(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
