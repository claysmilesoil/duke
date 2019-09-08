import java.io.IOException;
import java.text.ParseException;

public class Duke {
    private Ui ui;
    private Duke() {
        ui = new Ui();
        try {
            Memory.readListFromFile();
        } catch (ParseException e) {
            ui.getErrorMessage("There was an error in loading the file.\n", e);
        } catch (DukeException e) {
            ui.getFileCorruptMessage();
        }
    }
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
            Memory.writeListToFile();
        } catch (IOException | NullPointerException e) {
            ui.getErrorMessage("File may not be saved properly.\n", e);
        }
    }
    public static void main(String[] args) {
        new Duke().run();
    }
}