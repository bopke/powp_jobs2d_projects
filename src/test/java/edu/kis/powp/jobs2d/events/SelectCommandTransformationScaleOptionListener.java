package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.transformation.CommandTransformation;
import edu.kis.powp.jobs2d.command.transformation.CommandTransformationScale;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCommandTransformationScaleOptionListener implements ActionListener {
    double scaleFactorX;
    double scaleFactorY;

    public SelectCommandTransformationScaleOptionListener (double scaleFactorX, double scaleFactorY) {
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager driverCommandManager = CommandsFeature.getDriverCommandManager();

        CommandTransformation commandTransformation = new CommandTransformationScale(this.scaleFactorX, this.scaleFactorY);
        driverCommandManager.getCurrentCommand().accept(commandTransformation);
        ICompoundCommand iCompoundCommand = commandTransformation.getCompoundCommand();

        driverCommandManager.setCurrentCommand(iCompoundCommand);
    }
}
