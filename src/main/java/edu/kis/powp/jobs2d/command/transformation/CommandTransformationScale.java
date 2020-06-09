package edu.kis.powp.jobs2d.command.transformation;

public class CommandTransformationScale extends CommandTransformation {
    private final double scaleFactorX;
    private final double scaleFactorY;

    public CommandTransformationScale(double scaleFactorX, double scaleFactorY) {
        super();
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
    }

    @Override
    int transformXPoint(int x, int y) {
        return (int) (x * this.scaleFactorX);
    }

    @Override
    int transformYPoint(int x, int y) {
        return (int) (y * this.scaleFactorY);
    }
}