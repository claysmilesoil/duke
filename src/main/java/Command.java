/**
 * Represents a command that is parsed from user input.
 */
public class Command {
    /**
     * A CommandType enum that represents the type of command.
     */
    private CommandType command;
    /**
     * The user input string. Currently a misnomer as it is the full user input.
     */
    private String processedInput;
    /**
     * Value that defines whether the program should exit.
     * Initialized to false until an exit command is entered.
     */
    private boolean exit;

    /**
     * Defines the type of command.
     */
    public enum CommandType {
        LIST, EXIT, HELP, TODO, DEADLINE, EVENT, DELETE,
        DONE, FIND, INVALID
    }

    /**
     * Instantiates Command object with a CommandType enum only.
     *
     * @param command the type of command
     */
    public Command(CommandType command) {
        this.command = command;
        this.exit = false;
    }

    /**
     * Instantiates Command object with a CommandType enum and processedInput.
     *
     * @param command the type of command
     * @param processedInput the full user input string
     */
    public Command(CommandType command, String processedInput) {
        this.command = command;
        this.processedInput = processedInput;
        this.exit = false;
    }

    /**
     * Executes instructions based on the received command and prints relevant messages to the UI.
     *
     * @param ui the UI to print to
     */
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

    /**
     * Gets the boolean value of exit.
     *
     * @return boolean value of exit
     */
    public boolean isExit() {
        return this.exit;
    }
}
