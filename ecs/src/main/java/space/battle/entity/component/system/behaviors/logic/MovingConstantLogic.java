package space.battle.entity.component.system.behaviors.logic;

import org.jetbrains.annotations.NotNull;
import space.battle.entity.component.system.behaviors.interfaces.IsMovingConstant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MovingConstantLogic {
	private static Set<IsMovingConstant> movingEntities = new HashSet<>();

	public static Set<IsMovingConstant> getMovingEntities () {
		return Collections.unmodifiableSet(movingEntities);
	}

	static void addMovingEntity (@NotNull IsMovingConstant movingEntity) {
		movingEntities.add(movingEntity);
	}

	static void update (float deltaTimeSeconds) {
		for (IsMovingConstant movingEntity : movingEntities) {
			movingEntity.getPosition().setX(movingEntity.getPosition().getX() + movingEntity.getVelocity().getX() * deltaTimeSeconds);
			System.out.println(movingEntity.getPosition().getX() + movingEntity.getVelocity().getX() * deltaTimeSeconds);
			movingEntity.getPosition().setY(movingEntity.getPosition().getY() + movingEntity.getVelocity().getY() * deltaTimeSeconds);
		}
	}
}
