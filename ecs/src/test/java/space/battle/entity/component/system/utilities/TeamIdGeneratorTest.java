package space.battle.entity.component.system.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamIdGeneratorTest {
	@Test
	void getNextTeamID () {
		for (int i = 0; i < 1000; i++)
			assertEquals(TeamIdGenerator.getNextTeamID(), i);
	}
}