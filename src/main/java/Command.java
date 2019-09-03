public class Command {
    private CommandType command;
    private String processedInput;
    private boolean exit;

    public enum CommandType {
        listCommand, exitCommand, helpCommand, addTodo, addDeadline, addEvent, deleteCommand, doneCommand, findCommand, invalidInput
    }

    public Command(CommandType command) {
        this.command = command;
        this.exit = false;
    }
    public Command(CommandType command, String processedInput) {
        this.command = command;
        this.processedInput = processedInput;
        this.exit = false;
    }

    public void execute (Ui ui) {
        if (this.command == CommandType.listCommand) {
            ui.getList();
        } else if (this.command == CommandType.exitCommand) {
            this.exit = true;
            ui.goodbye();
        } else if (this.command == CommandType.helpCommand) {
            ui.getManual();
        } else if (this.command == CommandType.addTodo) {
            ToDo.addToDo(this.processedInput);
        } else if (this.command == CommandType.addDeadline) {
            Deadline.addDeadline(this.processedInput);
        } else if (this.command == CommandType.addEvent) {
            Event.addEvent(processedInput);
        } else if (this.command == CommandType.deleteCommand) {
            Task.deleteTask(processedInput);
        } else if (this.command == CommandType.doneCommand) {
            Task.doneTask(processedInput);
        } else if (this.command == CommandType.findCommand) {
            Task.findTask(processedInput);
        } else if (this.command == CommandType.invalidInput) {
            ui.getConfused();
        }
    }

    public boolean isExit() {
        return this.exit;
    }
}
