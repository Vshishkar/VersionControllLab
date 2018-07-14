package by.tc.vcl.controller.command;

import by.tc.vcl.controller.command.repository.RepositoryCreationCommand;
import by.tc.vcl.controller.command.user.UserRegistrationCommand;
import by.tc.vcl.controller.command.user.UserSignInCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandType {

    private static Map<String,Command> commands = new HashMap<>();

    static {
        commands.put("register",new UserRegistrationCommand());
        commands.put("login",new UserSignInCommand());
        commands.put("create_rep",new RepositoryCreationCommand());
    }

    public static Command getCommand(String key){
        return commands.get(key);
    }

}
