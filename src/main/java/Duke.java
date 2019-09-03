public class Duke {
    private Ui ui;
    private Duke() {
        ui = new Ui();
        Memory.readListFromFile();
    }
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.getLine();
            Command c = Parser.parse(fullCommand);
            c.execute(ui);
            isExit = c.isExit();
            ui.getLine();
        }
        Memory.writeListToFile();
    }
    public static void main(String[] args) {
        new Duke().run();
    }
}