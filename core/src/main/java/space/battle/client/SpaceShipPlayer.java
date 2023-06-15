package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

class SpaceShipPlayer implements Entity {
    final private Sprite sprite = new Sprite(new Texture("space_ship_player.png"));

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    SpaceShipPlayer(float x, float y, float rotationDegrees) {
        sprite.setPosition(x, y);
        sprite.setRotation(rotationDegrees);
    }
}
