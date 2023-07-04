package space.battle.entity.component.system.behaviors.logic;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import space.battle.entity.component.system.behaviors.interfaces.CollisionShapeBehavior;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CollisionShapeLogic {
	private List<CollisionShapeBehavior> entities = new ArrayList<>();

	void addEntity (CollisionShapeBehavior entity) {
		entities.add(entity);
	}

	void update () {
		// Update each entity's position, rotation, and origin based on its current state
		for (CollisionShapeBehavior entity : entities) {
			if (entity.positionChanged())
				entity.getShape().setPosition(entity.getPosition().x - entity.getOrigin().x,
						entity.getPosition().y - entity.getOrigin().y);

			if (entity.rotationChanged())
				entity.getShape().setRotation(entity.getRotationDegrees());

			if (entity.originChanged())
				entity.getShape().setOrigin(entity.getOrigin().x, entity.getOrigin().y);
		}

		// Check each pair of entities for possible collisions
		for (int i = 0; i < entities.size(); i++) {
			CollisionShapeBehavior entity0 = entities.get(i);
			Polygon shape0 = entity0.getShape();

			for (int j = i + 1; j < entities.size(); j++) {
				CollisionShapeBehavior entity1 = entities.get(j);
				Polygon shape1 = entity1.getShape();

				// If the bounding boxes of the two entities overlap, then check for a more precise collision using
				// the Separating Axis Theorem (SAT)
				if (shape1.getBoundingRectangle().overlaps(shape0.getBoundingRectangle())) {
					if (areIntersecting(shape0, shape1)) {
						System.out.println("test");
					}
				}
			}
		}
	}

	// Check if two polygons are intersecting by applying the Separating Axis Theorem (SAT)
	private boolean areIntersecting (Polygon shape1, Polygon shape2) {
		float[] vertices1 = shape1.getTransformedVertices();
		float[] vertices2 = shape2.getTransformedVertices();

		// Project all points of both polygons onto a series of axes perpendicular to the edges of the polygons
		for (int i = 0; i < vertices1.length; i += 2) {
			float x1 = vertices1[i];
			float y1 = vertices1[i + 1];

			float x2, y2;
			if (i + 2 < vertices1.length) {
				x2 = vertices1[i + 2];
				y2 = vertices1[i + 3];
			} else {
				x2 = vertices1[0];
				y2 = vertices1[1];
			}

			float axisX = y1 - y2;
			float axisY = x2 - x1;

			// If there exists an axis along which the projections of the two polygons do not overlap, then the
			// polygons do not intersect
			if (!overlap(axisX, axisY, vertices1, vertices2)) {
				return false;
			}
		}

		return true;
	}

	// Check if the projections of the two polygons overlap along the given axis
	private boolean overlap (float axisX, float axisY, float[] vertices1, float[] vertices2) {
		float min1 = project(axisX, axisY, vertices1[0], vertices1[1]);
		float max1 = min1;
		for (int i = 2; i < vertices1.length; i += 2) {
			float p = project(axisX, axisY, vertices1[i], vertices1[i + 1]);
			if (p < min1) {
				min1 = p;
			} else if (p > max1) {
				max1 = p;
			}
		}

		float min2 = project(axisX, axisY, vertices2[0], vertices2[1]);
		float max2 = min2;
		for (int i = 2; i < vertices2.length; i += 2) {
			float p = project(axisX, axisY, vertices2[i], vertices2[i + 1]);
			if (p < min2) {
				min2 = p;
			} else if (p > max2) {
				max2 = p;
			}
		}

		return !(min1 > max2 || max1 < min2);
	}

	// Project a point onto an axis
	private float project (float axisX, float axisY, float x, float y) {
		float dotProduct = (x * axisX + y * axisY) / (axisX * axisX + axisY * axisY);
		return dotProduct * axisX + dotProduct * axisY;
	}
}
