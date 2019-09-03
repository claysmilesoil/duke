public class Parser {

    public static Command parse(String fullCommand) {
        if (fullCommand.equals("list")) {
            return new Command(Command.CommandType.listCommand);
        } else if (fullCommand.equals(("bye"))) {
            return new Command(Command.CommandType.exitCommand);
        } else if (fullCommand.equals("help")) {
            return new Command(Command.CommandType.helpCommand);
        } else if (fullCommand.indexOf("todo") == 0) {
            return new Command(Command.CommandType.addTodo, fullCommand);
        } else if (fullCommand.indexOf("deadline") == 0) {
            return new Command(Command.CommandType.addDeadline, fullCommand);
        } else if (fullCommand.indexOf("event") == 0) {
            return new Command(Command.CommandType.addEvent, fullCommand);
        } else if (fullCommand.indexOf("delete") == 0) {
            return new Command(Command.CommandType.deleteCommand, fullCommand);
        } else if (fullCommand.indexOf("done") == 0) {
            return new Command(Command.CommandType.doneCommand, fullCommand);
        } else if (fullCommand.indexOf("find") == 0) {
            return new Command(Command.CommandType.findCommand, fullCommand);
        } else {
            return new Command(Command.CommandType.invalidInput);
        }
    }
}
