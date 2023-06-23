package space.battle.client.entities.components;

public class SpeedComponent {
    public int turnsPerStep;
    public int turnsSinceLastStep;

    public SpeedComponent(int turnsPerStep, int turnsSinceLastStep) {
        this.turnsPerStep = turnsPerStep;
        this.turnsSinceLastStep = 0;
    }
}
