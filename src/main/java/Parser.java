public class Parser {

    public static Command parse(String fullCommand) {
        if (fullCommand.equals("list")) {
            return new Command(Command.CommandType.LIST);
        } else if (fullCommand.equals(("bye"))) {
            return new Command(Command.CommandType.EXIT);
        } else if (fullCommand.equals("help")) {
            return new Command(Command.CommandType.HELP);
        } else if (fullCommand.indexOf("todo") == 0) {
            return new Command(Command.CommandType.TODO, fullCommand);
        } else if (fullCommand.indexOf("deadline") == 0) {
            return new Command(Command.CommandType.DEADLINE, fullCommand);
        } else if (fullCommand.indexOf("event") == 0) {
            return new Command(Command.CommandType.EVENT, fullCommand);
        } else if (fullCommand.indexOf("delete") == 0) {
            return new Command(Command.CommandType.DELETE, fullCommand);
        } else if (fullCommand.indexOf("done") == 0) {
            return new Command(Command.CommandType.DONE, fullCommand);
        } else if (fullCommand.indexOf("find") == 0) {
            return new Command(Command.CommandType.FIND, fullCommand);
        } else {
            return new Command(Command.CommandType.INVALID);
        }
    }
}
