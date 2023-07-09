package entity.component.system.entities;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import entity.component.system.components.PositionRotationComponent;
import entity.component.system.components.RelativePositionRotationComponent;
import entity.component.system.components.TextureComponent;
import org.jetbrains.annotations.NotNull;

public class TestSpaceShipSubcomponent extends SpaceShipSubcomponent {
	public TestSpaceShipSubcomponent (final @NotNull RelativePositionRotationComponent relativePositionAndRotationBehavior, TextureAtlas textureAtlas) {
		super(new PositionRotationComponent(new Vector2(0, 0), 0), relativePositionAndRotationBehavior,
				new TextureComponent(textureAtlas.findRegion("green_fighter_by_stephen_challener_on_open_game_art")));
	}
}
