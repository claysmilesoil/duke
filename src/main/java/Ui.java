import java.text.ParseException;
import java.util.Scanner;

public class Ui {
    private String line = "____________________________________________";
    private static Scanner inp = new Scanner(System.in);
    public Ui () {

    }

    public void welcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line + "\nHello, I'm Duke!\nWhat can I do for you?\n" + line);
    }

    public String readCommand() {
        return (inp.nextLine());
    }

    public void getLine() {
        System.out.println(line);
    }

    // Exceptions and invalid inputs
    public void getFileCorruptMessage() {
        System.out.println("Something went wrong when loading the file. File data may be corrupted.");
    }

    public void getErrorMessage(String added, Exception e) {
        System.out.println(e.getMessage() + added);
    }

    public void getConfused() {
        System.out.println("Uh, dunno what that means. Type \"help\" for the list of commands available.");
    }

    // normal operation
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

    public void getList() {
        if (Task.itemList.isEmpty()) {
            System.out.println("You have no tasks in your list.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < Task.itemList.size(); i++) {
                System.out.println(i + 1 + ". " + Task.itemList.get(i));
            }
        }
    }

    public void goodbye() {
        System.out.println("Bye, see you soon!");
    }
}
