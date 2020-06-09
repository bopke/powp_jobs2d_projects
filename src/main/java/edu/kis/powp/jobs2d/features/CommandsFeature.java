package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.manager.LoggerCommandChangeObserver;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;

public class CommandsFeature {

    private static DriverCommandManager commandManager;

    public static void setupCommandManager() {
        commandManager = new DriverCommandManager();
        commandManager.setDriverManager(DriverFeature.getDriverManager());

        LoggerCommandChangeObserver loggerObserver = new LoggerCommandChangeObserver();
        commandManager.getChangePublisher().addSubscriber(loggerObserver);
    }

    /**
     * Get manager of application driver command.
     *
     * @return plotterCommandManager.
     */
    public static DriverCommandManager getDriverCommandManager() {
        return commandManager;
    }

    public static DriverCommand deepCopyDriverCommand(DriverCommand driverCommandToCopy) throws SerializationException {
        return SerializationUtils.clone(driverCommandToCopy);
    }
}
