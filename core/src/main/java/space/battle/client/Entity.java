package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

interface Entity {
    float getX();
    float getY();
    float getRotation();
    Texture getTexture();
    void draw(SpriteBatch batch);
}
