package edu.kis.powp.jobs2d.command.transformation;

public class CommandTransformationRotate extends CommandTransformation {
    private final double angle;

    public CommandTransformationRotate(double angle) {
        super();
        this.angle = Math.toRadians(angle);
    }

    @Override
    int transformXPoint(int x, int y) {
        return (int) (x * Math.cos(angle) - y * Math.sin(angle));
    }

    @Override
    int transformYPoint(int x, int y) {
        return (int) (x * Math.sin(angle) + y * Math.cos(angle));
    }
}
