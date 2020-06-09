package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectLoadTestCommand implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        List<DriverCommand> commands = new ArrayList<DriverCommand>();
        commands.add(new SetPositionCommand(-180, -40));
        commands.add(new OperateToCommand(-180, 50));
        commands.add(new SetPositionCommand(-180, -40));
        commands.add(new OperateToCommand(-140, -40));
        commands.add(new SetPositionCommand(-140, -40));
        commands.add(new OperateToCommand(-140, 0));
        commands.add(new SetPositionCommand(-140, 0));
        commands.add(new OperateToCommand(-180, 0));

        commands.add(new SetPositionCommand(-50, -30));
        commands.add(new OperateToCommand(-50, -40));
        commands.add(new SetPositionCommand(-50, -40));
        commands.add(new OperateToCommand(-110, -40));
        commands.add(new SetPositionCommand(-110, -40));
        commands.add(new OperateToCommand(-110, 50));
        commands.add(new SetPositionCommand(-110, 50));
        commands.add(new OperateToCommand(-50, 50));
        commands.add(new SetPositionCommand(-50, 50));
        commands.add(new OperateToCommand(-50, 5));
        commands.add(new SetPositionCommand(-50, 5));
        commands.add(new OperateToCommand(-80, 5));

        commands.add(new SetPositionCommand(50, -40));
        commands.add(new OperateToCommand(50, 50));
        commands.add(new SetPositionCommand(50, -40));
        commands.add(new OperateToCommand(90, -40));
        commands.add(new SetPositionCommand(50, -40));
        commands.add(new OperateToCommand(10, -40));

        commands.add(new SetPositionCommand(110, 50));
        commands.add(new OperateToCommand(110, -40));
        commands.add(new SetPositionCommand(110, -40));
        commands.add(new OperateToCommand(140, 0));
        commands.add(new SetPositionCommand(140, 0));
        commands.add(new OperateToCommand(170, -40));
        commands.add(new SetPositionCommand(170, -40));
        commands.add(new OperateToCommand(170, 50));
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(commands, "TestCommand");
    }
}
