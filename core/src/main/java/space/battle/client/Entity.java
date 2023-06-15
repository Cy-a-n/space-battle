package space.battle.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

interface Entity {
    float getCenterX();
    float getCenterY();
    int getCenterWidth();
    float getRotationDegrees();
    Sprite getTexture();

}
