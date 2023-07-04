package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.graphics.Color;
import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.VisualCollisionShapeBehavior;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;
import java.util.List;

class VisualCollisionShapeLogic {
	private final List<VisualCollisionShapeBehavior> entities = new ArrayList<>();

	void addEntity (@NotNull VisualCollisionShapeBehavior entity) {
		entities.add(entity);
	}

	void update (@NotNull ShapeDrawer shapeDrawer) {
		shapeDrawer.setColor(Color.DARK_GRAY);
		for (VisualCollisionShapeBehavior entity : entities) {
			shapeDrawer.filledRectangle(entity.getShape().getBoundingRectangle());
		}

		shapeDrawer.setColor(Color.WHITE);
		for (VisualCollisionShapeBehavior entity : entities) {
			shapeDrawer.filledPolygon(entity.getShape().getTransformedVertices());
		}
	}
}
