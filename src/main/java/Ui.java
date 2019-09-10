import java.util.Scanner;

/**
 * Handles most of the UI, including reading user inputs and printing some messages.
 */
public class Ui {
    /**
     * The border for outputs.
     */
    private String line = "____________________________________________";
    /**
     * Scanner object to read in user commands.
     */
    private static Scanner inp = new Scanner(System.in);

    public Ui () {
    }

    /**
     * Prints to terminal a welcome message.
     */
    public void welcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line + "\nHello, I'm Duke!\nWhat can I do for you?\n" + line);
    }

    /**
     * Reads user input from terminal
     * @return user input in String format
     */
    public String readCommand() {
        return (inp.nextLine());
    }

    /**
     * Prints the border.
     */
    public void getLine() {
        System.out.println(line);
    }

    // Exceptions and invalid inputs

    /**
     * Prints an error message saying the file data may be corrupted.
     */
    public void getFileCorruptMessage() {
        System.out.println("Something went wrong when loading the file. File data may be corrupted.");
    }

    /**
     * Prints an error message.
     *
     * @param added additional information on the behaviour of the program when the exception is thrown
     * @param e the message of the exception thrown
     */
    public void getErrorMessage(String added, Exception e) {
        System.out.println(e.getMessage() + added);
    }

    /**
     * Prints an error message when the user input is not recognised.
     */
    public void getConfused() {
        System.out.println("Uh, dunno what that means. Type \"help\" for the list of commands available.");
    }

    // normal operation

    /**
     * Prints the help page.
     */
    public void getManual () {
        System.out.println("Here are the currently available commands:\n" +
                "    1. todo [field]                 -- Add a todo task to the list\n" +
                "    2. deadline [field] /by [time]  -- Add a deadline task to the list\n" +
                "    3. event [field] /at [time]     -- Add an event to the list\n" +
                "    4. done [number]                -- Mark corresponding task on the list as completed\n" +
                "    5. delete [number]              -- Delete corresponding task on the list\n" +
                "    5. list                         -- Display list of tasks\n" +
                "    6. help                         -- Bring up this manual\n" +
                "    7. bye                          -- Close the program. ");
    }

    /**
     * Prints all items in the current task list.
     */
    public void getList() {
        if (TaskList.itemList.isEmpty()) {
            System.out.println("You have no tasks in your list.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < TaskList.itemList.size(); i++) {
                System.out.println(i + 1 + ". " + TaskList.itemList.get(i));
            }
        }
    }

    /**
     * Prints goodbye message.
     */
    public void goodbye() {
        System.out.println("Bye, see you soon!");
    }
}
