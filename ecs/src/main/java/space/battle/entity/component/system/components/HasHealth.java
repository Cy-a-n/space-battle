package space.battle.entity.component.system.components;

public interface HasHealth {
	float getHealth ();

	void setHealth (float health);

	int getArmorClass ();

	int effectiveAgainstArmorClass ();
}
