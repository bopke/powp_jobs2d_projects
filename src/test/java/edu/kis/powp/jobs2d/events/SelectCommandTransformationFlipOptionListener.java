package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.transformation.CommandTransformation;
import edu.kis.powp.jobs2d.command.transformation.CommandTransformationFlip;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCommandTransformationFlipOptionListener implements ActionListener {
    boolean isHorizontal;

    public SelectCommandTransformationFlipOptionListener (boolean isHorizontal) {
        this.isHorizontal = isHorizontal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager driverCommandManager = CommandsFeature.getDriverCommandManager();

        CommandTransformation commandTransformation = new CommandTransformationFlip(this.isHorizontal);
        driverCommandManager.getCurrentCommand().accept(commandTransformation);
        ICompoundCommand iCompoundCommand = commandTransformation.getCompoundCommand();

        driverCommandManager.setCurrentCommand(iCompoundCommand);
    }
}