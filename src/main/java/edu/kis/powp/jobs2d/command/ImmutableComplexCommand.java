package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ImmutableComplexCommand implements ICompoundCommand {
    private final List<DriverCommand> driverCommands;
    
    /**
     * Creates immutable complex command from passed DriverCommands
     * 
     * @param commands - List containing DriverCommands
     */
    public ImmutableComplexCommand(List<DriverCommand> commands) {
        driverCommands = Collections.unmodifiableList(new ArrayList<DriverCommand>(commands));
    }
    
    /**
     * Creates immutable complex command from passed DriverCommands
     * 
     * @param commands - comma separated DriverCommands
     */
    public ImmutableComplexCommand(DriverCommand ... commands) {
        this(Arrays.asList(commands));
    }
    
    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : driverCommands) {
            command.execute(driver);
        }
    }
    
    @Override
    public Iterator<DriverCommand> iterator() {
        return driverCommands.iterator();
    }

    @Override
    public DriverCommand clone() throws CloneNotSupportedException {
        return ICompoundCommand.super.clone();
    }

}
