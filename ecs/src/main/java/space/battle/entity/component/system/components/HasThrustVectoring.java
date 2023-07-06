package space.battle.entity.component.system.components;

public interface HasThrustVectoring {
	float getThrustLeft ();

	float getThrustRight ();

	float getThrustDown ();

	float getThrustUp ();

	float getThrustClockwise ();

	float getThrustCounterclockwise ();
}