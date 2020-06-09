package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.visitor.CommandVisitorInterface;

import java.io.Serializable;

/**
 * DriverCommand interface.
 */
public interface DriverCommand extends Cloneable, Serializable {

    /**
     * Execute command on driver.
     *
     * @param driver driver.
     */
    public void execute(Job2dDriver driver);


    void accept(CommandVisitor visitor);
}
