package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.visitor.CommandVisitorInterface;

/**
 * Implementation of Job2dDriverCommand for setPosition command functionality.
 */
public class SetPositionCommand implements DriverCommand {

    private int posX, posY;

    public SetPositionCommand(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public void execute(Job2dDriver driver) {
        driver.setPosition(posX, posY);
    }

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }
}
