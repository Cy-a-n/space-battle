package space.battle.client.entities;

import space.battle.client.entities.behaviors.IsCamera;
import space.battle.client.entities.behaviors.IsDrawable;
import space.battle.client.entities.components.CameraComponent;
import space.battle.client.entities.components.PositionComponent;
import space.battle.client.entities.components.TextureRegionComponent;

public class TestEntity extends Entity implements IsDrawable, IsCamera {
    private PositionComponent position;
    private TextureRegionComponent textureRegion;
    private CameraComponent camera;

    public TestEntity(PositionComponent position, TextureRegionComponent textureRegion) {
        this.position = position;
        this.textureRegion = textureRegion;
    }

    @Override
    public PositionComponent getPosition() {
        return position;
    }

    @Override
    public TextureRegionComponent getTextureRegion() {
        return textureRegion;
    }

    @Override
    public CameraComponent getCamera() {
        return camera;
    }
}
