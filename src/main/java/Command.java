public class Command {
    private CommandType command;
    private String processedInput;
    private boolean exit;

    public enum CommandType {
        LIST, EXIT, HELP, TODO, DEADLINE, EVENT, DELETE,
        DONE, FIND, INVALID
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
        switch (this.command){
            case LIST:
                ui.getList();
                break;
            case EXIT:
                this.exit = true;
                ui.goodbye();
                break;
            case HELP:
                ui.getManual();
                break;
            case TODO:
                ToDo.addToDo(this.processedInput);
                break;
            case DEADLINE:
                Deadline.addDeadline(this.processedInput);
                break;
            case EVENT:
                Event.addEvent(this.processedInput);
                break;
            case DELETE:
                Task.deleteTask(this.processedInput);
                break;
            case DONE:
                Task.doneTask(this.processedInput);
                break;
            case FIND:
                Task.findTask(this.processedInput);
                break;
            case INVALID:
                ui.getConfused();
                break;
        }
    }

    public boolean isExit() {
        return this.exit;
    }
}
