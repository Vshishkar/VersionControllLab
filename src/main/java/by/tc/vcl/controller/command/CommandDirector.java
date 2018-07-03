package by.tc.vcl.controller.command;

public class CommandDirector {

    Command command;

    public CommandDirector(Command command) {
        this.command = command;
    }

    public CommandDirector(){

    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
