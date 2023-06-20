package space.battle.client.entities;

class Entity2D extends Entity {
    float relativeX;
    float relativeY;
    float rotationRadians;

    /**
     * Returns the X coordinate of the entity.
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the Y coordinate of the entity.
     */
    public float getY() {
        return y;
    }

    /**
     * Returns the rotation of the entity in degrees.
     */
    public float getRotationRadians() {
        return rotationRadians;
    }
}
