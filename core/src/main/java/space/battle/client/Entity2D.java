package space.battle.client;

interface Entity2D extends Entity {
    /**
     * Returns the X coordinate of the entity.
     */
    float getX();

    /**
     * Returns the Y coordinate of the entity.
     */
    float getY();

    /**
     * Returns the rotation of the entity in degrees.
     */
    float getRotationDegrees();
}
