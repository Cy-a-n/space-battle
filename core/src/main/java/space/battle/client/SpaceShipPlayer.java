package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class SpaceShipPlayer implements Entity {
    private float x;
    private float y;
    private float rotation;
    final private Texture texture = new Texture("space_ship_player.png");

    @Override
    public float getX() {
        return x;
    }
    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getRotation() {
        return 0;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public SpaceShipPlayer(float x, float y, float rotation) {
        this.x = x;
        this.y = y;
    }
}
