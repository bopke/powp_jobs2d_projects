package edu.kis.powp.jobs2d.command.transformation;

public class CommandTransformationFlip extends CommandTransformation {

    private final boolean isHorizontal;

    public CommandTransformationFlip(boolean isHorizontal) {
        super();
        this.isHorizontal = isHorizontal;
    }

    @Override
    int transformXPoint(int x, int y) {
        return isHorizontal ? -x : x;
    }

    @Override
    int transformYPoint(int x, int y) {
        return isHorizontal ? y : -y;
    }
}
