package edu.kis.powp.jobs2d.command.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import edu.kis.powp.appbase.gui.WindowComponent;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindow extends JFrame implements WindowComponent {

    private DriverCommandManager commandManager;

    private JTextArea currentCommandField;

    private String observerListString;
    private JTextArea observerListField;

    private List<Subscriber> observers;
    private boolean isDeleted = false;

    /**
     *
     */
    private static final long serialVersionUID = 9204679248304669948L;

    public CommandManagerWindow(DriverCommandManager commandManager) {
        this.setTitle("Command Manager");
        this.setSize(400, 400);
        Container content = this.getContentPane();
        content.setLayout(new GridBagLayout());

        this.commandManager = commandManager;

        GridBagConstraints c = new GridBagConstraints();

        observerListField = new JTextArea("");
        observerListField.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(observerListField, c);
        updateObserverListField();

        currentCommandField = new JTextArea("");
        currentCommandField.setEditable(false);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(currentCommandField, c);
        updateCurrentCommandField();

        JButton btnClearCommand = new JButton("Clear command");
        btnClearCommand.addActionListener((ActionEvent e) -> this.clearCommand());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnClearCommand, c);

        JButton btnRunCommand = new JButton("Run command");
        btnRunCommand.addActionListener((ActionEvent e) -> this.runCommand());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnRunCommand, c);

        JButton btnHandleObservers = new JButton("Delete observers");
        btnHandleObservers.addActionListener((ActionEvent e) -> this.handleObservers(btnHandleObservers));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridx = 0;
        c.weighty = 1;
        content.add(btnHandleObservers, c);
    }

    public void handleObservers(JButton button) {
        if (this.isDeleted) {
            this.resetObservers();
            button.setText("Delete observers");
        } else {
            this.deleteObservers();
            button.setText("Reset observers");
        }

        this.updateObserverListField();
        this.isDeleted = !this.isDeleted;
    }

    private void clearCommand() {
        commandManager.clearCurrentCommand();
        updateCurrentCommandField();
    }

    private void runCommand() {
        commandManager.runCurrentCommand();
        updateCurrentCommandField();
    }

    public void updateCurrentCommandField() {
        currentCommandField.setText(commandManager.getCurrentCommandString());
    }

    public void deleteObservers() {
        this.observers = new ArrayList<>(this.commandManager.getChangePublisher().getSubscribers());
        commandManager.getChangePublisher().clearObservers();
    }

    private void updateObserverListField() {
        observerListString = "";
        List<Subscriber> commandChangeSubscribers = commandManager.getChangePublisher().getSubscribers();
        for (Subscriber observer : commandChangeSubscribers) {
            observerListString += observer.toString() + System.lineSeparator();
        }
        if (commandChangeSubscribers.isEmpty())
            observerListString = "No observers loaded";

        observerListField.setText(observerListString);
    }

    public void resetObservers() {
        if (this.observers != null && this.observers.size() > 0) {
            this.commandManager.getChangePublisher().clearObservers();
            this.addObservers(this.observers);
        }
    }

    private void addObservers(List<Subscriber> observers) {
        if (observers != null) {
            for (Subscriber observer : observers) {
                this.commandManager.getChangePublisher().addSubscriber(observer);
            }
        }
    }

    @Override
    public void HideIfVisibleAndShowIfHidden() {
        updateObserverListField();
        if (this.isVisible()) {
            this.setVisible(false);
        } else {
            this.setVisible(true);
        }
    }
    
}
