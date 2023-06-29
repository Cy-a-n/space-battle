package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.Color;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.VisualShapeBehavior;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;
import java.util.List;

public class VisualShapeLogic {
	private final List<VisualShapeBehavior> entities = new ArrayList<>();

	void addEntity (@NotNull VisualShapeBehavior entity) {
		entities.add(entity);
	}

	void update (@NotNull ShapeDrawer shapeDrawer) {
		for (VisualShapeBehavior entity : entities) {
			shapeDrawer.setColor(Color.WHITE);
			entity.getShape().setPosition(entity.getPosition().x, entity.getPosition().y);
			shapeDrawer.filledPolygon(entity.getShape().getTransformedVertices());
		}
	}
}
