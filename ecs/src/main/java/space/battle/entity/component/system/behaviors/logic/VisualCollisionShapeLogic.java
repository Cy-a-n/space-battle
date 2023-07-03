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
		shapeDrawer.setColor(Color.WHITE);
		for (VisualCollisionShapeBehavior entity : entities) {
			if (entity.positionChanged())
				entity.getShape().setPosition(entity.getPosition().x - entity.getOrigin().x, entity.getPosition().y - entity.getOrigin().y);

			if (entity.rotationChanged())
			 	entity.getShape().setRotation(entity.getRotationDegrees());

			if (entity.originChanged())
				entity.getShape().setOrigin(entity.getOrigin().x, entity.getOrigin().y);

			shapeDrawer.filledPolygon(entity.getShape().getTransformedVertices());
		}
	}
}
