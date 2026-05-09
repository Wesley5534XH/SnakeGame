package snakegame.directions;

public enum Direction {

    UP(180),
    DOWN(0),
    LEFT(270),
    RIGHT(90);

    private final double angle;

    Direction(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }
}