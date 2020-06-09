package edu.kis.powp.jobs2d.command.transformation;

import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.command.visitor.CommandVisitorInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandTransformation implements CommandVisitorInterface {
    private final List<DriverCommand> driverCommandList;

    public CommandTransformation() {
        driverCommandList = new ArrayList<>();
    }

    public ICompoundCommand getCompoundCommand() {
        return new DefaultCompoundCommand(driverCommandList);
    }

    @Override
    public void visit(SetPositionCommand setPositionCommand) {
        int transformedXPoint = transformXPoint(setPositionCommand.getPosX(), setPositionCommand.getPosY());
        int transformedYPoint = transformYPoint(setPositionCommand.getPosX(), setPositionCommand.getPosY());

        driverCommandList.add(new SetPositionCommand(transformedXPoint, transformedYPoint));
    }

    @Override
    public void visit(OperateToCommand operateToCommand) {
        int transformedXPoint = transformXPoint(operateToCommand.getPosX(), operateToCommand.getPosY());
        int transformedYPoint = transformYPoint(operateToCommand.getPosX(), operateToCommand.getPosY());

        driverCommandList.add(new OperateToCommand(transformedXPoint, transformedYPoint));
    }

    @Override
    public void visit(ICompoundCommand iCompoundCommand){
        for (DriverCommand driverCommand : iCompoundCommand) {
            driverCommand.accept(this);
        }
    }

    abstract int transformXPoint(int x, int y);
    abstract int transformYPoint(int x, int y);
}
