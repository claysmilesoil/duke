import java.io.IOException;
import java.text.ParseException;

/**
 * The main class of Duke.
 */
public class Duke {
    private Ui ui;

    /**
     * Instantiates Duke. Loads task list from file.
     * Prints a message if unsuccessful in loading task list.
     */
    private Duke() {
        ui = new Ui();
        try {
            Storage.readListFromFile();
        } catch (ParseException e) {
            ui.getErrorMessage("There was an error in loading the file.\n", e);
        } catch (DukeException e) {
            ui.getFileCorruptMessage();
        }
    }

    /**
     * Describes the run cycle of the Duke Program.
     * Prints a welcome message, then receives user input and executes instructions based on the input
     * continuously until the user input executes the exit command.
     * Upon exiting, writes or overwrites the current task list to a .txt file.
     */
    public void run() {
        boolean isExit = false;
        ui.welcome();
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.getLine();
            Command c = Parser.parse(fullCommand);
            c.execute(ui);
            isExit = c.isExit();
            ui.getLine();
        }

        try {
            Storage.writeListToFile();
        } catch (IOException | NullPointerException e) {
            ui.getErrorMessage("File may not be saved properly.\n", e);
        }
    }

    /**
     * Main method of the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}