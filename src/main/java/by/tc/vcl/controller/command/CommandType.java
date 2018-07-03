package by.tc.vcl.controller.command;

import by.tc.vcl.controller.command.user.UserRegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandType {

    private static Map<String,Command> commands = new HashMap<>();

    static {
        commands.put("register",new UserRegistrationCommand());
    }

    public static Command getCommand(String key){
        return commands.get(key);
    }

}
