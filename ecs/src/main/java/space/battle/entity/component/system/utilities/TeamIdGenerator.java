package space.battle.entity.component.system.utilities;

public class TeamIdGenerator {
	private static int teamIdCounter = 0;

	public static int getNextTeamID () {
		return teamIdCounter++;
	}
}
